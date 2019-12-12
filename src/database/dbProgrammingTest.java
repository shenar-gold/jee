package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbProgrammingTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.print("Driver class loaded");
		
		String url = "jdbc:mysql://localhost:3306/db1"; 
		String user = "root";
		String psw = "Root5827";
		
		Connection con = DriverManager.getConnection(url,user,psw);
		
		Statement st = con.createStatement();
		
		final String create_table_sql = "create table db1.books ("				
				+ "uid int not null,"
				+ "name varchar(45) not null,"
				+ "primary key (uid))";

		String query = "insert into db1.books (uid, name) values (1, 'Data structures')";
//		st.executeUpdate(create_table_sql);
		st.executeUpdate(query);
	}

}
