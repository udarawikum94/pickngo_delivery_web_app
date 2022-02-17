package com.esoft.coursework.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Udara Wikum
 * @since 20/11/2021 7.44PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@MappedSuperclass
public abstract class MapModifiedUserEntity extends MapCreatedUserEntity {
	private String modifiedUser;
	private Date modifiedDate;
	private String status;
	
	@Column(name="modified_user")
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	
	@Column(name="modified_date")
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
