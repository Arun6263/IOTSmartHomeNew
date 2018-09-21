package com.akshar.iot.smarthome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akshar.iot.smarthome.model.Device;


@Repository("deviceRepository")
public interface DeviceRepository extends JpaRepository<Device, Long> {

	List<Device> findAll();
	
	Device findByDeviceCode(String deviceCode);
	
}
