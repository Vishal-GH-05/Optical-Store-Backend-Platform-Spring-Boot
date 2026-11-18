package com.capg.lenskart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lens {
	@Id
	private int lensId;
	private String brand;
	private String type;
	private String shade;
	private double index;
	private double additionalPrice;
//	private double power;
	public int getLensId() {
		return lensId;
	}
	public void setLensId(int lensId) {
		this.lensId = lensId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getShade() {
		return shade;
	}
	public void setShade(String shade) {
		this.shade = shade;
	}
	public double getAdditionalPrice() {
		return additionalPrice;
	}
	public void setAdditionalPrice(double additionalPrice) {
		this.additionalPrice = additionalPrice;
	}
	public double getIndex() {
		return index;
	}
	public void setIndex(double index) {
		this.index = index;
	}
	
	
//	public double getPower() {
//		return power;
//	}
//	public void setPower(double power) {
//		this.power = power;
//	}
	

}
