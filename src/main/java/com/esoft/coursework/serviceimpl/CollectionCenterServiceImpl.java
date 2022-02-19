package com.esoft.coursework.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esoft.coursework.daoimpl.CollectionCenterDAOImpl;
import com.esoft.coursework.domain.OperationalCenter;

@Service
public class CollectionCenterServiceImpl {
	@Autowired
	private CollectionCenterDAOImpl collectionCenterDAOImpl;
	
	public CollectionCenterDAOImpl getCollectionCenterDAOImpl() {
		return collectionCenterDAOImpl;
	}
	public void setCollectionCenterDAOImpl(CollectionCenterDAOImpl collectionCenterDAOImpl) {
		this.collectionCenterDAOImpl = collectionCenterDAOImpl;
	}

	@Transactional
	public OperationalCenter getCollectionCenterById(Long id) {
		return getCollectionCenterDAOImpl().getCollectionCenterById(id);
	}
	
	@Transactional
	public List<OperationalCenter> getAllCollectionCenter() {
		return getCollectionCenterDAOImpl().getAllCollectionCenter();
	}
	
	@Transactional
	public boolean isExistCollectionCenter(Long id) {
		return getCollectionCenterDAOImpl().isExistCollectionCenter(id);
	}
	
	@Transactional
	public boolean isExistCollectionCenterByCode(String code) {
		return getCollectionCenterDAOImpl().isExistCollectionCenterByCode(code);
	}
	
	@Transactional
	public void saveCollectionCenter(OperationalCenter operationalCenter) {
		getCollectionCenterDAOImpl().saveCollectionCenter(operationalCenter);
	}
	
	
	@Transactional
	public void updateCollectionCenter(OperationalCenter operationalCenter) {
		getCollectionCenterDAOImpl().updateCollectionCenter(operationalCenter);
	}
	
	@Transactional
	public void deleteCollectionCenter(OperationalCenter operationalCenter) {
		getCollectionCenterDAOImpl().deleteCollectionCenter(operationalCenter);
	}
}
