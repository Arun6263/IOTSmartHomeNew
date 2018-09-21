package com.akshar.iot.smarthome.webservice.rest;

import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.CacheControl;

import com.akshar.iot.smarthome.model.User;
import com.akshar.iot.smarthome.mqtt.publisher.MQTTPublisherBase;
import com.akshar.iot.smarthome.service.UserService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "UserRestController  API", description = "<b>UserRestController  API</b> \n\n"
	+ "Use this API for Add, Find, Remove the Home devices based on SmartHome APP calls")

@RestController
public class UserRestController {

	public final static Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
/*	@Autowired
	MQTTPublisherBase publisher;*/
	@Autowired
	private UserService userService;
	
/*	@ApiOperation(value = "Get the User Details ")
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
	public ResponseEntity<User>  getUserDtails(@RequestBody Map<String, Object> userData) {
		LOGGER.info(" Getlogin: {} ::: "+ userData.get("EmailId"));
		String userName = (String)userData.get("EmailId");
		
		User user = userService.findByEmailId(userName);
		
	//	User user=userService.findByEmailId(userName);
		
		
					
		if(user!=null) {
			user.setPassword("");
			LOGGER.info(" user details: {} ::: "+ user.getEmailId() + " First Name : "+ user.getFirstName()+"Last Name : "+user.getLastName());
			 return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
		
	}*/
  

	@ApiOperation(value = "Check User Credentials")
	@PostMapping(value = "/user/checkUser")
	public String checkUserCredentials(@RequestBody Map<String, Object> userData) {
		
		String phoneNo = (String)userData.get("PhoneNo");
		
		LOGGER.info("getUserDetails :- PhoneNo : "+phoneNo);
		LOGGER.info("getUserDetails :- Password : "+userData.get("Password"));
		LOGGER.info("getUserDetails :- UserType : "+userData.get("UserType"));
		
		User user = userService.findByPhoneNo(phoneNo);
		
		if(userData.get("UserType").equals(user.getUserType()) && userData.get("Password").equals(user.getPassword())){
			LOGGER.info("getUserDetails :- Valid User.. Successful..");
		}
			
//		publisher.publishMessage("demoTopic2017", userData.toString());
		return "Success";
	}
	
	@ApiOperation(value = "Get User Details")
	@PostMapping(value = "/user/getUserInfo")
	//public ResponseEntity<Map<String, Object>> getUserDetails(@RequestBody Map<String, Object> userData) {
	public ResponseEntity<User> getUserDetails(@RequestBody Map<String, Object> userData) {
		
		String phoneNo = (String)userData.get("PhoneNo");
		
		LOGGER.info("getUserDetails :- phoneNo : "+phoneNo);
		LOGGER.info("getUserDetails :- UserType : "+userData.get("UserType"));
		
		User user = userService.findByPhoneNo(phoneNo);
		
		if(user!=null) {
			user.setPassword("");
			LOGGER.info(" user details: {} ::: "+phoneNo+" EmailId: "+ user.getEmailId() + " First Name : "+ user.getFirstName()+"Last Name : "+user.getLastName());
			// return ResponseEntity.status(HttpStatus.OK).body(user);
			 //return ResponseEntity<User>(user, HttpStatus.OK);
			 //return ResponseEntity.ok().body(user);
		//	return new ResponseEntity<User>(user, HttpStatus.OK);
		
			 /*
			 return ResponseEntity.ok()
		        .header("Custom-Header", "foo")
		        .body("Custom header set");
*/
			 
		}
		/*Map map = new HashMap();
		map.put("PhoneNo",phoneNo);
		map.put("EmailId",user.getEmailId());
		map.put("FirstName",user.getFirstName());
		map.put("LastName",user.getLastName());*/
		
		//return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(map);

		return ResponseEntity.status(HttpStatus.OK).body(user);
		//return new ResponseEntity<User>(user, HttpStatus.OK);
		//return ResponseEntity.status(HttpStatus.OK).body(user);
	  //  return new ResponseEntity(HttpStatus.NOT_FOUND);
    
    
    
    
	}
	
	
	@ApiOperation(value = "Get the User Details ")
	@PostMapping(value = "/changePassword")
	public ResponseEntity  changePasswd(@RequestBody Map<String, Object> userData) {
		LOGGER.info(" Getlogin: {} ::: "+ userData.get("EmailId"));
		String phoneno= (String)userData.get("phoneno");
		String oldpwd = (String)userData.get("oldpassword");
		String newpwd= (String)userData.get("newpassword");
		String cnfpwd= (String)userData.get("conformpassword");
		
		
		  User user=userService.findByPhoneNo(phoneno);
		  String pwd=user.getPassword();
		
		
		
		if(oldpwd.equals(pwd) && newpwd.equals(cnfpwd)){
			int count = userService.changePassword(userData);
			LOGGER.info(" update count: {} ::: "+ userData.get("EmailId"));
			if(count>=0)
			  return ResponseEntity.status(HttpStatus.OK).body("Password has been mpdified successfully");
			else
				return ResponseEntity.status(HttpStatus.OK).body("Password has not modified due to internal issue");
			
		}
		else{
			return ResponseEntity.status(HttpStatus.OK).body("Password has not modified due to internal issue");	
		}
		
		
	}

}
