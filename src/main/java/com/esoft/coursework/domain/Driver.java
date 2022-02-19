package com.esoft.coursework.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.MapModifiedUserEntity;

/**
 * @author Udara Wikum
 * @since 19/02/2022 4.01PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "driver")
public class Driver extends MapModifiedUserEntity {
	
	private String name;
	private String nic;
	private String address;
	private String contactNo;
	private String email;
	private String drivingLicenseNo;
	private String licenseExpDate;
	private String username;
	private String password;
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	@Column(name="nic")
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="driving_license_no")
	public String getDrivingLicenseNo() {
		return drivingLicenseNo;
	}
	public void setDrivingLicenseNo(String drivingLicenseNo) {
		this.drivingLicenseNo = drivingLicenseNo;
	}
	
	@Column(name="license_exp_date")
	public String getLicenseExpDate() {
		return licenseExpDate;
	}
	public void setLicenseExpDate(String licenseExpDate) {
		this.licenseExpDate = licenseExpDate;
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
