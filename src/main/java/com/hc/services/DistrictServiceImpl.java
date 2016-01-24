/**
 * 
 */
package com.hc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrt.data.db.beans.District;
import com.hrt.data.db.dao.DistrictDao;

@Component
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	DistrictDao districtDao;
	
	@Autowired
	public DistrictServiceImpl(DistrictDao dao) {
		this.districtDao = dao;
	}

	public void addDistrict(District district) {
		
		try {
			districtDao.addDistrict(district);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public District findById(long id) {
		return districtDao.findById(id);
	}

	public List<District> findAll() {
		return districtDao.findAll();
	}

	public List<District> findByZip(String zip) {
		return districtDao.findByZip(zip);
	}
	
}
