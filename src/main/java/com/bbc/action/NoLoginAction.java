package com.bbc.action;

import com.alibaba.fastjson.JSON;
import com.bbc.contants.ContantKey;
import com.bbc.entity.Accusation;
import com.bbc.entity.User;
import com.bbc.entity.WX;
import com.bbc.service.AccusationService;
import com.bbc.service.HongBaoService;
import com.bbc.service.UserService;
import com.bbc.util.HBMoneyUtil;
import com.bbc.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Controller
@RequestMapping("nologin")
public class NoLoginAction {
	@Autowired
	private AccusationService accusationService;
	/**
	 * 跳转到推广页面
	 * Created by gonglixun on 2016/12/13.
	 * 跳转到网站首页
	 */
	@RequestMapping(value = "/toTG/{userId}/{level}")
	public String toIndex(HttpServletRequest request,@PathVariable("userId")int userId,@PathVariable("level")int level){
		request.setAttribute("userId",userId);
		request.setAttribute("level",level);
		return "view/tui_guang";
	}

	@RequestMapping(value = "/toAccusation1/{userId}")
	public String toAccusation(@PathVariable("userId")int userId){
		return "view/accusation1";
	}
	@RequestMapping(value = "/toAccusation2/{categoryCode}")
	public String toAccusation2(HttpServletRequest req,@PathVariable("categoryCode")int categoryCode){
		req.setAttribute("categoryCode",categoryCode);
		return "view/accusation2";
	}

	/**
	 * 商城首页
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/tosc")
	public String tosc(HttpServletRequest req){
		return "view/sc";
	}
	@RequestMapping(value = "/addAccusation")
	public String toAccusation2(HttpServletRequest req, Accusation a) {
		Object obj = req.getSession().getAttribute("user");
		User user = (User) obj;
		a.setUserId(user.getId());
		accusationService.addAccusation(a);
		req.setAttribute("aId",a.getId());
		return "redirect:toSuccess.html?aId="+a.getId();
	}

	@RequestMapping(value = "/toSuccess")
	public String toSuccess(){
		return "view/success";
	}

}
