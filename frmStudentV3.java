import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.CheckboxGroup;
import java.awt.Checkbox;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

public class frmStudentV3 extends JFrame implements ActionListener{
    JLabel labelName, labelGender, labelScore, labelDate, labelTel, labelYear, labelGrade;
    JLabel labelDisplay;
    TextField txtName, txtScore, txtDate, txtTel;
    Button btnAdd, btnClear;
    Choice chYear = new Choice();
    CheckboxGroup g = new CheckboxGroup();
    Checkbox ch1, ch2;
    JTable table;
    DefaultTableModel model;
    JScrollPane scrollPane;
    public static String name, gender, date, tel, year, grade, age;
    public static float score;
    public static float ageLong;
    public static int no = 1;
    LocalDate currentDate = LocalDate.now();
    
    public frmStudentV3(){
        GUI();
        initialize();
        actionButton();
    }

    public void GUI(){
        prepareGUI();

        JPanel panelDisplay = new JPanel();
        panelDisplay.add(labelDisplay);

        JPanel panelCheckbox = new JPanel(new FlowLayout());
        panelCheckbox.add(ch1);
        panelCheckbox.add(ch2);
        
        JPanel p1 = new JPanel(new GridLayout(1, 2));
        p1.add(labelName);
        p1.add(txtName);

        JPanel p2 = new JPanel(new GridLayout(1, 2));
        p2.add(labelGender);
        p2.add(panelCheckbox);

        JPanel p3 = new JPanel(new GridLayout(1, 2));
        p3.add(labelYear);
        p3.add(chYear);

        JPanel p4 = new JPanel(new GridLayout(3, 2));
        p4.add(labelDate);
        p4.add(txtDate);
        p4.add(labelTel);
        p4.add(txtTel);
        p4.add(labelScore);
        p4.add(txtScore);

        JPanel p5 = new JPanel(new FlowLayout());
        p5.add(btnAdd);
        p5.add(btnClear);

        JPanel p6 = new JPanel(new FlowLayout());
        p6.add(scrollPane);

        JPanel p12 = new JPanel(new BorderLayout());
        p12.add(p1, BorderLayout.NORTH);
        p12.add(p2, BorderLayout.CENTER);

        JPanel p34 = new JPanel(new BorderLayout());
        p34.add(p3, BorderLayout.NORTH);
        p34.add(p4, BorderLayout.CENTER);

        JPanel p56 = new JPanel(new BorderLayout());
        p56.add(p5, BorderLayout.NORTH);
        p56.add(p6, BorderLayout.CENTER);

        JPanel p1234 = new JPanel(new BorderLayout());
        p1234.add(p12, BorderLayout.NORTH);
        p1234.add(p34, BorderLayout.CENTER);

        JPanel p123456 = new JPanel(new BorderLayout());
        p123456.add(p1234, BorderLayout.NORTH);
        p123456.add(p56, BorderLayout.CENTER);

        JPanel p = new JPanel(new BorderLayout());
        p.add(panelDisplay, BorderLayout.NORTH);
        p.add(p123456, BorderLayout.CENTER);

        add(p);
    }

    public void prepareGUI(){
        labelDisplay = new JLabel("Student List");
        labelDisplay.setFont(new Font("Arial", Font.BOLD, 30));
        labelDisplay.setForeground(Color.red);
        labelName = new JLabel("Name: ");
        labelGender = new JLabel("Gender: ");
        labelYear = new JLabel("Year: ");
        labelDate = new JLabel("Date: ");
        labelTel = new JLabel("Tel: ");
        labelScore = new JLabel("Score: ");
        labelGrade = new JLabel("Grade: ");
        txtName = new TextField(20);
        txtDate = new TextField(20);
        txtTel = new TextField(20);
        txtScore = new TextField(20);
        btnAdd = new Button("Add");
        btnAdd.setPreferredSize(new Dimension(100, 20));
        btnClear = new Button("Clear");
        btnClear.setPreferredSize(new Dimension(100, 20));
        chYear.add("Year 1");
        chYear.add("Year 2");
        chYear.add("Year 3");
        chYear.add("Year 4");
        ch1 = new Checkbox("Male", g, false);
        ch2 = new Checkbox("Female", g, false);
        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Year");
        model.addColumn("Date");
        model.addColumn("Age");
        model.addColumn("Tel");
        model.addColumn("Score");
        model.addColumn("Grade");
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(750, 100));
    }

    public void initialize(){
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Student Lists");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addTextFormatter();
    }

    public void actionButton(){
        btnAdd.addActionListener(this);
        btnClear.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnClear){
            model.setRowCount(0);
        }
        else if(e.getSource() == btnAdd){
            name = txtName.getText();
            score = Float.parseFloat(txtScore.getText());
            year = chYear.getSelectedItem();
            date = txtDate.getText();
            tel = txtTel.getText();

            if(ch1.getState())
                gender = "Male";
            else if(ch2.getState())
                gender = "Female";
            
            if(score >= 90)
                grade = "A";
            else if(score >= 80)
                grade = "B";
            else if(score >= 70)
                grade = "C";
            else if(score >= 60)
                grade = "D";
            else if(score >= 50)
                grade = "E";
            else if(score < 50)
                grade = "F";

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dateFormatted = LocalDate.parse(date, formatter);
            ageLong = ChronoUnit.YEARS.between(dateFormatted, currentDate);
            age = String.format("%.0f", ageLong);

            model.addRow(new Object[]{no++, name, gender, year, date, age, tel, score, grade});
        }
    }

    public void addTextFormatter(){
        txtDate.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char ch = e.getKeyChar();
                if(!Character.isDigit(ch) && ch != '\b'){
                    e.consume();
                    return;
                }

                String text = txtDate.getText();
                int len = text.length();

                if(len >= 10 && ch != '\b'){
                    e.consume();
                    return;
                }

                if(len == 2 || len == 5 && ch != '\b'){
                    int pos = txtDate.getCaretPosition();
                    String newDate = text + "-" + ch;
                    txtDate.setText(newDate);
                    txtDate.setCaretPosition(pos + 2);
                    e.consume();
                }
            }
        });

        txtTel.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char ch = e.getKeyChar();

                if(!Character.isDigit(ch) && ch!='\b'){
                    e.consume();
                    return;
                }

                String text = txtTel.getText();
                int len = text.length();

                if(len >= 12 && ch != '\b'){
                    e.consume();
                    return;
                }

                if(len == 3 || len == 7 && ch != '\b'){
                    int pos = txtTel.getCaretPosition();
                    String newText = text + "-" + ch;
                    txtTel.setText(newText);
                    txtTel.setCaretPosition(pos + 2);
                    e.consume();
                }
            }
        });
    }

    public static void main(String[] args){new frmStudentV3();}
}
