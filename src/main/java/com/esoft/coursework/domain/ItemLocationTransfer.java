package com.esoft.coursework.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.MapCreatedUserEntity;

/**
 * @author Udara Wikum
 * @since 20/11/2021 8.43PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "item_location_transfer")
public class ItemLocationTransfer extends MapCreatedUserEntity {
	private Date date;
	private Long fromLocation;
	private Long toLocation;
	private Long vehicleId;
	private String remark;
	
	@Column(name="date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name="from_location")
	public Long getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(Long fromLocation) {
		this.fromLocation = fromLocation;
	}
	
	@Column(name="to_location")
	public Long getToLocation() {
		return toLocation;
	}
	public void setToLocation(Long toLocation) {
		this.toLocation = toLocation;
	}
	
	@Column(name="vehicle_id")
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	@Column(name="remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
