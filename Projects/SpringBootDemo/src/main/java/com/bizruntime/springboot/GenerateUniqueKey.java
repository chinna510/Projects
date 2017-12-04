package com.bizruntime.springboot;


public class GenerateUniqueKey {

	private int key;
	
	public GenerateUniqueKey(){ }

	public GenerateUniqueKey(int key) {
		super();
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
}
