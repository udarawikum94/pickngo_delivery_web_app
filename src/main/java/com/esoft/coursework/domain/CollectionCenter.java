package com.esoft.coursework.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.MapModifiedUserEntity;

/**
 * @author Udara Wikum
 * @since 20/11/2021 7.59PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "collection_center")
public class CollectionCenter extends MapModifiedUserEntity {
	
	private String code;
	private String name;
	private String description;
	private String address;
	private String contactNo1;
	private String contactNo2;
	private BigDecimal collectionLimit;
	private BigDecimal capacity;
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="contact_no1")
	public String getContactNo1() {
		return contactNo1;
	}
	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}
	
	@Column(name="contact_no2")
	public String getContactNo2() {
		return contactNo2;
	}
	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}
	
	@Column(name="colllection_limit")
	public BigDecimal getCollectionLimit() {
		return collectionLimit;
	}
	public void setCollectionLimit(BigDecimal collectionLimit) {
		this.collectionLimit = collectionLimit;
	}
	
	@Column(name="capacity")
	public BigDecimal getCapacity() {
		return capacity;
	}
	public void setCapacity(BigDecimal capacity) {
		this.capacity = capacity;
	}
	
}
