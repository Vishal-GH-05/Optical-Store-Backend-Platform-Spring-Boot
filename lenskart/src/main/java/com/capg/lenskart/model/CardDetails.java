package com.capg.lenskart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class CardDetails {
	@Id
	private String uniqueKey;
	@NotEmpty(message = "Pleas enter your Card Number!")
	@Pattern(regexp = "^[0-9]{16}$", message = "Your Card Number is Invalid!")
	private String cardNum;
	
	@NotEmpty(message = "Please enter your Username!")
	private String userName;
	
	@Pattern(regexp = "^[0-9]{3}$", message = "Your cvv is Invalid!")
	@NotEmpty(message = "Please enter your cvv!")
	private int cvv;
	
	@Pattern(regexp = "^[0-9]{2}$", message = "Invalid credentials!")
	@NotEmpty(message = "This field can't be emty!")
	private int expMonth;
	
	@Pattern(regexp = "^[0-9]{2}$", message = "Invalid credentials!")
	@NotEmpty(message = "This field can't be emty!")
	private int expYr;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public int getExpMonth() {
		return expMonth;
	}
	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}
	public int getExpYr() {
		return expYr;
	}
	public void setExpYr(int expYr) {
		this.expYr = expYr;
	}
	public String getUniqueKey() {
		return uniqueKey;
	}
	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}
	

}
