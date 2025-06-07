import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.time.temporal.ChronoUnit;

public class frmSignUpV2 extends JFrame implements ActionListener{
    JLabel labelDisplay, labelUsername, labelPassword, labelConfirmPassword,
        labelDateOfBirth, labelGender;
    TextField txtUsername, txtPassword, txtConfirmPassword, txtDate;
    CheckboxGroup g = new CheckboxGroup();
    Checkbox ch1, ch2;
    Button btnSignUp, btnShow;
    JLabel labelTel = new JLabel("Tel: ");
    TextField txtPhone = new TextField(20);
    JTable table;
    DefaultTableModel model;
    JScrollPane scrollPane;
    public static String name;
    public static String password, cPassword;
    public static String gender;
    public static String date;
    LocalDate currentDate = LocalDate.now();
    public static float ageLong;
    public static String age;
    public static String numPhone;

    public frmSignUpV2(){
        GUI();
        initialize();
        buttonAction();
    }

    public void GUI(){
        prepareGUI();
        JPanel panelCheckbox = new JPanel(new FlowLayout());
        panelCheckbox.add(ch1);
        panelCheckbox.add(ch2);

        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(labelDisplay);

        JPanel p2 = new JPanel(new GridLayout(6, 2));
        p2.add(labelUsername);
        p2.add(txtUsername);
        p2.add(labelGender);
        p2.add(panelCheckbox);
        p2.add(labelDateOfBirth);
        p2.add(txtDate);
        p2.add(labelTel);
        p2.add(txtPhone);
        p2.add(labelPassword);
        p2.add(txtPassword);
        p2.add(labelConfirmPassword);
        p2.add(txtConfirmPassword);

        JPanel p3 = new JPanel(new FlowLayout());
        p3.add(btnShow);
        p3.add(btnSignUp);

        JPanel p4 = new JPanel(new FlowLayout());
        p4.add(scrollPane);

        JPanel p12 = new JPanel(new BorderLayout());
        p12.add(p1, BorderLayout.NORTH);
        p12.add(p2, BorderLayout.CENTER);

        JPanel p34 = new JPanel(new BorderLayout());
        p34.add(p3, BorderLayout.NORTH);
        p34.add(p4, BorderLayout.CENTER);

        JPanel p = new JPanel(new BorderLayout());
        p.add(p12, BorderLayout.NORTH);
        p.add(p34, BorderLayout.CENTER);

        add(p);
    }

    public void prepareGUI(){
        labelDisplay = new JLabel("Sign Up");
        labelDisplay.setFont(new Font("Arial", Font.BOLD, 30));
        labelDisplay.setForeground(Color.red);
        labelUsername = new JLabel("Username: ");
        labelPassword = new JLabel("Password: ");
        labelConfirmPassword = new JLabel("Confirm Password: ");
        txtUsername = new TextField(20);
        txtPassword = new TextField(20);
        txtPassword.setEchoChar('*');
        txtConfirmPassword = new TextField(20);
        txtConfirmPassword.setEchoChar('*');
        btnSignUp = new Button("Sign Up");
        btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnSignUp.setForeground(Color.blue);
        btnSignUp.setPreferredSize(new Dimension(100, 25));
        model = new DefaultTableModel();
        model.addColumn("Username");
        model.addColumn("Gender");
        model.addColumn("Date of Birth");
        model.addColumn("Age");
        model.addColumn("Tel");
        model.addColumn("Password");
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        ch1 = new Checkbox("Male", g, false);
        ch2 = new Checkbox("Female", g, false);
        txtDate = new TextField(20);
        labelGender = new JLabel("Gender: ");
        labelDateOfBirth = new JLabel("Date of Birth: ");
        txtDate = new TextField(20);
        btnShow = new Button("Show");
    }

    public void initialize(){
        setSize(550, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Sign Up");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addDateFormatter();
    }

    public void buttonAction(){
        btnShow.addActionListener(this);
        btnSignUp.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnShow){
            if(btnShow.getLabel().equals("Show")){
                btnShow.setLabel("Hide");
                txtPassword.setEchoChar('\0');
                txtConfirmPassword.setEchoChar('\0');
            } else{
                btnShow.setLabel("Show");
                txtPassword.setEchoChar('*');
                txtConfirmPassword.setEchoChar('*');
            }

        }
        else if(e.getSource() == btnSignUp){
            name = txtUsername.getText();
            password = txtPassword.getText();
            cPassword = txtConfirmPassword.getText();
            date = txtDate.getText();
            if(ch1.getState())
                gender = "Male";
            else if(ch2.getState())
                gender = "Female";
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dateFormatted = LocalDate.parse(date, formatter);
            ageLong = ChronoUnit.YEARS.between(dateFormatted, currentDate);
            age = String.format("%.0f", ageLong);
            model.addRow(new Object[]{name, gender, date, age + " years old", password});
        }
    }

    public void addDateFormatter(){
        txtDate.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char ch = e.getKeyChar();
                if(!Character.isDigit(ch) && ch!='\b'){
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

        txtPhone.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char ch = e.getKeyChar();
                if(!Character.isDigit(ch) && ch != '\b'){
                    e.consume();
                    return;
                }

                String text = txtPhone.getText();
                int len = text.length();

                if(len >= 12 && ch != '\b'){
                    e.consume();
                    return;
                }
                
                if(len == 3 || len == 7 && ch != '\b'){
                    int pos = txtPhone.getCaretPosition();
                    String newText = text + "-" + ch;
                    txtPhone.setText(newText);
                    txtPhone.setCaretPosition(pos + 2);
                    e.consume();
                }
            }
        });
    }

    public static void main(String[] args){new frmSignUpV2();}
}
