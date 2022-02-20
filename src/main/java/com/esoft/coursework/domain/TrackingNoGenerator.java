package com.esoft.coursework.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.BaseEntityClass;

/**
 * @author Udara Wikum
 * @since 19/02/2022 3.59PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "tracking_no_generator")
public class TrackingNoGenerator extends BaseEntityClass {
	
	private Long sequence;
	private Long operationCenterId;

	@Column(name="sequence")
	public Long getSequence() {
		return sequence;
	}
	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}
	
}
