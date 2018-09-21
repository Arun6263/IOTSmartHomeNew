package com.akshar.iot.smarthome.form;

import java.util.List;

public class CommandForm {
	int commandId;
	String commandCode;
	String commandDesc;
	String commandValue;
	int deviceId;
	char activeFlag;
	
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
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public char getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(char activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	
	
}


