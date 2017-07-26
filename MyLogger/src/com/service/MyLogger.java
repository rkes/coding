package com.service;

public class MyLogger {
	private String className;
	private LoggingService loggingService;
	MyLogger(String className){
		this.className=className;
		this.loggingService=LoggingService.getLoggingService();
	}
	
	public void Info(String msg){
		this.loggingService.log(this);
	}
}
