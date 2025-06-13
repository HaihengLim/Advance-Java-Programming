import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.border.BevelBorder;

public class myMenu extends JFrame{
    public myMenu(){
        super("Menu Demo");
        setSize(450, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));
        menuBar.setBorderPainted(true);
        add(menuBar, BorderLayout.NORTH);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        fileMenu.add(new JMenuItem("New"));
        fileMenu.add(new JMenuItem("Open"));
        fileMenu.add(new JMenuItem("Save"));
        fileMenu.add(new JMenuItem("Save as"));

        JMenu editMenu = new JMenu("Edit"); 
        menuBar.add(editMenu);
        editMenu.add(new JMenuItem("Undo"));
        editMenu.add(new JMenuItem("Cut"));
        editMenu.add(new JMenuItem("Copy"));
        editMenu.add(new JMenuItem("Paste"));

        JMenu optionMenu = new JMenu("Option");
        menuBar.add(optionMenu);
        JMenu bookMarkMenu = new JMenu("Book Marks");
        optionMenu.add(bookMarkMenu);
        JMenuItem addMbookMarkMenuI = new JMenuItem("Add Alt_K");
        bookMarkMenu.add(addMbookMarkMenuI);
        JMenuItem addMbookMarkMenuII = new JMenuItem("Edit Alt_B");
        bookMarkMenu.add(addMbookMarkMenuII);
        JMenu guideMenu = new JMenu("Guide");
        bookMarkMenu.add(guideMenu);
        
        JMenuItem whatIsNewMI = new JMenuItem("What's New");
        whatIsNewMI.setMnemonic('N');
        guideMenu.add(whatIsNewMI);
        JMenuItem whatIsCoolMI = new JMenuItem("What's Cool");
        whatIsCoolMI.setMnemonic('C');
        guideMenu.add(whatIsCoolMI);

        JMenuItem addressBookMI = new JMenuItem("AddressBook");
        optionMenu.add(addressBookMI);

        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args){new myMenu();}
}
