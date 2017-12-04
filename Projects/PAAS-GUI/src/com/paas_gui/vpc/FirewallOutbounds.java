package com.paas_gui.vpc;

public class FirewallOutbounds {

	private String out_type;
	private String out_protocol;
	private String out_portrange;
	private String out_source;
	private String out_ip;

	public String getOut_type() {
		return out_type;
	}

	public void setOut_type(String out_type) {
		this.out_type = out_type;
	}

	public String getOut_protocol() {
		return out_protocol;
	}

	public void setOut_protocol(String out_protocol) {
		this.out_protocol = out_protocol;
	}

	public String getOut_portrange() {
		return out_portrange;
	}

	public void setOut_portrange(String out_portrange) {
		this.out_portrange = out_portrange;
	}

	public String getOut_source() {
		return out_source;
	}

	public void setOut_source(String out_source) {
		this.out_source = out_source;
	}

	public String getOut_ip() {
		return out_ip;
	}

	public void setOut_ip(String out_ip) {
		this.out_ip = out_ip;
	}

}
