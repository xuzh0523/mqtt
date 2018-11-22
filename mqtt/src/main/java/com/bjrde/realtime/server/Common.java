package com.bjrde.realtime.server;

import java.text.DecimalFormat;
import java.util.Collection;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Common {
	private static String template = "ABCDEFGHIJKLMNPQRSTUVWXYZabcdefghjklmnpqrstuvwxyz123456789";
	public static DecimalFormat doubleDecimal = new DecimalFormat("##.00");
	public static DecimalFormat intDecimal = new DecimalFormat("##");
	public static final String addition = "1";
	public static final String subtraction = "2";
	public static final String multiplication = "3";
	public static final String division = "4";
	public static String TRUE = "true";
	public static String SPLIT_COMMA = ",";
	public static String SPLIT_SEMICO = ";";
	public static String SPLIT_MIDDLE = "\\|";
	public static String SPLIT_AND = "&";
	public static String SPLIT_POINT = "\\.";
	public static String POINT = ".";
	public static volatile int data;
	public static ApplicationContext springContext;

	/**
	 * 初始化spring容器
	 * 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 参数
	 * @return void 返回类型
	 */
	public static void springContextInitialize() {
		springContext = new FileSystemXmlApplicationContext("classpath:springContext.xml");
	}

	public static boolean isEmpty(String s) {
		if ((s == null) || ("".equals(s)) || ("".equals(s.trim())) || ("null".equalsIgnoreCase(s))) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmpty(String s) {
		if ((s == null) || ("".equals(s)) || ("".equals(s.trim())) || ("null".equalsIgnoreCase(s))) {
			return false;
		}
		return true;
	}

	public static boolean isEmpty(Collection<?> value) {
		return (value == null) || (value.size() == 0);
	}

	public static String getRandomStr(int digit) {
		StringBuffer str = new StringBuffer("");
		for (int i = 0; i < digit; i++) {
			str.append(RandomStringUtils.random(1, template));
		}
		return str.toString();
	}

	public static String delSpace(String str) {
		if (isNotEmpty(str)) {
			return str.trim().replaceAll("\r|\n", "");
		}
		return "";
	}
}
