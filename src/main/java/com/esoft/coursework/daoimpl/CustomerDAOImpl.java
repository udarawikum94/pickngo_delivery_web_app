package com.esoft.coursework.daoimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.esoft.coursework.domain.Customer;

@Repository
public class CustomerDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Customer getById(Long id) {
		Criteria crt = getSession().createCriteria(Customer.class);
		crt.add(Restrictions.eq("id", id));
		
		return (Customer) crt.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> getAll() {
		Criteria crt = getSession().createCriteria(Customer.class);
		List<Customer> dataList = crt.list();
		
		return dataList;
	}
	
	public boolean isExistById(Long id) {
		Criteria crt = getSession().createCriteria(Customer.class);
		crt.add(Restrictions.eq("id", id));
		
		if (crt.uniqueResult()!=null) 
			return true;
		return false;
	}
	
	public boolean isExistByCode(String code) {
		Criteria crt = getSession().createCriteria(Customer.class);
		crt.add(Restrictions.eq("code", code));
		
		if (crt.uniqueResult()!=null) 
			return true;
		return false;
	}
	
	public void save(Customer obj) {
		getSession().save(obj);
	}
	
	public void update(Customer obj) {
		getSession().saveOrUpdate(obj);
	}
	
	public void delete(Customer obj) {
		getSession().delete(obj);
	}
	
	public Long getMaxSequenceNo() {
		Criteria crt = getSession().createCriteria(Customer.class);
		crt.setProjection(
		         Projections.projectionList()
		            .add(Projections.groupProperty("id"))
		            .add(Projections.max("id"))
		);
		
		if (crt.uniqueResult()!=null) 
			return (Long) crt.uniqueResult();
		return BigDecimal.ZERO.longValue();
	}
	
	public boolean isExistByNicBr(String nicbr) {
		Criteria crt = getSession().createCriteria(Customer.class);
		crt.add(Restrictions.eq("nicNo", nicbr));
		
		if (crt.uniqueResult()!=null) 
			return true;
		return false;
	}
}
