/*package com.akshar.iot.smarthome.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.akshar.iot.smarthome.mqtt.subscriber.MQTTSubscriberBase;
import com.akshar.iot.smarthome.webservice.rest.SmartHomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MessageListener implements Runnable{
	public final static Logger LOGGER = LoggerFactory.getLogger(MessageListener.class);
	@Autowired
	MQTTSubscriberBase subscriber;
	
	@Override
	public void run() {
		while(true) {
			//LOGGER.info(" subscriber.subscribeMessage ");
			subscriber.subscribeMessage("demoTopic2017");
		}
		
	}

}
*/