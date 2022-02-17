package com.esoft.coursework.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.esoft.coursework.domain.CollectionCenter;

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
	
	public CollectionCenter getCollectionCenterById(Long id) {
		Criteria crt = getSession().createCriteria(CollectionCenter.class);
		crt.add(Restrictions.eq("id", id));
		
		return (CollectionCenter) crt.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<CollectionCenter> getAllCollectionCenter() {
		Criteria crt = getSession().createCriteria(CollectionCenter.class);
		List<CollectionCenter> collectionCenterList = crt.list();
		
		return collectionCenterList;
	}
	
	public boolean isExistCollectionCenter(Long id) {
		Criteria crt = getSession().createCriteria(CollectionCenter.class);
		crt.add(Restrictions.eq("id", id));
		
		if (crt.uniqueResult()!=null) 
			return true;
		return false;
	}
	
	public boolean isExistCollectionCenterByCode(String code) {
		Criteria crt = getSession().createCriteria(CollectionCenter.class);
		crt.add(Restrictions.eq("code", code));
		
		if (crt.uniqueResult()!=null) 
			return true;
		return false;
	}
	
	public void saveCollectionCenter(CollectionCenter collectionCenter) {
		getSession().save(collectionCenter);
	}
	
	public void updateCollectionCenter(CollectionCenter collectionCenter) {
		getSession().saveOrUpdate(collectionCenter);
	}
	
	public void deleteCollectionCenter(CollectionCenter collectionCenter) {
		getSession().delete(collectionCenter);
	}
}
