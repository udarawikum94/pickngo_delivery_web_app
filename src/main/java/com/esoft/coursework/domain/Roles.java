package com.esoft.coursework.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.MapModifiedUserEntity;

/**
 * @author Udara Wikum
 * @since 20/11/2021 10.43PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "roles")
public class Roles extends MapModifiedUserEntity {
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
