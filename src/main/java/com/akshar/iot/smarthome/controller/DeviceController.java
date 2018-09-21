package com.akshar.iot.smarthome.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.akshar.iot.smarthome.form.DeviceForm;
import com.akshar.iot.smarthome.form.CommandForm;
import com.akshar.iot.smarthome.model.Device;
import com.akshar.iot.smarthome.model.Command;
import com.akshar.iot.smarthome.model.User;
import com.akshar.iot.smarthome.repository.DeviceRepository;
import com.akshar.iot.smarthome.repository.UserRepository;
import com.akshar.iot.smarthome.service.UserService;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DeviceController {

	public final static Logger LOGGER = LoggerFactory.getLogger(DeviceController.class);
	
	@Autowired(required=true)
	 private DeviceRepository deviceRepository;
	
	@RequestMapping(value="/addDevice",method = RequestMethod.GET)
	public ModelAndView addDevice(){
		ModelAndView model = new ModelAndView();
		model.setViewName("user/addNewDevicePage");
		DeviceForm deviceForm = new DeviceForm();
		
		List<CommandForm> commandList = new ArrayList<CommandForm>(3);
		CommandForm commandForm = new CommandForm();
		commandForm.setCommandCode("");
		commandForm.setCommandDesc("");
		commandForm.setCommandValue("");
		commandList.add(commandForm);
		
		commandForm = new CommandForm();
		commandForm.setCommandCode("");
		commandForm.setCommandDesc("");
		commandForm.setCommandValue("");
		commandList.add(commandForm);
		
		commandForm = new CommandForm();
		commandForm.setCommandCode("");
		commandForm.setCommandDesc("");
		commandForm.setCommandValue("");
		commandList.add(commandForm);
		deviceForm.setCommandList(commandList);
		
		model.getModelMap().put("deviceForm",deviceForm);
		return model;
	}
	
	@RequestMapping(value = { "/saveDevice" }, method = RequestMethod.POST)
	public ModelAndView deviceSave(@ModelAttribute("deviceForm")DeviceForm deviceForm,Model modl) {
		
		
		ModelAndView model=new ModelAndView("redirect:getAllDevices");
		
		Device device = new Device();
		Command command = null;
		Set commands = new HashSet<Command>();
		try {
			
			LOGGER.info("deviceSave : - Device Code "+ deviceForm.getDeviceCode());
			LOGGER.info("deviceSave : - Device Name "+ deviceForm.getDeviceName());
			LOGGER.info("deviceSave : - Product Code "+ deviceForm.getProductCode());
			
			/*List<CommandForm> commandList = deviceForm.getCommandList();
			LOGGER.info("deviceSave : - Command Size "+ commandList.size());
			for(CommandForm cForm : commandList){
				LOGGER.info("Command Info : Code : "+cForm.getCommandCode()+" Desc : "+cForm.getCommandDesc()+ "  Value : "+cForm.getCommandValue());
			}
			*/
			device.setDeviceCode(deviceForm.getDeviceCode());
			device.setDeviceName(deviceForm.getDeviceName());
			device.setProductCode(deviceForm.getProductCode());
			
				command = new Command();
				command.setCommandCode("ON");
				command.setCommandDesc("ON");
				command.setCommandValue("on");
				
				command.setDevice(device);		
				commands.add(command);
				
				command = new Command();
				command.setCommandCode("OFF");
				command.setCommandDesc("OFF");
				command.setCommandValue("off");
				command.setDevice(device);
				
				commands.add(command);
				
				device.setCommand(commands);
				
		
				deviceRepository.save(device);
				
				LOGGER.info("deviceSave :- ------successfully saved");
		
		}
		catch (Exception e) {
			
			LOGGER.error("deviceSave :- Exception "+e.getMessage());
			 modl.addAttribute("error", "Problem in Login , Please try again "+e.getMessage());
			 model.setViewName("user/login");
		
		}
		return model;

	}
	@RequestMapping(value = { "/getAllDevices" }, method = RequestMethod.GET)
	public ModelAndView getAllDevices(Model modl) {
		ModelAndView model = new ModelAndView();
		 model.setViewName("user/devicesList");
		 
		 List<Device> deviceList = deviceRepository.findAll();
			for(Device device : deviceList){
				LOGGER.info(" getAllDevices :- Code : "+device.getDeviceCode()+"  Name : "+device.getDeviceName());
			}
	
			modl.addAttribute("deviceList", deviceList);
			 
			 LOGGER.info("getAllDevices :- You are in the LIST ALL Devices");
	        return model;
		

	}
	
}
