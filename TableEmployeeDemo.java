import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;

public class TableEmployeeDemo extends JFrame implements ActionListener{
    JTextField txtId, txtName, txtHour, txtRate;
    JButton btnAdd, btnClear;
    JTable table;
    JScrollPane scrollPane;
    Checkbox ch1, ch2, ch3;
    CheckboxGroup cg;
    DefaultTableModel model;
    
    public TableEmployeeDemo(){
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        JLabel lb1 = new JLabel("Employee Form");
        p1.add(lb1);
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(5, 2));
        p2.add(new JLabel("Id: "));
        p2.add(txtId = new JTextField(20));
        p2.add(new JLabel("Name: "));
        p2.add(txtName = new JTextField(20));
        p2.add(new JLabel("Hour: "));
        p2.add(txtHour = new JTextField(20));
        p2.add(new JLabel("Rate: "));
        p2.add(txtRate = new JTextField(20));
        p2.add(new JLabel("Rate Tax: "));
        JPanel pRateTax = new JPanel(new FlowLayout());
        cg = new CheckboxGroup();
        ch1 = new Checkbox("10%", cg, false);
        ch2 = new Checkbox("15%", cg, false);
        ch3 = new Checkbox("20%", cg, false);
        pRateTax.add(ch1);
        pRateTax.add(ch2);
        pRateTax.add(ch3);
        
        p2.add(pRateTax);
        JPanel p12 = new JPanel(new BorderLayout());
        p12.add(p1, BorderLayout.NORTH);
        p12.add(p2, BorderLayout.CENTER);
        
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p3.add(btnAdd = new JButton("Add"));
        p3.add(btnClear = new JButton("Clear"));
        
        JPanel p123 = new JPanel(new BorderLayout());
        p123.add(p12, BorderLayout.NORTH);
        p123.add(p3, BorderLayout.CENTER);
        
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Hour");
        model.addColumn("Rate");
        model.addColumn("Income");
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        
        btnAdd.addActionListener(this);
        btnClear.addActionListener(this);
        
        setLayout(new BorderLayout());
        add(p123, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        setSize(500, 350);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Employee Form Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnAdd){
            String id = txtId.getText();
            String name = txtName.getText();
            String hour = txtHour.getText();
            String rate = txtRate.getText();
            Double income = Double.parseDouble(hour) * 
                    Double.parseDouble(rate);
            if(ch1.getState())
                income = income - income * 0.1;
            else if(ch2.getState())
                income = income - income * 0.15;
            else if(ch3.getState())
                income = income - income * 0.2;
            
            model.addRow(new Object[]{id, name, hour, rate, income});
            txtId.setText("");
            txtName.setText("");
            txtHour.setText("");
            txtRate.setText("");
        }
        else if(e.getSource() == btnClear){
            model.setRowCount(0);
        }
    }
    public static void main(String[] args){new TableEmployeeDemo();}
}
