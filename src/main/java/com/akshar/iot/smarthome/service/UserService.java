package com.akshar.iot.smarthome.service;

import java.util.List;
import java.util.Map;

import com.akshar.iot.smarthome.model.User;

public interface UserService {
  
 //public User findByEmailId(String email);
 
// public void saveUser(Customer customer);

 public void saveUser(User user);

public List<User> getAllUsers();
public List<User> findByUserType(String userType);
User findByPhoneNo(String phoneNo);

/**
 * @param userData
 * @return
 */
public int changePassword(Map<String, Object> userData);

}