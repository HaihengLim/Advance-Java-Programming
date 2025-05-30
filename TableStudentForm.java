import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.table.TableRowSorter;

public class TableStudentForm extends JFrame implements ActionListener{
    JLabel labelDisplay;
    JButton btnNew, btnClear;
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel model;
    TableRowSorter<DefaultTableModel> sorter;
    
    public TableStudentForm(){
        labelDisplay = new JLabel("Student Form");
        labelDisplay.setFont(new Font("Arial", Font.BOLD, 30));
        labelDisplay.setForeground(Color.red);
        
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(labelDisplay);
      
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("CA");
        model.addColumn("DC");
        model.addColumn("DS");
        model.addColumn("DBS");
        model.addColumn("ENG");
        model.addColumn("JAVA");
        model.addColumn("Total");
        model.addColumn("AVG");
        model.addColumn("Grade");
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        scrollPane.setPreferredSize(new Dimension(1253, 250));
        
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setPreferredWidth(100);
        table.getColumnModel().getColumn(8).setPreferredWidth(100);
        table.getColumnModel().getColumn(9).setPreferredWidth(150);
        table.getColumnModel().getColumn(10).setPreferredWidth(150);
        table.getColumnModel().getColumn(11).setPreferredWidth(50);
        
        for(int i = 0; i < 12; i++)
            table.getColumnModel().getColumn(i).setResizable(false);
        table.getTableHeader().setReorderingAllowed(false);
        
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(scrollPane);
        
        JPanel p12 = new JPanel();
        p12.setLayout(new BorderLayout());
        p12.add(p1, BorderLayout.NORTH);
        p12.add(p2, BorderLayout.CENTER);
        
        btnNew = new JButton("New");
        btnClear = new JButton("Clear");
        
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p3.add(btnNew);
        p3.add(btnClear);
        
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(p12, BorderLayout.NORTH);
        p.add(p3, BorderLayout.CENTER);
        
        add(p);
        setSize(1300, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Student Form");
        
        btnNew.addActionListener(this);
        btnClear.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnNew){
            String id = JOptionPane.showInputDialog("Input Id: ");
            String name = JOptionPane.showInputDialog("Input Name: ");
            String gender = JOptionPane.showInputDialog("Input Gender: ");
            String grade;
            float ca = Float.parseFloat(JOptionPane.showInputDialog
                    ("Input Computer Architecture Score: "));
            float dc = Float.parseFloat(JOptionPane.showInputDialog
                    ("Input Data Communication Score: "));
            float ds = Float.parseFloat(JOptionPane.showInputDialog
                    ("Input Data Structure Score: "));
            float dbs = Float.parseFloat(JOptionPane.showInputDialog
                    ("Input Data Base System Score: "));
            float eng = Float.parseFloat(JOptionPane.showInputDialog
                    ("Input English Score: "));
            float java = Float.parseFloat(JOptionPane.showInputDialog
                    ("Input Java Programming Scre: "));
            float totalScore = ca + dc + ds + dbs + eng + java;
            float avg = totalScore / 6;
            
            if(avg >= 95)
                grade = "A+";
            else if(avg >= 90 )
                grade = "A";
            else if(avg >= 85)
                grade = "B+";
            else if(avg >= 80)
                grade = "B";
            else if(avg >= 75)
                grade = "C+";
            else if(avg > 70)
                grade = "C";
            else if(avg >= 65)
                grade = "D+";
            else if(avg >= 60)
                grade = "D";
            else if(avg >= 55)
                grade = "E+";
            else if(avg >= 50)
                grade = "E";
            else
                grade = "F";

            model.addRow(new Object[] {id, name, gender, ca, dc, ds, dbs, eng,
                                        java, totalScore, avg, grade});
        }
        else if(e.getSource() == btnClear){
            model.setRowCount(0);
        }
    }
    
    public static void main(String[] args){new TableStudentForm();}
}
