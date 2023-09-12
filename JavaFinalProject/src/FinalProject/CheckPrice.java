package FinalProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
 
public class CheckPrice {
    public static void main(String[] args) {
        new price();
    }
}
class price {
        JFrame jf;
        JLabel l1,l2,l3,l4,l5,l6,l7,l8;
        JButton jb1,jb2;
        ButtonGroup bg;
        JRadioButton jrb1, jrb2, jrb3,jrb4,jrb5,jrb6,jrb7,jrb8;
       
       
        
        public price() {
            jf = new JFrame("Edit Inventory");
            jf.setSize(700,480);
            jf.setLocationRelativeTo(null);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setLayout(null);  
            
          
            
            l1 = new JLabel("554724-092-10.5");
            l1.setBounds(50, 10, 130, 40);         
       
            l2 = new JLabel("BB550PB1-10.5");
            l2.setBounds(50, 60, 130, 40);        
            
            l3 = new JLabel("DC0774-141-7.5W");
            l3.setBounds(50, 110, 130, 40);
            
            l4 = new JLabel("DD1399-106-10.5");
            l4.setBounds(50, 160, 130, 40);
            
            l5 = new JLabel("DD1391-100-10");
            l5.setBounds(50, 210, 130, 40);
            
            l6 = new JLabel("DD1869-103-8W");
            l6.setBounds(50, 260, 130, 40);
            
            l7 = new JLabel("CT8019-162-11");
            l7.setBounds(50, 310, 130, 40);
            
            l8 = new JLabel("FZ5897-10");
            l8.setBounds(50, 360, 130, 40);
            
         
            bg =  new ButtonGroup();
            
            jrb1=new JRadioButton("SKU");
            jrb1.setBounds(20, 20, 20, 20);
            
            jrb2=new JRadioButton("SKU");
            jrb2.setBounds(20, 70, 20, 20);
            
            jrb3=new JRadioButton("SKU");
            jrb3.setBounds(20, 120, 20, 20);
            
            jrb4=new JRadioButton("SKU");
            jrb4.setBounds(20, 170, 20, 20);
            
            jrb5=new JRadioButton("SKU");
            jrb5.setBounds(20, 220, 20, 20);
            
            jrb6=new JRadioButton("SKU");
            jrb6.setBounds(20, 270, 20, 20);
            
            jrb7=new JRadioButton("SKU");
            jrb7.setBounds(20, 320, 20, 20);
           
            jrb8=new JRadioButton("SKU");
            jrb8.setBounds(20, 370, 20, 20);
            
               

            
  
            jb1 = new JButton("Check");
            jb1.setBounds(70, 400, 120, 30);
           
      
          
            jb1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                   
         			try {
         				
         				String url = null;
         				
         				if (jrb1.isSelected()) {
         					url = "https://stockx.com/air-jordan-1-mid-light-smoke-grey";
                          
                  		}
                  		
                  		if (jrb2.isSelected()) {
                  			url = "https://stockx.com/new-balance-550-white-grey";
                         
                  		}
                  		
                  		if (jrb3.isSelected()) {
                  			url = "https://stockx.com/air-jordan-1-low-aluminum-w";
                   
                  		}
                  		
                  		if (jrb4.isSelected()) {
                  			url = "https://stockx.com/nike-dunk-high-university-red";
                   
                  		}
                  		
                  		if (jrb5.isSelected()) {
                  			url = "https://stockx.com/nike-dunk-low-retro-white-black-2021";
                   
                  		}
                  		
                  		if (jrb6.isSelected()) {
                  			url = "https://stockx.com/nike-dunk-high-panda-2021-w";
                   
                  		}
                  		
                  		if (jrb7.isSelected()) {
                  			url = "https://stockx.com/air-jordan-9-retro-fire-red";
                   
                  		}
                  		
                  		if (jrb8.isSelected()) {
                  			url = "https://stockx.com/adidas-yeezy-slide-bone-2022";
                   
                  		}
 				
         				
         					java.net.URI uri = java.net.URI.create(url);
         					java.awt.Desktop dp = java.awt.Desktop.getDesktop();
         					if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
         					dp.browse(uri);
         					}

         				} catch (java.lang.NullPointerException e1) {				
         				e1.printStackTrace();
         				} catch (java.io.IOException e1) {		
         				e1.printStackTrace();
         				}
                }
            });
           
            

            jb2=new JButton("Back");
            jb2.setBounds(460,400,120,30);
            jb2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new menu();
                    jf.dispose();
                }
            });
          
            
     
            jf.add(l1);           
            jf.add(l2);           
            jf.add(l3);
            jf.add(l4);           
            jf.add(l5);           
            jf.add(l6);
            jf.add(l7);           
            jf.add(l8);           
            
            jf.add(jb1);
            jf.add(jb2);
            
            jf.add(jrb1);
            jf.add(jrb2);
            jf.add(jrb3);
            jf.add(jrb4);
            jf.add(jrb5);
            jf.add(jrb6);
            jf.add(jrb7);
            jf.add(jrb8);
             
            bg.add(jrb1);
            bg.add(jrb2);
            bg.add(jrb3);
            bg.add(jrb4);
            bg.add(jrb5);
            bg.add(jrb6);
            bg.add(jrb7);
            bg.add(jrb8);

            jrb1.setSelected(true);
            
            jf.setVisible(true);
    }
}