package com.culture.util;  


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.json.JSONObject;

public class Log {
	private static final Logger loger = Logger.getLogger(Log.class);
	public void before(JoinPoint point){
		StringBuffer sb = new StringBuffer();
		sb.append("\n请求的controller:"+point.getTarget().getClass());
		sb.append("\n请求的方法为："+ point.getTarget().getClass().getName() + "." + point.getSignature().getName() + "()");
		Object[] objs = point.getArgs();
		sb.append("\n请求的参数:");
	    if(objs.length == 0){
			sb.append("\n无请求参数");	
		}else{
			for(Object obj:objs){
				sb.append("\n"+new JSONObject(obj).toString()+",");
			}
		}
		loger.info(sb);
	}
	
	public void after(JoinPoint point){
//		System.out.println("被拦截方法调用之后调用此方法，输出此语句");    
	}

}
 