package com.akshar.iot.smarthome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akshar.iot.smarthome.model.User;



@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findAll();
 //User findByEmailId(String emailId);
  User findByPhoneNo(String phoneNo);
  public List<User> findByUserType(String userType);
 

}