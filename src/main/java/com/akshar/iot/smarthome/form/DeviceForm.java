package com.akshar.iot.smarthome.form;

import java.util.List;
import com.akshar.iot.smarthome.form.CommandForm;

public class DeviceForm {

	int deviceId;
	String deviceCode;
	String deviceName;
	String productCode;
	char activeFlag;
	
	List<CommandForm> commandList;

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

	public char getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(char activeFlag) {
		this.activeFlag = activeFlag;
	}

	public List<CommandForm> getCommandList() {
		return commandList;
	}

	public void setCommandList(List<CommandForm> commandList) {
		this.commandList = commandList;
	}
	
	
	

}


