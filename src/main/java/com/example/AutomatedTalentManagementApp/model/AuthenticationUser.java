package com.example.AutomatedTalentManagementApp.model;

public class AuthenticationUser {
	private String status;
	
	public AuthenticationUser(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
