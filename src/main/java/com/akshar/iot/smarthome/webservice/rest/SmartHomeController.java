/*package com.akshar.iot.smarthome.webservice.rest;

import java.util.Map;

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


import com.akshar.iot.smarthome.model.User;
import com.akshar.iot.smarthome.mqtt.publisher.MQTTPublisherBase;
import com.akshar.iot.smarthome.service.UserService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

*//**
 * SmartHomeController  to  Rest API
 * 
 * @author RAJU 
 *
 *//*
@Api(value = "SmartHomeController  API", description = "<b>SmartHomeController  API</b> \n\n"
		+ "Use this API for Add, Find, Remove the Home devices based on SmartHome APP calls")
@RestController
public class SmartHomeController {

	public final static Logger LOGGER = LoggerFactory.getLogger(SmartHomeController.class);
		@Autowired
		MQTTPublisherBase publisher;
		@Autowired
		private UserService userService;
		
		
		@ApiOperation(value = "Get the Customer Details ")
		@RequestMapping(value = "/getCustomerInfo", method = RequestMethod.GET)
		public ResponseEntity<User>  getLogin(@RequestParam String userName,@RequestParam String Password) {
			LOGGER.info(" Getlogin: {} ::: "+ userName);
			User user=userService.findByPhoneNo(userName);
			
			if(user!=null) {
				LOGGER.info(" user details: {} ::: "+ user.toString());
			//	 return ResponseEntity.status(HttpStatus.OK).body(user);
			}
			
			
			//LOGGER.info(" user details: {} ::: "+ user.toString());
			return ResponseEntity.status(HttpStatus.OK).body(user);
			//publisher.publishMessage("demoTopic2017", userData.toString());
			//return "Message sent to Broker";
		}
      
		@ApiOperation(value = "Post for add user")
		@RequestMapping(value = "/mqtt/getinfo", method = RequestMethod.POST)
		public String getLogininfo() {
			LOGGER.info("index getlogin info: {}");
			//publisher.publishMessage("demoTopic2017", userData.toString());
			return "Message sent to Broker";
		}
		
		
		@ApiOperation(value = "Post for add user")
		@PostMapping(value = "/mqtt/send")
		public String index(@RequestBody Map<String, Object> userData,
                @RequestHeader("SmartHome-API-Key") String api_key) {
			LOGGER.info("index: {}", userData.toString());
			
			System.out.println("------REST Service -- PhoneNo : "+userData.get("PhoneNo"));
			System.out.println("------REST Service -- FirstName : "+userData.getFirstName());
			System.out.println("------REST Service -- LastName : "+userData.getLastName());
			System.out.println("------REST Service -- Phone : "+userData.getUserPhone());
			System.out.println("------REST Service -- CompanyName : "+userData.getCompanyName());
			System.out.println("------REST Service -- LineOne : "+user.get);
			System.out.println("------REST Service -- LineTwo : "+user.getEmailId());
			System.out.println("------REST Service -- City : "+user.getEmailId());
			System.out.println("------REST Service -- State : "+user.getEmailId());
			System.out.println("------REST Service -- Country : "+user.getEmailId());
			
			publisher.publishMessage("demoTopic2017", userData.toString());
			return "Message sent to Broker";
		}

		@ApiOperation(value = "PUT for update password")
		@RequestMapping(value = "/mqtt/update", method = RequestMethod.PUT)
		public String ChangePassword(@RequestBody Map<String, Object> userData,
                @RequestHeader("SmartHome-API-Key") String api_key) {
			LOGGER.info("ChangePassword: {}", userData.toString());
			return null;
		}

		
	}
	

*/