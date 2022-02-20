package com.esoft.coursework.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.esoft.coursework.core.MapModifiedUserEntity;

/**
 * @author Udara Wikum
 * @since 19/02/2022 4.01PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "operational_center")
public class OperationalCenter extends MapModifiedUserEntity {
	
	private String code;
	private String name;
	private String description;
	private String address;
	private String contactNo;
	private String faxNo;
	private Long contactPersonId;
	private Long districtId;
	
	@Transient
	private User contactPerson;

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
	
	@Column(name="contact_no")
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	@Column(name="fax_no")
	public String getFaxNo() {
		return faxNo;
	}
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	@Column(name="contact_person_id")
	public Long getContactPersonId() {
		return contactPersonId;
	}
	public void setContactPersonId(Long contactPersonId) {
		this.contactPersonId = contactPersonId;
	}
	
	@Column(name="district_id")
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	
}
