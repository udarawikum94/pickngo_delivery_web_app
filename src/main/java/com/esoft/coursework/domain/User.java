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
@Table(name = "officer")
public class User extends MapModifiedUserEntity {
	
	private String code;
	private String name;
	private String accessGroup;
	private Long operationCenterId;
	private String nic;
	private String contactNo;
	private String emailAddress;
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
	
	@Column(name="access_group")
	public String getAccessGroup() {
		return accessGroup;
	}
	public void setAccessGroup(String accessGroup) {
		this.accessGroup = accessGroup;
	}
	
	@Column(name="operation_center_id")
	public Long getOperationCenterId() {
		return operationCenterId;
	}
	public void setOperationCenterId(Long operationCenterId) {
		this.operationCenterId = operationCenterId;
	}
	
	@Column(name="nic")
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	
	@Column(name="contact_no")
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	@Column(name="email_address")
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
