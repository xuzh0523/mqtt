/** 
 * <pre>项目名称:mqtt 
 * 文件名称:PushCallback.java 
 * 包名:com.bjrde.realtime.main 
 * 创建日期:2018年11月21日下午3:32:10 
 * Copyright (c) 2018, 许志豪 1067380015@qq.com  All Rights Reserved.</pre> 
 */
package com.bjrde.realtime.server;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * <p>
 * 项目名称：mqtt 类名称：PushCallback 类描述： 创建人：许志豪 1067380015@qq.com 创建时间：2018年11月21日
 * 下午3:32:10 修改人：许志豪 1067380015@qq.com 修改时间：2018年11月21日 下午3:32:10 修改备注：
 * 
 * @version
 *          </p>
 */
public class PushCallback implements MqttCallback {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.paho.client.mqttv3.MqttCallback#connectionLost(java.lang.
	 * Throwable)
	 */
	@Override
	public void connectionLost(Throwable cause) {
		System.out.println("重新连接");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.paho.client.mqttv3.MqttCallback#messageArrived(java.lang.String,
	 * org.eclipse.paho.client.mqttv3.MqttMessage)
	 */
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("接收消息主题 : " + topic);
		System.out.println("接收消息Qos : " + message.getQos());
		System.out.println("接收消息内容 : " + new String(message.getPayload()));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.paho.client.mqttv3.MqttCallback#deliveryComplete(org.eclipse.paho
	 * .client.mqttv3.IMqttDeliveryToken)
	 */
	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		System.out.println("11111");
	}

}
