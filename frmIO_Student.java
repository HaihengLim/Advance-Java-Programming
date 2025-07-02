import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

class Student implements Serializable{
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
}

public class frmIO_Student extends JFrame implements ActionListener{
    JTextField txtId, txtName, txtScore;
    JButton btnAdd, btnClear, btnRemove, btnSave, btnLoad;
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel model;
    CheckboxGroup g = new CheckboxGroup();
    Checkbox ch1, ch2;
    public frmIO_Student(){
        GUI();
        intFrame();
        actionButton();
    }
    public void prepareGUI(){
        txtId = new JTextField(20);
        txtName = new JTextField(20);
        txtScore = new JTextField(20);
        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
        btnClear = new JButton("Clear");
        btnSave = new JButton("Save");
        btnLoad = new JButton("Load");
        ch1 = new Checkbox("Male", g, false);
        ch2 = new Checkbox("Female", g, false);
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Score");
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
    }
    public void GUI(){
        prepareGUI();
        JPanel panelGender = new JPanel(new FlowLayout());
        panelGender.add(ch1);
        panelGender.add(ch2);

        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new JLabel("Students List"));

        JPanel p2 = new JPanel(new GridLayout(4, 2));
        p2.add(new JLabel("Id:"));
        p2.add(txtId);
        p2.add(new JLabel("Name:"));
        p2.add(txtName);
        p2.add(new JLabel("Gender:"));
        p2.add(panelGender);
        p2.add(new JLabel("Score:"));
        p2.add(txtScore);

        JPanel p3 = new JPanel(new FlowLayout());
        p3.add(btnAdd);
        p3.add(btnRemove);
        p3.add(btnClear);
        p3.add(btnSave);
        p3.add(btnLoad);

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
    public void intFrame(){
        setSize(700, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    public void actionButton(){
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnClear.addActionListener(this);
        btnSave.addActionListener(this);
        btnLoad.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnAdd){
            String id = txtId.getText();
            String name = txtName.getText();
            String score = txtScore.getText();
            String gender = ch1.getState() ? ch1.getLabel() : (ch2.getState() ? ch2.getLabel() : "");
            model.addRow(new Object[]{id, name, gender, score});
            txtId.setText("");
            txtName.setText("");
            txtScore.setText("");
        }
        else if(e.getSource() == btnRemove){
            int n = table.getRowCount();
            for(int i = 0; i < n; i++){
                int index = table.getSelectedRow();
                model.removeRow(index);
                n--;
            }
            JOptionPane.showMessageDialog(null, "Row removed!");
        }
        else if(e.getSource() == btnClear){
            model.setRowCount(0);
            JOptionPane.showMessageDialog(null, "Row Clear!");
        }
        else if(e.getSource() == btnSave){
            try(ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("d:\\Programming\\Text\\StudentListSave.dat"))){ // set your own directory
                int rows = table.getRowCount();
                for(int i = 0; i < rows; i++){
                    String id = model.getValueAt(i, 0).toString();
                    String name = model.getValueAt(i, 1).toString();
                    String gender = model.getValueAt(i, 2).toString();
                    String score = model.getValueAt(i, 3).toString();
                    Student s = new Student(id, name, gender, score);
                    save.writeObject(s);
                }
                JOptionPane.showMessageDialog(null, "Save File Successfully");
                save.close();
            } catch(Exception ex){
                 JOptionPane.showMessageDialog(null, "Save File Failed " + ex.getMessage());
            }
        }
        else if(e.getSource() == btnLoad){
            model.setRowCount(0);
            try(ObjectInputStream load = new ObjectInputStream(new FileInputStream("d:\\Programming\\Text\\StudentListSave.dat"))){ // set your own directory
                while(true){
                    Student s = (Student) load.readObject();
                    model.addRow(new Object[]{s.id, s.name, s.gender, s.score});
                }
            } catch(EOFException ex){
                JOptionPane.showMessageDialog(null, "Load File Successfully");
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Load File Failed " + ex.getMessage());
            }
        }
    }
    public static void main(String[] args){new frmIO_Student();}
}
