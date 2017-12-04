package com.paas_gui.vpc;

public class ContainerTypes {

	private String name;
	private int cpu_shares;
	private int memory;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCpu_shares() {
		return cpu_shares;
	}

	public void setCpu_shares(int cpu_shares) {
		this.cpu_shares = cpu_shares;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
