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
@Table(name = "order_processing")
public class OrderProcessing extends MapCreatedUserEntity {
	private String type;
	private String address;
	private BigDecimal orderStatus;
	private Long customerId;
	private Long driverVehicleMappingId;
	private Long operationCenterId;
	private String trackingNo;
	private Boolean isCustomerSignedOff;
	private Date scheduleTime;
	private String comments;
	private Long collectionDetailId;
	private Long sequence;
	
	@Column(name="type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="order_status")
	public BigDecimal getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(BigDecimal orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	@Column(name="customer_id")
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	@Column(name="driver_vehicle_mapping_id")
	public Long getDriverVehicleMappingId() {
		return driverVehicleMappingId;
	}
	public void setDriverVehicleMappingId(Long driverVehicleMappingId) {
		this.driverVehicleMappingId = driverVehicleMappingId;
	}
	
	@Column(name="operation_center_id")
	public Long getOperationCenterId() {
		return operationCenterId;
	}
	public void setOperationCenterId(Long operationCenterId) {
		this.operationCenterId = operationCenterId;
	}
	
	@Column(name="tracking_no")
	public String getTrackingNo() {
		return trackingNo;
	}
	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}
	
	@Column(name="is_customer_signed_off")
	public Boolean getIsCustomerSignedOff() {
		return isCustomerSignedOff;
	}
	public void setIsCustomerSignedOff(Boolean isCustomerSignedOff) {
		this.isCustomerSignedOff = isCustomerSignedOff;
	}
	
	@Column(name="schedule_time")
	public Date getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(Date scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	
	@Column(name="comments")
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Column(name="collection_detail_id")
	public Long getCollectionDetailId() {
		return collectionDetailId;
	}
	public void setCollectionDetailId(Long collectionDetailId) {
		this.collectionDetailId = collectionDetailId;
	}
	
	@Column(name="sequence")
	public Long getSequence() {
		return sequence;
	}
	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}
	
}
