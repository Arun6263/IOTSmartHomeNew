package com.akshar.iot.smarthome.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.akshar.iot.smarthome.form.LoginForm;
import com.akshar.iot.smarthome.model.User;
import com.akshar.iot.smarthome.service.UserService;

@Controller
public class LoginController {
	
	public final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/showHome" }, method = RequestMethod.GET)
	public ModelAndView showHome() {
		ModelAndView model = new ModelAndView();
	
		model.setViewName("user/index");
		
		return model;

	}
	
	@RequestMapping(value = {"/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("user/login");

		LoginForm loginForm = new LoginForm();
		//model.setObject("loginForm",loginForm);
		model.getModelMap().put("loginForm",loginForm);
		return model;

	}

	
	@RequestMapping(value = {"/logout" }, method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session,HttpServletRequest req,HttpServletResponse res) {
		session.invalidate();
		
		Cookie[] cookies = req.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("1234")){
    			System.out.println("JSESSIONID="+cookie.getValue());
    		}
    		cookie.setMaxAge(0);
    		res.addCookie(cookie);
    	}
    	}
		
		return new ModelAndView("redirect:login");

	}

	
	@RequestMapping(value = { "/signin" }, method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("loginForm")LoginForm loginForm,Model modl) {
		ModelAndView model = new ModelAndView();
		
		try {
			User user = userService.findByPhoneNo(loginForm.getPhoneNo());
	
			LOGGER.info("userLogin :- After getting the user details based on the Email");
			LOGGER.info("userLogin :- LoginForm.EmailId : "+ loginForm.getPhoneNo());
			LOGGER.info("userLogin :- loginForm.Password : "+ loginForm.getPassword());
			
			LOGGER.info("userLogin :- user.EMailId : "+ user.getPhoneNo());
			LOGGER.info("userLogin :- user.getLoginId : "+ user.getPassword());
			LOGGER.info("userLogin :- user.getUserType : "+ user.getUserType());
			
			
			 
			if (user==null ||!user.getPassword().equals(loginForm.getPassword())){
				 modl.addAttribute("error", "UserName or Password is incorrect Please Try Again");
				 model.setViewName("user/login");
				 LOGGER.info("userLogin :- You are in the Invalid Credentials block");
			}
			
			else if (user.getPhoneNo().equals(loginForm.getPhoneNo()) && loginForm != null) {
				
				if (user.getUserType().equals("ADMIN")) {
					model.setViewName("user/index");
					LOGGER.info("userLogin :- You are in the Successfully LoggedIn block");
				}
				else {
					model.setViewName("errors/access_denied");
					LOGGER.info("userLogin :- You are in the ACCESS DENIED block");
				}

			}
			
		}
		catch (Exception e) {
			
			LOGGER.error("userLogin :- Exception "+e.getMessage());
			 modl.addAttribute("error", "Problem in Login , Please try again "+e.getMessage());
			 model.setViewName("user/login");
		
		}
		return model;

	}

}
