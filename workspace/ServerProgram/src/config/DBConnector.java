package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	
	private static DBConnector connector;
	
	private DBConnector() {}
	
	public static DBConnector getInstance() {
		if(connector == null) {
			connector = new DBConnector();
		}
		return connector;
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.url, DBConfig.username, DBConfig.password);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(con != null) {
				con.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
