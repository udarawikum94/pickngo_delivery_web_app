package com.esoft.coursework.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esoft.coursework.daoimpl.DistrictDAOImpl;
import com.esoft.coursework.domain.District;

@Service
public class DistrictServiceImpl {
	@Autowired
	private DistrictDAOImpl districtDAOImpl;

	public DistrictDAOImpl getDistrictDAOImpl() {
		return districtDAOImpl;
	}
	public void setDistrictDAOImpl(DistrictDAOImpl districtDAOImpl) {
		this.districtDAOImpl = districtDAOImpl;
	}

	@Transactional
	public District getById(Long id) {
		return getDistrictDAOImpl().getById(id);
	}
	
	@Transactional
	public List<District> getAll() {
		return getDistrictDAOImpl().getAll();
	}
	
	@Transactional
	public boolean isExistById(Long id) {
		return getDistrictDAOImpl().isExistById(id);
	}
	
	@Transactional
	public boolean isExistByCode(String code) {
		return getDistrictDAOImpl().isExistByCode(code);
	}
	
	@Transactional
	public void save(District district) {
		getDistrictDAOImpl().save(district);
	}
	
	
	@Transactional
	public void update(District district) {
		getDistrictDAOImpl().update(district);
	}
	
	@Transactional
	public void delete(District district) {
		getDistrictDAOImpl().delete(district);
	}
	
}
