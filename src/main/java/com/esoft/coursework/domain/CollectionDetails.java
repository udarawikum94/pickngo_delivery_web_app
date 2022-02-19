package com.esoft.coursework.domain;

import java.math.BigDecimal;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.esoft.coursework.core.MapModifiedUserEntity;
import com.esoft.coursework.enumeration.SizeEnum;

/**
 * @author Udara Wikum
 * @since 19/02/2022 3.59PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "collection_details")
public class CollectionDetails extends MapModifiedUserEntity {
	
	private String requestNo;
	private String trackingNo;
	private BigDecimal weight;
	private String itemName;
	private String itemType;
	private Blob orderImage;
	private SizeEnum size;	
	private BigDecimal calculatedChargeAmount;
	private String fromLocation;
	private String toLocation;
	private Long customerRequestId;
	private Long recieverId;
	private Boolean isCollected;
	private Boolean isImediateRequest;
	private Boolean hasInterBranchTrasfer;
	
	@Column(name="request_no")
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	
	@Column(name="tracking_no")
	public String getTrackingNo() {
		return trackingNo;
	}
	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}
	
	@Column(name="calculated_charge_amount")
	public BigDecimal getCalculatedChargeAmount() {
		return calculatedChargeAmount;
	}
	public void setCalculatedChargeAmount(BigDecimal calculatedChargeAmount) {
		this.calculatedChargeAmount = calculatedChargeAmount;
	}
	
	@Column(name="weight")
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	
	@Column(name="item_type")
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	@Column(name="order_image")
	public Blob getOrderImage() {
		return orderImage;
	}
	public void setOrderImage(Blob orderImage) {
		this.orderImage = orderImage;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="size")
	public SizeEnum getSize() {
		return size;
	}
	public void setSize(SizeEnum size) {
		this.size = size;
	}
	
	@Column(name="from_location")
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	
	@Column(name="to_location")
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	
	@Column(name="customer_request_id")
	public Long getCustomerRequestId() {
		return customerRequestId;
	}
	public void setCustomerRequestId(Long customerRequestId) {
		this.customerRequestId = customerRequestId;
	}
	
	@Column(name="reciever_id")
	public Long getRecieverId() {
		return recieverId;
	}
	public void setRecieverId(Long recieverId) {
		this.recieverId = recieverId;
	}
	
	@Column(name="is_collected")
	public Boolean getIsCollected() {
		return isCollected;
	}
	public void setIsCollected(Boolean isCollected) {
		this.isCollected = isCollected;
	}
	
	@Column(name="is_imediate_request")
	public Boolean getIsImediateRequest() {
		return isImediateRequest;
	}
	public void setIsImediateRequest(Boolean isImediateRequest) {
		this.isImediateRequest = isImediateRequest;
	}
	
	@Column(name="item_name")
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	@Column(name="has_inter_branch_transfer")
	public Boolean getHasInterBranchTrasfer() {
		return hasInterBranchTrasfer;
	}
	public void setHasInterBranchTrasfer(Boolean hasInterBranchTrasfer) {
		this.hasInterBranchTrasfer = hasInterBranchTrasfer;
	}
	
	
}
