package com.esoft.coursework.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esoft.coursework.daoimpl.CollectionCenterDAOImpl;
import com.esoft.coursework.domain.CollectionCenter;

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
	public CollectionCenter getCollectionCenterById(Long id) {
		return getCollectionCenterDAOImpl().getCollectionCenterById(id);
	}
	
	@Transactional
	public List<CollectionCenter> getAllCollectionCenter() {
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
	public void saveCollectionCenter(CollectionCenter collectionCenter) {
		getCollectionCenterDAOImpl().saveCollectionCenter(collectionCenter);
	}
	
	
	@Transactional
	public void updateCollectionCenter(CollectionCenter collectionCenter) {
		getCollectionCenterDAOImpl().updateCollectionCenter(collectionCenter);
	}
	
	@Transactional
	public void deleteCollectionCenter(CollectionCenter collectionCenter) {
		getCollectionCenterDAOImpl().deleteCollectionCenter(collectionCenter);
	}
}
