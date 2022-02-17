package com.esoft.coursework.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.BaseEntityClass;

/**
 * @author Udara Wikum
 * @since 20/11/2021 7.45PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "cash_in_hand")
public class CashInHand extends BaseEntityClass {
	
	private String code;
	private String name;
	
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
}
