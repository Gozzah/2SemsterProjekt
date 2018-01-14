package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBC
{
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://212.47.234.177:3306/fog";
    private static String user = "fog";
    private static String password = "1234";
    
    private static PreparedStatement stmt;
    private static Connection conn = null;
    
    
    public static Connection getConnection()
    {
        if (conn == null)
        {
            try
            {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
            }
            catch (ClassNotFoundException | SQLException ex)
            {
            }
        }
        
        return conn;
    }
     
      public static PreparedStatement preparedStatement(String SQLString) throws ClassNotFoundException, SQLException {
          stmt = DBC.getConnection().prepareStatement(SQLString, 0);
          return stmt;
      }
      
    
      public static PreparedStatement prepareKeys(String SQLString, int i) throws ClassNotFoundException, SQLException {
          stmt = DBC.getConnection().prepareStatement(SQLString, 1);
          return stmt;
      }
}