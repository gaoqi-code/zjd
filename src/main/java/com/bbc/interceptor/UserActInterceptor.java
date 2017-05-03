package com.bbc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserActInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		String url = request.getServletPath();
		if(url.indexOf("toDefault")!=-1||url.indexOf("toserver")!=-1||url.indexOf("back.json")!=-1||url.indexOf("nologin")!=-1||url.indexOf("manage")!=-1){
			return true;
		}else if(url.indexOf("toUser")>-1||url.indexOf("getCode")>-1){
			return true;
		}else{
			//验证登录
			Object obj = request.getSession().getAttribute("user");
			if(obj==null){
				response.sendRedirect(request.getContextPath()+"/toDefault.html");
				return false;
			}else{
				return true;
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {


	}

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex)	throws Exception {

	}
}
