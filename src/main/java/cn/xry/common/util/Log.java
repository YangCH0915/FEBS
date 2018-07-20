package cn.xry.common.util;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class Log {

	
	private static Logger getLogger(@SuppressWarnings("rawtypes") Class c){
		return (Logger) LoggerFactory.getLogger(c);
	}
	
	public static void i(@SuppressWarnings("rawtypes") Class c,String msg){
		getLogger(c).info(msg);
	}
	
	public static void d(@SuppressWarnings("rawtypes") Class c,String msg){
		getLogger(c).debug(msg);
	}
	
	public static void e(@SuppressWarnings("rawtypes") Class c,String msg){
		getLogger(c).error(msg);
	}
	
}
