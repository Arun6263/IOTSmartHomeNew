package com.akshar.iot.smarthome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akshar.iot.smarthome.model.ControlBox;

@Repository("controlBoxRepository")
public interface ControlBoxRepository extends JpaRepository<ControlBox, Long>{

	 List<ControlBox> findByUserId(int userId);

}
