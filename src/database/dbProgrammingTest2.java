package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbProgrammingTest2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.print("Driver class loaded");
		
		String url = "jdbc:mysql://localhost:3306/db1"; 
		String user = "root";
		String psw = "Root5827";
		
		Connection con = DriverManager.getConnection(url,user,psw);
		
		Statement st = con.createStatement();

//		Passing parameters through executeUpdate method 
		String query = "select * from db1.books";

		
		PreparedStatement ps = con.prepareStatement("insert into db1.books values(?,?)", ResultSet.TYPE_SCROLL_INSENSITIVE); 
		
		ps.setInt(1, 3);
		ps.setString(2, "Programming");
		
//		ps.executeUpdate();
		
		ResultSet rs= st.executeQuery(query);
		while (rs.next()){
			System.out.println(rs.getInt(1)+" : "+rs.getString(2));
		}
		
//		Fetching meta information of query results 
		
		DatabaseMetaData md = con.getMetaData();
		System.out.println(md.getDatabaseProductName());
		System.out.println(md.getDatabaseMajorVersion());
		System.out.println(md.getDriverName());
		System.out.println(md.getURL());
		System.out.println(md.getUserName());
		System.out.println(md.getCatalogs());
		ResultSet columns = md.getColumns(null, null, "books", null);
		while(columns.next()) {
			System.out.print("Column name and size: "+ columns.getString("column_name"));
			System.out.print("("+ columns.getInt("column_size")+") ");
			System.out.println("Data type: " + columns.getString("type_name"));
		}
		
		
		
		
	}

}
