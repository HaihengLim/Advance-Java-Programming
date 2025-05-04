import java.awt.Color;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class demoSignUp extends Frame{
    Label labelUserName, labelGender, labelPassword, labelConfirmedPassword, failedSignUp, labelGetName;
    Button signUpButton;
    TextField textUserName, textFieldPassword, textFieldConfirmPassword;
    Checkbox MaleCheckBox, FemaleCheckBox;
    CheckboxGroup genderCheckBoxGroup = new CheckboxGroup();

    public void successSignUp(String UserName, String password, String cPassword){
        remove(labelUserName); remove(labelGender); remove(labelPassword); remove(labelConfirmedPassword);
        remove(textUserName); remove(textFieldPassword); remove(textFieldConfirmPassword);
        remove(MaleCheckBox); remove(FemaleCheckBox);
        remove(signUpButton);
        if(password.equals(cPassword)){
            labelGetName = new Label("Welcome " + UserName + "!!");
            labelGetName.setBounds(40, 40, 200, 20);
            add(labelGetName);
        }
        if(!password.equals(cPassword)){
            remove(failedSignUp);
            labelGetName = new Label(" " + UserName);
            labelGetName.setBounds(40, 40, 200, 20);
            add(labelGetName);
        }
    }

    public void signUpFailed(){
        failedSignUp.setText("*Password is not matched");
        failedSignUp.setBounds(200, 190, 150, 200);
        failedSignUp.setForeground(Color.red);
        add(failedSignUp);
    }

    public demoSignUp(){
        setLayout(null);
        setSize(720, 720);
        setBackground(Color.cyan);
        setLocationRelativeTo(null);
        setTitle("HeadBook");
        setVisible(true);
        setResizable(false);

        failedSignUp = new Label("");

        //UserName
        labelUserName = new Label("Username");
        labelUserName.setBounds(40, 40, 150, 20);
        add(labelUserName);

        textUserName = new TextField("");
        textUserName.setBounds(200, 40, 350, 20);
        add(textUserName);

        //Gender
        labelGender = new Label("Gender");
        labelGender.setBounds(40, 70, 60, 20);
        add(labelGender);

        MaleCheckBox = new Checkbox("Male", genderCheckBoxGroup, false);
        MaleCheckBox.setBounds(110, 70, 60, 20);
        add(MaleCheckBox);

        FemaleCheckBox = new Checkbox("Female", genderCheckBoxGroup, false);
        FemaleCheckBox.setBounds(180, 70, 60, 20);
        add(FemaleCheckBox);

        //password
        labelPassword = new Label("Password");
        labelPassword.setBounds(40, 100, 150, 20);
        add(labelPassword);

        textFieldPassword = new TextField("");
        textFieldPassword.setBounds(200, 100, 350, 20);
        add(textFieldPassword);

        //confirmed Password
        labelConfirmedPassword = new Label("Confirmed Password");
        labelConfirmedPassword.setBounds(40, 130, 150, 20);
        add(labelConfirmedPassword);

        textFieldConfirmPassword = new TextField("");
        textFieldConfirmPassword.setBounds(200, 130, 350, 20);
        add(textFieldConfirmPassword);

        //signup Button
        signUpButton = new Button("Sign Up");
        signUpButton.setBounds(200, 160, 50, 20);
        signUpButton.setBackground(Color.red);
        signUpButton.setForeground(Color.white);
        add(signUpButton);

        signUpButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String userName, password, confirmedPassword;

                userName = textUserName.getText();
                password = textFieldPassword.getText();
                confirmedPassword = textFieldConfirmPassword.getText();

                if(password.equals(confirmedPassword)){
                    remove(failedSignUp);
                    successSignUp(userName, password, confirmedPassword);}
                else
                    signUpFailed();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
    public static void main(String[] args){
        new SignUp();
    }
}
