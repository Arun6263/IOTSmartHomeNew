package com.akshar.iot.smarthome.controller;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.akshar.iot.smarthome.form.CommandForm;
import com.akshar.iot.smarthome.form.DeviceForm;
import com.akshar.iot.smarthome.repository.UserDeviceRepository;

@Controller
public class UserDeviceController {
	public final static Logger LOGGER = LoggerFactory.getLogger(UserDeviceController.class);
	
	@Autowired(required=true)
	 private UserDeviceRepository userDeviceRepository;
	
	
	@RequestMapping(value="/mapDeviceToUser",method = RequestMethod.GET)
	public ModelAndView addDevice(){
		ModelAndView model = new ModelAndView();
		model.setViewName("user/mapDeviceToUser");
		
		
		//model.getModelMap().put("deviceForm",deviceForm);
		return model;
	}
	
	@RequestMapping(value="/getControlsOfUser",method = RequestMethod.GET)
	public ModelAndView getControlsOfUser(){
		ModelAndView model = new ModelAndView();
		model.setViewName("user/mapDeviceToUser");
		
		
		//model.getModelMap().put("deviceForm",deviceForm);
		return model;
	}
}
