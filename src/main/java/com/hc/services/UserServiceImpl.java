package com.hc.services;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hrt.data.db.beans.User;
import com.hrt.data.db.dao.UserDao;

@Component
@Service
public class UserServiceImpl implements UserService {
		
	@Autowired
	UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;		
	}
	
	public List<User> getAllUsers() {			
		return userDao.findAll();		
	}
	
	public User getUser( long Id) {		
		return userDao.findById(Id);		
	}
	
	public User getUserById( long Id) {		
		return userDao.findUserById(Id);		
	}

	@Transaction
	public long addUser(User user) {
		long userId = userDao.addUser(user);
		
		//
		// insert a record into the webUser table [ userId, user.token ]
		// TODO: create a WebUser DTO-DAO-Etc..
		
		return userId;	
	}

	@Override
	public User getUser(String email, String password) {
		return userDao.findByEmailPassword(email, password);
	}	
}
