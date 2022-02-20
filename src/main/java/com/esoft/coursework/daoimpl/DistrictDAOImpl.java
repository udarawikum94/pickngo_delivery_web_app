package com.esoft.coursework.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.esoft.coursework.domain.District;

@Repository
public class DistrictDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public District getById(Long id) {
		Criteria crt = getSession().createCriteria(District.class);
		crt.add(Restrictions.eq("id", id));
		
		return (District) crt.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<District> getAll() {
		Criteria crt = getSession().createCriteria(District.class);
		List<District> userList = crt.list();
		
		return userList;
	}
	
	public boolean isExistById(Long id) {
		Criteria crt = getSession().createCriteria(District.class);
		crt.add(Restrictions.eq("id", id));
		
		if (crt.uniqueResult()!=null) 
			return true;
		return false;
	}
	
	public boolean isExistByCode(String code) {
		Criteria crt = getSession().createCriteria(District.class);
		crt.add(Restrictions.eq("code", code));
		
		if (crt.uniqueResult()!=null) 
			return true;
		return false;
	}
	
	public void save(District district) {
		getSession().save(district);
	}
	
	public void update(District district) {
		getSession().saveOrUpdate(district);
	}
	
	public void delete(District district) {
		getSession().delete(district);
	}
	
}
