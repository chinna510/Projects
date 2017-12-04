package com.paas_gui.register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.paas_gui.dbconnection.DBConnection;

public class CheckLoginDAO {
	private static final String SELECTSQL = "SELECT password from register where email=?";
	final Logger log = Logger.getLogger(CheckLoginDAO.class);

	public boolean viewdata(String pwd, String email) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = (Connection) DBConnection.getConnection();
			stmt = (PreparedStatement) con.prepareStatement(SELECTSQL);
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				log.info("No data");
				flag = false;
				return flag;
			} 
			else{
				while (rs.next()) {
					log.info("pwd = " + pwd);
					String last1 = rs.getString("password");
					log.info("last = " + last1);
					if (last1.equalsIgnoreCase(pwd)) {
						flag = true;
						log.info("Matched");
						return flag;
					}else {
						log.info("Not Matched");
						flag = false;
						return flag;
						
					}
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