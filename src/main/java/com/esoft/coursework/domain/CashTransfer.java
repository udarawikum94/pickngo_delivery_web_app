package com.esoft.coursework.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.MapCreatedUserEntity;

/**
 * @author Udara Wikum
 * @since 20/11/2021 7.48PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "cash_transfer")
public class CashTransfer extends MapCreatedUserEntity {
	private Date date;
	private Long sentFrom;
	private Long sentTo;
	
	@Column(name="date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name="sent_from")
	public Long getSentFrom() {
		return sentFrom;
	}
	public void setSentFrom(Long sentFrom) {
		this.sentFrom = sentFrom;
	}
	
	@Column(name="sent_to")
	public Long getSentTo() {
		return sentTo;
	}
	public void setSentTo(Long sentTo) {
		this.sentTo = sentTo;
	}
	
}
