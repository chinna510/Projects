package com.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.istack.logging.Logger;

public class UserDAO {
	Logger log = Logger.getLogger(UserDAO.class);
	String id, name;
	String user1="";
	
	private static final String SELECTSQL = "SELECT * FROM user WHERE ID = ?";

	public String viewdata(User user) throws ClassNotFoundException {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
				con = (Connection) DBConnection.getConnection();
				
			pstmt = (PreparedStatement) con.prepareStatement(SELECTSQL);
			pstmt.setInt(1, user.getId());
			log.info("The befor displayed ");
			ResultSet rs = pstmt.executeQuery();
			log.info("The after displayed ");
			while (rs.next()) {
				id = rs.getString("id");
				name = rs.getString("name");
				log.info("-----------");
				log.info(id + " " + name);
				log.info("The data RS displayed ");
				user1=id + " " + name;
			}

		} catch (SQLException exp) {
			log.logSevereException(exp);
		}finally {
			DBConnection.dbCleanUp(con);
		}
		return user1;
	}
}
