package com.akshar.iot.smarthome.model;

import java.sql.Date;
import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name= "user_device")
public class UserDevice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_device_id")
	private int userDeviceId;
	
	@Column(name="controlbox_id")
	private int controlBoxId;
	
	@Column(name="device_id")
	private int deviceId;
	
	@Column(name="device_alias_name")
	private String aliasName;
	
	@Column(name="device_status")
	private String deviceStatus;
	
	@Column(name="active_flag")
	private String activeFlag;
	
	@Column(name = "created_dt")
	private Date createdDate;
	 
	@Column(name = "lst_update_dt")
	private Date lastUpdateDate;

	public int getUserDeviceId() {
		return userDeviceId;
	}

	public void setUserDeviceId(int userDeviceId) {
		this.userDeviceId = userDeviceId;
	}

	public int getControlBoxId() {
		return controlBoxId;
	}

	public void setControlBoxId(int controlBoxId) {
		this.controlBoxId = controlBoxId;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
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

