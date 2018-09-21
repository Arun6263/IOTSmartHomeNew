package com.akshar.iot.smarthome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akshar.iot.smarthome.model.Customer;


@Repository("customerRepository")
public interface RoleRespository extends JpaRepository<Customer, Long> {

// Role findByRole(String role);
	List<Customer> findAll();
	Customer findByEmail(String email);
}