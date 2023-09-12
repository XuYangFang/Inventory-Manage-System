package FinalProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

 
public class CheckInventory {
    public static void main(String[] args) {
        new search();
    }
}
class search {
    JLabel l1;
    
    private JTextArea jta;  
    private JScrollPane jsp;  
    private JPanel jp; 
    private JTextField jtf;  
    private JButton jb,jb2;   
    JFrame jf;
    private JRadioButton jrb1, jrb2, jrb3;
    private ButtonGroup bg;
    
    public search(){
       
        jta=new JTextArea();
        jf = new JFrame("Search");       
        jsp=new JScrollPane(jta);   
        jp=new JPanel();
        bg =  new ButtonGroup();
        jrb1=new JRadioButton("SKU");
        jrb2=new JRadioButton("Brand");
        jrb3=new JRadioButton("Name");
        l1 = new JLabel(":");
        jtf=new JTextField(10);
        jb=new JButton("Search");
       
        jb2=new JButton("Back");
        jb2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new menu();
                jf.dispose();
            }
        });
        jp.add(jrb1);
        jp.add(jrb2);
        jp.add(jrb3);
        jp.add(l1);
        jp.add(jtf);
        jp.add(jb);
        jp.add(jb2);
        
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        jrb1.setSelected(true);
 
       
        jf.add(jsp, BorderLayout.CENTER);
        jf.add(jp,BorderLayout.SOUTH);
        jf.setSize(600,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
 
       
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Statement st=null;
                Connection con=null;
                ResultSet rs=null;
                try {
                   
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");                 
                    String url = "jdbc:sqlserver://localhost:1433;databaseName=Inventory";                
                    con = DriverManager.getConnection(url, "sa", "123456");                 
                    String sql = null;
                    
                    if (jrb1.isSelected()) {
                      sql = "SELECT * FROM Shoes WhERE SKU LIKE "+"'%"+jtf.getText()+"%'";
                    
            		}
            		
            		if (jrb2.isSelected()) {
            		 sql = "SELECT * FROM Shoes WhERE Brand LIKE "+"'%"+jtf.getText()+"%'";
                   
            		}
            		
            		if (jrb3.isSelected()) {
            		 sql = "SELECT * FROM Shoes WhERE Name LIKE "+"'%"+jtf.getText()+"%'";
             
            		}
            		st=con.createStatement();
					rs=st.executeQuery(sql);

                    String text;
                    while (rs.next()){
                            text ="SKU: "+rs.getString("SKU")
                            	 	+"||     Brand: "+rs.getString("Brand")
                            		+"     ||     Name: "+rs.getString("Name")
                            		+"     ||     Quantity: "+rs.getString("Quantity")
                            		+"     ||     Price: "+rs.getString("Price")+"\n\n";
                            jta.append(text);    
                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}