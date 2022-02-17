package com.esoft.coursework.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.MapCreatedUserEntity;

@Entity
@Table(name = "buying_selling_price")
public class BuyingSellingPrice extends MapCreatedUserEntity {
	
	private Date effectiveDate;
	private BigDecimal buyingPrice;
	private BigDecimal sellingPrice;
	private Long itemId;
	private String status;
	
	@Column(name="effective_date")
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	@Column(name="buying_price")
	public BigDecimal getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(BigDecimal buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	
	@Column(name="selling_price")
	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	@Column(name="item_id")
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
