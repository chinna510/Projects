package com.paas_gui.vpc;

public class Vpc_pozo {
	private String vpc_name;
	private String vpc_region;
	private String cidr;
	private String acl;

	public Vpc_pozo() {

	}

	public Vpc_pozo(String vpc_name, String vpc_region, String cidr, String acl) {
		super();
		this.vpc_name = vpc_name;
		this.vpc_region = vpc_region;
		this.cidr = cidr;
		this.acl = acl;

	}

	public String getVpc_name() {
		return vpc_name;
	}

	public void setVpc_name(String vpc_name) {
		this.vpc_name = vpc_name;
	}

	public String getVpc_region() {
		return vpc_region;
	}

	public void setVpc_region(String vpc_region) {
		this.vpc_region = vpc_region;
	}

	public String getCidr() {
		return cidr;
	}

	public void setCidr(String cidr) {
		this.cidr = cidr;
	}

	public String getAcl() {
		return acl;
	}

	public void setAcl(String acl) {
		this.acl = acl;
	}

}
