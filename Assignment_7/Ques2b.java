package Assignment7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class Ques2b {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost:3306/cs241_assignments";
		String uname = "root";
		String pass = "mysql";
		
		try {
			
			Connection con = DriverManager.getConnection(url, uname, pass);
			
			System.out.println("Enter the name of a course to print the rooms and the times at which classes for that course will be conducted: ");
			String s = sc.nextLine();
			
			ResultSet rs = null;
			
			PreparedStatement pS = null;
			ResultSetMetaData rsmd = null;
			pS = con.prepareStatement("select room, meets_at from class where name = ?");
			pS.setString(1, s);
			rs = pS.executeQuery();
			rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnName(1) + "   " + rsmd.getColumnName(2));
			
			while(rs.next()) {
				System.out.println(rs.getString("room") + "    " + rs.getString("meets_at"));
			}
			
			pS.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
