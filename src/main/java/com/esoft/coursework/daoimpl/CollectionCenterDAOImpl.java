package com.esoft.coursework.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.esoft.coursework.domain.OperationalCenter;

@Repository
public class CollectionCenterDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public OperationalCenter getCollectionCenterById(Long id) {
		Criteria crt = getSession().createCriteria(OperationalCenter.class);
		crt.add(Restrictions.eq("id", id));
		
		return (OperationalCenter) crt.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<OperationalCenter> getAllCollectionCenter() {
		Criteria crt = getSession().createCriteria(OperationalCenter.class);
		List<OperationalCenter> collectionCenterList = crt.list();
		
		return collectionCenterList;
	}
	
	public boolean isExistCollectionCenter(Long id) {
		Criteria crt = getSession().createCriteria(OperationalCenter.class);
		crt.add(Restrictions.eq("id", id));
		
		if (crt.uniqueResult()!=null) 
			return true;
		return false;
	}
	
	public boolean isExistCollectionCenterByCode(String code) {
		Criteria crt = getSession().createCriteria(OperationalCenter.class);
		crt.add(Restrictions.eq("code", code));
		
		if (crt.uniqueResult()!=null) 
			return true;
		return false;
	}
	
	public void saveCollectionCenter(OperationalCenter operationalCenter) {
		getSession().save(operationalCenter);
	}
	
	public void updateCollectionCenter(OperationalCenter operationalCenter) {
		getSession().saveOrUpdate(operationalCenter);
	}
	
	public void deleteCollectionCenter(OperationalCenter operationalCenter) {
		getSession().delete(operationalCenter);
	}
}
