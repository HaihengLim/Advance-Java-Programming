import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class Student implements Serializable {
    String id;
    String name;
    String gender;
    String score;

    public Student(String id, String name, String gender, String score){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getScore() {
        return score;
    }
}

public class FormStudent extends JFrame implements ActionListener{
    private JTextField txtId, txtName, txtGender, txtScore;
    private JButton btnRead, btnWrite, btnClear;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    private ArrayList<Student>listAdd = new ArrayList<Student>();
    public FormStudent(){
        initGUI();
    }
    public void initGUI(){
        Container con = getContentPane();
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new JLabel("Student Information"));
        txtId = new JTextField(20);
        txtName = new JTextField(20);
        txtGender = new JTextField(20);
        txtScore = new JTextField(20);
        btnRead = new JButton("Read");
        btnWrite = new JButton("Write");
        btnClear = new JButton("Clear");

        JPanel p2 = new JPanel(new GridLayout(4, 2));
        p2.add(new JLabel("Id: "));
        p2.add(txtId);
        p2.add(new JLabel("Name:"));
        p2.add(txtName);
        p2.add(new JLabel("Gender:"));
        p2.add(txtGender);
        p2.add(new JLabel("Score:"));
        p2.add(txtScore);

        JPanel p3 = new JPanel(new FlowLayout());
        p3.add(btnRead);
        p3.add(btnWrite);
        p3.add(btnClear);

        JPanel p12 = new JPanel(new BorderLayout());
        p12.add(p1, BorderLayout.NORTH);
        p12.add(p2, BorderLayout.CENTER);

        JPanel p123 = new JPanel(new BorderLayout());
        p123.add(p12, BorderLayout.NORTH);
        p123.add(p3, BorderLayout.CENTER);
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Score");
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        
        JPanel p = new JPanel(new BorderLayout());
        p.add(p123, BorderLayout.NORTH);
        p.add(scrollPane, BorderLayout.CENTER);

        con.add(p);

        btnWrite.addActionListener(this);
        btnRead.addActionListener(this);
        btnClear.addActionListener(this);
        setVisible(true);
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnRead) myRead();
        else if(e.getSource() == btnWrite) myWrite();
        else if(e.getSource() == btnClear) clearTable();
    }
    public void myWrite(){
        listAdd.add(getStudent());
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("d:\\Programming\\Text\\StudentListSave1.bin"));
            out.writeObject(listAdd);
            JOptionPane.showMessageDialog(null, "Write Successfully");
            out.close();
        } catch(IOException e){e.printStackTrace();}
    }
    public Student getStudent(){
        String i = txtId.getText();
        String n = txtName.getText();
        String g = txtGender.getText();
        String s = txtScore.getText();
        txtId.setText("");
        txtName.setText("");
        txtGender.setText("");
        txtScore.setText("");
        return new Student(i, n, g, s);
    }
    public void myRead(){
        listAdd.clear();
        clearTable();
        read();
        addToTable(listAdd);
    }
    @SuppressWarnings("unchecked")
    public void read(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("d:\\Programming\\Text\\StudentListSave1.bin"));
            try {
                while(true){
                    listAdd = (ArrayList<Student>)in.readObject();
                    JOptionPane.showMessageDialog(null, "Read File Successfully");
                }
            } catch(EOFException e){in.close();}
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        } catch(IOException e){e.printStackTrace();}
    }
    public void addToTable(ArrayList<Student> listAdd){
        for(int i = 0; i < listAdd.size(); i++){
            Object[] rows = {listAdd.get(i).getId(), listAdd.get(i).getName(), listAdd.get(i).getGender(), listAdd.get(i).getScore()};
            model.addRow(rows);
        }
    }
    public void clearTable(){
        for(int i = model.getRowCount() - 1; i >= 0; i--){
            model.removeRow(i);
        }
    }
    public static void main(String[] args){new FormStudent();}
}
