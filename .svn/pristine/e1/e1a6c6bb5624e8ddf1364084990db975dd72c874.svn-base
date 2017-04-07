package com.culture.security;  

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class SecurityIntercepter implements HandlerInterceptor {
	
	private String[] paths;
	public String[] getPaths() {
		return paths;
	}
	public void setPaths(String[] paths) {
		this.paths = paths;
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2) throws Exception {
		HttpSession session = req.getSession();
		AntPathMatcher apm = new AntPathMatcher();
		String requestPath = req.getServletPath();
		for(String p :paths){
			if(apm.match(p, requestPath)){
				return true;
			}
		}

		if(session.getAttribute("user")!=null){
			return true;
		}

		req.setAttribute("errorResult", "session失效！");
		String path = req.getContextPath();
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
		resp.getWriter().write("<script>parent.location.href=\""+basePath+"\";</script>"); 
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp,
			Object obj, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}
	
}
 