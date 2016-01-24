package com.hc.services;

import java.util.Set;

import org.skife.jdbi.v2.sqlobject.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrt.data.db.beans.ZipCode;
import com.hrt.data.db.dao.ZipCodeDao;
import com.hrt.data.db.dao.ZipCodes;

@Component
public class ZipCodeServiceImpl implements ZipCodes {

	@Autowired
	ZipCodeDao zipCodeDao;
	
	public ZipCodeServiceImpl() {
		super();
	}

	@Autowired
	public ZipCodeServiceImpl(ZipCodeDao dao) {
		this.zipCodeDao = dao;
	}

	@Transaction
	public void addZipCode(ZipCode zip) {
		
		try {
			zipCodeDao.addZipCode(zip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Set<String> getAllZips(){
		return zipCodeDao.getAllZips();		
	}

	@Override
	public int insert(ZipCode something) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<String> getAll() {
		// TODO Auto-generated method stub
		return null;
	}



}
