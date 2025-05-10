import java.awt.Frame;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmElection extends Frame{
    Label disLabel, labelResultP1, labelResultP2, labelResultP3;
    TextField txtP1, txtP2, txtP3;
    Button btnSubmit, btnClose, btnClear;
    Checkbox p1Check, p2Check, p3Check;
    Font font = new Font("Times New Roman", Font.BOLD, 20);
    CheckboxGroup g = new CheckboxGroup();
    int a = 0, b = 0, c = 0;
    public frmElection(){
        //Panel 1
        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());
        disLabel = new Label("Election");
        disLabel.setFont(font);
        p1.add(disLabel);
        
        //Panel 3
        Panel p3 = new Panel();
        p3.setLayout(new FlowLayout());
        p1Check = new Checkbox("Democratice Party", g, false);
        p2Check = new Checkbox("Republican Party", g, false);
        p3Check = new Checkbox("Forward Party", g, false);
        p3.add(p1Check);
        p3.add(p2Check);
        p3.add(p3Check);
        
        //Panel 4
        Panel p4 = new Panel();
        p4.setLayout(new FlowLayout());
        btnSubmit = new Button("Submit");
        btnClose = new Button("Close");
        btnClear = new Button("Clear");
        p4.add(btnSubmit);
        p4.add(btnClose);
        p4.add(btnClear);
        
        //Panel 13
        Panel p13 = new Panel();
        p13.setLayout(new BorderLayout());
        p13.add(p1, BorderLayout.NORTH);
        p13.add(p3, BorderLayout.CENTER);
        
        //Panel
        Panel p = new Panel();
        p.setLayout(new BorderLayout());
        p.add(p13, BorderLayout.NORTH);
        p.add(p4, BorderLayout.CENTER);
        
        labelResultP1 = new Label("Democratic Party: ");
        labelResultP1.setBounds(120, 220, 100, 20);
        txtP1 = new TextField(0 + "");
        txtP1.setEditable(false);
        txtP1.setBounds(240, 220, 50, 20);
        
        labelResultP2 = new Label("Republican Party");
        labelResultP2.setBounds(120, 250, 100, 20);
        txtP2 = new TextField(0 + "");
        txtP2.setEditable(false);
        txtP2.setBounds(240, 250, 50, 20);
        
        labelResultP3 = new Label("Forward Party: ");
        labelResultP3.setBounds(120, 280, 100, 20);
        txtP3 = new TextField(0 + "");
        txtP3.setEditable(false);
        txtP3.setBounds(240, 280, 50, 20);
        
        
        add(labelResultP1);
        add(txtP1);
        add(labelResultP2);
        add(txtP2);
        add(labelResultP3);
        add(txtP3);
        add(p);
        setSize(720, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Election");
        setVisible(true);
        
        btnSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(p1Check.getState() == true)
                    a++;
                else if(p2Check.getState() == true)
                    b++;
                else if(p3Check.getState() == true)
                    c++;
                
                txtP1.setText(a + "");
                txtP2.setText(b + "");
                txtP3.setText(c + "");
            }
        });
        
        btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                a = 0; b = 0; c= 0;
                txtP1.setText(a + "");
                txtP2.setText(b + "");
                txtP3.setText(c + "");
            }
        });
        
        btnClose.addActionListener((ActionEvent e)->{
            System.exit(0);
        });
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] args){new frmElection();}
}
