package com.paas_gui.vpc;


public class EnvironmentTypes {

	private String name;
	private String description;
	private String accept_tag;
	private String promote_tag;
	private String action;
	private int restart_interval;
	private int quiet_period;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccept_tag() {
		return accept_tag;
	}

	public void setAccept_tag(String accept_tag) {
		this.accept_tag = accept_tag;
	}

	public String getPromote_tag() {
		return promote_tag;
	}

	public void setPromote_tag(String promote_tag) {
		this.promote_tag = promote_tag;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getRestart_interval() {
		return restart_interval;
	}

	public void setRestart_interval(int restart_interval) {
		this.restart_interval = restart_interval;
	}

	public int getQuiet_period() {
		return quiet_period;
	}

	public void setQuiet_period(int quiet_period) {
		this.quiet_period = quiet_period;
	}


}
