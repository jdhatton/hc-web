package com.hc.services;

import java.util.List;

import com.hrt.data.db.beans.User;

public interface UserService {

	public List<User> getAllUsers() ;
	
	public User getUser( long Id);
	
	public User getUser( String email, String password);
	
	public long addUser(User user);
	
	public User getUserById( long Id);
	
}
