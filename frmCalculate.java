import java.awt.Color;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmCalculate extends Frame{
    Label labelA, labelB, labelDisplay, labelResult;
    TextField textFieldA, textFieldB, textFieldResult;
    Button buttonSum, buttonSub, buttonMul, buttonDiv, buttonClear, buttonClose;

    public frmCalculate(){
        setLayout(null);

        //Label Display
        labelDisplay = new Label("Input A and B");
        labelDisplay.setBounds(50, 50, 120, 30);
        labelDisplay.setBackground(Color.green);
        labelDisplay.setForeground(Color.RED);
        add(labelDisplay);

        //label A
        labelA = new Label("A: ");
        labelA.setBounds(50, 80, 50, 20);
        labelA.setBackground(Color.green);
        labelA.setForeground(Color.WHITE);
        add(labelA);

        //labelB
        labelB = new Label("B: ");
        labelB.setBounds(50, 110, 50, 20);
        labelB.setBackground(Color.green);
        labelB.setForeground(Color.white);
        add(labelB);

        //label result
        labelResult = new Label("Result");
        labelResult.setBounds(50, 140, 50, 20);
        labelResult.setBackground(Color.green);
        labelResult.setForeground(Color.white);
        add(labelResult);

        //text field A
        textFieldA = new TextField("");
        textFieldA.setBounds(110, 80, 120, 20);
        add(textFieldA);

        //text field B
        textFieldB = new TextField("");
        textFieldB.setBounds(110, 110, 120, 20);
        add(textFieldB);

        //text field result
        textFieldResult = new TextField("");
        textFieldResult.setBounds(110, 140, 120, 20);
        add(textFieldResult);

        //button sum
        buttonSum = new Button("+");
        buttonSum.setBounds(50, 170, 20, 20);
        add(buttonSum);
        
        //button sub
        buttonSub = new Button("-");
        buttonSub.setBounds(80, 170, 20, 20);
        add(buttonSub);
        
        //button mul
        buttonMul = new Button("*");
        buttonMul.setBounds(110, 170, 20, 20);
        add(buttonMul);

        //button div
        buttonDiv = new Button("/");
        buttonDiv.setBounds(140, 170, 20, 20);
        add(buttonDiv);

        //button clear
        buttonClear = new Button("Clear");
        buttonClear.setBounds(170, 170, 50, 20);
        add(buttonClear);

        //button close
        buttonClose = new Button("Close");
        buttonClose.setBounds(230, 170, 50, 20);
        buttonClose.setBackground(Color.red);
        buttonClose.setForeground(Color.white);
        add(buttonClose);

        //event sum
        buttonSum.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                float a, b;
                float result;

                a = Float.parseFloat(textFieldA.getText());
                b = Float.parseFloat(textFieldB.getText());

                result = a + b;
                textFieldResult.setText(result + "");
            }
        });

        //event sum
        buttonSub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                float a, b;
                float result;

                a = Float.parseFloat(textFieldA.getText());
                b = Float.parseFloat(textFieldB.getText());

                result = a - b;
                textFieldResult.setText(result + "");
            }
        });

        buttonMul.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
            float a, b;
            float result;

            a = Float.parseFloat(textFieldA.getText());
            b = Float.parseFloat(textFieldB.getText());

            result = a * b;
            textFieldResult.setText(result + "");
           } 
        });

        buttonDiv.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                float a, b;
                float result;

                a = Float.parseFloat(textFieldA.getText());
                b = Float.parseFloat(textFieldB.getText());

                result = a / b;
                textFieldResult.setText(result + "");
            }
        });

        buttonClose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        buttonClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textFieldA.setText("");
                textFieldB.setText("");
                textFieldResult.setText("");
                textFieldA.requestFocus();
            }
        });

        setSize(720, 720);
        setVisible(true);
        setLocationRelativeTo(null);
        setBackground(Color.cyan);
        setResizable(true);
        setTitle("Mini Calculator");
        setResizable(false);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    public static void main(String[] args){
        new frmCalculate();
    }
}
