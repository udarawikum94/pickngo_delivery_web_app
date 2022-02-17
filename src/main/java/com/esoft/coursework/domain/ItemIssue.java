package com.esoft.coursework.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.MapCreatedUserEntity;

/**
 * @author Udara Wikum
 * @since 20/11/2021 8.44PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "item_issue")
public class ItemIssue extends MapCreatedUserEntity {
	private Date date;
	private Long customerId;
	private Long sellingLocationId;
	private Long itemId;
	private BigDecimal qty;
	private String remark;
	
	@Column(name="date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name="customer_id")
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	@Column(name="selling_location_id")
	public Long getSellingLocationId() {
		return sellingLocationId;
	}
	public void setSellingLocationId(Long sellingLocationId) {
		this.sellingLocationId = sellingLocationId;
	}
	
	@Column(name="item_id")
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	@Column(name="qty")
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	
	@Column(name="remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
