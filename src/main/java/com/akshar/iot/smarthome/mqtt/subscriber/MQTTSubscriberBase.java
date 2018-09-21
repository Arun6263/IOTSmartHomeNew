package com.akshar.iot.smarthome.mqtt.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.akshar.iot.smarthome.mqtt.publisher.MQTTPublisherBase;



/**
 * MQTT Subscriber Base Interface
 * 
 * @author Raju b
 *
 */
public interface MQTTSubscriberBase {

	public static final Logger logger = LoggerFactory.getLogger(MQTTPublisherBase.class);

	/**
	 * Subscribe message
	 * 
	 * @param topic
	 * @param jasonMessage
	 */
	public void subscribeMessage(String topic);

	/**
	 * Disconnect MQTT Client
	 */
	public void disconnect();
}
