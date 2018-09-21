package com.akshar.iot.smarthome.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "cust_id")
 private int id;
 
	 @Column(name = "cust_email")
 private String email;
	 @Column(name = "cust_phone")
	 private String custphn;
 
	 @Column(name = "first_name")
 private String firstname; 
 
	 @Column(name = "last_name")
 private String lastname;
	 @Column(name = "phone_one")
 private String phone_one;
 
	 @Column(name = "phone_two")
 private String phone_two;
 
	 @Column(name = "company_name")
 private String comanyname;
	 @Column(name = "created_by")
 private String created_by;
	 @Column(name = "active_flag")
 private String active_flag;
	 @Column(name = "created_dt")
 private Date created_dt;
	 @Column(name = "lst_update_dt")
 private Date lst_update_dt;
	 
	 @Column(name = "address")
	 private String address;
	 
	 
public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getPhone_one() {
	return phone_one;
}
public void setPhone_one(String phone_one) {
	this.phone_one = phone_one;
}
public String getPhone_two() {
	return phone_two;
}
public void setPhone_two(String phone_two) {
	this.phone_two = phone_two;
}
public String getComanyname() {
	return comanyname;
}
public void setComanyname(String comanyname) {
	this.comanyname = comanyname;
}
public String getCreated_by() {
	return created_by;
}
public void setCreated_by(String created_by) {
	this.created_by = created_by;
}
public String getActive_flag() {
	return active_flag;
}
public void setActive_flag(String active_flag) {
	this.active_flag = active_flag;
}
public Date getCreated_dt() {
	return created_dt;
}
public void setCreated_dt(Date created_dt) {
	this.created_dt = created_dt;
}
public Date getLst_update_dt() {
	return lst_update_dt;
}
public void setLst_update_dt(Date lst_update_dt) {
	this.lst_update_dt = lst_update_dt;
}
public String getCustphn() {
	return custphn;
}
public void setCustphn(String custphn) {
	this.custphn = custphn;
}
 
 
}

