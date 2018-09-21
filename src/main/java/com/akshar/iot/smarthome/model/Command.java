package com.akshar.iot.smarthome.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name="command")
public class Command {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="command_id")
	private int commandId;
	
	@Column(name="command_code")
	private String commandCode;
	
	@Column(name="command_desc")
	private String commandDesc;
	
	@Column(name="command_value")
	private String commandValue;
	
	@ManyToOne
	@JoinColumn(name="device_id")
	private Device device;
	
	@Column(name = "active_flag")
	private String activeFlag;
	 
	@Column(name = "created_dt")
	private Date cratedDate;
	 
	@Column(name = "lst_update_dt")
	private Date updateDate;

	public int getCommandId() {
		return commandId;
	}

	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}

	public String getCommandCode() {
		return commandCode;
	}

	public void setCommandCode(String commandCode) {
		this.commandCode = commandCode;
	}

	public String getCommandDesc() {
		return commandDesc;
	}

	public void setCommandDesc(String commandDesc) {
		this.commandDesc = commandDesc;
	}

	public String getCommandValue() {
		return commandValue;
	}

	public void setCommandValue(String commandValue) {
		this.commandValue = commandValue;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
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

	
}
