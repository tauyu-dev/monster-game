package newmonstergame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getConnection() throws SQLException {

		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/monster_game", "root", "pass");

		return con;
	}

}
