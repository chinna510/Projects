package com.socket.SimpleSocketProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static final String URL = "jdbc:mysql://localhost:3306/bizruntime";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASSWORD = "root";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_CLASS);
		Connection connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		return connection;
	}

	public static void dbCleanUp(Connection conn) {
		close(conn);
	}

	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException sqlexp) {
				sqlexp.printStackTrace();
			}
		}
	}
}
