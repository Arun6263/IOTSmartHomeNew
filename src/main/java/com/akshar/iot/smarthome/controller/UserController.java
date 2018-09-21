package com.akshar.iot.smarthome.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.akshar.iot.smarthome.form.AddressForm;
import com.akshar.iot.smarthome.form.UserForm;
import com.akshar.iot.smarthome.model.Address;
import com.akshar.iot.smarthome.model.User;
import com.akshar.iot.smarthome.service.AddressService;
import com.akshar.iot.smarthome.service.UserService;
import com.akshar.iot.smarthome.util.MailUtil;

@Controller
public class UserController {

	public final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private MailUtil mailservice ;


		
	@RequestMapping(value = { "/new_user" }, method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView();
		UserForm userForm = new UserForm();
		model.getModelMap().put("userForm",userForm);
		LOGGER.info("newUser :- You are in the NEW USER Setup");
		model.setViewName("user/new_user");
		return model;

	}
	
	/*@RequestMapping(value = "/changePassword",method = RequestMethod.GET)
	public ResponseEntity  changePasswd() {
		System.out.println("in change pwd===");
		
		Map<String, Object> userData = null;
		int count=userService.changePassword(userData);
		System.out.println("updated successfully"+count);
		return null;
		  
		
		
	}
	*/
	
	@RequestMapping(value= {"/saveUser"}, method=RequestMethod.POST)
	 public ModelAndView createUser(@ModelAttribute("userForm")UserForm userForm,Model modl) {
		
		ModelAndView model=new ModelAndView("redirect:getAllUsers");
			
			//new ModelAndView();
	  
	  try{
		  
		  User user=new User();
			 // customer.setAddress(address);
			  user.setPhoneNo(userForm.getPhoneNo());
			  user.setEmailId(userForm.getEmailId());
			  user.setPassword("admin");
			  user.setFirstName(userForm.getFirstName());
			  user.setLastName(userForm.getLastName());
			  user.setUserType("CUST");
			  user.setCompanyName("");
			  user.setActiveFlag("Y");
			  
			  
			  
			  Address addr = new Address();
			 // addr.setUserId(user.getUserId());
			  addr.setLineOne(userForm.getAddressForm().getLineOne());
			  addr.setLineTwo(userForm.getAddressForm().getLineTwo());
			  addr.setCity(userForm.getAddressForm().getCity());
			  addr.setState(userForm.getAddressForm().getStateCode());
			  addr.setCountry(userForm.getAddressForm().getCountryCode());  
			 // addressService.saveAddress(addr);
			  
			  user.setAddress(addr);
			  addr.setUser(user);
			  //userService.saveUser(user);
			  addressService.saveAddress(addr);
			  

			  /*
				if(custmr==null ){
					  userService.saveUser(user);
					  LOGGER.info("---------------You are in the NEW USER Saving--------------");
				      final byte[] authBytes = password.getBytes(StandardCharsets.UTF_8);
				      final String encodedpwd = Base64.getEncoder().encodeToString(authBytes);
				      System.out.println(password + " => " + encodedpwd);
					 // User user=new User();
					  //user.setLoginId(customerForm.getEmailId());
					 // user.setUsertype("user");
					//  user.setPassword(encodedpwd);
					  //userService.saveUser(user);
					
				}else {
					ModelAndView modelAndView=new ModelAndView();
					modelAndView.addObject("error", "The email is already registered with us Register with new email");
					modelAndView.setViewName("user/new_user");
			          return modelAndView;
					}
		*/	 
			  LOGGER.info("createUser :- Before calling send email");
			  
			  //User custmr=userService.findByEmailId(user.getEmailId());
			  String userName=userForm.getFirstName()+userForm.getLastName();
			  mailservice.sendMail(userForm.getEmailId(), userName);
			  
			  LOGGER.info("createUser :- Mail sent sucessfully...");
			  
	  }catch(Exception ex){
		  model.setViewName("user/new_user");
		  model.addObject("error", "Error while saving the User data, the Exception is : + "+ex.toString());
		  LOGGER.info("createUser :- Exception ex: "+ex);
	  }
	  /* ModelAndView model = new ModelAndView();
	  
	  StringBuffer errorStr = new StringBuffer("UserName or Password is incorrect Please Try Again");
	  errorStr.append( "\nState  is incorrect Please Try Again");
	  errorStr.append("\nCountry or Address is incorrect Please Try Again");
	 // modl.addAttribute("error", "UserName or Password is incorrect Please Try Again");
	 // modl.addAttribute("error", "State  is incorrect Please Try Again");
	  modl.addAttribute("error", errorStr);
		 model.setViewName("user/new_user");
*/
	 // return model;
	  return model;
	  
	 }
	@RequestMapping(value = { "/getAllUsers" }, method = RequestMethod.GET)
	public ModelAndView getAllUsers(Model modl) {
		ModelAndView model = new ModelAndView();
		 model.setViewName("user/userList");
		List<User> userList = userService.findByUserType("CUST");
		//User user = new User();
		
		for(User user : userList){
			LOGGER.info("getAllUsers :- User : "+ user.getFirstName());
		}
		/*ModelMap modl=new ModelMap();
		modl.put("listCustomer", listCustomer);*/
			// model.addObject("listCustomer", listCustomer);
			 modl.addAttribute("listOfUser", userList);
			 LOGGER.info("getAllUsers :- You are in the LIST ALL USERS");
	        return model;
		

	}
	

}