package com.musto.rest.model;

public class User {
	private String username;
	private String password;
	private int id;
	
	public User() { 
		
	}
	
	public User (String user, String pwd) {
		this.username = user;
		this.password = pwd;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
