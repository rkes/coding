package com.service;

import java.util.HashMap;

public class LoggerService {
	private static HashMap<Class,MyLogger> logMap=new HashMap<Class,MyLogger>();
	
	public static MyLogger getLogger(Class className){
		MyLogger logger=logMap.get(className);
		if(logger==null){
			MyLogger log=new MyLogger(className.getName());
			logMap.put(className, logger);
		}
		return logger;
	}
	
}
