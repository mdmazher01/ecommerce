package com.mazher.ecom.entity;

import java.util.Set;

public class AuthResponse {
	
	private Long id;
	private String email;
	private String accessToken;
	private Set<Role> roles;
	
	
	
	
	



	public AuthResponse(Long id, String email, String accessToken, Set<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.accessToken = accessToken;
		this.roles = roles;
	}
	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	
	
	

}
