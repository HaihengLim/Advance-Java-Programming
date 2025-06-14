//Hongsy Seyha
//Lim Haiheng

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class frmSaleProduct extends JFrame implements ActionListener{
    JTextField txtName, txtQty, txtPrice;
    CheckboxGroup g = new CheckboxGroup();
    Checkbox ch1, ch2, ch3;
    JButton btnAdd, btnRemove, btnClear;
    JTable table;
    DefaultTableModel model;
    JScrollPane scrollPane;
    public static int no = 1;
    
    public frmSaleProduct(){
        GUI();
        initialize();
        buttonAction();
    }

    public void GUI(){
        prepareGUI();

        JPanel panelCheck = new JPanel(new FlowLayout());
        panelCheck.add(ch1);
        panelCheck.add(ch2);
        panelCheck.add(ch3);

        JPanel p1 = new JPanel(new GridLayout(4, 2));
        p1.add(new JLabel("Name: "));
        p1.add(txtName);
        p1.add(new JLabel("Quantity: "));
        p1.add(txtQty);
        p1.add(new JLabel("Price: "));
        p1.add(txtPrice);
        p1.add(new Label("Promotion: "));
        p1.add(panelCheck);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(btnAdd);
        p2.add(btnRemove);
        p2.add(btnClear);

        JPanel p12 = new JPanel(new BorderLayout());
        p12.add(p1, BorderLayout.NORTH);
        p12.add(p2, BorderLayout.CENTER);

        JPanel p = new JPanel(new BorderLayout());
        p.add(p12, BorderLayout.NORTH);
        p.add(scrollPane, BorderLayout.CENTER);

        add(p);
    }

    public void prepareGUI(){
        txtName = new JTextField(20);
        txtQty = new JTextField(20);
        txtPrice = new JTextField(20);
        ch1 = new Checkbox("5%", g, false);
        ch2 = new Checkbox("10%", g, false);
        ch3 = new Checkbox("15%", g, false);
        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
        btnClear = new JButton("Clear");
        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Name");
        model.addColumn("Qty");
        model.addColumn("Price");
        model.addColumn("Promotion");
        model.addColumn("Total");
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
    }

    public void initialize(){
        setSize(700, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Product On Sale");
        setResizable(false);
    }

    public void buttonAction(){
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnClear.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnAdd)
            addProduct();
        else if(e.getSource() == btnRemove)
            removeProduct();
        else if(e.getSource() == btnClear)
            clearProduct();
    }

    public void addProduct(){
        String promotion = "0%";
        String name = txtName.getText();
        String qty = txtQty.getText();
        String price = txtPrice.getText();
        float promotionPrice = 0;
        float total = 0;
        if(ch1.getState()){
            promotion = ch1.getLabel();
            total = Float.parseFloat(price) * Float.parseFloat(qty);
            promotionPrice = (total * 5) / 100;
            total = total - promotionPrice;
        }
        else if(ch2.getState()){
            promotion = ch2.getLabel();
            total = Float.parseFloat(price) * Float.parseFloat(qty);
            promotionPrice = (total * 10) / 100;
            total = total - promotionPrice;
        }
        else if(ch3.getState()){
            promotion = ch3.getLabel();
            total = Float.parseFloat(price) * Float.parseFloat(qty);
            promotionPrice = (total * 15) / 100;
            total = total - promotionPrice;
        }
        else
            total = Float.parseFloat(price) * Float.parseFloat(qty);
        
        model.addRow(new Object[] {no++, name, qty, price, promotion, total});
        txtName.setText("");
        txtQty.setText("");
        txtPrice.setText("");
        ch1.setState(false);
        ch2.setState(false);
        ch3.setState(false);
    }

    public void removeProduct(){
        int n = table.getRowCount();
        for(int i = 0; i < n; i++){
            int index = table.getSelectedRow();
            model.removeRow(index);
            n--;
        }
    }

    public void clearProduct(){
        model.setRowCount(0);
    }

    public static void main(String[] args){new frmSaleProduct();}
}
