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
        setSize(720, 720); //set width and height to form
        setLocationRelativeTo(null); //set form to middle of the screen when run
        setBackground(Color.cyan); // set background color
        setVisible(true); //set element to appear on the frame
        setResizable(false); //prevent resize frame
        setTitle("I Love you every universe"); //set title to the form
        setLayout(null); // prvent from use set layout manager such as flowlayout borderlayout and gridlayout

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
