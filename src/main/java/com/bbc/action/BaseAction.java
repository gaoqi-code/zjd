package com.bbc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.bbc.entity.bo.user.User;

public class BaseAction {

	/**
	 * ����session
	 * @param request
	 * @param sessionKey
	 * @param data
	 */
	protected void setSessionData(HttpServletRequest request,String sessionKey,Object data){
		request.getSession().setAttribute(sessionKey, data);
	}

	/**
	 * ���session
	 * @param request
	 * @return
	 */
	protected HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}

	public User getLoginUser(HttpServletRequest request,String sessionKey){
		Object obj = this.getSession(request).getAttribute(sessionKey);
		if(null!=obj)
			return (User)obj;
		else
			return null;
	}


}
