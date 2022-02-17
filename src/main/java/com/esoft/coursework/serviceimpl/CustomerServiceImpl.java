package com.esoft.coursework.serviceimpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esoft.coursework.daoimpl.CustomerDAOImpl;
import com.esoft.coursework.domain.Customer;

@Service
public class CustomerServiceImpl {
	@Autowired
	private CustomerDAOImpl customerDAOImpl;
	
	public CustomerDAOImpl getCustomerDAOImpl() {
		return customerDAOImpl;
	}
	public void setCustomerDAOImpl(CustomerDAOImpl customerDAOImpl) {
		this.customerDAOImpl = customerDAOImpl;
	}

	@Transactional
	public Optional<Customer> getById(Long id) {
		return Optional.ofNullable(getCustomerDAOImpl().getById(id));
	}
	
	@Transactional
	public List<Customer> getAll() {
		return getCustomerDAOImpl().getAll();
	}
	
	@Transactional
	public boolean isExist(Long id) {
		return getCustomerDAOImpl().isExistById(id);
	}
	
	@Transactional
	public boolean isExistByCode(String code) {
		return getCustomerDAOImpl().isExistByCode(code);
	}
	
	@Transactional
	public void save(Customer obj) {
		getCustomerDAOImpl().save(obj);
	}
	
	
	@Transactional
	public void update(Customer obj) {
		getCustomerDAOImpl().update(obj);
	}
	
	@Transactional
	public void delete(Customer obj) {
		getCustomerDAOImpl().delete(obj);
	}
	
	@Transactional
	public Long getSequenceNo() {
		return getCustomerDAOImpl().getMaxSequenceNo()+BigDecimal.ONE.longValue();
	}
	
	@Transactional
	public boolean isExistByNicBr(String nicbr) {
		return getCustomerDAOImpl().isExistByNicBr(nicbr);
	}
}
