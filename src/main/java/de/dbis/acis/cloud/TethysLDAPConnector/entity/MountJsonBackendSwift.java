package de.dbis.acis.cloud.TethysLDAPConnector.entity;

import com.google.gson.annotations.SerializedName;

public class MountJsonBackendSwift {
	@SerializedName("class")
	private String class_type;
	private MountJsonOptions options;
	private int priority;
	
	public MountJsonBackendSwift() {
		super();
	}

	public String getClass_type() {
		return class_type;
	}

	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}

	public MountJsonOptions getOptions() {
		return options;
	}

	public void setOptions(MountJsonOptions options) {
		this.options = options;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	} 
}
