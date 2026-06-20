package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestLoginDAO {
	
	    private Connection con;

	    public TestLoginDAO(Connection con) {
	        this.con = con;
	    }

	    public boolean login(String id, String password) {

	        String sql =
	                "SELECT * FROM users "
	              + "WHERE id = ? "
	              + "AND password = ?";

	        try {

	            PreparedStatement ps =
	                    con.prepareStatement(sql);

	            ps.setString(1, id);
	            ps.setString(2, password);

	            ResultSet rs = ps.executeQuery();

	            return rs.next();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return false;
	    }
	}

