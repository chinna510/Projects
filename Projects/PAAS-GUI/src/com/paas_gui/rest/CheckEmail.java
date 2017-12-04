package com.paas_gui.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;
import com.paas_gui.dbconnection.DBConnection;

public class CheckEmail {
	private static final String SELECTSQL = "SELECT email from register";
	final Logger log = Logger.getLogger(CheckEmail.class);

	public boolean viewdata(String email) {
		boolean flag = false;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = (Connection) DBConnection.getConnection();
			stmt = (Statement) con.createStatement();
			rs = stmt.executeQuery(SELECTSQL);
				while (rs.next()) {
					log.info("email = " + email);
					String last1 = rs.getString("email");
					log.info("last = " + last1);
					if (last1.equalsIgnoreCase(email)) {
						flag = true;
						log.info("Matched");
						return flag;
					}
				}
				
			
		} catch (SQLException sqlexp) {
			sqlexp.printStackTrace();
			return flag;
		}
		log.info(flag);
		return flag;
	}
}