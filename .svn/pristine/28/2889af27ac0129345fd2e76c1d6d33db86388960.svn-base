package com.culture.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;




import org.json.JSONArray;
import org.json.JSONObject;

public class JSONUtil {
	
	
	public static Map<String,Object>  parse(String[] params,String jsonstr) throws Exception{
		Map<String,Object> reult=null;
		try{
			JSONObject jo=new JSONObject(jsonstr);
			 reult=new HashMap<String, Object>();
			for (int i = 0; i < params.length; i++) {
				reult.put(params[i], jo.get(params[i]));
			}
		}catch(Exception e){
			throw new Exception();
		}
		return reult;
		
	}
	public static Object  parseObject(Class<?> cs,String jsonstr) throws Exception{
		
		ObjectUtil ob=new ObjectUtil(cs);
		Map<String, Property> maps=ob.getLPropertyForMap();
		try{
			JSONObject jo=new JSONObject(jsonstr); 
            Iterator it = jo.keys();  
            while (it.hasNext()) { 
                String key = (String) it.next();  
                Property po=maps.get(key);
				if(po.getGeneric()!=null){
					maps.get(key).setValue(parseList(Class.forName(po.getGeneric()), jo.get(key).toString()));
				}else{
					if(ObjectUtil.isPrimitive(po.getType())){
						
						Object value=null;
						Object va=jo.get(key);
						if("java.lang.String".equals(jo.get(key).getClass().getName()) && po.getType().indexOf("Integer")!=-1){
							value=Integer.valueOf(va.toString());
						}else if("java.lang.String".equals(jo.get(key).getClass().getName()) && po.getType().indexOf("Long")!=-1){
							value=Long.valueOf(va.toString());
						}else if("java.lang.String".equals(jo.get(key).getClass().getName()) && po.getType().indexOf("Character")!=-1){
							value=Character.valueOf(va.toString().charAt(0));
						}else{
							value=jo.get(key);
						}			
						maps.get(key).setValue(value);
					}else if("".equals(po.getType())){
					}else{
						maps.get(key).setValue(parseObject(Class.forName(po.getType()),jo.get(key).toString()));
					}
				}
            }
			ob.setProperty(maps);
		}catch(Exception e){
			throw e;
		}
		return ob.getBean();
		
	}
	
	public static List<?>  parseList(Class<?> cs,String jsonstr) throws Exception{
		List<Object> list=new ArrayList<Object>();

		try{
			JSONArray ja=new JSONArray(jsonstr);
			for (int i = 0; i < ja.length(); i++) {
				//System.out.println(cs.isPrimitive());
				if(cs.isPrimitive() || cs.getName().equals("java.lang.String")){
					list.add(ja.get(i));
				}else{
					list.add(parseObject(cs,ja.get(i).toString()));
				}
			}
		}catch(Exception e){
			throw e;
		}
		return list;
		
	}
	
   

}
