import java.awt.Frame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Panel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmRegister extends Frame implements ActionListener{
    Label labelRegister, labelUserName, labelGender, labelPhoneNumber, labelAddress;
    Label labelResultUserName, labelResultGender, labelResultPhoneNum, labelResultAddress;
    TextField labelDisplayUserName, labelDisplayGender, labelDisplayPhoneNum, labelDisplayAddress;
    TextField txtUserName, txtPhoneNumber, txtAddress;
    Checkbox maleCheck, femaleCheck;
    CheckboxGroup g = new CheckboxGroup();
    Button btnNew, btnSubmit, btnClose;
    Font font = new Font("Arial", Font.BOLD, 30);
    
    public frmRegister(){
        setSize(720, 720);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        //Panel 1
        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());
        labelRegister = new Label("Register");
        labelRegister.setForeground(Color.BLACK);
        labelRegister.setFont(font);
        p1.add(labelRegister);

        //Panel 2
        Panel p2 = new Panel();
        p2.setLayout(new FlowLayout());
        p2.add(maleCheck = new Checkbox("Male", g, true));
        p2.add(femaleCheck = new Checkbox("Female", g, false));

        //Panel 3
        Panel p3 = new Panel();
        p3.setLayout(new GridLayout(4, 2));
        p3.add(labelUserName = new Label("Username: "));
        p3.add(txtUserName = new TextField(40));
        p3.add(labelGender = new Label("Gender"));
        p3.add(p2);
        p3.add(labelPhoneNumber = new Label("Phone Number: "));
        p3.add(txtPhoneNumber = new TextField(40));
        p3.add(labelAddress = new Label("Email Address"));
        p3.add(txtAddress = new TextField(40));

        //Panel 4
        Panel p4 = new Panel();
        p4.setLayout(new FlowLayout()); 
        p4.add(btnNew = new Button("New"));
        p4.add(btnSubmit = new Button("Submit"));
        p4.add(btnClose = new Button("Close"));

        //Panel 5
        Panel p5 = new Panel();
        p5.setLayout(new GridLayout(4, 1));

        Panel row1 = new Panel(); //Username
        row1.setLayout(new FlowLayout());
        row1.add(labelResultUserName = new Label("Username: "));
        row1.add(labelDisplayUserName = new TextField(40));
        
        Panel row2 = new Panel(); //Gender
        row2.setLayout(new FlowLayout());
        row2.add(labelResultGender = new Label("Gender: "));
        row2.add(labelDisplayGender = new TextField(40));
        
        Panel row3 = new Panel(); //Phone Number
        row3.setLayout(new FlowLayout());
        row3.add(labelResultPhoneNum = new Label("Phone Number: "));
        row3.add(labelDisplayPhoneNum = new TextField(40));
        
        Panel row4 = new Panel(); //Address
        row4.setLayout(new FlowLayout());
        row4.add(labelResultAddress = new Label("Address "));
        row4.add(labelDisplayAddress = new TextField(40));

        p5.add(row1);
        p5.add(row2);
        p5.add(row3);
        p5.add(row4);
        
        //p13
        Panel p13 = new Panel();
        p13.setLayout(new BorderLayout());
        p13.add(p1, BorderLayout.NORTH);
        p13.add(p3, BorderLayout.CENTER);

        //p45
        Panel p45 = new Panel();
        p45.setLayout(new BorderLayout());
        p45.add(p4, BorderLayout.NORTH);
        p45.add(p5, BorderLayout.CENTER);

        //Panel
        Panel p = new Panel();
        p.setLayout(new BorderLayout());
        p.add(p13, BorderLayout.NORTH);
        p.add(p45, BorderLayout.CENTER);
        p.setBackground(Color.cyan);

        add(p);

        //button Action
        btnSubmit.addActionListener(this);
        btnClose.addActionListener(this);
        btnNew.addActionListener(this);

        //window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnSubmit){
            String name, gender, phoneNum, address;
            name = txtUserName.getText();
            phoneNum = txtUserName.getText();
            address = txtAddress.getText();

            if(maleCheck.getState() == true)
                gender = "Male";
            else
                gender = "Female";
            
            labelDisplayUserName.setText(name + "");
            labelDisplayGender.setText(gender + "");
            labelDisplayPhoneNum.setText(phoneNum + "");
            labelDisplayAddress.setText(address + "");
        }
        else if(e.getSource() == btnNew){
            txtUserName.setText("");
            txtPhoneNumber.setText("");
            txtAddress.setText("");
            maleCheck.requestFocus();
            labelDisplayUserName.setText("");
            labelDisplayGender.setText("");
            labelDisplayPhoneNum.setText( "");
            labelDisplayAddress.setText("");
        }
        else if(e.getSource() == btnClose)
            System.exit(0);
    }

    public static void main(String[] args){new frmRegister();}
}
