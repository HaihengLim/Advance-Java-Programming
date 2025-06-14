import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class frmElectronicInvoice extends JFrame implements ActionListener{
    JLabel labelDisplay = new JLabel("Electronic Invoices");
    JTextField txtId, txtName, txtOldCounter, txtNewCounter;
    JButton btnAdd, btnRemove, btnClear;
    JTable table;
    DefaultTableModel model;
    JScrollPane scrollPane;
    
    public frmElectronicInvoice(){
        GUI();
        initialize();
        actionButton();
    }

    public void GUI(){
        prepareGUI();

        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(labelDisplay);

        JPanel p2 = new JPanel(new GridLayout(4, 2));
        p2.add(new JLabel("Id: "));
        p2.add(txtId);
        p2.add(new JLabel("Name: "));
        p2.add(txtName);
        p2.add(new JLabel("Old Counter: "));
        p2.add(txtOldCounter);
        p2.add(new JLabel("New Counter: "));
        p2.add(txtNewCounter);

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
        txtId = new JTextField(20);
        txtName = new JTextField(20);
        txtOldCounter = new JTextField(20);
        txtNewCounter = new JTextField(20);
        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
        btnClear = new JButton("Clear");
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Old Counter");
        model.addColumn("New Counter");
        model.addColumn("Volume");
        model.addColumn("Rate");
        model.addColumn("Total");
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
    }

    public void initialize(){
        setSize(700, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Electronic Invoices");
    }

    public void actionButton(){
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnClear.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnAdd)
            addInvoice();
        else if(e.getSource() == btnRemove)
            removeInvoice();
        else if(e.getSource() == btnClear)
            clearInvoice();
    }

    public void addInvoice(){
        String Id = txtId.getText();
        String Name = txtName.getText();
        String OldCounter = txtOldCounter.getText();
        String NewCounter = txtNewCounter.getText();
        float rate = 0;
        float Volume = Float.parseFloat(NewCounter) - Float.parseFloat(OldCounter);
        float total = 0;
        if(Volume >= 170){
            rate = 10;
            total = Volume * rate;
        }
        else if(Volume >= 100){
            rate = 7;
            total = Volume * rate;
        }
        else{
            rate = 4;
            total = Volume * rate;
        }
        model.addRow(new Object[] {Id, Name, OldCounter, NewCounter, Volume, rate, total});
        JOptionPane.showMessageDialog(null, "The new row added!");
    }

    public void removeInvoice(){
        try{
            int n = table.getRowCount();
            for(int i = 0; i < n; i++){
                int pos = table.getSelectedRow();
                model.removeRow(pos);
                n--;
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "The Row Removed!");
        }
    }

    public void clearInvoice(){
        model.setRowCount(0);
        JOptionPane.showMessageDialog(null, "All Row Clear!");
    }

    public static void main(String[] args){new frmElectronicInvoice();}
}
