package com.esoft.coursework.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.esoft.coursework.domain.Vehicle;
import com.esoft.coursework.enumeration.RecordStatusEnum;

@Repository
public class VehicleDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Vehicle getById(Long id) {
		Criteria crt = getSession().createCriteria(Vehicle.class);
		crt.add(Restrictions.eq("id", id));
		
		if (crt.uniqueResult()!=null)
			return (Vehicle) crt.uniqueResult();
		return null;
	}
	
	public Vehicle getByVehicleNo(String vehicleNo) {
		Criteria crt = getSession().createCriteria(Vehicle.class);
		crt.add(Restrictions.eq("vehicleNo", vehicleNo));
		crt.add(Restrictions.eq("status", RecordStatusEnum.ACTIVE.getDescription()));
		
		if (crt.uniqueResult()!=null)
			return (Vehicle) crt.uniqueResult();
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Vehicle> getAll() {
		Criteria crt = getSession().createCriteria(Vehicle.class);
		List<Vehicle> allDataList = crt.list();
		
		return allDataList;
	}
	
	public boolean isExistById(Long id) {
		Criteria crt = getSession().createCriteria(Vehicle.class);
		crt.add(Restrictions.eq("id", id));
		
		if (crt.uniqueResult()!=null) 
			return true;
		return false;
	}
	
	public void saveEntity(Vehicle classObj) {
		getSession().save(classObj);
	}
	
	public void updateEntity(Vehicle classObj) {
		getSession().saveOrUpdate(classObj);
	}
	
	public void deleteEntity(Vehicle classObj) {
		getSession().delete(classObj);
	}
}
