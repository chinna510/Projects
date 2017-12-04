package com.paas_gui.vpc;

public class ServiceAffinities {
	private String application;
	private String services;
	private String environment_types;
	private String affinity;

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

	public String getAffinity() {
		return affinity;
	}

	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}

}
