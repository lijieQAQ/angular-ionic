package com.culture.util;

import org.json.JSONObject;

public class Property {
	private String type;
	private String name;
	private String role;
	private Object value;
	private String generic;
	
	public Property(String type, String name, String role) {
		super();
		this.type = type;
		this.name = name;
		this.role = role;
	}
	
	public Property(String type, String name, String role, Object value) {
		super();
		this.type = type;
		this.name = name;
		this.role = role;
		this.value = value;
	}

	public Property() {
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	public String getGeneric() {
		return generic;
	}

	public void setGeneric(String generic) {
		this.generic = generic;
	}

	public JSONObject toJson(){
		return new JSONObject(this);
		
	}

}
