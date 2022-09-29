package com.example.restapidemo.dto;

public class EmployeeRequestDto {

	private String name;
	
	private String id;
	
	private String address;
	
	private String pincode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "EmployeeRequestDto [name=" + name + ", id=" + id + ", address=" + address + ", pincode=" + pincode
				+ "]";
	}
	
	
	
	
}
