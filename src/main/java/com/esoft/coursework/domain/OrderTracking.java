package com.esoft.coursework.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.esoft.coursework.core.MapModifiedUserEntity;
import com.esoft.coursework.enumeration.TrackingTypeEnum;

/**
 * @author Udara Wikum
 * @since 19/02/2022 4.01PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "order_tracking")
public class OrderTracking extends MapModifiedUserEntity {
	
	private String trackingNo;
	private String trackingStatus;
	private TrackingTypeEnum trackingType;
	private Date estimatedTime;
	private Date taskCompletedtime;
	
	@Column(name="tracking_no")
	public String getTrackingNo() {
		return trackingNo;
	}
	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}
	
	@Column(name="tracking_status")
	public String getTrackingStatus() {
		return trackingStatus;
	}
	public void setTrackingStatus(String trackingStatus) {
		this.trackingStatus = trackingStatus;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="tracking_type")
	public TrackingTypeEnum getTrackingType() {
		return trackingType;
	}
	public void setTrackingType(TrackingTypeEnum trackingType) {
		this.trackingType = trackingType;
	}
	
	@Column(name="estimated_time")
	public Date getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(Date estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	
	@Column(name="completed_time")
	public Date getTaskCompletedtime() {
		return taskCompletedtime;
	}
	public void setTaskCompletedtime(Date taskCompletedtime) {
		this.taskCompletedtime = taskCompletedtime;
	}
	
}
