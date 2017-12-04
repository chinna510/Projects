package com.hive.HiveClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DataLoadIntoTable {
	Connection con;
	Statement st;
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	static Logger logger = Logger.getLogger(DataLoadIntoTable.class);

	public void test() throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		con = DriverManager.getConnection("jdbc:hive2://192.168.1.146:10000/bizruntime2", "", "");
		String sql = "LOAD DATA INPATH '/user/hive/warehouse/input/customer.txt' OVERWRITE INTO TABLE customers PARTITION (City='Portland', country='USA')";
		st = con.createStatement();
		st.executeQuery(sql);
		logger.info("Data Loaded into Table successfully.");
		con.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DataLoadIntoTable load = new DataLoadIntoTable();
		load.test();
	}

}