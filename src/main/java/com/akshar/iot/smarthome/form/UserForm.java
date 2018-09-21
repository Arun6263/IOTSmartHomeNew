package com.akshar.iot.smarthome.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class UserForm {

	private int customerId;
	
	@NotNull
	@Size(min=5,max=20)
	private String emailId;
	
	@NotNull
	@Size(min=5,max=20)
	private String phoneNo;
	
	@NotNull
	@Size(min=5,max=10)
	private String firstName;
	private String lastName;
	private String companyName;
	private char activeFlag;
	
	private AddressForm addressForm;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public char getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(char activeFlag) {
		this.activeFlag = activeFlag;
	}

	public AddressForm getAddressForm() {
		return addressForm;
	}

	public void setAddressForm(AddressForm addressForm) {
		this.addressForm = addressForm;
	}
	
	
}
