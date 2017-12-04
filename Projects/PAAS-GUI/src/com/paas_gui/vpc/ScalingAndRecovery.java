package com.paas_gui.vpc;

public class ScalingAndRecovery {

	private String application;
	private String services;
	private String environment_types;
	private String desired_count;
	private String auto_recovery;

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getEnvironment_types() {
		return environment_types;
	}

	public void setEnvironment_types(String environment_types) {
		this.environment_types = environment_types;
	}

	public String getDesired_count() {
		return desired_count;
	}

	public void setDesired_count(String desired_count) {
		this.desired_count = desired_count;
	}

	public String getAuto_recovery() {
		return auto_recovery;
	}

	public void setAuto_recovery(String auto_recovery) {
		this.auto_recovery = auto_recovery;
	}

}
