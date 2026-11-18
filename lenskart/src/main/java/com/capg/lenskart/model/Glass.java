package com.capg.lenskart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Glass {
	@Id
	private int glassId;
	private String glassType;
	private String glassBrand;
	private double price;
	private String imgSource;
	@OneToOne
	@JoinColumn(name="fk_frameId")
	private Frame frame;
	@OneToOne
	@JoinColumn(name="fk_lensId")
	private Lens lens;
//	@ManyToOne
//	private Cart cart;
	public int getGlassId() {
		return glassId;
	}
	public void setGlassId(int glassId) {
		this.glassId = glassId;
	}
	public String getGlassType() {
		return glassType;
	}
	public void setGlassType(String glassType) {
		this.glassType = glassType;
	}
	public String getGlassBrand() {
		return glassBrand;
	}
	public void setGlassBrand(String glassBrand) {
		this.glassBrand = glassBrand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImgSource() {
		return imgSource;
	}
	public void setImgSource(String imgSource) {
		this.imgSource = imgSource;
	}
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	public Lens getLens() {
		return lens;
	}
	public void setLens(Lens lens) {
		this.lens = lens;
	}

	
	
}
