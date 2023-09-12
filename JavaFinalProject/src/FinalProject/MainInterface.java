package FinalProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
public class MainInterface {
    public static void main(String[] args) {
        new menu();
    }
}
class menu{
    JFrame jf;
    JLabel l1;
    JButton jb1, jb2,jb3,jb4,jb5;
    
    public menu() {
        jf = new JFrame("Menu");
        jf.setSize(260, 400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        l1 = new JLabel("Main Menu");
        l1.setBounds(90,10,500,30);
        jb1 = new JButton("Check Inventory");
        jb1.setBounds(45, 50, 150, 30);
       
        
        jb1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                
                new search();
                jf.dispose();
    }
});
        jb2=new JButton("Edit Inventory");
        jb2.setBounds(45,100,150,30);
       
        jb2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {              
                new ed();
                jf.dispose();
            }
        });
        jb3=new JButton("Check All");
        jb3.setBounds(45,150,150,30);
        
        jb3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {               
                new all();
                jf.dispose();
            }
        });
        jb4=new JButton("Check Price");
        jb4.setBounds(45,200,150,30);
        
        jb4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new price();
                jf.dispose();
            }
        });
    
        jb5 = new JButton("Exit");
        jb5.setBounds(80, 300, 80, 30);
       
        jb5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Successful exited");               
                System.exit(0);
            }
        });
       
       
        jf.add(l1);
        jf.add(jb1);
        jf.add(jb2);
        jf.add(jb3);
        jf.add(jb4);
        jf.add(jb5);
        jf.setVisible(true);
    }
}