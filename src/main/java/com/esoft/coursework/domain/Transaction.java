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
	private String transactionNo;
	private Date date;
	private BigDecimal cashInAmount;
	private BigDecimal cashOutAmount;
	
	@Column(name="transaction_no")
	public String getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	
	@Column(name="date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name="cash_in_amount")
	public BigDecimal getCashInAmount() {
		return cashInAmount;
	}
	public void setCashInAmount(BigDecimal cashInAmount) {
		this.cashInAmount = cashInAmount;
	}
	
	@Column(name="cash_out_amount")
	public BigDecimal getCashOutAmount() {
		return cashOutAmount;
	}
	public void setCashOutAmount(BigDecimal cashOutAmount) {
		this.cashOutAmount = cashOutAmount;
	}
	
}
