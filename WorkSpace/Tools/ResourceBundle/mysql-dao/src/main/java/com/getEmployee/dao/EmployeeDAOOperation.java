package com.getEmployee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.biz.DBConnection.DBConnection;
import com.biz.db.Employee;

public class EmployeeDAOOperation {

	private static final String INSERTSQL = "INSERT INTO employee (id, firstname, lastname, phno) VALUES (?, ?, ?, ?)";

	public boolean insertEmployeeData(Employee emp) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBConnection.getConnection();

			pstmt = (PreparedStatement) con.prepareStatement(INSERTSQL);
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getFname());
			pstmt.setString(3, emp.getLname());
			pstmt.setInt(4, emp.getPhno());

			pstmt.executeUpdate();

		} catch (SQLException sqlexp) {
			// log.error(sqlexp.getMessage());
			System.out.println(sqlexp);
		} catch (ClassNotFoundException e) {
			// log.error(e.getMessage());
			System.out.println(e);
		} finally {
			DBConnection.dbCleanUp(con, pstmt);
		}
		return true;
	}

	public void updateEmployeeDetail() {

		// impl how to get the data from emp

	}
}
