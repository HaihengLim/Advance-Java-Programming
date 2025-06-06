import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.Choice;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmProductV2 extends Frame implements ActionListener{
    Label labelDisplay = new Label("SHOP", Label.CENTER);
    Label labelColor = new Label("Color: ");
    Label labelTotal = new Label("Total: ");
    Button btnAdd, btnAdd5, btnAdd10, btnDec, btnDec5, btnDec10, btnClear;
    Button btnPurchease, btnClearAll;
    TextArea txtInvoice = new TextArea();
    TextField txtQuantity = new TextField("0");
    TextField txtTotal = new TextField(20);
    Choice chProduct = new Choice();
    CheckboxGroup cg = new CheckboxGroup();
    Checkbox ch1 = new Checkbox("Red", cg, false);
    Checkbox ch2 = new Checkbox("Black", cg, false);
    Checkbox ch3 = new Checkbox("White", cg, false);
    Checkbox ch4 = new Checkbox("Cyan", cg, false);
    public static int quantity = 0;
    public static double price, total, totalPrice;
    public static String color;
    
    public frmProductV2(){
        prepareGUI();
        intFrame();
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        btnAdd.addActionListener(this);
        btnAdd5.addActionListener(this);
        btnAdd10.addActionListener(this);
        btnDec.addActionListener(this);
        btnDec5.addActionListener(this);
        btnDec10.addActionListener(this);
        btnClear.addActionListener(this);
        btnClearAll.addActionListener(this);
        btnPurchease.addActionListener(this);
    }

    public void prepareGUI(){
        txtTotal.setText("0");
        labelDisplay.setFont(new Font("Arial", Font.BOLD, 30));
        labelDisplay.setForeground(Color.red);
        txtInvoice.setEditable(false);
        txtQuantity.setEditable(false);
        txtTotal.setEditable(false);

        Panel p1 = new Panel(new FlowLayout());
        p1.add(labelDisplay);

        Panel p2 = new Panel(new FlowLayout());
        chProduct.add("Nintendo Switch: 249.99$");
        chProduct.add("Steam Deck Oled: 499.99$");
        chProduct.add("Lenovo Legion go: 699.99$");
        chProduct.add("MSI Claw: 449.99$");
        chProduct.add("ROG ALLY: 699.99$");
        chProduct.add("ROG ALLY X: 799.99$");
        p2.add(chProduct);

        Panel p3 = new Panel(new FlowLayout());
        p3.add(labelColor);
        Panel panelCheckbox = new Panel(new FlowLayout());
        panelCheckbox.add(ch1);
        panelCheckbox.add(ch2);
        panelCheckbox.add(ch3);
        panelCheckbox.add(ch4);
        p3.add(panelCheckbox);

        Panel p4 = new Panel(new FlowLayout(FlowLayout.CENTER));
        p4.add(txtQuantity);
        p4.add(btnAdd = new Button("+1"));
        p4.add(btnAdd5 = new Button("+5"));
        p4.add(btnAdd10 = new Button("+10"));
        p4.add(btnDec = new Button("-1"));
        p4.add(btnDec5 = new Button("-5"));
        p4.add(btnDec10 = new Button("-10"));
        p4.add(btnClear = new Button("Clear"));

        Panel p5 = new Panel(new FlowLayout());
        p5.add(btnPurchease = new Button("Purchease"));
        p5.add(btnClearAll = new Button("ClearAll"));

        Panel p6 = new Panel(new FlowLayout());
        txtInvoice.setPreferredSize(new Dimension(500, 100));
        p6.add(txtInvoice);

        Panel p7 = new Panel(new FlowLayout());
        p7.add(labelTotal);
        p7.add(txtTotal);

        Panel p23 = new Panel(new BorderLayout());
        p23.add(p2, BorderLayout.NORTH);
        p23.add(p3, BorderLayout.CENTER);

        Panel p45 = new Panel(new BorderLayout());
        p45.add(p4, BorderLayout.NORTH);
        p45.add(p5, BorderLayout.CENTER);

        Panel p67 = new Panel(new BorderLayout());
        p67.add(p6, BorderLayout.NORTH);
        p67.add(p7, BorderLayout.CENTER);

        Panel p123 = new Panel(new BorderLayout());
        p123.add(p1, BorderLayout.NORTH);
        p123.add(p23, BorderLayout.CENTER);

        Panel p4567 = new Panel();
        p4567.add(p45, BorderLayout.NORTH);
        p4567.add(p67, BorderLayout.CENTER);

        Panel p = new Panel(new BorderLayout());
        p.add(p123, BorderLayout.NORTH);
        p.add(p4567, BorderLayout.CENTER);

        add(p);
    }

    public void intFrame(){
        setSize(550, 450);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Shop");
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnAdd){
            quantity++;
            txtQuantity.setText(quantity + "");
        }
        else if(e.getSource() == btnAdd5){
            quantity += 5;
            txtQuantity.setText(quantity + "");
        }
        else if(e.getSource() == btnAdd10){
            quantity += 10;
            txtQuantity.setText(quantity + "");
        }
        else if(e.getSource() == btnDec){
            quantity--;
            txtQuantity.setText(quantity + "");
        }
        else if(e.getSource() == btnDec5){
            quantity -= 5;
            txtQuantity.setText(quantity + "");
        }
        else if(e.getSource() == btnDec10){
            quantity -= 10;
            txtQuantity.setText(quantity + "");
        }
        else if(e.getSource() == btnClear){
            quantity = 0;
            txtQuantity.setText(quantity + "");
        }
        else if(e.getSource() == btnPurchease){
            if(chProduct.getSelectedItem() == "Nintendo Switch: 249.99$")
                price = 249.99;
            else if(chProduct.getSelectedItem() == "Steam Deck Oled: 499.99$")
                price = 499.99;
            else if(chProduct.getSelectedItem() == "Lenovo Legion go: 699.99$")
                price = 699.99;
            else if(chProduct.getSelectedItem() == "MSI Claw: 449.99$")
                price = 499.99;
            else if(chProduct.getSelectedItem() == "ROG ALLY: 699.99$")
                price = 699.99;
            else if(chProduct.getSelectedItem() == "ROG ALLY X: 799.99$")
                price = 799.99;

            if(ch1.getState())
                color = "Red";
            else if(ch2.getState())
                color = "Black";
            else if(ch3.getState())
                color = "White";
            else if(ch4.getState())
                color = "Cyan";
            totalPrice = price * quantity;
            total += totalPrice;
            txtInvoice.append(chProduct.getSelectedItem() + "\t" + color + "\t" + price + "$\t\t" + quantity + "\t" + totalPrice + "$\n");
            txtTotal.setText(total + "");
        }
        else if(e.getSource() == btnClearAll){
            txtInvoice.setText("");
            txtTotal.setText("0");
            txtQuantity.setText("0");
            quantity = 0;
            total = 0;
        }
    }

    public static void main(String[] args){new frmProductV2();}
}
