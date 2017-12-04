package com.task;

import java.util.Arrays;

public class User1 {
	private String fname;
	private String lname;
	private String[] address;
	private long phone;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String[] getAddress() {
		return address;
	}

	public void setAddress(String[] address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return fname + "" + lname + " , " + Arrays.toString(address) + "," + phone;
	}

}
