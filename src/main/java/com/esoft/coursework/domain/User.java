package com.esoft.coursework.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.MapModifiedUserEntity;

/**
 * @author Udara Wikum
 * @since 20/11/2021 10.24PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "user")
public class User extends MapModifiedUserEntity {
	
	private String code;
	private String name;
	private String designation;
	private Long collectionCenterId;
	private String username;
	private String password;
	
	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="designation")
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Column(name="collection_center_id")
	public Long getCollectionCenterId() {
		return collectionCenterId;
	}
	public void setCollectionCenterId(Long collectionCenterId) {
		this.collectionCenterId = collectionCenterId;
	}
	
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
