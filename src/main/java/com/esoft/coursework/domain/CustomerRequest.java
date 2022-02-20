package com.esoft.coursework.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.MapModifiedUserEntity;

/**
 * @author Udara Wikum
 * @since 19/02/2022 3.59PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "customer_request")
public class CustomerRequest extends MapModifiedUserEntity {
	
	private String requestNo;
	private String itemDescription;
	private Long nearestOpCenterId;
	private String trackingNo;
	private Date pickupTime;
	private BigDecimal estimatedDistance;	//Km
	private BigDecimal calculatedChargeAmount;
	private Long fetchingOpCenterId;
	private Long customerId;
	
	@Column(name="request_no")
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	
	@Column(name="item_description")
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	@Column(name="nearest_op_center_id")
	public Long getNearestOpCenterId() {
		return nearestOpCenterId;
	}
	public void setNearestOpCenterId(Long nearestOpCenterId) {
		this.nearestOpCenterId = nearestOpCenterId;
	}
	
	@Column(name="tracking_no")
	public String getTrackingNo() {
		return trackingNo;
	}
	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}
	
	@Column(name="pickup_time")
	public Date getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}
	
	@Column(name="estimated_distance")
	public BigDecimal getEstimatedDistance() {
		return estimatedDistance;
	}
	public void setEstimatedDistance(BigDecimal estimatedDistance) {
		this.estimatedDistance = estimatedDistance;
	}
	
	@Column(name="calculated_charge_amount")
	public BigDecimal getCalculatedChargeAmount() {
		return calculatedChargeAmount;
	}
	public void setCalculatedChargeAmount(BigDecimal calculatedChargeAmount) {
		this.calculatedChargeAmount = calculatedChargeAmount;
	}
	
	@Column(name="fetching_op_center_id")
	public Long getFetchingOpCenterId() {
		return fetchingOpCenterId;
	}
	public void setFetchingOpCenterId(Long fetchingOpCenterId) {
		this.fetchingOpCenterId = fetchingOpCenterId;
	}
	
	@Column(name="customer_id")
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
}
