package com.capg.lenskart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class PersonalDetails {
	@Id
	private long pId;
	
	@NotEmpty(message = "Name can't be empty!")
	private String firstName;
	
	@NotEmpty(message = "LastName can't be empty!")
	private String lastName;
	
	private String gender;
	
	@NotEmpty(message = "phoneNum can't be empty!")
	@Pattern(regexp = "^[0-9]$", message = "Enter a valid phone no")
	private long phoneNum;
	
	private int age;
	
	@NotEmpty(message = "Email Id can't be empty!")
	@Pattern(regexp = "^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Enter a valid Email Id!")
	private String emailid;
	
	@OneToOne
	@JoinColumn(name="fk_addId")
	private Address address;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

}
