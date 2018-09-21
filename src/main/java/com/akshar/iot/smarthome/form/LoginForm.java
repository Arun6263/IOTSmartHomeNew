package com.akshar.iot.smarthome.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class LoginForm {

@NotNull
@Size(min=2,max=10)
	String phoneNo;
	
	@NotNull
	@Size(min=2,max=20)
	String password;
	
	String loginType;


	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	
	
}
