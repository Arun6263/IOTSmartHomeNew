package com.akshar.iot.smarthome.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


import com.akshar.iot.smarthome.service.UserService;
//import com.akshar.iot.smarthome.webservice.rest.SmartHomeController;
import com.akshar.iot.smarthome.model.User;

import com.akshar.iot.smarthome.repository.UserRepository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
 
	
public final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

@Autowired(required=true)
 private UserRepository userRepository;
 
 
/*public User findByEmailId(String email) {
	 return userRepository.findByEmailId(email);
}

*/


@PersistenceContext
EntityManager entityManager ;
public User findByPhoneNo(String phoneNo){
	 return userRepository.findByPhoneNo(phoneNo);
}

public List<User> findByUserType(String userType){
	return userRepository.findByUserType(userType);
}
public void saveUser(User user) {
	
	try{
		
		userRepository.save(user);
	
	}catch(Exception e){
		e.getMessage();
	}
	/*  user.setActive(1);
	  Role userRole = roleRespository.findByRole("USER");
	  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	  userRepository.save(user);*/
	  
	  
}

public List<User> getAllUsers() {
	
	List<User> userList = null;
	
	userList = userRepository.findAll();
	
	System.out.println("User Service Impl : "+ userList.size());
	return userList;
	
}

/* (non-Javadoc)
 * @see com.akshar.iot.smarthome.service.UserService#changePassword(java.util.Map)
 */
@Override
public int changePassword(Map<String, Object> userData) {
	String newpwd= (String)userData.get("newpassword");
	String phoneno= (String)userData.get("phoneno");
	
	try{
	int count=	entityManager.createNamedQuery("updateUserPwd", User.class)
		.setParameter(1, newpwd)
		.setParameter(2, phoneno)
		
		.executeUpdate();
	
		
		return count;
		
	}
	
	 catch (Exception e)
    {
		 System.out.println("exception   "+e);
        return 0;
    }
	

	
	
}


}