package com.esoft.coursework.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esoft.coursework.daoimpl.LoginDAOImpl;
import com.esoft.coursework.domain.User;

@Transactional(rollbackOn = Exception.class)
@Service
public class LoginServiceImpl {
	
	@Autowired
	private LoginDAOImpl loginDao;
	
	public LoginDAOImpl getLoginDao() {
		return loginDao;
	}
	public void setLoginDao(LoginDAOImpl loginDao) {
		this.loginDao = loginDao;
	}

	public User getUserLogin(String userName, String password) {
		return getLoginDao().getUserLogin(userName, password);
	}
}
