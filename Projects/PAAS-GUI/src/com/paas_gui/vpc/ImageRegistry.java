package com.paas_gui.vpc;

public class ImageRegistry {

	private String name;
	private String location;
	private String version;
	private String private_cloud;
	private String user_name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPrivate_cloud() {
		return private_cloud;
	}

	public void setPrivate_cloud(String private_cloud) {
		this.private_cloud = private_cloud;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}