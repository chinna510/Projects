package com.paas_gui.vpc;

public class CloudProviders {

	private String name;
	private String type;
	private String private_cloud;
	private String description;
	private String default_region;
	private int account_id;
	private String external_id;
	private String role_arn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrivate_cloud() {
		return private_cloud;
	}

	public void setPrivate_cloud(String private_cloud) {
		this.private_cloud = private_cloud;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDefault_region() {
		return default_region;
	}

	public void setDefault_region(String default_region) {
		this.default_region = default_region;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getExternal_id() {
		return external_id;
	}

	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}

	public String getRole_arn() {
		return role_arn;
	}

	public void setRole_arn(String role_arn) {
		this.role_arn = role_arn;
	}

}
