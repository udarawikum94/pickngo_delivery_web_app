package com.esoft.coursework.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.esoft.coursework.core.MapModifiedUserEntity;
import com.esoft.coursework.enumeration.SizeEnum;

/**
 * @author Udara Wikum
 * @since 19/02/2022 4.01PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Entity
@Table(name = "charges_template")
public class ChargesTemplate extends MapModifiedUserEntity {
	
	private String code;
	private BigDecimal fromWeight;
	private BigDecimal toWeight;
	private SizeEnum size;
	private BigDecimal distance;
	private BigDecimal chargeAmount;
	
	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="from_weight")
	public BigDecimal getFromWeight() {
		return fromWeight;
	}
	public void setFromWeight(BigDecimal fromWeight) {
		this.fromWeight = fromWeight;
	}
	
	@Column(name="to_weight")
	public BigDecimal getToWeight() {
		return toWeight;
	}
	public void setToWeight(BigDecimal toWeight) {
		this.toWeight = toWeight;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="size")
	public SizeEnum getSize() {
		return size;
	}
	public void setSize(SizeEnum size) {
		this.size = size;
	}
	
	@Column(name="distance")
	public BigDecimal getDistance() {
		return distance;
	}
	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}
	
	@Column(name="charge_amount")
	public BigDecimal getChargeAmount() {
		return chargeAmount;
	}
	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}
	
}
