package com.esoft.coursework.core;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * @author Udara Wikum
 * @since 20/11/2021 7.43PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@MappedSuperclass
public abstract class BaseEntityClass {
	private Long id;
	private Long version;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Version
	@Column(name="version")
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	
}
