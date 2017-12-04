package com.getEmployee.dao;

import com.biz.db.Employee;

public class EmployeeDAO {

	public EmployeeDAOOperation employeeDAOOperation = null;

	public void sendEmployeeDetails() {
		// Logger log = Logger.getLogger(AddEmp.class);

		employeeDAOOperation = new EmployeeDAOOperation();

		Employee Employee = new Employee();

		Employee.setId(5);
		Employee.setFname("chinna");
		Employee.setLname("Rao");
		Employee.setPhno(897055564);

		employeeDAOOperation.insertEmployeeData(Employee);

		// log.debug("The data is inserted successfully !! ");
		System.out.println("The data is inserted successfully !! ");
	}

	public void receiveEmployeeDetails() {
		// write code to select the data from database
	}

	public static void main(String args[]) {
		EmployeeDAO ae = new EmployeeDAO();
		ae.sendEmployeeDetails();
	}
}
