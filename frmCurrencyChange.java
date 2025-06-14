import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmCurrencyChange extends JFrame implements ActionListener{
    JLabel labelDisplay, labelFrom, labelTo;
    JButton btnChange, btnReverse, btnClear;
    JTextField txtFrom, txtTo;
    
    public frmCurrencyChange(){
        GUI();
        initialize();
        actionButton();
    }

    public void GUI(){
        prepareGUI();
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(labelDisplay);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(labelFrom);
        p2.add(txtFrom);

        JPanel p3 = new JPanel(new FlowLayout());
        p3.add(labelTo);
        p3.add(txtTo);

        JPanel p4 = new JPanel(new FlowLayout());
        p4.add(btnChange);
        p4.add(btnReverse);
        p4.add(btnClear);

        JPanel p12 = new JPanel(new BorderLayout());
        p12.add(p1, BorderLayout.NORTH);
        p12.add(p2, BorderLayout.CENTER);
        
        JPanel p34 = new JPanel(new BorderLayout());
        p34.add(p3, BorderLayout.NORTH);
        p34.add(p4, BorderLayout.CENTER);

        JPanel p = new JPanel(new BorderLayout());
        p.add(p12, BorderLayout.NORTH);
        p.add(p34, BorderLayout.CENTER);

        add(p);
    }

    public void prepareGUI(){
        labelDisplay = new JLabel("Currency Exchange");
        labelDisplay.setFont(new Font("Arial", Font.BOLD, 30));
        labelDisplay.setForeground(Color.red);
        labelFrom = new JLabel("USD");
        labelFrom.setFont(new Font("Arial", Font.PLAIN, 20));
        labelTo = new JLabel("KHR");
        labelTo.setFont(new Font("Arial", Font.PLAIN, 20));
        txtFrom = new JTextField(10);
        txtTo = new JTextField(10);
        btnChange = new JButton("Change");
        btnClear = new JButton("Clear");
        btnReverse = new JButton("Reverse");
    }

    public void initialize(){
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Currency Changes");
    }

    public void actionButton(){
        btnChange.addActionListener(this);
        btnClear.addActionListener(this);
        btnReverse.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnChange)
            ChangeButton();
        else if(e.getSource() == btnReverse)
            ReverseButton();
        else if(e.getSource() == btnClear)
            ClearButton();
    }

    public void ChangeButton(){
        float From = Float.parseFloat(txtFrom.getText());
        float To;
        if(labelFrom.getText() == "USD" && labelTo.getText() == "KHR")
            To = From * 4000;
        else
            To = From / 4000;
        txtTo.setText(To + "");
    }

    public void ReverseButton(){
        if(labelFrom.getText() == "USD" && labelTo.getText() == "KHR"){
            labelFrom.setText("KHR");
            labelTo.setText("USD");
        }
        else{
            labelFrom.setText("USD");
            labelTo.setText("KHR");
        }
    }

    public void ClearButton(){
        txtFrom.setText("");
        txtTo.setText("");
    }

    public static void main(String[] args){new frmCurrencyChange();}
}
