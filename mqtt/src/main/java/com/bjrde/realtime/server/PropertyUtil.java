package com.bjrde.realtime.server;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PropertyUtil {
	public static volatile Map<String, String> property;
	public static volatile Logger log = Logger.getLogger(PropertyUtil.class);
	public static volatile int errorExportLogCount = 0;
	public static volatile String debug = "debug";
	public static volatile String error = "error";

	public static void init() {
		PropertyUtil.logExport(PropertyUtil.debug, "PropertyUtil init start ...", null);
		InputStream CONFIG = null;
		try {
			CONFIG = new BufferedInputStream(
					new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
			PropertyResourceBundle CONFIGPROPERTY = new PropertyResourceBundle(CONFIG);
			property = new HashMap<>();
			Set<String> keySet = CONFIGPROPERTY.keySet();
			for (String key : keySet) {
				property.put(key, CONFIGPROPERTY.getString(key));
			}
			PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
		} catch (Exception e) {
			PropertyUtil.logExport(error, "PropertyUtil init fail ...", "" + e);
		} finally {
			try {
				CONFIG.close();
			} catch (IOException e) {
				if (PropertyUtil.errorExportLogCount < 11) {
					PropertyUtil.logExport(PropertyUtil.error, "PropertyUtil InputStream Close fail ...", "" + e);
				} else {
					PropertyUtil.errorExportLogCount++;
				}
			}
		}
		PropertyUtil.logExport(PropertyUtil.debug, "PropertyUtil init success ...", null);
	}

	public static void logExport(String level, String msg, String errorMsg) {
		if (debug.equals(level)) {
			log.debug(msg);
		} else if (error.equals(level)) {
			log.error(msg + errorMsg);
		}
	}
}
