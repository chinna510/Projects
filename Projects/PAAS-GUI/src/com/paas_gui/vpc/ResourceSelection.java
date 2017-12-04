package com.paas_gui.vpc;

public class ResourceSelection {

	private String rank;
	private String name;
	private String container_types;
	private String environment_types;
	private String host_groups;
	private String placement;
	private String minimum;

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContainer_types() {
		return container_types;
	}

	public void setContainer_types(String container_types) {
		this.container_types = container_types;
	}

	public String getEnvironment_types() {
		return environment_types;
	}

	public void setEnvironment_types(String environment_types) {
		this.environment_types = environment_types;
	}

	public String getHost_groups() {
		return host_groups;
	}

	public void setHost_groups(String host_groups) {
		this.host_groups = host_groups;
	}

	public String getPlacement() {
		return placement;
	}

	public void setPlacement(String placement) {
		this.placement = placement;
	}

	public String getMinimum() {
		return minimum;
	}

	public void setMinimum(String minimum) {
		this.minimum = minimum;
	}

}
