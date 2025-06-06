import java.awt.*;
import java.awt.event.*;

public class Pizza extends Frame {
    private Label lblKind = new Label("Kind");
    private Choice chKind = new Choice();
    private CheckboxGroup cg = new CheckboxGroup();
    private Checkbox cbo1 = new Checkbox("Small", cg, false);
    private Checkbox cbo2 = new Checkbox("Medium", cg, false);
    private Checkbox cbo3 = new Checkbox("Large", cg, false);
    private Label lblPrice = new Label("Price");
    private TextField txtPrice = new TextField();
    private Label lblQty = new Label("Qty");
    private TextField txtQty = new TextField();
    private TextArea txtDisplay = new TextArea();
    private Button btnAdd = new Button("Add");
    private Label lblTotal = new Label("Total: ");
    private TextField txtTotal = new TextField("0");

    int total = 0;

    public Pizza(){
        setLayout(null);
        lblKind.setBounds(100, 100, 100, 30);
        chKind.add("A");
        chKind.add("B");
        chKind.add("C");
        chKind.add("D");

        chKind.setBounds(200, 70, 150, 30); add(chKind);
        cbo1.setBounds(100, 100, 70, 30); add(cbo1);
        cbo2.setBounds(200, 100, 70, 30); add(cbo2);
        cbo3.setBounds(300, 100, 70, 30); add(cbo3);
        lblPrice.setBounds(100, 150, 100, 30); add(lblPrice);
        txtPrice.setBounds(200, 150, 150, 30); add(txtPrice);
        lblQty.setBounds(100, 200, 100, 30); add(lblQty);
        txtQty.setBounds(200, 200, 150, 30); add(txtQty);
        txtDisplay.setBounds(50, 240, 400, 150); add(txtDisplay);
        btnAdd.setBounds(100, 400, 60, 30); add(btnAdd);
        lblTotal.setBounds(100, 450, 100, 30); add(lblTotal);
        txtTotal.setBounds(200, 450, 150, 30); add(txtTotal);

        setTitle("Pizza");
        setSize(550, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        txtDisplay.setEditable(false); //Prevent edit text in txtDisplay
        txtTotal.setEditable(false); //Prevent edit text in txtTotal

        btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String txtService = "";
                txtDisplay.append(txtPrice.getText() + "\t" + txtQty.getText() + "\t" + chKind.getSelectedItem() + "\t");
                if(cbo1.getState())
                    txtService = "small";
                else if(cbo2.getState())
                    txtService = "Medium";
                else if(cbo3.getState())
                    txtService = "Large";
                txtDisplay.append(txtService + "\n");
                total = Integer.parseInt(txtPrice.getText());
                total += Integer.parseInt(txtPrice.getText()) * Integer.parseInt(txtQty.getText());
                txtTotal.setText(String.valueOf(total));
            }
        });
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    public static void main(String[] args){
        new Pizza();
    }
}
