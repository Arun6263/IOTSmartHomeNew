package com.akshar.iot.smarthome.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akshar.iot.smarthome.model.Address;


@Repository("addressRepository")
public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findAll();
	
//	Address findByUserId(int userId);
}
