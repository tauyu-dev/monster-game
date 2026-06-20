package login;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDBUtil {
	

	    private static final String URL =
	            "jdbc:mysql://localhost:3306/login_db";

	    private static final String USER = "root";
	    private static final String PASSWORD = "pass";

	    public static Connection getConnection() throws Exception {

	        Class.forName("com.mysql.cj.jdbc.Driver");

	        return DriverManager.getConnection(
	                URL,
	                USER,
	                PASSWORD
	        );
	    
	}
}
