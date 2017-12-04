package com.hive.HiveClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class HiveJoins {
	Connection con;
	Statement st;
	ResultSet rs;
	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	static Logger logger = Logger.getLogger(HiveGroupBy.class);

	public void test() throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		con = DriverManager.getConnection("jdbc:hive://192.168.1.146:10000/bizruntime", "", "");
		String sql = "INSERT OVERWRITE TABLE JoinTable SELECT emp.*, sal.gender, sal.age FROM Employee emp FULL OUTER JOIN Salaries sal ON (sal.userid = emp.eid) WHERE emp.country = 'USA';";
		st = con.createStatement();
		rs = st.executeQuery(sql);
		logger.info("Data Retrived Group By City successfully.");
		while (rs.next()) {
			String cname = rs.getString("CustomerName");
			String ctname = rs.getString("ContactName");
			String address = rs.getString("Address");
			String city = rs.getString("City");
			int code = rs.getInt("PostalCode");
			logger.info(cname + "/t" + ctname + "/t" + address + "/t" + city + "/t" + code);

		}
		con.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		HiveGroupBy retrieve = new HiveGroupBy();
		retrieve.test();
	}

}
