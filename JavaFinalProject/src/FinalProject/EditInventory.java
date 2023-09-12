package FinalProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
 
public class EditInventory {
    public static void main(String[] args) {
        new ed();
    }
}
class ed {
        JFrame jf;
        JLabel l1,l2,l3,l4,l5;
        JTextField t1,t2,t3,t4,t5;
        JButton jb1,jb2,jb3,jb4;
        
        
        public ed() {
            jf = new JFrame("Edit Inventory");
            jf.setSize(700,480);
            jf.setLocationRelativeTo(null);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setLayout(null);  
            
            
            l1 = new JLabel("SKU: ");
            l1.setBounds(50, 10, 130, 40);
            t1 = new JTextField(20);
            t1.setBounds(160, 15, 300, 30);
       
            l2 = new JLabel("Brand: ");
            l2.setBounds(50, 60, 130, 40);        
            t2 = new JTextField(20);
            t2.setBounds(160, 65, 300, 30);    

            
            l3 = new JLabel("Name: ");
            l3.setBounds(50, 110, 130, 40);    
            t3 = new JTextField(20);
            t3.setBounds(160, 115, 300, 30);
          
       
            l4 = new JLabel("Quantity: ");
            l4.setBounds(50, 160, 130, 40);         
            t4 = new JTextField(20);
            t4.setBounds(160, 165, 300, 30);
          
            
            l5 = new JLabel("Price: ");
            l5.setBounds(50, 210, 130, 40);         
            t5 = new JTextField(20);
            t5.setBounds(160, 215, 300, 30);
           
            
  
            jb1 = new JButton("Add");
            jb1.setBounds(70, 400, 120, 30);
           
      
          
            jb1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {

                	 Statement st=null;
                     Connection con=null;
                  
                     
                    try {
                        
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");                       
                        String url = "jdbc:sqlserver://localhost:1433;databaseName=Inventory;";                        
                        con = DriverManager.getConnection(url, "sa", "123456");

                        String sql = "INSERT INTO Shoes VALUES('"+t1.getText()+"','"+ t2.getText() +"','" +t3.getText()+"', '"+t4.getText()+"', '"+t5.getText()+"')";
                        st=con.createStatement();
    					int rs=st.executeUpdate(sql);
    				
    	                JOptionPane.showMessageDialog(null, "Successfully added");
    	                            
    	                         
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
           
            
            
            
            
            jb2 = new JButton("Delete");
            jb2.setBounds(200, 400, 120, 30);
            jb2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {

               	 	Statement st=null;
                    Connection con=null;
                    
                    
                   try {
                       
                       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");                       
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=Inventory;";                        
                       con = DriverManager.getConnection(url, "sa", "123456");

                       String sql = "delete from Shoes WHERE SKU = '"+t1.getText()+"'"; 
  
                       st=con.createStatement();
                       int rs =st.executeUpdate(sql);
   				
   	                JOptionPane.showMessageDialog(null, "Successfully deleted");
   	                            
   	                         
                   } catch (ClassNotFoundException ex) {
                       ex.printStackTrace();
                   } catch (SQLException ex) {
                       ex.printStackTrace();
                   }
               }
           });
           
            
            
            jb3 = new JButton("Update");
            jb3.setBounds(330, 400, 120, 30);
            jb3.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {

               	 	Statement st=null;
                    Connection con=null;
                   
                    
                   try {
                       
                       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");                       
                       String url = "jdbc:sqlserver://localhost:1433;databaseName=Inventory;";                        
                       con = DriverManager.getConnection(url, "sa", "123456");

                     
                       
                       String sql = "UPDATE Shoes SET Brand ='"+t2.getText()+"', Name = '"+t3.getText()+"', Quantity = '"+t4.getText()+"', Price = '"+t5.getText()+"' WHERE SKU = '"+t1.getText()+"'";
                       
                       st=con.createStatement();
                       int rs =st.executeUpdate(sql);
   				
   	                JOptionPane.showMessageDialog(null, "Successfully updated");
   	                            
   	                         
                   } catch (ClassNotFoundException ex) {
                       ex.printStackTrace();
                   } catch (SQLException ex) {
                       ex.printStackTrace();
                   }
               }
           });
            
            
            
            jb4=new JButton("Back");
            jb4.setBounds(460,400,120,30);
            jb4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new menu();
                    jf.dispose();
                }
            });
          
                      
            jf.add(l1);
            jf.add(t1);
            jf.add(l2);
            jf.add(t2);
            jf.add(l3);
            jf.add(t3);
            jf.add(l4);
            jf.add(t4);
            jf.add(l5);
            jf.add(t5);
            jf.add(jb1);
            jf.add(jb2);
            jf.add(jb3);
            jf.add(jb4);
            jf.setVisible(true);
    }
}