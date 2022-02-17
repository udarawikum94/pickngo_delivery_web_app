package com.esoft.coursework.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Udara Wikum
 * @since 20/11/2021 7.43PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@MappedSuperclass
public abstract class MapCreatedUserEntity extends BaseEntityClass {
	private String createdUser;
	private Date createdDate;
	
	@Column(name="created_date")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="created_user")
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	
}
