package com.esoft.coursework.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.MapCreatedUserEntity;

/**
 * @author Udara Wikum
 * @since 20/11/2021 8.59PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "item_selling")
public class ItemSelling extends MapCreatedUserEntity {
	private String orderNo;
	private Date date;
	private Long customerId;
	private Long sellingLocation;
	private Long itemId;
	private BigDecimal qty;
	private BigDecimal unitPrice;
	private BigDecimal totalPrice;
	private String remark;
	
	@Column(name="order_no")
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
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
	
	@Column(name="selling_location")
	public Long getSellingLocation() {
		return sellingLocation;
	}
	public void setSellingLocation(Long sellingLocation) {
		this.sellingLocation = sellingLocation;
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
	
	@Column(name="unit_price")
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@Column(name="total_price")
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	@Column(name="remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
