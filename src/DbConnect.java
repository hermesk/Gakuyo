
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DbConnect {

 public static Connection connecrDb(){
      
 
       try{
            String url3 = "jdbc:sqlserver://192.168.0.148:1433;databaseName=gakuyo";
            String user="dab";
            String pass="3306";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn=DriverManager.getConnection(url3,user,pass);
            System.out.println("Connected Successfully");
              return conn;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        }
      return null;   
    
 }
    
}
