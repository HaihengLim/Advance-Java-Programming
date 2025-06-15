import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmElectionCounter {
    JFrame frame = new JFrame();
    JLabel labelDisplay = new JLabel("Election");
    JButton btnVote, btnClear;
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel model;
    CheckboxGroup g = new CheckboxGroup();
    Checkbox ch1, ch2, ch3;
    public static int vote1 = 0, vote2 = 0, vote3 = 0;
    
    public frmElectionCounter(){
        labelDisplay.setFont(new Font("Arial", Font.BOLD, 30));
        labelDisplay.setForeground(Color.blue);
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(labelDisplay);
        JPanel p2 = new JPanel(new GridLayout(3, 1));
        ch1 = new Checkbox("Democracy Party", g, false);
        ch2 = new Checkbox("Republic Party", g, false);
        ch3 = new Checkbox("Free Party", g, false);
        ch1.setFont(new Font("Arial", Font.PLAIN, 20));
        ch2.setFont(new Font("Arial", Font.PLAIN, 20));
        ch3.setFont(new Font("Arial", Font.PLAIN, 20));
        p2.add(ch1);
        p2.add(ch2);
        p2.add(ch3);
        JPanel p3 = new JPanel(new FlowLayout());
        btnVote = new JButton("Vote");
        btnClear = new JButton("Clear");
        p3.add(btnVote);
        p3.add(btnClear);
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Vote");
        Object[] obj1 = new Object[] {"Democracy Party", vote1};
        Object[] obj2 = new Object[] {"Republic Party", vote2};
        Object[] obj3 = new Object[] {"Free Party", vote3};
        model.addRow(obj1);
        model.addRow(obj2);
        model.addRow(obj3);
        table = new JTable(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        scrollPane = new JScrollPane(table);
        JPanel p12 = new JPanel(new BorderLayout());
        p12.add(p1, BorderLayout.NORTH);
        p12.add(p2, BorderLayout.CENTER);

        JPanel p34 = new JPanel(new BorderLayout());
        p34.add(p3, BorderLayout.NORTH);
        p34.add(scrollPane, BorderLayout.CENTER);

        JPanel p = new JPanel(new BorderLayout());
        p.add(p12, BorderLayout.NORTH);
        p.add(p34, BorderLayout.CENTER);

        frame.add(p);
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        frame.setLocationRelativeTo(null);
        btnVote.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(ch1.getState()) vote1++;
                else if(ch2.getState()) vote2++;
                else if(ch3.getState()) vote3++;

                model.setValueAt(vote1, 0, 1);
                model.setValueAt(vote2, 1, 1);
                model.setValueAt(vote3, 2, 1);
            }
        });
        btnClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                vote1 = 0; vote2 = 0; vote3 = 0;
                model.setValueAt(vote1, 0, 1);
                model.setValueAt(vote2, 1, 1);
                model.setValueAt(vote3, 2, 1);
            }
        });
    }
    public static void main(String[] args){new frmElectionCounter();}
}
