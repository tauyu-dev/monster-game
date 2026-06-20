package login;

import java.sql.Connection;
import java.util.Scanner;


public class TestMainClass {
	
	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        try {

	            Connection con =
	                    TestDBUtil.getConnection();

	            TestLoginDAO dao =
	                    new TestLoginDAO(con);

	            System.out.print("ID:");
	            String id = sc.nextLine();

	            System.out.print("PASS:");
	            String pass = sc.nextLine();

	            if (dao.login(id, pass)) {
	                System.out.println("ログイン成功");
	            } else {
	                System.out.println("ログイン失敗");
	            }

	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        sc.close();
	    }
	}

