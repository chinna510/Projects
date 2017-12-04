package com.hive.HiveClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class HiveDatabaseCreation {
	Connection con;
	Statement st;
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	static Logger logger = Logger.getLogger(HiveDatabaseCreation.class);

	public void test() throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		con = DriverManager.getConnection("jdbc:hive2://192.168.1.146:10000/", " ", " ");
		String sql = "create database bizruntime5";
		st = con.createStatement();
		st.executeUpdate(sql);

		logger.info("Database bizruntime created successfully.");
		con.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		HiveDatabaseCreation db = new HiveDatabaseCreation();
		db.test();
	}

}
