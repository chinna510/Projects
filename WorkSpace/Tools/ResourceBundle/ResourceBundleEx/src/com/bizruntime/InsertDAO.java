package com.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class InsertDAO {
	Logger log = Logger.getLogger(InsertDAO.class);
	
	int id;
	String name,address;
	
	private static final String INSERTSQL = "INSERT INTO user values(?,?,?)";
	
	public String setData(User user) throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DBConnection.getConnection();
		pstmt = con.prepareStatement(INSERTSQL);
		pstmt.setInt(0, id);
		pstmt.setString(1, name);
		pstmt.setString(2, address);
		
		
		return null;
		
	}

}
