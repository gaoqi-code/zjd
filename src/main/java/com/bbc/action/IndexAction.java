package com.bbc.action;

import com.alibaba.fastjson.JSON;
import com.bbc.contants.ContantKey;
import com.bbc.entity.Orders;
import com.bbc.entity.User;
import com.bbc.entity.WX;

import com.bbc.service.HongBaoService;
import com.bbc.service.OrdersService;
import com.bbc.service.UserService;
import com.bbc.util.HBMoneyUtil;
import com.bbc.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Controller
@RequestMapping("")
public class IndexAction {

	@Autowired
	private UserService userService;
	@Autowired
	private HongBaoService hongBaoService;
	/**
	 * Created by gonglixun on 2016/12/13.
	 * 跳转到网站首页
	 */
	@RequestMapping(value = "/index")
	public String toIndex(HttpServletRequest request){
		return "view/index";
	}

	/**
	 * 后台中转页面，中转后，通过微信接口 获得 code,然后通过 code 获得 openid。
	 * @param req
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value = "/toUser/{parentId}/{level}")
	public String toUser(HttpServletRequest req,@PathVariable("parentId")int parentId,@PathVariable("level")int level){
		StringBuffer url = new StringBuffer(ContantKey.url_1);
		url.append("appid").append("=").append(ContantKey.appID);
		url.append("&redirect_uri").append("=").append("http://").append(ContantKey.domain).append("/getCode/").append(parentId).append("/").append(level).append(".html");
		url.append("&response_type").append("=").append("code");
		url.append("&scope").append("=").append("snsapi_userinfo");
		url.append("&state").append("=").append("STATE");
		url.append("&connect_redirect").append("=").append("1#wechat_redirect");
		//String url = ContantKey.url_1+"appid="+ContantKey.appID+"&redirect_uri=http%3a%2f%2f"+ContantKey.domain+"%2fgetCode.html%3fparentId%3d"+parentId+"%26level%3d1&response_type=code&scope=snsapi_userinfo&state=STATE&connect_redirect=1#wechat_redirect";
		System.out.printf("user enter sys ===>>>" + url.toString());
		req.setAttribute("url",url.toString());
		return "view/user";
	}
	/**
	 * 产品列表页面，10，20元两个产品。
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/product")
	public String toProduct(HttpServletRequest request){
		return "view/product";
	}

	/**
	 * 跳到推广页面
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/toTuiG")
	public String toTuiG(HttpServletRequest req){
		Object obj = req.getSession().getAttribute("user");
		if(obj==null){
            /*  登录过期 ， 需要重登录  */
			return "view/default";
		}else{
			User user = (User) obj;
			return "redirect:/nologin/toTG/"+user.getId()+"/"+user.getLevel()+".html";
		}
	}

	@RequestMapping(value = "/toDefault")
	public String toDefault(){
        return "view/default";
    }

	@RequestMapping(value = "/myhb")
	public String myhb(HttpServletRequest req){
		Object obj = req.getSession().getAttribute("user");
		User user = (User) obj;
		req.setAttribute("hbList",hongBaoService.getHongBaoPager(user.getId()));
		return "view/my_hb";
	}

	@RequestMapping(value = "/toserver")
	public String toserver(HttpServletRequest req) {
		return "view/server";
	}


    @RequestMapping(value = "/getMoney")
    public @ResponseBody String getMoney(HttpServletRequest req){
        BigDecimal mooney = HBMoneyUtil.getMoney(10);
        return "view/chb";
    }



	//	@RequestMapping(value = "/index")
//	public String toIndex(HttpServletRequest request){
//
//		String agent = request.getHeader("User-Agent").toLowerCase();
//		System.out.println(agent);
//		if (agent.indexOf("micromessenger")>0){
//			System.out.println("微信支付");
//		}else if(agent.indexOf("alipayclient")>0){
//			System.out.println("阿里支付");
//		}
//		return agent;
//	}




	@RequestMapping(value = "/getCode/{parentId}/{level}")
	public String getCode(HttpServletRequest req,@PathVariable("parentId")int parentId,@PathVariable("level")int level){
		String code = req.getParameter("code");

		System.out.println("--------------------------------------------------------");
		System.out.println(code);
		System.out.println("--------------------------------------------------------");
		req.setAttribute("code",code);
//		return "view/index";
//		return "redirect:/getAccessToken.html";

		String reURL = "https://api.weixin.qq.com/sns/oauth2/access_token";
		String allUrl = reURL+"?appid="+ ContantKey.appID+"&secret"+"="+ContantKey.appsecret+"&code="+code+"&grant_type=authorization_code";
		String contentJSON = HttpUtils.sendGet(allUrl,null);
		System.out.println("contentJSON===="+contentJSON);
		if(null!=contentJSON&&contentJSON.indexOf("errcode")==-1){
			WX wx = JSON.parseObject(contentJSON, WX.class);
			String openid = wx.getOpenid();
			String unionid = wx.getUnionid();
			req.setAttribute("openid",wx.getOpenid());
			//判断openid是否存在
			User user = userService.getUserByUnionid(unionid);
			if (user==null){//用户不存在
				user = userService.addUser(openid,unionid,parentId,level);
			}
//			req.setAttribute("user",user);
			req.getSession().setAttribute("user",user);
			return "view/product";
		}
		return "view/product";

//		String reURL = "https://api.weixin.qq.com/sns/oauth2/access_token";
//		return "redirect:"+reURL+"?appid="+ ContantKey.appID+"&" +
//				"="+ContantKey.appsecret+"&code="+code+"&grant_type=authorization_code";
	}

	@RequestMapping(value = "/getAccessToken")
	public String getAccessToken(HttpServletRequest req) {
		String access_token = req.getParameter("access_token");
		String openid = req.getParameter("openid");
		System.out.println("--------------------------------------------------------");
		System.out.println(access_token);
		System.out.println(openid);
		System.out.println("--------------------------------------------------------");
		req.setAttribute("access_token", access_token);
		req.setAttribute("openid", openid);
		return "view/index";
	}


	@RequestMapping(value = "/toTest")
	public String toTest(HttpServletRequest req) {
		return "view/test";
	}


	@RequestMapping(value = "/toError/{code}")
	public String toError(HttpServletRequest req,@PathVariable("code")String code) {
		req.setAttribute("code",code);
		return "view/error/error_pay";
	}

	@RequestMapping(value = "/toMy")
	public String toMy(HttpServletRequest req) {
		User curentUser = (User)req.getSession().getAttribute("user");
		User user =  userService.getUserByUnionid(curentUser.getUnionid());
		System.out.println("=========================="+user.getBalance());
		req.setAttribute("balance",user.getBalance());
		return "view/my";
	}




}
