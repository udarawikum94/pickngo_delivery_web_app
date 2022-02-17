package com.esoft.coursework.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esoft.coursework.daoimpl.VehicleDAOImpl;
import com.esoft.coursework.domain.Vehicle;

@Service
public class VehicleServiceImpl {
	@Autowired
	private VehicleDAOImpl vehicleDAOImpl;
	
	public VehicleDAOImpl getVehicleDAOImpl() {
		return vehicleDAOImpl;
	}
	public void setVehicleDAOImpl(VehicleDAOImpl vehicleDAOImpl) {
		this.vehicleDAOImpl = vehicleDAOImpl;
	}

	@Transactional
	public Vehicle getById(Long id) {
		return getVehicleDAOImpl().getById(id);
	}
	
	@Transactional
	public Vehicle getByVehicleNo(String vehicleNo) {
		return getVehicleDAOImpl().getByVehicleNo(vehicleNo);
	}
	
	@Transactional
	public List<Vehicle> getAll() {
		return getVehicleDAOImpl().getAll();
	}
	
	@Transactional
	public boolean isExistById(Long id) {
		return getVehicleDAOImpl().isExistById(id);
	}
	
	@Transactional
	public void saveEntity(Vehicle classObj) {
		getVehicleDAOImpl().saveEntity(classObj);
	}
	
	
	@Transactional
	public void updateEntity(Vehicle classObj) {
		getVehicleDAOImpl().updateEntity(classObj);
	}
	
	@Transactional
	public void deleteEntity(Vehicle classObj) {
		getVehicleDAOImpl().deleteEntity(classObj);
	}
}
