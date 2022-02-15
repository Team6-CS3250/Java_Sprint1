// Hey!  I split this class from the CRUD-operations as this 
// class is vital for integrating witht SQLite.  From what I 
// can tell I have been able to establish connection to the 
// database "inputdata.db" (which I created in DB Browser for the moment).
import java.sql.*;

public class DbConnection {
	
	// Connect to database
	public static void connect() {
        Connection con = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/GitHub/Java_Sprint1/inputdata.db";
            // create a connection to the database
            con = DriverManager.getConnection(url);
            
            System.out.println("Connection to the database has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
