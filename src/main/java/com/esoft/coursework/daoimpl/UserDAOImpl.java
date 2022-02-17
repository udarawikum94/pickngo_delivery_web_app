package com.esoft.coursework.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.esoft.coursework.domain.User;

@Repository
public class UserDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public User getUserById(Long id) {
		Criteria crt = getSession().createCriteria(User.class);
		crt.add(Restrictions.eq("id", id));
		
		return (User) crt.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		Criteria crt = getSession().createCriteria(User.class);
		List<User> userList = crt.list();
		
		return userList;
	}
	
	public boolean isExistUser(Long id) {
		Criteria crt = getSession().createCriteria(User.class);
		crt.add(Restrictions.eq("id", id));
		
		if (crt.uniqueResult()!=null) 
			return true;
		return false;
	}
	
	public boolean isExistUserByCode(String code) {
		Criteria crt = getSession().createCriteria(User.class);
		crt.add(Restrictions.eq("code", code));
		
		if (crt.uniqueResult()!=null) 
			return true;
		return false;
	}
	
	public void saveUser(User user) {
		getSession().save(user);
	}
	
	public void updateUser(User user) {
		getSession().saveOrUpdate(user);
	}
	
	public void deleteUser(User user) {
		getSession().delete(user);
	}
	
	public User getUserByUsername(String username) {
		Criteria crt = getSession().createCriteria(User.class);
		crt.add(Restrictions.eq("username", username));
		
		if (crt.uniqueResult()!=null)
			return (User) crt.uniqueResult();
		else
			return null;
	}
}
