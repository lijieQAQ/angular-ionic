package com.culture.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.culture.model.User;
import com.culture.service.AdminService;
import com.culture.service.UserService;


@Controller
public class LoginCtorl {
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="admin/login.do",method=RequestMethod.POST)
	public String login(HttpServletRequest request,HttpServletResponse response){
		System.out.println("登陆中----------------");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username != null && !username.equals("") && password != null && !password.equals("")){
			int icount = adminService.isAdmin(username, password);
			if( icount != 0){
				try {
					User u = userService.findUserByusername(username);
					request.getSession().setAttribute("user", u);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			else{
				request.setAttribute("errorResult", "用户名或密码错误");
				return "Login";
			}
			
		}
		
		return "main";
		
	}
	@RequestMapping(value="admin/login.htm",method=RequestMethod.POST)
	public String htmLogin(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("登陆中----------------");
		String username = request.getParameter("username");
		
		if(username != null && !username.equals("")){
			User u = userService.findUserByusername(username);
			request.getSession().setAttribute("user",u);
			JSONObject jsonObject =new JSONObject(u);
			PrintWriter printWriter=response.getWriter();
			printWriter.print(jsonObject);
		}
		return null;
		
	}
	@RequestMapping(value="admin/menu.do",method=RequestMethod.GET)
	public String mainMenu(HttpServletRequest request){
		String view=request.getParameter("url");
		System.out.println(view);
		return view;
		
	}


}
