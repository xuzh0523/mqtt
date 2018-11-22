/** 
 * <pre>项目名称:mqtt 
 * 文件名称:Server.java 
 * 包名:com.bjrde.realtime.main 
 * 创建日期:2018年11月21日下午3:31:30 
 * Copyright (c) 2018, 许志豪 1067380015@qq.com  All Rights Reserved.</pre> 
 */
package com.bjrde.realtime.server;

import java.util.Date;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 项目名称：mqtt 类名称：Server 类描述： 创建人：许志豪 1067380015@qq.com 创建时间：2018年11月21日
 * 下午3:31:30 修改人：许志豪 1067380015@qq.com 修改时间：2018年11月21日 下午3:31:30 修改备注：
 * 
 * @version
 *          </p>
 */
@Component
public class Server {
	public static volatile String broker = PropertyUtil.property.get("iothub.mqtt.broke");
	public static volatile String userName = PropertyUtil.property.get("iothub.mqtt.username");
	public static volatile String passWord = PropertyUtil.property.get("iothub.mqtt.password");
	public static volatile String TOPIC = PropertyUtil.property.get("iothub.mqtt.topic");
	public static volatile MqttClient mqttClient;
	public static volatile MqttConnectOptions connOpts;
	private MqttTopic topic;
	private MqttMessage message;

	@Scheduled(cron = "0/5 * * * * ? ") // 每5秒执行一次
	public void run() throws MqttException {
		connOpts = new MqttConnectOptions();
		connOpts.setUserName(userName);
		connOpts.setPassword(passWord.toCharArray());
		String randomStr = "test_sub_" + Common.getRandomStr(30);
		mqttClient = new MqttClient(broker, randomStr);
		mqttClient.connect(connOpts);
		topic = mqttClient.getTopic(TOPIC);
		message = new MqttMessage();
		message.setQos(0);
		message.setRetained(true);
		message.setPayload(String.valueOf(new Date().getTime()).getBytes());
		publish(topic, message);
	}

	public void publish(MqttTopic topic, MqttMessage message) throws MqttPersistenceException, MqttException {
		MqttDeliveryToken token = topic.publish(message);
		token.waitForCompletion();
		System.out.println("发送的消息是=" + message);
	}
}
