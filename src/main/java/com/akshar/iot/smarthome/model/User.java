package com.akshar.iot.smarthome.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity(name="User")
@Table(name = "user")

@SqlResultSetMapping(name="updateResult", columns = { @ColumnResult(name = "count")})

@NamedNativeQueries({
        @NamedNativeQuery(
                name    =   "updateUserPwd",
                query   =   "UPDATE user SET user_password= ?1  WHERE phone_no = ?2"
                ,resultSetMapping = "updateResult"
        )
})

public class User implements Serializable {
 
	public User(){
		
	}
	
 public User(int userId, String emailId, String password, String userType, String phoneNo, String firstName,
			String lastName, String companyName, String activeFlag, Date cratedDate, Date updateDate, Address address) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
		this.userType = userType;
		this.phoneNo = phoneNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.activeFlag = activeFlag;
		this.cratedDate = cratedDate;
		this.updateDate = updateDate;
		this.address = address;
	}
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "user_id")
 private int userId;
 
 @Column(name = "email_id")
 private String emailId;
 
 @Column(name = "user_password")
 private String password;
 
 @Column(name = "user_type")
 private String userType;
 
 @Column(name = "phone_no")
 private String phoneNo;
 
 @Column(name = "first_name")
 private String firstName;
 
 @Column(name = "last_name")
 private String lastName;
 
 @Column(name = "company_name")
 private String companyName;
 
 @Column(name = "active_flag")
 private String activeFlag;
 
 @Column(name = "created_dt")
	private Date cratedDate;
 
 @Column(name = "lst_update_dt")
	private Date updateDate;

 @JsonManagedReference
 @OneToOne(mappedBy = "user") 
 private Address address;
 
public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getUserType() {
	return userType;
}

public void setUserType(String userType) {
	this.userType = userType;
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



public String getActiveFlag() {
	return activeFlag;
}

public void setActiveFlag(String activeFlag) {
	this.activeFlag = activeFlag;
}

public Date getCratedDate() {
	return cratedDate;
}

public void setCratedDate(Date cratedDate) {
	this.cratedDate = cratedDate;
}

public Date getUpdateDate() {
	return updateDate;
}

public void setUpdateDate(Date updateDate) {
	this.updateDate = updateDate;
}

public String getPhoneNo() {
	return phoneNo;
}

public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}

@Override
public String toString() {
    try {
        return new ObjectMapper().writer().writeValueAsString(this);
    } catch (JsonProcessingException e) {
        return super.toString();
    }

}

 
}