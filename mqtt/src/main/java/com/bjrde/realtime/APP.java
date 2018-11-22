/** 
 * <pre>项目名称:mqtt 
 * 文件名称:APP.java 
 * 包名:com.bjrde.realtime 
 * 创建日期:2018年11月21日下午6:14:22 
 * Copyright (c) 2018, 许志豪 1067380015@qq.com  All Rights Reserved.</pre> 
 */
package com.bjrde.realtime;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.bjrde.realtime.server.Common;
import com.bjrde.realtime.server.PropertyUtil;
import com.bjrde.realtime.server.Server;

/**
 * <p>
 * 项目名称：mqtt 类名称：APP 类描述： 创建人：许志豪 1067380015@qq.com 创建时间：2018年11月21日 下午6:14:22
 * 修改人：许志豪 1067380015@qq.com 修改时间：2018年11月21日 下午6:14:22 修改备注：
 * 
 * @version
 *          </p>
 */
public class APP {
	public static void main(String[] args) throws MqttException {
		PropertyUtil.init();
		Common.springContextInitialize();
		new Server().run();
	}
}
