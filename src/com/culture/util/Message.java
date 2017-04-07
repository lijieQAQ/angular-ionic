package com.culture.util;



public class Message {
	private  final static String[] msg={"系统运行错误!","参数错误!","登陆超时!","操作成功!"};
	public static String getMsg(int index){
		return msg[index-1];
	}
	public static org.json.JSONObject getParamMsg(){
		org.json.JSONObject jo=new org.json.JSONObject();
		jo.put("state", 1);
		jo.put("Msg", msg[1]);
		return jo;
	}
	public static org.json.JSONObject getParamMsg(String msg){
		org.json.JSONObject jo=new org.json.JSONObject();
		jo.put("state", 1);
		jo.put("Msg", msg);
		return jo;
	}
	public static org.json.JSONObject getErrorMsg(){
		org.json.JSONObject jo=new org.json.JSONObject();
		jo.put("state", -1);
		jo.put("Msg", msg[0]);
		return jo;
	}
	public static org.json.JSONObject getTimeOutMsg(){
		org.json.JSONObject jo=new org.json.JSONObject();
		jo.put("state", 2);
		jo.put("Msg", msg[2]);
		return jo;
	}
	public static org.json.JSONObject getSuccessMsg(){
		org.json.JSONObject jo=new org.json.JSONObject();
		jo.put("state", 0);
		jo.put("Msg", msg[3]);
		return jo;
	}
	
	public static org.json.JSONObject getLoginSuccessMsg(){
		org.json.JSONObject jo=new org.json.JSONObject();
		jo.put("state", "0");
		jo.put("Msg", "登陆成功!");
		return jo;
	}
	public static org.json.JSONObject getSuccessMsg(String msg){
		org.json.JSONObject jo=new org.json.JSONObject();
		jo.put("state", "0");
		jo.put("Msg",msg);
		return jo;
	}
	
	
	
}
