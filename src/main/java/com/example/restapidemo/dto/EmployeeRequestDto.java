package com.example.restapidemo.dto;

public class EmployeeRequestDto {

	private String name;
	
	private String rollnumber;
	
	private String mobileNumber;
	
	private String address;
	
	private String pincode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address.toUpperCase();
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	

	
	
	
	
}
