package com.esoft.coursework.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esoft.coursework.core.MapModifiedUserEntity;

/**
 * @author Udara Wikum
 * @since 20/11/2021 9.17PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "vehicle")
public class Vehicle extends MapModifiedUserEntity {
	
	private String vehicleNo;
	private String name;
	private String brand;
	
	@Column(name="vehicle_no")
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="brand")
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}
