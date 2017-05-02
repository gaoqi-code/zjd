package com.bbc.action;

import com.bbc.contants.ContantKey;
import com.bbc.contants.ContantType;
import com.bbc.entity.Cash;
import com.bbc.entity.Orders;
import com.bbc.entity.User;
import com.bbc.entity.bo.Data;
import com.bbc.entity.bo.RespData;
import com.bbc.service.CashService;
import com.bbc.service.HongBaoService;
import com.bbc.service.OrdersService;
import com.bbc.service.UserService;
import com.bbc.util.HBMoneyUtil;
import com.bbc.util.HttpXmlUtils;
import com.bbc.util.PCAddress;
import com.bbc.util.WXSignUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Controller
@RequestMapping("cash")
public class CashAction extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private CashService cashService;

	@RequestMapping(value = "/toCash")
	public String toCash(HttpServletRequest req){
		Object sessionUser = req.getSession().getAttribute("user");
		User user = (User)sessionUser;
		User u2 = userService.getUserByUnionid(user.getUnionid());
		req.setAttribute("balance",u2.getBalance());
		return "view/cash/cash_detail";
	}

	@RequestMapping(value = "/addCash")
	public String addCash(HttpServletRequest req){
		Object sessionUser = req.getSession().getAttribute("user");
		User user = (User)sessionUser;
		User u2 = userService.getUserByUnionid(user.getUnionid());
		if (u2.getBalance() != null&&u2.getBalance().compareTo(new BigDecimal("0"))>0) {
			Cash cash = new Cash();
			cash.setUserId(u2.getId());
			cash.setDataStatus(1);
			cash.setAmount(u2.getBalance());
			cash.setRemark(req.getParameter("remark"));
			cashService.addCash(cash);
			return "view/cash/success";
		}else{
			return "view/cash/fail";
		}
	}


	@RequestMapping(value = "/toCashList")
	public String toCashList(HttpServletRequest req){
		Object sessionUser = req.getSession().getAttribute("user");
		User user = (User)sessionUser;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId",user.getId());
		req.setAttribute("cashList",cashService.getCashList(map));
		return "view/cash/cash_list";
	}

}
