package com.esoft.coursework.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.MapModifiedUserEntity;

/**
 * @author Udara Wikum
 * @since 20/11/2021 8.26PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "farmer")
public class Farmer extends MapModifiedUserEntity {
	private String nicNo;
	private String code;
	private String fullName;
	private String address;
	private String contactNo;
	private String bank;
	private String bankBranch;
	private String bankAccountNo;
	
	@Column(name="nicbr_no")
	public String getNicNo() {
		return nicNo;
	}
	public void setNicNo(String nicNo) {
		this.nicNo = nicNo;
	}
	
	@Column(name="full_name")
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Column(name="address_line")
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
	
	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="bank")
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	@Column(name="bank_branch")
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	
	@Column(name="bank_account_no")
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	
}
