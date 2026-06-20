package newmonstergame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MonsterDAO {

	public int insertMonster(Monster monster) throws SQLException {

		Connection con = null;
		String sql = "INSERT INTO MONSTER(NAME,HP ,ATTACK)VALUES(?,?,?)";

		PreparedStatement pst = null;
		int numberOfRows = 0;

		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);

			pst.setString(1, monster.getName());
			pst.setInt(2, monster.getHp());
			pst.setInt(3, monster.getAttack());

			numberOfRows = pst.executeUpdate();
			System.out.println(numberOfRows + "匹のモンスターが登録された！");
			return numberOfRows;
		} finally {

			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}

	public List<Monster> findAll() throws SQLException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			String sql = "SELECT * FROM MONSTER;";
			pst = con.prepareStatement(sql);
			List<Monster> monsters = new ArrayList<Monster>();
			rs = pst.executeQuery();
			while (rs.next()) {

				Monster monster = new Monster(rs.getInt("ID"), rs.getString("NAME"), rs.getInt("HP"),
						rs.getInt("ATTACK"));
				monsters.add(monster);
			}
			return monsters;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}

		}
	}

	public Monster findById(int id) throws SQLException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			String sql = "SELECT * FROM MONSTER WHERE ID = ?";
			pst = con.prepareStatement(sql);

			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				Monster monster = new Monster(rs.getInt("id"), rs.getString("name"), rs.getInt("hp"),
						rs.getInt("attack"));
				return monster;
			}
			return null;

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}

		}
	}

	public int deleteMonster(int id) throws SQLException {

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = DBUtil.getConnection();
			String sql = "DELETE FROM MONSTER WHERE ID = ?";
			pst = con.prepareStatement(sql);

			pst.setInt(1, id);
			int numberOfRows = pst.executeUpdate();
			return numberOfRows;

		} finally {

			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}

		}
	}

	public int updateMonster(Monster monster) throws SQLException {

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = DBUtil.getConnection();
			String sql = "UPDATE MONSTER SET NAME=?,HP=?,ATTACK=? WHERE ID=?";
			pst = con.prepareStatement(sql);

			pst.setString(1, monster.getName());
			pst.setInt(2, monster.getHp());
			pst.setInt(3, monster.getAttack());
			pst.setInt(4, monster.getId());

			int numberOfRows = pst.executeUpdate();
			return numberOfRows;

		} finally {

			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

}
