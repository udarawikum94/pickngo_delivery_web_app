package com.esoft.coursework.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.MapCreatedUserEntity;

/**
 * @author Udara Wikum
 * @since 21/11/2021 12.12AM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "transaction")
public class Transaction extends MapCreatedUserEntity {
	private String recieptNo;
	private Date transactionDate;
	private BigDecimal chargeAmount;
	private Long collectionDetailId;
	private Long chargeTemplateId;
	private String requestNo;
	
	@Column(name="reciept_no")
	public String getRecieptNo() {
		return recieptNo;
	}
	public void setRecieptNo(String recieptNo) {
		this.recieptNo = recieptNo;
	}
	
	@Column(name="transaction_date")
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	@Column(name="charge_amount")
	public BigDecimal getChargeAmount() {
		return chargeAmount;
	}
	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}
	
	@Column(name="collection_detail_id")
	public Long getCollectionDetailId() {
		return collectionDetailId;
	}
	public void setCollectionDetailId(Long collectionDetailId) {
		this.collectionDetailId = collectionDetailId;
	}
	
	@Column(name="charge_template_id")
	public Long getChargeTemplateId() {
		return chargeTemplateId;
	}
	public void setChargeTemplateId(Long chargeTemplateId) {
		this.chargeTemplateId = chargeTemplateId;
	}
	
	@Column(name="request_no")
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	
}
