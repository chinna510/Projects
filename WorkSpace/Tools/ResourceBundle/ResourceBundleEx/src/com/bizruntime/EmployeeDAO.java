package com.bizruntime;

import com.bizruntime.Employee;

public class EmployeeDAO {
	
	public EmployeeDAOOperation employeeDAOOperation = null;
	public void sendEmployeeDetails() {
		// Logger log = Logger.getLogger(AddEmp.class);
		
		employeeDAOOperation = new EmployeeDAOOperation();
		
		Employee Employee = new Employee();

		Employee.setId(2);
		Employee.setFname("Alok");
		Employee.setLname("Ranjan");
		Employee.setPhno(999995555);

		employeeDAOOperation.insertEmployeeData(Employee);

		// log.debug("The data is inserted successfully !! ");
		System.out.println("The data is inserted successfully !! ");
	}
	
	public void receiveEmployeeDetails(){
		//write code to select the data from database
	}
	
	public static void main(String args[]) {
		EmployeeDAO ae = new EmployeeDAO();
		ae.sendEmployeeDetails();
	}
}