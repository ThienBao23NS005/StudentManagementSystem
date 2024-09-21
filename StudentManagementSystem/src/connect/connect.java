package connect;

import java.sql.*;

public class connect {
	public static Connection getConnection() {
		Connection c = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url = "jdbc:mySQL://localhost:3306/studentmanagementsystem";
			String user = "root";
			String pass = "1234";
			c = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;

	}

}