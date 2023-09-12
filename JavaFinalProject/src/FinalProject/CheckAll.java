package FinalProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class CheckAll {
    public static void main(String[] args) {
        new all();
    }
}
class all{
 
    private JTextArea jta;   
    private JScrollPane jsp;   
    private JPanel jp;
    private JButton jb,jb2;  
    JFrame jf;
    public all(){
       
        jta=new JTextArea();
        jf = new JFrame("Inventory");      
        jsp=new JScrollPane(jta);     
        jp=new JPanel();
        jb=new JButton("Check");     
        jb2=new JButton("Back");
        jb2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new menu();
                jf.dispose();
            }
        });
        jp.add(jb);
        jp.add(jb2);
 
        
        jf.add(jsp, BorderLayout.CENTER);
        jf.add(jp,BorderLayout.SOUTH);
        jf.setSize(600,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
 
        
        jb.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Statement st=null;
                Connection con=null;
                ResultSet rs=null;
                try {
                 
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");                 
                    String url = "jdbc:sqlserver://localhost:1433;databaseName=Inventory;";                 
                    con = DriverManager.getConnection(url, "sa", "123456");
                    
                    String sql = "select * from Shoes"; 
                    st=con.createStatement();
                    rs=st.executeQuery(sql);
                    String text;
                    while (rs.next()){
                            text =  "SKU: "+rs.getString(1)+
                            		"||     Brand: "+rs.getString(2)+
                            		"     ||     Name: "+rs.getString(3)+
                            		"     ||     Quantity: "+rs.getInt(4)+
                            		"     ||     Price: "+rs.getDouble(5)+"\n\n";
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