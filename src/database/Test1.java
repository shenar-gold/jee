package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.print("Driver class loaded");
		
		String url = "jdbc:mysql://localhost:3306/db1"; 
		String user = "root";
		String psw = "Root5827";
		
		Connection con = DriverManager.getConnection(url,user,psw);
		
		Statement st = con.createStatement();
		
		String sql = "Select * from users";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println(rs.getString(1)+ ": "+ rs.getString(2));
		}		
		
	}

}
