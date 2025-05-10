import java.awt.*;
import java.awt.event.*;

public class frmEquation extends Frame{
    Label titleLabel, labelx2, labelx1, labelResultX1, labelResultX2;
    TextField txta, txtb, txtc, resultX1, resultX2;
    Button btnAnswer, btnClose, btnClear;
    Font font = new Font("Arial", Font.BOLD, 30);
    
    public frmEquation(){

        Panel p = new Panel();
        p.setLayout(new FlowLayout());
        titleLabel = new Label("Quadratic Equation");
        titleLabel.setFont(font);
        p.add(titleLabel);

        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());
        p1.add(txta = new TextField(5));
        p1.add(labelx2 = new Label("x2 + "));
        p1.add(txtb = new TextField(5));
        p1.add(labelx1 = new Label("x + "));
        p1.add(txtc = new TextField(5));
        p1.add(new Label("= 0"));

        Panel p2 = new Panel();
        p2.setLayout(new FlowLayout());
        p2.add(btnAnswer = new Button("Answer"));
        p2.add(btnClear = new Button("Clear"));
        p2.add(btnClose = new Button("Close"));

        Panel p3 = new Panel();
        p3.setLayout(new FlowLayout());
        p3.add(labelResultX1 = new Label("X1 = "));
        p3.add(resultX1 = new TextField(20));
        p3.add(labelResultX2 = new Label("X2 = "));
        p3.add(resultX2 = new TextField(20));

        Panel p12 = new Panel();
        p12.setLayout(new BorderLayout());
        p12.add(p, BorderLayout.NORTH);
        p12.add(p1, BorderLayout.CENTER);

        Panel p34 = new Panel();
        p34.setLayout(new BorderLayout());
        p34.add(p2, BorderLayout.NORTH);
        p34.add(p3, BorderLayout.CENTER);

        Panel p1234 = new Panel();
        p1234.setLayout(new BorderLayout());
        p1234.add(p12, BorderLayout.NORTH);
        p1234.add(p34, BorderLayout.CENTER);

        p1234.setBackground(Color.cyan);
        add(p1234);
        

        setSize(720, 720);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        btnAnswer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                float a ,b, c, x1, x2, delta;
                a = Float.parseFloat(txta.getText());
                b = Float.parseFloat(txtb.getText());
                c = Float.parseFloat(txtc.getText());

                delta = (b*b) - (4*a*c);

                if(delta < 0){
                    resultX1.setText("No Root");
                    resultX2.setText("No Root");
                }
                else if(delta > 0){
                    x1 = (float) ((-b + Math.sqrt(delta)))/2*a;
                    x2 = (float) ((-b - Math.sqrt(delta)))/2*a;

                    resultX1.setText(x1 + "");
                    resultX2.setText(x2 + "");
                }
                else{
                    x1 = x2 = -b/2*a;
                    resultX1.setText(x1 + "");
                    resultX2.setText(x2 + "");
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                txta.setText("");
                txtb.setText("");
                txtc.setText("");
                resultX1.setText("");
                resultX2.setText("");
                txta.requestFocus();
            }
        });
        
        btnClose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    public static void main(String[] args){new frmEquation();}
}
