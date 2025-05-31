import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmProduct extends JFrame implements ActionListener{
    JButton btnAdd, btnClose, btnTotal;
    JTextField txtId, txtName, txtQuantity, txtPrice, txtTotal;
    JTable table;
    DefaultTableModel model;
    JScrollPane scrollPane;
    public static float total = 0;

    public frmProduct(){
        prepareGUI();
        
        setSize(500, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setTitle("Table Employee");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void prepareGUI(){
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new JLabel("Insert Product Data"));

        JPanel p2 = new JPanel(new GridLayout(4, 2));
        p2.add(new JLabel("Id:"));
        p2.add(txtId = new JTextField(20));
        p2.add(new JLabel("Name:"));
        p2.add(txtName = new JTextField(20));
        p2.add(new JLabel("Qunatity:"));
        p2.add(txtQuantity = new JTextField(20));
        p2.add(new JLabel("Price:"));
        p2.add(txtPrice = new JTextField(20));

        JPanel p3 = new JPanel(new FlowLayout());
        p3.add(btnAdd = new JButton("New"));
        p3.add(btnClose = new JButton("Close"));
        p3.add(btnTotal = new JButton("Total"));
        p3.add(txtTotal = new JTextField(20));

        JPanel p12 = new JPanel(new BorderLayout());
        p12.add(p1, BorderLayout.NORTH);
        p12.add(p2, BorderLayout.CENTER);

        JPanel p123 = new JPanel(new BorderLayout());
        p123.add(p12, BorderLayout.NORTH);
        p123.add(p3, BorderLayout.CENTER);

        model = new DefaultTableModel();
        model.addColumn("ProductId");
        model.addColumn("ProductName");
        model.addColumn("Quantity");
        model.addColumn("Price");
        model.addColumn("Amount");
        table = new JTable(model);
        scrollPane = new JScrollPane(table);

        JPanel p = new JPanel(new BorderLayout());
        p.add(p123, BorderLayout.NORTH);
        p.add(scrollPane, BorderLayout.CENTER);

        add(p);
        btnAdd.addActionListener(this);
        btnClose.addActionListener(this);
        btnTotal.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnAdd){
            String id = txtId.getText();
            String name = txtName.getText();
            String quantity = txtQuantity.getText();
            String price = txtPrice.getText();
            float amount = Float.parseFloat(quantity) * Float.parseFloat(price);
            total += amount;
            model.addRow(new Object[]{id, name, quantity, price + "$", amount + "$"});
            txtId.setText("");
            txtName.setText("");
            txtQuantity.setText("");
            txtPrice.setText("");
        }
        else if(e.getSource() == btnClose)
            System.exit(0);
        else if(e.getSource() == btnTotal)
            txtTotal.setText(total + "$");
    }
    public static void main(String[] args){new frmProduct();}
}
