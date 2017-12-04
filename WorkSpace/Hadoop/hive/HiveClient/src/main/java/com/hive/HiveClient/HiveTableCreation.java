package com.hive.HiveClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class HiveTableCreation {
	Connection con;
	Statement st;
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	static Logger logger = Logger.getLogger(HiveTableCreation.class);

	public void test() throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		con = DriverManager.getConnection("jdbc:hive2://192.168.1.146:10000/bizruntime2", "", "");
		String sql = "CREATE TABLE IF NOT EXISTS Customers (CustomerID int, CustomerName string ,ContactName string,Address string,PostalCode int) PARTITIONED BY(City STRING, country STRING) row format delimited fields terminated by '\t'  stored as textfile LOCATION '/user/hive/warehouse/input/jdbc.txt'";
		st = con.createStatement();
		st.executeQuery(sql);
		logger.info("Table created successfully.");
		con.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		HiveTableCreation table = new HiveTableCreation();
		table.test();
	}

}
