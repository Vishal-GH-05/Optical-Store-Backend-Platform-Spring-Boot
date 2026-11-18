package com.capg.lenskart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Frame {
	@Id
	private int frameId;
	private String frameShape;
	private String frameSize;
	private String frameType;
	public int getFrameId() {
		return frameId;
	}
	public void setFrameId(int frameId) {
		this.frameId = frameId;
	}
	public String getFrameShape() {
		return frameShape;
	}
	public void setFrameShape(String frameShape) {
		this.frameShape = frameShape;
	}
	public String getFrameSize() {
		return frameSize;
	}
	public void setFrameSize(String frameSize) {
		this.frameSize = frameSize;
	}
	public String getFrameType() {
		return frameType;
	}
	public void setFrameType(String frameType) {
		this.frameType = frameType;
	}
	
	
}
