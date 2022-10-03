package com.trippify.trippify.trip.model;

public class ParticularsVO {

	private boolean isRegUser;
	private String name;
	private String email;

	public boolean isRegUser() {
		return isRegUser;
	}

	public void setRegUser(boolean isRegUser) {
		this.isRegUser = isRegUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
