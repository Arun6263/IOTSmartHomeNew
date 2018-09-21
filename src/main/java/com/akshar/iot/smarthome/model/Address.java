package com.akshar.iot.smarthome.model;

import java.sql.Date;
import javax.persistence.*;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
*/
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;

@Entity
@Table(name ="address")
public class Address implements Serializable {
	

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "addr_id")
	 private int addressId;
	 
	 
	@Column(name="line_one")
	private String lineOne;
	
	@Column(name="line_two")
	private String lineTwo;
	
	@Column(name="line_three")
	private String lineThree;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	
	//private int userId;
	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="active_flag")
	private String activeFlag;
	
	 @Column(name = "created_dt")
	 private Date createdDate;
	 
	 @Column(name = "lst_update_dt")
	 private Date lastUpdateDate;

	 
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getAddressId() {
		return addressId;
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
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	 
	
	
	 
}
