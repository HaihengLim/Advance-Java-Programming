import java.awt.Frame;
import java.awt.Panel;
import java.awt.Button;
import java.awt.TextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmLottery extends Frame implements ActionListener{
    private TextField txtNum, txtMoney, txtResult;
    private Checkbox ch1, ch2, ch3;
    private CheckboxGroup g;
    private Button btnPlay, btnExit;
    
    public frmLottery(){

        Panel p = new Panel();
        p.setLayout(new FlowLayout());
        p.add(new Label("Lottery Playing!!"));

        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());
        g = new CheckboxGroup();
        p1.add(ch1 = new Checkbox("One", g, true));
        p1.add(ch2 = new Checkbox("Two", g, false));
        p1.add(ch3 = new Checkbox("Three", g, false));

        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(3, 2));
        p2.add(new Label("Type:"));
        p2.add(p1);
        p2.add(new Label("Your number: "));
        p2.add(txtNum = new TextField(12));
        p2.add(new Label("Your Money: "));
        p2.add(txtMoney = new TextField(12));

        Panel p3 = new Panel();
        p3.setLayout(new FlowLayout());
        p3.add(btnPlay = new Button("Play"));
        p3.add(btnExit = new Button("Exit"));

        Panel p4 = new Panel();
        p4.setLayout(new FlowLayout());
        p4.add(new Label("Result: "));
        p4.add(txtResult = new TextField(40));

        Panel p12 = new Panel();
        p12.setLayout(new BorderLayout());
        p12.add(p, BorderLayout.NORTH);
        p12.add(p2, BorderLayout.CENTER);

        Panel p34 = new Panel();
        p34.setLayout(new BorderLayout());
        p34.add(p3, BorderLayout.NORTH);
        p34.add(p4, BorderLayout.CENTER);

        Panel p1234 = new Panel();
        p1234.setLayout(new BorderLayout());
        p1234.add(p12, BorderLayout.NORTH);
        p1234.add(p34, BorderLayout.CENTER);

        add(p1234);

        btnPlay.addActionListener(this);
        btnExit.addActionListener(this);
        
        setSize(650, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
    public int getRandom(int min, int max){
        return (min + (int) (Math.random()*(max-min+1)));
    }
    
    public void actionPerformed(ActionEvent e){
        int m = 0, y;
        double money;

        if(e.getSource() == btnPlay){
            if(ch1.getState() == true)
                m = getRandom(0, 9);
            if(ch2.getState() == true)
                m = getRandom(0, 99);
            if(ch3.getState())
                m = getRandom(0, 999);
            
            money = Double.parseDouble(txtMoney.getText());
            y = Integer.parseInt(txtNum.getText());

            if(m==y)
                money = money * 10;
            else
                money = 0;
            
            String result;
            
            result = "Your number is " + y + "The result is " + m + "==> You got " + money + "$";
            txtResult.setText(result);
        }
        else if(e.getSource() == btnExit)
            System.exit(0);
    }
    public static void main(String[] args){
        new frmLottery();
    }
}
