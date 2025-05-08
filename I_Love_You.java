import java.awt.Frame;
import java.awt.Color;
import java.awt.Label;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class I_Love_You extends Frame{
    Label label = new Label("I Love you every universe");
    Button button = new Button("Me too");
    TextField textField = new TextField("");
    
    public I_Love_You(){
        setSize(720, 720);
        setLocationRelativeTo(null);
        setBackground(Color.cyan);
        setVisible(true);
        setResizable(false);
        setTitle("I Love you every universe");
        setLayout(null);

        label.setBounds(300, 300, 150, 20);
        label.setForeground(Color.red);
        add(label);

        button.setBounds(300, 330, 60, 20);
        button.setForeground(Color.white);
        button.setBackground(Color.black);
        add(button);

        textField.setBounds(300, 360, 150, 20);
        textField.setForeground(Color.BLACK);
        add(textField);

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textField.setText("Thank You!!");
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    public static void main(String[] args){
        new I_Love_You();
    }
}
