package com.hrt.data.db.dao;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.hrt.data.db.beans.ZipCode;

@Component
public class ZipCodeDaoImpl extends DAO implements ZipCodeDao {

	public ZipCodeDaoImpl() {
	}

	public void addZipCode(ZipCode zipCode) {
		ZipCodes dao = DAO.getDBI().onDemand(ZipCodes.class);
		dao.insert(zipCode);

	}
	
	public Set<String> getAllZips() {
		ZipCodes dao = DAO.getDBI().onDemand(ZipCodes.class);
		return dao.getAll();
	}
	
 

}
