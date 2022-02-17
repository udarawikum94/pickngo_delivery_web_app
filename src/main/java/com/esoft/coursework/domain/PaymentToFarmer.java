package com.esoft.coursework.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.MapCreatedUserEntity;

/**
 * @author Udara Wikum
 * @since 20/11/2021 9.35PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "payment_to_farmer")
public class PaymentToFarmer extends MapCreatedUserEntity {
	private Date date;
	private String invoice_no;
	private String reference_no;
	private Long farmerId;
	private BigDecimal outstatndingBalance;
	private BigDecimal paidAmount;
	
	@Column(name="date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name="invoice_no")
	public String getInvoice_no() {
		return invoice_no;
	}
	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}
	
	@Column(name="ref_no")
	public String getReference_no() {
		return reference_no;
	}
	public void setReference_no(String reference_no) {
		this.reference_no = reference_no;
	}
	
	@Column(name="farmer_id")
	public Long getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(Long farmerId) {
		this.farmerId = farmerId;
	}
	
	@Column(name="outstanding_balance")
	public BigDecimal getOutstatndingBalance() {
		return outstatndingBalance;
	}
	public void setOutstatndingBalance(BigDecimal outstatndingBalance) {
		this.outstatndingBalance = outstatndingBalance;
	}
	
	@Column(name="paid_amount")
	public BigDecimal getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}
	
}
