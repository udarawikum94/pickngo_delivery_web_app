package com.esoft.coursework.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.BaseEntityClass;

@Entity
@Table(name = "user_role_mapping")
public class UserRoleMaping extends BaseEntityClass {
	
	private String uiName;
	private String crudAccess;
	
	@Column(name="ui_name")
	public String getUiName() {
		return uiName;
	}
	public void setUiName(String uiName) {
		this.uiName = uiName;
	}
	
	@Column(name="crudAccess") //this will store array of data {Create- 1, Read-2, Update-3, Delete-4}
	public String getCrudAccess() {
		return crudAccess;
	}
	public void setCrudAccess(String crudAccess) {
		this.crudAccess = crudAccess;
	}
	
}
