import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Choice;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmStudentV4 extends JFrame implements ActionListener{
    JLabel labelDisplay = new JLabel("Student List");
    JButton btnAdd, btnRemove, btnClear;
    JTextField txtId, txtName, txtAttendance, txtMidterm, txtQuiz, txtAssignment, txtFinal;
    CheckboxGroup cg = new CheckboxGroup();
    Checkbox ch1, ch2;
    Choice Year = new Choice();
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel model;
    
    public frmStudentV4(){
        GUI();
        initialize();
        actionButton();
    }

    public void GUI(){
        prepareGUI();
        JPanel pCheck = new JPanel(new FlowLayout());
        pCheck.add(ch1);
        pCheck.add(ch2);

        JPanel p1 = new JPanel(new FlowLayout());
        
        JPanel p2 = new JPanel(new GridLayout(9, 2));
        p2.add(new JLabel("Year: "));
        p2.add(Year);
        p2.add(new JLabel("Id: "));
        p2.add(txtId);
        p2.add(new JLabel("Name: "));
        p2.add(txtName);
        p2.add(new JLabel("Gender: "));
        p2.add(pCheck);
        p2.add(new JLabel("Attendance: "));
        p2.add(txtAttendance);
        p2.add(new JLabel("Quiz: "));
        p2.add(txtQuiz);
        p2.add(new JLabel("Midterm: "));
        p2.add(txtMidterm);
        p2.add(new JLabel("Assignment: "));
        p2.add(txtAssignment);
        p2.add(new JLabel("Final: "));
        p2.add(txtFinal);

        JPanel p3 = new JPanel(new FlowLayout());
        p3.add(btnAdd);
        p3.add(btnRemove);
        p3.add(btnClear);

        JPanel p12 = new JPanel(new BorderLayout());
        p12.add(p1, BorderLayout.NORTH);
        p12.add(p2, BorderLayout.CENTER);

        JPanel p34 = new JPanel(new BorderLayout());
        p34.add(p3, BorderLayout.NORTH);
        p34.add(scrollPane, BorderLayout.CENTER);

        JPanel p = new JPanel(new BorderLayout());
        p.add(p12, BorderLayout.NORTH);
        p.add(p34, BorderLayout.CENTER);

        add(p);
    }
    public void prepareGUI(){
        labelDisplay.setFont(new Font("Arial", Font.BOLD, 30));
        labelDisplay.setForeground(Color.red);
        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
        btnClear = new JButton("Clear");
        txtId = new JTextField(20);
        txtName = new JTextField(20);
        txtAttendance = new JTextField(20);
        txtMidterm = new JTextField(20);
        txtQuiz = new JTextField(20);
        txtAssignment = new JTextField(20);
        txtFinal = new JTextField(20);
        ch1 = new Checkbox("Male", cg, false);
        ch2 = new Checkbox("Female", cg, false);
        Year.add("Year1");
        Year.add("Year2");
        Year.add("Year3");
        Year.add("Year4");
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Year");
        model.addColumn("Attendance");
        model.addColumn("Quiz");
        model.addColumn("Midterm");
        model.addColumn("Assignment");
        model.addColumn("Final");
        model.addColumn("Total");
        model.addColumn("Grade");
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
    }
    public void initialize(){
        setSize(1200, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void actionButton(){
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnClear.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnAdd)
            addNewStudent();
        else if(e.getSource() == btnRemove)
            removeStudent();
        else if(e.getSource() == btnClear)
            clearStudent();
    }
    public void addNewStudent(){
        String id = txtId.getText();
        String name = txtName.getText();
        String gender = "";
        String year = Year.getSelectedItem();
        float att = Float.parseFloat(txtAttendance.getText());
        String quiz = txtQuiz.getText();
        String mid = txtMidterm.getText();
        String ass = txtAssignment.getText();
        String finale = txtFinal.getText();
        float total = att + Float.parseFloat(quiz) + 
            Float.parseFloat(mid) + Float.parseFloat(ass) + Float.parseFloat(finale);
        String grade = "";
        if(ch1.getState())
            gender = ch1.getLabel();
        else if(ch2.getState())
            gender = ch2.getLabel();
        
        if(att == 0){
            grade = "F";
            total = 0;
        }
        else{
            if(total >= 90)
                grade = "A";
            else if(total >= 80)
                grade = "B";
            else if(total >= 70)
                grade = "C";
            else if(total >= 60)
                grade = "D";
            else
                grade = "F";
        }
        model.addRow(new Object[]{id, name, gender, year, att, quiz, mid, ass, finale, total, grade});
    }
    public void removeStudent(){
        int n = table.getRowCount();
        for(int i = 0; i < n; i++){
            int index = table.getSelectedRow();
            model.removeRow(index);
            n--;
            JOptionPane.showMessageDialog(this, "Row Removed");
        }
    }
    public void clearStudent(){
        model.setRowCount(0);
        JOptionPane.showMessageDialog(this, "All Row Clear!!");
    }
    public static void main(String[] args){new frmStudentV4();}
}
