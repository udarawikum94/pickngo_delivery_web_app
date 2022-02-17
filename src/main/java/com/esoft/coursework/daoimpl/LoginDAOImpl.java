package com.esoft.coursework.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.esoft.coursework.domain.User;

@Repository
public class LoginDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public User getUserLogin(String userName, String password)  {
		Criteria crt = getSession().createCriteria(User.class);
		crt.add(Restrictions.eq("username", userName));
		crt.add(Restrictions.eq("password", password));
		
		return (User) crt.uniqueResult();
	}
	
}
