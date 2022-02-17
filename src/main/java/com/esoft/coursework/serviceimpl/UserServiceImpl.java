package com.esoft.coursework.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esoft.coursework.daoimpl.UserDAOImpl;
import com.esoft.coursework.domain.User;

@Service
public class UserServiceImpl {
	@Autowired
	private UserDAOImpl userDAOImpl;
	
	public UserDAOImpl getUserDAOImpl() {
		return userDAOImpl;
	}
	public void setUserDAOImpl(UserDAOImpl userDAOImpl) {
		this.userDAOImpl = userDAOImpl;
	}

	@Transactional
	public User getUserById(Long id) {
		return getUserDAOImpl().getUserById(id);
	}
	
	@Transactional
	public List<User> getAllUser() {
		return getUserDAOImpl().getAllUser();
	}
	
	@Transactional
	public boolean isExistUser(Long id) {
		return getUserDAOImpl().isExistUser(id);
	}
	
	@Transactional
	public boolean isExistUserByCode(String code) {
		return getUserDAOImpl().isExistUserByCode(code);
	}
	
	@Transactional
	public void saveUser(User user) {
		getUserDAOImpl().saveUser(user);
	}
	
	
	@Transactional
	public void updateUser(User user) {
		getUserDAOImpl().updateUser(user);
	}
	
	@Transactional
	public void deleteUser(User user) {
		getUserDAOImpl().deleteUser(user);
	}
	
	@Transactional
	public Optional<User> getUserByUsername(String username) {
		return Optional.ofNullable(getUserDAOImpl().getUserByUsername(username));
	}
}
