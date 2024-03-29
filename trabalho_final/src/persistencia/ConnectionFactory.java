package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String password = "<senha>";
		String url = "jdbc:postgresql://127.0.0.1:5432/clube";
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException ex) {
			System.err.print(ex.getMessage());
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		}
		
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			//System.err.print(e.getMessage());
		}
	}
}
