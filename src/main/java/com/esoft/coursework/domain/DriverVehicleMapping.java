package com.esoft.coursework.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.MapModifiedUserEntity;

/**
 * @author Udara Wikum
 * @since 19/02/2022 4.01PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "driver")
public class DriverVehicleMapping extends MapModifiedUserEntity {
	
	private Long driverId;
	private Long vehicleId;
	
	@Column(name="driver_id")
	public Long getDriverId() {
		return driverId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	
	@Column(name="vehicle_id")
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
}
