package com.gl.casestudy4.bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Entity
public class RechargeUsers extends User{
	
	@Id
	private String username;
	private String password;
	
	public RechargeUsers() {
		super("Tulip","Orange",new ArrayList<>());
	}

	public RechargeUsers(String username, String password, Collection<? extends GrantedAuthority> authorities,String username2,String password2) {
		super(username, password, authorities);
		username = username2;
		password = password2;
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
	@Override
	public String toString() {
		return " " + username + " " + password;
	}
	
	
}