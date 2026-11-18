package com.capg.lenskart.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Table")
public class Customer implements Serializable {
	@Id
    @OneToOne(cascade = CascadeType.ALL)
	private User user;
	@OneToOne 
	private PersonalDetails details;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public PersonalDetails getDetails() {
		return details;
	}
	public void setDetails(PersonalDetails details) {
		this.details = details;
	}
	

}
