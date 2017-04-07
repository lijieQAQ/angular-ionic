package com.culture.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ObjectUtil {
	private Class<?> cs;
	
	private Object obj;
	public ObjectUtil() {
	}
	public ObjectUtil(Object obj) throws ClassNotFoundException, Exception{
		this.cs=Class.forName(obj.getClass().getCanonicalName());
		this.obj= obj;
	}
	public ObjectUtil(Class<?> cs) throws ClassNotFoundException, Exception{
		this.cs=cs;
		this.obj= cs.newInstance();
	}
	
	
	//获取自己的属性
	public List<Property> getLProperty(){
			Field[] field = cs.getDeclaredFields();
			List<Property> pro=null;
		try{
			pro=new ArrayList<Property>();
	       for (int i = 0; i < field.length; i++) {
	            int mo = field[i].getModifiers();
	            field[i].setAccessible(true); //设置些属性是可以访问的  
	            Object val=null;
				try {
					val = field[i].get(obj);
					val.toString();
				} catch (Exception e) {
					val=null;
				}finally{
					String priv = Modifier.toString(mo);
					Class<?> type = field[i].getType();
					Property po=new Property(getType(type.getName()), field[i].getName(), priv,val);
					if(type.isAssignableFrom(List.class)){
						Type fc =field[i].getGenericType(); 
						if(fc != null){
						  
			             if(fc instanceof ParameterizedType) // 【3】如果是泛型参数的类型   
			            {   
			                   ParameterizedType pt = (ParameterizedType) fc;  
			  
			                   Class<?> genericClazz = (Class<?>)pt.getActualTypeArguments()[0]; //【4】 得到泛型里的class类型对象。  
			                   if(genericClazz.isPrimitive()){
			                	   po.setGeneric(getType(genericClazz.getName()));
			                   }else{
			                	   po.setGeneric(genericClazz.getName());
			                   }
			             }  
						} 
					}
					pro.add(po);
				}
	        }
		}catch(Exception e){
			e.printStackTrace();
		}
		return pro;
	}
	public List<Property> getFProperty() {
		Field[] field = cs.getFields();
		List<Property> pro=new ArrayList<Property>();
		for (int i = 0; i < field.length; i++) {
			int mo = field[i].getModifiers();
			String priv = Modifier.toString(mo);
            field[i].setAccessible(true); //设置些属性是可以访问的  
            Object val=null;
			try {
				val = field[i].get(obj);
				val.toString();
			} catch (Exception e) {
				val=null;
			}finally{
				Class<?> type = field[i].getType();
				Property po=new Property(getType(type.getName()), field[i].getName(), priv,val);
				if(type.isAssignableFrom(List.class)){
					Type fc =field[i].getGenericType(); 
					if(fc != null){
					  
		             if(fc instanceof ParameterizedType) // 【3】如果是泛型参数的类型   
		            {   
		                   ParameterizedType pt = (ParameterizedType) fc;  
		                   Class<?> genericClazz = (Class<?>)pt.getActualTypeArguments()[0]; //【4】 得到泛型里的class类型对象。  
		                   if(genericClazz.isPrimitive()){
		                	   po.setGeneric(getType(genericClazz.getName()));
		                   }else{
		                	   po.setGeneric(genericClazz.getName());
		                   }
		             }  
					} 
				}
				pro.add(po);
			}
		}
		return pro;
	}
	public Map<String,Property> getLPropertyForMap(){
		Field[] field = cs.getDeclaredFields();
		Map<String,Property> pro=new HashMap<String, Property>();
		for (int i = 0; i < field.length; i++) {
			int mo = field[i].getModifiers();
            field[i].setAccessible(true); //设置些属性是可以访问的  
            Object val=null;
			try {
				val = field[i].get(obj);
				val.toString();
			} catch (Exception e) {
				val=null;
			}finally{
				String priv = Modifier.toString(mo);
				Class<?> type = field[i].getType();
				Property po=new Property(getType(type.getName()), field[i].getName(), priv,val);
				if(type.isAssignableFrom(List.class)){
					Type fc =field[i].getGenericType(); 
					if(fc != null){
					  
		             if(fc instanceof ParameterizedType) // 【3】如果是泛型参数的类型   
		            {   
		                   ParameterizedType pt = (ParameterizedType) fc;  
		                   Class<?> genericClazz = (Class<?>)pt.getActualTypeArguments()[0]; //【4】 得到泛型里的class类型对象。  
		                   if(genericClazz.isPrimitive()){
		                	   po.setGeneric(getType(genericClazz.getName()));
		                   }else{
		                	   po.setGeneric(genericClazz.getName());
		                   }
		             }  
					} 
				}
				pro.put(field[i].getName(),po);
			}
		}
		return pro;
	}

	public Map<String,Property> getFPropertyForMap() {
		Field[] field = cs.getFields();
		Map<String,Property> pro=new HashMap<String, Property>();
		for (int i = 0; i < field.length; i++) {
			int mo = field[i].getModifiers();
            field[i].setAccessible(true); //设置些属性是可以访问的  
            Object val=null;
			try {
				val = field[i].get(obj);
			} catch (Exception e) {
				val=null;
			}finally{
				String priv = Modifier.toString(mo);
				Class<?> type = field[i].getType();
				Property po=new Property(getType(type.getName()), field[i].getName(), priv,val);
				if(type.isAssignableFrom(List.class)){
					Type fc =field[i].getGenericType(); 
					if(fc != null){
					  
		             if(fc instanceof ParameterizedType) // 【3】如果是泛型参数的类型   
		            {   
		                   ParameterizedType pt = (ParameterizedType) fc;  
		  
		                   Class<?> genericClazz = (Class<?>)pt.getActualTypeArguments()[0]; //【4】 得到泛型里的class类型对象。  
		                   if(genericClazz.isPrimitive()){
		                	   po.setGeneric(getType(genericClazz.getName()));
		                   }else{
		                	   po.setGeneric(genericClazz.getName());
		                   }
		             }  
					} 
				}
				pro.put(field[i].getName(),po);
			}
		}
		return pro;
	}
	
	public Object  getProperty(String name){
		 Object ob=null;
		 try{
	            String methodname="get"+StringUtil.toUpperCaseFirstOne(name);
	            Method method=cs.getMethod(methodname);
	            ob= method.invoke(cs.newInstance());
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	        return ob;
	}
	public void setProperty(Map<String,Property> map){
		String methodname=null;
		 try{
			 	for(String key:map.keySet()){
					if(Modifier.isFinal(cs.getDeclaredField(key).getModifiers())){
						continue;
					}
			 		methodname="set"+StringUtil.toUpperCaseFirstOne(key);
			 		Property po=map.get(key);
			 		Method method=cs.getMethod(methodname,cs.getDeclaredField(key).getType());
			 		method.invoke(obj,po.getValue());
			 	}
	        }catch (Exception e) {
	            System.err.println(methodname+" 方法没有找到!");
	        }
	}
	public void setProperty(List<Property> map){
		
		try{
			for(Property pro:map){
				if(Modifier.isFinal(cs.getDeclaredField(pro.getName()).getModifiers())){
					continue;
				}
				String methodname="set"+StringUtil.toUpperCaseFirstOne(pro.getName());
				Method method=cs.getMethod(methodname,cs.getDeclaredField(pro.getName()).getType());
				method.invoke(obj,pro.getValue());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public Object getBean() {
		return obj;
	}
	@SuppressWarnings("unused")
	public void setBean(Object obj) throws ClassNotFoundException, Exception{
		this.cs=Class.forName(obj.getClass().getCanonicalName());
		if(obj!=null){
			this.obj=obj;
		}else{
			this.obj= cs.newInstance();
		}
	}
	public void setBean(Class<?> cs) throws ClassNotFoundException, Exception{
		this.cs=cs;
		this.obj= cs.newInstance();
	}
	
	private  String getType(String type){
		if("int".equals(type)){
			return "java.lang.Integer";
		}
		if("long".equals(type)){
			return "java.lang.Long";
		}
		if("boolean".equals(type)){
			return "java.lang.Boolean";
		}
		if("short".equals(type)){
			return "java.lang.Short";
		}
		if("byte".equals(type)){
			return "java.lang.Byte";
		}
		if("char".equals(type)){
			return "java.lang.Character";
		}
		if("float".equals(type)){
			return "java.lang.Float";
		}
		if("double".equals(type)){
			return "java.lang.Double";
		}
		return type;
		
	}
	public static boolean isPrimitive(String name){
		String type="java.lang.Integer,int,java.lang.Long,long,java.lang.Boolean,boolean,java.lang.Short,short,java.lang.Byte,byte,java.lang.Character,char,java.lang.Float,float,java.lang.Double,double,java.lang.String";
		if(type.indexOf(name)!=-1){
			return true;
		}
		return false;
		
	}
	
}
