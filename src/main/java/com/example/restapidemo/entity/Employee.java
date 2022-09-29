package com.example.restapidemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee" ,schema = "db1")
public class Employee {

	@Column(name = "name")
	private String name;

	@Id
	@Column(name = "rollnumber")
	private String rollnumber;

	@Column(name = "address")
	private String address;

	@Column(name = "mobilenumber")
	private String mobileNumber;

	@Column(name = "pincode")
	private String pincode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	public String getAddress() {
		return address.toUpperCase();
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
