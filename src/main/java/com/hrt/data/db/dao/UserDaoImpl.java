package com.hrt.data.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrt.data.db.beans.User;

@Component
public class UserDaoImpl extends DAO implements UserDao{
	 
	public UserDaoImpl() { }

	public List<User> findAll() {
		Users all = DAO.getDBI().onDemand(Users.class);
		return all.findAll();		
	}
	
	public User findById(long Id) {
		Users dao = DAO.getDBI().onDemand(Users.class);
		return dao.findById(Id);
	}
	
	public long addUser(User user) {
		Users one = DAO.getDBI().onDemand(Users.class);
		return one.insert(user);
	}

	public void updateUser(User user) {

	}

	@Override
	public User findByEmailPassword(String email, String password) {
		Users dao = DAO.getDBI().onDemand(Users.class);
		return dao.findByEmailPassword(email, password);
	}

	@Override
	public User findUserById(long id) {
		Users dao = DAO.getDBI().onDemand(Users.class);
		return dao.findUserById(id);
	}

}
