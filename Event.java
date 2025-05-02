import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Frame;

public class Event extends Frame{
    Label labelDisplay, labelB, labelResult, labelA;
    TextField txtA, txtB, txtResult;
    Button buttonSum, buttonSub, buttonMul, buttonDiv, buttonClose = new Button("Close");
    Button buttonClear = new Button("Clear");

    public Event(){
        setLayout(null);

        //Display Label
        labelDisplay = new Label("Input A and B");
        labelDisplay.setBounds(50, 50, 100, 20);
        labelDisplay.setBackground(Color.green);
        labelDisplay.setForeground(Color.red);
        add(labelDisplay);

        //Label A
        labelA = new Label("A: ");
        labelA.setBounds(50, 80, 50, 20);
        labelA.setBackground(Color.RED);
        labelA.setForeground(Color.white);
        add(labelA);

        //Label B
        labelB = new Label("B: ");
        labelB.setBounds(50, 100, 50, 20);
        labelB.setBackground(Color.RED);
        labelB.setForeground(Color.WHITE);
        add(labelB);

        //Label Result
        labelResult = new Label("Result: ");
        labelResult.setBounds(50, 120, 50, 20);
        labelResult.setBackground(Color.red);
        labelResult.setForeground(Color.white);
        add(labelResult);

        //text field A
        txtA = new TextField(" ");
        txtA.setBounds(140, 80, 120, 20);
        add(txtA);

        //text field B
        txtB = new TextField(" ");
        txtB.setBounds(140, 100, 120, 20);
        add(txtB);

        //text field Result
        txtResult = new TextField(" ");
        txtResult.setBounds(140, 120, 120, 20);
        add(txtResult);

        //button sum
        buttonSum = new Button("+");
        buttonSum.setBounds(140, 160, 20, 20);
        add(buttonSum);

        //button sub
        buttonSub = new Button("-");
        buttonSub.setBounds(170, 160, 20, 20);
        add(buttonSub);

        //button mul
        buttonMul = new Button("*");
        buttonMul.setBounds(200, 160, 20, 20);
        add(buttonMul);

        //button div
        buttonDiv = new Button("/");
        buttonDiv.setBounds(230, 160, 20, 20);
        add(buttonDiv);

        //button clear
        buttonClear.setBounds(260, 160, 40, 20);
        add(buttonClear);

        //button close
        buttonClose.setBounds(320, 160, 40, 20);
        buttonClose.setBackground(Color.RED);
        buttonClose.setForeground(Color.WHITE);
        add(buttonClose);

        buttonSum.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                float a, b;
                float result;

                a = Float.parseFloat(txtA.getText());
                b = Float.parseFloat(txtB.getText());

                result = a + b;
                txtResult.setText(result + "");
            }
        });

        buttonSub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                float a, b;
                float result;

                a = Float.parseFloat(txtA.getText());
                b = Float.parseFloat(txtB.getText());

                result = a - b;
                txtResult.setText(result + "");
            }
        });

        buttonMul.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                float a, b;
                float result;

                a = Float.parseFloat(txtA.getText());
                b = Float.parseFloat(txtB.getText());

                result = a * b;
                txtResult.setText(result + "");
            }
        });

        buttonDiv.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                float a, b;
                float result;

                a = Float.parseFloat(txtA.getText());
                b = Float.parseFloat(txtB.getText());

                result = a / b;
                txtResult.setText(result + "");
            }
        });

        buttonClose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        buttonClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtA.setText("");
                txtB.setText("");
                txtResult.setText("");
                txtA.requestFocus();
            }
        });

        setSize(800, 250);
        setTitle("Kdet");
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(Color.cyan);
        setResizable(false);

        addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e){
            System.exit(0);
           } 
        });
    }

    public static void main(String[] args){
        new Event();
    }
}
