package Assignment7;

import java.sql.*;
import java.util.Scanner;

public class Ques1 {

	public static Scanner sc = new Scanner(System.in);
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/cs241_assignments";
		String uname = "root";
		String pass = "mysql";
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			
			Statement st = con.createStatement();
			
			System.out.println("Select a table to print:");
			ResultSet rs = st.executeQuery("show tables");
			int i = 1;
			while(rs.next()) {
				System.out.println(i + ". " + rs.getString("Tables_in_cs241_assignments"));
				i++;
			}
			System.out.println();
			
			int n = Integer.parseInt(sc.nextLine());			
			
			ResultSetMetaData rsmd = null;
			int columnsNumber = 0, k = 0;
			switch(n) {
			case 1:
				rs = st.executeQuery("select * from class");
				rsmd = rs.getMetaData();
				columnsNumber = rsmd.getColumnCount();
			    for(k = 1; k <= columnsNumber; k++) {
			    	System.out.print(rsmd.getColumnName(k) + "                ");
			    }
			    System.out.println("\n");
				while (rs.next()) {
					for (k = 1; k <= columnsNumber; k++) {
				        System.out.print(rs.getString(k) + "        ");
				    }
				    System.out.println("\n");
				}
				break;
			case 2:
				rs = st.executeQuery("select * from enrolled");
				rsmd = rs.getMetaData();
				columnsNumber = rsmd.getColumnCount();
			    for(k = 1; k <= columnsNumber; k++) {
			    	System.out.print(rsmd.getColumnName(k) + "             ");
			    }
			    System.out.println("\n");
				while (rs.next()) {
					for (k = 1; k <= columnsNumber; k++) {
				        System.out.print(rs.getString(k) + "        ");
				    }
				    System.out.println("\n");
				}
				break;
			case 3:
				rs = st.executeQuery("select * from faculty");
				rsmd = rs.getMetaData();
				columnsNumber = rsmd.getColumnCount();
			    for(k = 1; k <= columnsNumber; k++) {
			    	System.out.print(rsmd.getColumnName(k) + "             ");
			    }
			    System.out.println("\n");
				while (rs.next()) {
					for (k = 1; k <= columnsNumber; k++) {
				        System.out.print(rs.getString(k) + "        ");
				    }
				    System.out.println("\n");
				}
				break;
			case 4:
				rs = st.executeQuery("select * from student");
				rsmd = rs.getMetaData();
				columnsNumber = rsmd.getColumnCount();
			    for(k = 1; k <= columnsNumber; k++) {
			    	System.out.print(rsmd.getColumnName(k) + "            ");
			    }
			    System.out.println("\n");
				while (rs.next()) {
					for (k = 1; k <= columnsNumber; k++) {
				        System.out.print(rs.getString(k) + "        ");
				    }
				    System.out.println("\n");
				}
				break;
			default:
				System.out.print("Invalid value.");
			}
			
			st.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
