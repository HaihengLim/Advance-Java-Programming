import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SignIn extends Frame{
    Label labelDisplay, labelUserName, labelPassword, labelResult;
    Button buttonSignin, buttonTryAgain;
    TextField textFieldUserName, textFieldPassword, textFieldResult;

    public SignIn(){
        setLayout(null);
        //label display
        labelDisplay = new Label("Sign In");
        labelDisplay.setBounds(20, 20, 50, 20);
        labelDisplay.setBackground(Color.GREEN);
        labelDisplay.setForeground(Color.WHITE);
        add(labelDisplay);

        //label Username
        labelUserName = new Label("Username: ");
        labelUserName.setBounds(20, 50, 60, 20);
        labelUserName.setBackground(Color.RED);
        labelUserName.setForeground(Color.white);
        add(labelUserName);

        //label Password
        labelPassword = new Label("Password: ");
        labelPassword.setBounds(20, 80, 60, 20);
        labelPassword.setBackground(Color.red);
        labelPassword.setForeground(Color.white);
        add(labelPassword);

        //label result
        labelResult = new Label("Result");
        labelResult.setBounds(20, 110, 60, 20);
        labelResult.setBackground(Color.red);
        labelResult.setForeground(Color.white); add(labelResult);

        //text field username
        textFieldUserName = new TextField("");
        textFieldUserName.setBounds(100, 50, 450, 20);
        add(textFieldUserName);

        //text field Password
        textFieldPassword = new TextField("");
        textFieldPassword.setBounds(100, 80, 450, 20);
        add(textFieldPassword);

        //text field result
        textFieldResult = new TextField("");
        textFieldResult.setBounds(100, 110, 450, 20);
        add(textFieldResult);

        //button sign in
        buttonSignin = new Button("Sign In");
        buttonSignin.setBounds(120, 140, 50, 20);
        add(buttonSignin);

        //button Try again
        // buttonTryAgain = new Button("Try Again");
        // buttonTryAgain.setBounds(40, 140, 50, 20);
        // add(buttonTryAgain);

        setSize(720, 400);
        setResizable(false);
        setBackground(Color.CYAN);
        setLocationRelativeTo(null);
        setTitle("Headbook");
        setVisible(true);

        buttonSignin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String realUserName = "Knull";
                String realPassword = "abcd";
                
                String userName, password;
                String result;

                userName = textFieldUserName.getText();
                password = textFieldPassword.getText();

                if(userName.equals(realUserName))
                    if(password.equals(realPassword)){
                        result = "log in successfully";
                        textFieldResult.setText(result + "");
                    }
                    else{
                        result = "Your password is incorrect";
                        textFieldResult.setText(result + "");
                        textFieldUserName.setText("");
                        textFieldPassword.setText("");
                    }
                else{
                    if(password.equals(realPassword)){
                        result = "Your Username is incorrect";
                        textFieldResult.setText(result + "");
                        textFieldUserName.setText("");
                        textFieldPassword.setText("");
                    }
                    else{
                        result = "Is you really the owner of this accout? If you are not, please get the fuck out!!";
                        textFieldResult.setText(result + "");
                        textFieldUserName.setText("");
                        textFieldPassword.setText("");
                    }
                }
            }
        });

        // buttonTryAgain.addActionListener(new ActionListener(){
        //     public void actionPerformed(ActionEvent e){
        //         textFieldUserName.setText("");
        //         textFieldPassword.setText("");
        //         textFieldResult.setText("");
        //     }
        // });

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
    public static void main(String[] args){
        new SignIn();
    }
}
