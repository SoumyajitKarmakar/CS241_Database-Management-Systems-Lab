package Assignment7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Ques2d {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost:3306/cs241_assignments";
		String uname = "root";
		String pass = "mysql";
		
		try {
			
			Connection con = DriverManager.getConnection(url, uname, pass);
			
			System.out.println("Printing all faculty members who belong to department 20 and whose courses are conducted in room R128: \n");
			
			ResultSet rs = null;
			
			PreparedStatement pS = null;
			ResultSetMetaData rsmd = null;
			pS = con.prepareStatement("select fname from faculty, class where faculty.fid = class.fid and room = 'R128' and deptid = 20");
			rs = pS.executeQuery();
			rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnName(1));
			
			while(rs.next()) {
				System.out.println(rs.getString("fname"));
			}
			
			pS.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
