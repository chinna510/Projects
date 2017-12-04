package com.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer implements Serializable {
	private String customerID;
	private String name;
	private String phone;

	public static Customer load(ResultSet rs) throws SQLException {
		Customer customer = new Customer();
		String value = null;
		value = rs.getString(1);
		if (value != null)
			customer.setCustomerID(value);
		value = rs.getString(2);
		if (value != null)
			customer.setName(value);
		value = rs.getString(3);
		if (value != null)
			customer.setPhone(value);
		return customer;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (getCustomerID() != null)
			sb.append(Util.quote(getCustomerID()));
		sb.append(",");
		if (getName() != null)
			sb.append(Util.quote(getName()));
		sb.append(",");
		if (getPhone() != null)
			sb.append(Util.quote(getPhone()));
		return sb.toString();
	}

	public String getCustomerID() {
		return customerID;
	}

	/**
	 * Sets the customerID.
	 * 
	 * @param customerID
	 *            the customerID.
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	/**
	 * Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the telephone number.
	 * 
	 * @param phone
	 *            the phone.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
