package com.akshar.iot.smarthome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.akshar.iot.smarthome.model.UserDevice;

@Repository("userDeviceRepository")
public interface UserDeviceRepository extends JpaRepository<UserDevice, Long> {

	List<UserDevice> findByControlBoxId(int controlBoxId);
}
