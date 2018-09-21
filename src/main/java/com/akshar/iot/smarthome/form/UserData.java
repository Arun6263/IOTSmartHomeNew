/**
 * 
 */
package com.akshar.iot.smarthome.form;

/**
 * @author arunn
 * Sep 20, 2018
 */
public class UserData {
	private String PhoneNo;
	
	private String OldPassword;
	private String NewPassword;
	private String ConformPassword;
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	public String getOldPassword() {
		return OldPassword;
	}
	public void setOldPassword(String oldPassword) {
		OldPassword = oldPassword;
	}
	public String getNewPassword() {
		return NewPassword;
	}
	public void setNewPassword(String newPassword) {
		NewPassword = newPassword;
	}
	public String getConformPassword() {
		return ConformPassword;
	}
	public void setConformPassword(String conformPassword) {
		ConformPassword = conformPassword;
	}
	

}
