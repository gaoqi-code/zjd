package com.bbc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("m")
public class IndexMobileAction {

	private String _VIEW = "view/";

	@RequestMapping(value = "/contact")
	public String toContact(){
		return _VIEW+"m/m-contact";
	}

}
