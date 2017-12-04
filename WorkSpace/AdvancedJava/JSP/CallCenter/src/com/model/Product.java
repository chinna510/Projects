package com.model;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * A software product supported by the Product Support system.
 */
public class Product implements Serializable {
	private String productID;
	private String name;
	private String productSupport;
	private String developer;
	private String tester;

	public static Product load(ResultSet rs) throws SQLException {
		Product product = new Product();
		String value = null;
		value = rs.getString(1);
		if (value != null)
			product.setProductID(value);
		value = rs.getString(2);
		if (value != null)
			product.setName(value);
		value = rs.getString(3);
		if (value != null)
			product.setProductSupport(value);
		value = rs.getString(4);
		if (value != null)
			product.setDeveloper(value);
		value = rs.getString(5);
		if (value != null)
			product.setTester(value);
		return product;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (getProductID() != null)
			sb.append(Util.quote(getProductID()));
		sb.append(",");
		if (getName() != null)
			sb.append(Util.quote(getName()));
		sb.append(",");
		if (getProductSupport() != null)
			sb.append(Util.quote(getProductSupport()));
		sb.append(",");
		if (getDeveloper() != null)
			sb.append(Util.quote(getDeveloper()));
		sb.append(",");
		if (getTester() != null)
			sb.append(Util.quote(getTester()));
		return sb.toString();
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the productSupport ID.
	 */
	public String getProductSupport() {
		return productSupport;
	}

	/**
	 * Sets the productSupport ID.
	 * 
	 * @param productSupport
	 *            the productSupport.
	 */
	public void setProductSupport(String productSupport) {
		this.productSupport = productSupport;
	}

	public String getDeveloper() {
		return developer;
	}

	/**
	 * Sets the developer ID.
	 * 
	 * @param developer
	 *            the developer.
	 */
	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getTester() {
		return tester;
	}

	public void setTester(String tester) {
		this.tester = tester;
	}
}
