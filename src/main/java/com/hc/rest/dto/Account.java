package com.hc.rest.dto;

import com.hrt.data.db.beans.User;
import com.hrt.data.db.enums.UserRole;

public class Account {

	String role;
	String token;
	String firstName;
	String lastName;
	String email;
	String password;
	String rememberMe;
	String authenticated;
	String userId;
	
	User user;
		
	public Account() { }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

	public String getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(String authenticated) {
		this.authenticated = authenticated;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public User getUser() {	
		if(user == null) {
			user = new User();
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPaid(0);
			user.setPassword(password);
			user.setRegistered(1);			
			user.setStatus(0);
			
			if(role.equals("0") || role.equals("Teacher")){
				user.setRole(0);
			} else if(role.equals("1")|| role.equals("Parent")){
				user.setRole(1);
			} else if(role.equals("2")|| role.equals("Student")){
				user.setRole(2);
			} else if(role.equals("3")|| role.equals("Admin")){
				user.setRole(3);
			} else {
				user.setRole(6);  // Other
			}
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Account [role=" + role + ", token=" + token + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", rememberMe=" + rememberMe + ", authenticated="
				+ authenticated + ", userId=" + userId + ", getRole()=" + getRole() + ", getToken()=" + getToken()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()="
				+ getEmail() + ", getPassword()=" + getPassword() + ", getRememberMe()=" + getRememberMe()
				+ ", getAuthenticated()=" + getAuthenticated() + ", getUserId()=" + getUserId() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	

}
