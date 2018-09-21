package com.akshar.iot.smarthome.form;

public class AddressForm {

	private int addressId;
	private String lineOne;
	private String lineTwo;	
	private String lineThree;
	private String City;
	private String stateCode;
	private String countryCode;
	private int customerId;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getLineOne() {
		return lineOne;
	}
	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}
	public String getLineTwo() {
		return lineTwo;
	}
	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}
	public String getLineThree() {
		return lineThree;
	}
	public void setLineThree(String lineThree) {
		this.lineThree = lineThree;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	
}
