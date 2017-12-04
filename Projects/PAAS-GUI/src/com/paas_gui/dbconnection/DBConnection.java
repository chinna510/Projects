package com.paas_gui.dbconnection;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class DBConnection {

	private static final Logger log = Logger.getLogger(DBConnection.class);
	
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");  //load the class
		} catch (ClassNotFoundException e) {
			log.info(e.getMessage());
			
		}
	}
	

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/bizruntime";
		Connection conn = DriverManager.getConnection(url, "root", "password");  //get the connection
		return conn;
	}

	
	public static void cleanup(Statement st, Connection conn) {      //close the resources
		try {
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	       
	
	public static void cleanup(ResultSet rs, Statement st, Connection conn) {     //close the resources
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}