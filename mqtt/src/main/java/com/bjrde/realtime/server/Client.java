/** 
 * <pre>项目名称:mqtt 
 * 文件名称:Client.java 
 * 包名:com.bjrde.realtime.main 
 * 创建日期:2018年11月21日下午3:32:37 
 * Copyright (c) 2018, 许志豪 1067380015@qq.com  All Rights Reserved.</pre> 
 */
package com.bjrde.realtime.server;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * <p>
 * 项目名称：mqtt 类名称：Client 类描述： 创建人：许志豪 1067380015@qq.com 创建时间：2018年11月21日
 * 下午3:32:37 修改人：许志豪 1067380015@qq.com 修改时间：2018年11月21日 下午3:32:37 修改备注：
 * 
 * @version
 *          </p>
 */
public class Client {
	public static volatile MqttClient mqttClient;
	public static volatile MqttConnectOptions mqttConnectOptions;

	public void run() {
		mqttConnectOptions = new MqttConnectOptions();
		mqttConnectOptions.setCleanSession(true);
		mqttConnectOptions.setUserName("s05vj98/xuzh");
		mqttConnectOptions.setPassword("F77GLqQmFBUautTf".toCharArray());
		String randomStr = "test_sub_" + Common.getRandomStr(30);
		try {
			mqttClient = new MqttClient("tcp://s05vj98.mqtt.iot.bj.baidubce.com:1883", randomStr);
			mqttClient.connect(mqttConnectOptions);
			int Qos = Integer.parseInt("0");
			mqttClient.subscribe("test", Qos);
			mqttClient.setCallback(new PushCallback());
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
