package Assignment7;

import java.sql.*;
import java.util.Scanner;

public class Ques2a {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost:3306/cs241_assignments";
		String uname = "root";
		String pass = "mysql";
		
		try {
			
			Connection con = DriverManager.getConnection(url, uname, pass);
			
			System.out.println("Enter a room number to print the names of all classes that meet in that room: ");
			String s = sc.nextLine();
			
			ResultSet rs = null;
			
			PreparedStatement pS = null;
			ResultSetMetaData rsmd = null;
			pS = con.prepareStatement("select name from class where room = ?");
			pS.setString(1, s);
			rs = pS.executeQuery();
			rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnName(1));
			
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			pS.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
