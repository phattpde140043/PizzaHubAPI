package com.hello.Model;

import java.io.Serializable;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Account implements Serializable {
	private String UserName;
	private String Password;
	
	
	public Account() {
	}
	
	public Account(String userName,String password) {
		UserName = userName;
		Password = password;
	}
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	

}
