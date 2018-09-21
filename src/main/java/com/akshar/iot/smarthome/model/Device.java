package com.akshar.iot.smarthome.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
@Table(name="device")
public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="device_id")
	private int deviceId;
	
	@Column(name="device_code")
	private String deviceCode;
	
	@Column(name="device_name")
	private String deviceName;
	
	@Column(name="product_code")
	private String productCode;
	
	@Column(name = "active_flag")
	private String activeFlag;
	 
	@Column(name = "created_dt")
	private Date cratedDate;
	 
	@Column(name = "lst_update_dt")
	private Date updateDate;

	@OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
	private Set<Command> command;

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	public Set<Command> getCommand() {
		return command;
	}

	public void setCommand(Set<Command> command) {
		this.command = command;
	}
	
	
}
