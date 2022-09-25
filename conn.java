
package hotel.mangement.system;

        
import java.sql.*;


public class conn {
    Connection c ;
    Statement s;
    
    public conn(){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///projhms","root","7619"); 
            
            s =c.createStatement();  
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    
    
    }
    }
    

