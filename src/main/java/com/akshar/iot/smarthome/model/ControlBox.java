package com.akshar.iot.smarthome.model;

import java.sql.Date;
import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name= "controlbox")
public class ControlBox implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="controlbox_id")
	private int controlboxId;
	
	@Column(name="controlbox_code")
	private String controlboxCode;
	
	@Column(name="controlbox_name")
	private String controlboxName;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="active_flag")
	private String activeFlag;
	
	@Column(name = "created_dt")
	private Date createdDate;
	 
	@Column(name = "lst_update_dt")
	private Date lastUpdateDate;

	public int getControlboxId() {
		return controlboxId;
	}

	public void setControlboxId(int controlboxId) {
		this.controlboxId = controlboxId;
	}

	public String getControlboxCode() {
		return controlboxCode;
	}

	public void setControlboxCode(String controlboxCode) {
		this.controlboxCode = controlboxCode;
	}

	public String getControlboxName() {
		return controlboxName;
	}

	public void setControlboxName(String controlboxName) {
		this.controlboxName = controlboxName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	
	
	
}




	
	
	

