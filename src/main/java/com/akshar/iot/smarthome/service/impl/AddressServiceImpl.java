package com.akshar.iot.smarthome.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.akshar.iot.smarthome.model.Address;
import com.akshar.iot.smarthome.service.AddressService;
import com.akshar.iot.smarthome.repository.AddressRepository;
import java.util.List;


@Service("addressService")
public class AddressServiceImpl implements AddressService{
	
	@Autowired(required= true)
	private AddressRepository addressRepository;
	
	public void saveAddress(Address addr){
		addressRepository.save(addr);
		
	}
	
	/*public Address findByUserId(int custId){
		return addressRepository.findByUserId(custId);
	}*/

}
