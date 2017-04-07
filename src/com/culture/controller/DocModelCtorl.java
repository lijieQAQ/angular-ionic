package com.culture.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.annotate.JsonValue;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.culture.model.Culture_article;
import com.culture.model.Culture_doctype;
import com.culture.model.User;
import com.culture.service.DocTypeService;
import com.culture.util.JSONUtil;
import com.culture.util.Message;

@Controller
public class DocModelCtorl {
	
	
	@Autowired
	private DocTypeService moSV;
	
	@RequestMapping(value="model/operation.htm")
	public String getAll(HttpServletRequest request,HttpServletResponse response){
		JSONObject jo=null;
		PrintWriter printWriter=null;
	try{
		String cmd=request.getParameter("cmd");
		if("add".equals(cmd)){
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			User u=(User) request.getSession().getAttribute("user");
			String moduleName=request.getParameter("moduleName");
			String moduleSort=request.getParameter("moduleSort");
			String state=request.getParameter("state");
			Culture_doctype model=new Culture_doctype();
			model.setName(moduleName);
			model.setSort(new Integer(moduleSort));
			model.setState(state.charAt(0));
			Date date=new Date();
			model.setCreatetime(date);
			model.setLastupdatetime(date);
			model.setCreatorname(u.getUsername());
			model.setCreatorid(Integer.valueOf(u.getUserid()));
			model.setLastupdateuser(u.getUsername());
			model.setLastupdateuserid(Integer.valueOf(u.getUserid()));
			model.setIsdelete('0');
			moSV.addDocType(model);
			jo=Message.getSuccessMsg();
			return "model";
		}else if("update".equals(cmd)){
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			User u=(User) request.getSession().getAttribute("user");
			String sort=request.getParameter("sort");
			String name=request.getParameter("name");
			String id=request.getParameter("moduleid");
			if(id==null || "".equals(id)){
				jo=Message.getParamMsg();
				return "model";
			}
			Culture_doctype model=new Culture_doctype();
			model.setLastupdateuser(u.getUsername());
			model.setLastupdateuserid(Integer.valueOf(u.getUserid()));
			model.setName(name);
			model.setSort(new Integer(sort));
			Date date=new Date();
			model.setLastupdateuser(u.getUsername());
			model.setLastupdatetime(dateFormat.parse(dateFormat.format(date)));
			model.setId(new Integer(id));
			moSV.updateDocType(model);
			return "model";
		}else if("updateState".equals(cmd)){
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			User u=(User) request.getSession().getAttribute("user");
			String modelStr=request.getParameter("state");
			String id=request.getParameter("id");
			if(modelStr==null || "".equals(modelStr)){
				jo=Message.getParamMsg();
				return "model";
			}
			Culture_doctype model=new Culture_doctype();
			model.setLastupdateuser(u.getUsername());
			model.setLastupdateuserid(Integer.valueOf(u.getUserid()));
			model.setState(modelStr.charAt(0));
			model.setId(new Integer(id));
			Date date=new Date();
			model.setLastupdatetime(dateFormat.parse(dateFormat.format(date)));
			int value=moSV.updateState(model);
			printWriter=response.getWriter();
			printWriter.print(value);
		}
		else if("delete".equals(cmd)){
			String id=request.getParameter("id");
			if(id==null || "".equals(id)){
				jo=Message.getParamMsg();
				return "";
			}
			Culture_doctype model=new Culture_doctype();
			User u=(User) request.getSession().getAttribute("user");
			model.setLastupdateuser(u.getUsername());
			model.setLastupdateuserid(Integer.valueOf(u.getUserid()));
			model.setId(new Integer(id));
			model.setIsdelete('1');
			int value=moSV.deleteModuleById(model);
			printWriter=response.getWriter();
			printWriter.print(value);
		}else if("getAll".equals(cmd)){
			List<Culture_doctype> mos=moSV.getAll();
			jo=Message.getSuccessMsg();
			if(mos!=null){
				jo.put("body", new JSONArray(mos));
			}else{
				jo.put("body", new JSONArray());
			}
			printWriter=response.getWriter();
			printWriter.print(jo);
		}else if("getModuleByid".equals(cmd)){
			String id=request.getParameter("id");
			Culture_doctype mos=new Culture_doctype();
			mos.setId(new Integer(id));
			Culture_doctype module=moSV.getModuleByid(mos);
			List<Culture_doctype> list=new ArrayList<Culture_doctype>();
			list.add(module);
			jo=Message.getSuccessMsg();
			if(list!=null){
				jo.put("body", new JSONArray(list));
			}else{
				jo.put("body", new JSONArray());
			}
			printWriter=response.getWriter();
			printWriter.print(jo);
		}else if("getDelete".equals(cmd)){
			List<Culture_doctype> mos=moSV.getDelete();
			jo=Message.getSuccessMsg();
			if(mos!=null){
				jo.put("body", new JSONArray(mos));
			}else{
				jo.put("body", new JSONArray());
			}
		}
	}catch(Exception e){
		jo=Message.getErrorMsg();
		e.printStackTrace();
	}finally{
		try {
			/*byte[] jsonBytes = jo.toString().getBytes("utf-8");
			response.setContentType("text/json;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	return null;
	}
	

	private boolean isEmpty(String[] strs){
		for (int i = 0; i < strs.length; i++) {
			if(strs[i]==null || "".equals(strs[i])){
				return true;
			}
		}
		return false;
		
	}
	
	
	
	
}
