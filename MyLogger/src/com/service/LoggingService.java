package com.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoggingService {

	private static LoggingService logService;
	private static final String FILENAME = "D:\\logFile.log";
	private BufferedWriter bw;
	private FileWriter fw ;
	private LoggingService(){
		try {
			this.fw = new FileWriter(new File(FILENAME));
		} catch (IOException e) {
			System.out.println("Unable to open file");
			e.printStackTrace();
		}
		this.bw = new BufferedWriter(fw);
	}
	public static LoggingService getLoggingService(){
		if(logService==null){
			synchronized (logService) {
				if(logService==null){
					logService=new LoggingService();
				}
			}
		}
		return logService;
	}
	public void log(MyLogger log){
		try {
			synchronized (log) {
				bw.write(log.toString());
			}
		} catch (IOException e) {
			System.out.println(" Unable to Write in File");
		}
	}
}
