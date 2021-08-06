package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "spring";
		String password = "1111";
		return DriverManager.getConnection(url, user, password);
	}
		
		
}
