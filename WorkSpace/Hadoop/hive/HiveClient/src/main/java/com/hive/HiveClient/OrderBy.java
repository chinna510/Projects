package com.hive.HiveClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class OrderBy {
	Connection con;
	Statement st;
	ResultSet rs;
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	static Logger logger = Logger.getLogger(OrderBy.class);

	public void test() throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		con = DriverManager.getConnection("jdbc:hive2://192.168.1.146:10000/bizruntime2", "", "");
		String sql = "FROM customers emp INSERT OVERWRITE TABLE cust_details SELECT emp.CustomerName,emp.ContactName,emp.Address,emp.City,emp.PostalCode ORDER BY CustomerName";
		st = con.createStatement();
		st.execute(sql);
		logger.info("Data Retrived successfully.");
		String sql1 = "select * from cust_details";
		logger.info("Running "+ sql1);
		rs = st.executeQuery(sql1);
		while (rs.next()) {
			logger.info(String.valueOf(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
					+ "\t" + rs.getInt(5)));

		}
		con.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		OrderBy retrieve = new OrderBy();
		retrieve.test();
	}

}
