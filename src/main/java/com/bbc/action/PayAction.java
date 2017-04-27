package com.bbc.action;

import com.bbc.contants.ContantKey;
import com.bbc.contants.ContantType;
import com.bbc.entity.Orders;
import com.bbc.entity.Unifiedorder;
import com.bbc.entity.User;
import com.bbc.entity.bo.Data;
import com.bbc.entity.bo.RespData;
import com.bbc.service.HongBaoService;
import com.bbc.service.OrdersService;
import com.bbc.service.UserService;
import com.bbc.tencent.common.Signature;
import com.bbc.tencent.common.XMLParser;
import com.bbc.util.*;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("pay")
public class PayAction extends BaseController {

	@Autowired
	private OrdersService ordersService;
	@Autowired
	private UserService userService;
	@Autowired
	private HongBaoService hongBaoService;


	/**
	 * 支付完成后的回调方法，该方法跳转到 拆红包页面。
	 * @return
	 */
	@RequestMapping(value = "/back")
	public @ResponseBody Data back(HttpServletRequest request) throws IOException {

		String orderNo = request.getParameter("orderNo");
		String tradeNo = request.getParameter("tradeNo");
		String sign = request.getParameter("sign");
		String code = request.getParameter("code");
		System.out.println("---支付成功，异步回调。orderNo="+orderNo+",tradeNo="+tradeNo+",sign="+sign+",code="+code);
		if(null==code||!"200".equals(code))
			return new Data(501,"支付失败");

		//通过返回的信息查出订单信息
		Orders orders = ordersService.getOrderByOrderNo(orderNo);
		if(orders.getDataStatus()==100){
			return new Data(100,"已支付");
		}
		SortedMap<String,Object> parameters = new TreeMap<String,Object>();
		parameters.put("orderNo",orderNo);
		parameters.put("orderAmt",orders.getTotalFee().toString());
		parameters.put("code",code);

		//验证请求信息与订单信息的合法性
		if(null!=sign&&sign.equals(WXSignUtils.createSign("utf-8",parameters))){
			ordersService.updateOrder(orderNo,100);
			userService.updateUserBalance(orders.getUserId(),orders.getTotalFee(),1,"用户充值",true);
			return new Data(200,"支付成功");
		}else{
			//参数不合法
			System.out.println("参数不合法 === "+orderNo+" === "+tradeNo+" === "+sign);
			return new Data(500,"参数不合法");
		}

		//读取参数
//		InputStream inputStream ;
//		StringBuffer sb = new StringBuffer();
//		inputStream = request.getInputStream();
//		String s ;
//		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
//		while ((s = in.readLine()) != null){
//			sb.append(s);
//		}
//		in.close();
//		inputStream.close();

//		try {
//			Map<String, Object> m = XMLParser.getMapFromXML(sb.toString());
			//过滤空 设置 TreeMap
//			SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();
//			Iterator it = m.keySet().iterator();
//			while (it.hasNext()) {
//				String parameter = (String) it.next();
//				Object parameterValue = m.get(parameter);
//
//				String v = "";
//				if(null != parameterValue) {
//					v = parameterValue.toString().trim();
//				}
//				packageParams.put(parameter, v);
//			}
//			System.out.printf("packageParams = "+packageParams);
			//验证签名
//			if (Signature.checkIsSignValidFromResponseString(sb.toString())){
//				ordersService.updateOrder(m.get("out_trade_no").toString(),100);
//				System.out.printf("数据合理");
//			}else{
//				System.out.printf("数据不合理");
//			}
//		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
//		} catch (SAXException e) {
//			e.printStackTrace();
//		}

		//ordersService.getOrderByUserIdAndOrderId();
	}


	/**
	 * 获得订单状态，判断支付是否成功
	 */
	@RequestMapping(value = "/orderfunc1")
	public @ResponseBody RespData orderfunc1(HttpServletRequest req,int orderId){
		Object sessionUser = req.getSession().getAttribute("user");
		User user = (User)sessionUser;
		Orders orders = ordersService.getOrderByUserIdAndOrderId(user.getId(),orderId);
		if(orders==null)
			return new RespData(500,"error");
		RespData respData = new RespData(200,"success");
		if(orders.getDataStatus()==100){
			respData.setObj(100);
			return respData;
		}else{
			respData.setObj(0);
			return respData;
		}
	}

	@RequestMapping(value = "/toChb")
	public String toChb(HttpServletRequest req,int orderId,String orderNo){
		req.setAttribute("orderId",orderId);
		req.setAttribute("orderNo",orderNo);
		return "view/chb";
	}


    @RequestMapping(value = "/getMoney")
    public @ResponseBody RespData getMoney(HttpServletRequest req,int orderId){
		//拆红包之前，验证订单状态。如果拆过一次，就提示不能拆红包了
		RespData respData = new RespData(100,"success");
		Object obj = req.getSession().getAttribute("user");
		if(obj==null){
			return new RespData(101,"登录过期，请重新登录！");
		}
		User user = (User) obj;
		Orders orders = ordersService.getOrderByUserIdAndOrderId(user.getId(),orderId);
		if(orders==null){
			return new RespData(102,"订单不存在或已砸过金蛋了");
		}
		if(orders.getDataStatus()==100){
			Map<String,Object> map = new HashMap<String,Object>();
			int hb_level = orders.getTotalFee().intValue();
			map.put("money",HBMoneyUtil.getMoney(hb_level));
			for (int i = 1;i<16;i++){
				map.put("m"+i,HBMoneyUtil.getMoneyBig(hb_level));
			}
			map.put("secret", DigestUtils.md5DigestAsHex((ContantKey.HB_SECRET+map.get("money")).getBytes()));
			respData.setObj(map);
			respData.setCode(200);
			return respData;
		}else if(orders.getDataStatus()==200){
			respData.setMsg("已经领过红包了");
			respData.setObj(200);
			return respData;
		}else if(orders.getDataStatus()==0){
			respData.setMsg("订单未支付");
			respData.setObj(0);
			return respData;
		}else{
			respData.setCode(500);
			respData.setMsg("未知异常，订单状态："+orders.getDataStatus());
			respData.setObj(-1);
			return respData;
		}
    }
	/**
	 * Created by gonglixun on 2016/12/13.
	 */
	@RequestMapping(value = "/test")
	public String toIndex(HttpServletRequest req,String attach,String totalFee){

		Object sessionUser = req.getSession().getAttribute("user");
		if(null!=sessionUser) {
            User user = (User) sessionUser;
            if ("10".equals(totalFee)||"20".equals(totalFee)||"50".equals(totalFee)||"100".equals(totalFee)) {

            } else {
				return "redirect:/toError/2003.html";
            }
            //获得用户余额信息
			User userBalance = userService.getUserByUnionid(user.getUnionid());
			if(userBalance.getBalance()==null||userBalance.getBalance().compareTo(new BigDecimal(totalFee))==-1){
				//用户余额不足
				return "redirect:/toError/1000.html";
			}
            Orders orders = ordersService.addOrder(attach, new BigDecimal(totalFee), user.getId(),2);

			req.setAttribute("totalFee", totalFee);

			String orderNo = orders.getOrderNo();
            String ip = PCAddress.getIpAddress(req);
            String charset = "utf-8";


            SortedMap<String, Object> parameters = new TreeMap<String, Object>();
			parameters.put("ip", ip);
			parameters.put("orderNo", orderNo);
            parameters.put("totalFee", totalFee);
            String sign = WXSignUtils.createSign(charset, parameters);
            System.out.println("签名是：" + sign);

            req.setAttribute("orderId", orders.getId());
			req.setAttribute("sign", sign);
			req.setAttribute("orderNo", orderNo);
            req.setAttribute("totalFee", totalFee);
            return "view/pay";
        }else{
            //您还没有登录
            return "view/error/error_500";
        }

	}

	@RequestMapping(value = "/toPay")
	public String toPay(HttpServletRequest req){
		return "view/pay";
	}

	/**
	 * 拆红包后，后台处理方法
	 */
    @RequestMapping(value = "/ph")
	public @ResponseBody  RespData ph(HttpServletRequest req,String s,BigDecimal totalFee,int orderId,String orderNo) throws Exception {
        Object obj = req.getSession().getAttribute("user");
		String ip = PCAddress.getIpAddress(req);
		System.out.println("===totalFee:"+totalFee);
		System.out.println("===密文:"+s);
		System.out.println("===明文加密后:"+DigestUtils.md5DigestAsHex((ContantKey.HB_SECRET+totalFee).getBytes()));
		if(null!=s&&s.equals(DigestUtils.md5DigestAsHex((ContantKey.HB_SECRET+totalFee).getBytes()))){
			if(null==obj){
				//会话失效
				return new RespData(401,"会话失效");
			}else{
				User user = (User)obj;
				//验证数据库里是否有订单
				Orders orders = ordersService.getOrderByUserIdAndOrderId(user.getId(),orderId);
				if(null==orders){
					return new RespData(402,"数据库里不存在这个订单");
				}else{
					if(orders.getDataStatus()==100) {
						ordersService.updateHandlerOrder(user.getId(), orderId, 200,user.getOpenid(),totalFee,orders.getOrderNo());
						System.out.println("---- company pay start ---------------------------------------------------------------------------");
						String temp = "";
						try {
//							temp = ClientCustomSSL.clientCustomSLL(ContantKey.mchId,ContantKey.url_3,getXML(orderNo,user.getOpenid(),totalFee,ip));
							this.userService.updateUserBalance(user.getId(),totalFee, ContantType.balanceLogType_3,"砸蛋奖励",true);
							hongBaoService.addHongBaoLog(user.getId(),orderId,totalFee,temp,0);
							System.out.println("---- company pay end  ---------------------------------------------------------------------------");
						} catch (Exception e) {
							e.printStackTrace();
						}



						//获得一级用户
						User user1J = userService.getUserByParentId(user.getParentId());
						User user2J = null;
						if(user1J != null){
							user2J = userService.getUserByParentId(user1J.getParentId());
						}
						BigDecimal user1YJ = new BigDecimal(1);
						BigDecimal user2YJ = new BigDecimal(1);
						/**
						 * 分发佣金
						 */
						BigDecimal orderTotalFee = orders.getTotalFee();
						if(orderTotalFee.compareTo(new BigDecimal(20))==0){
							user1YJ = new BigDecimal(2);
						}
						//一级返佣
						if(user1J!=null){
//							temp = ClientCustomSSL.clientCustomSLL(ContantKey.mchId,ContantKey.url_3,getXML(orderNo+"Y"+user1J.getId(),user1J.getOpenid(),user1YJ,ip));
							this.userService.updateUserBalance(user1J.getId(),user1YJ,ContantType.balanceLogType_4,"佣金",true);
							hongBaoService.addHongBao(user1J.getOpenid(),user1J.getId(),user1YJ,1,orderNo+"Y"+user1J.getId());
							hongBaoService.addHongBaoLog(user1J.getId(),orderId,user1YJ,temp,1);
						}
						//二级返佣
						if(user2J!=null){
//							temp = ClientCustomSSL.clientCustomSLL(ContantKey.mchId,ContantKey.url_3,getXML(orderNo+"Y"+user2J.getId(),user2J.getOpenid(),user2YJ,ip));
							this.userService.updateUserBalance(user2J.getId(),user2YJ,ContantType.balanceLogType_4,"佣金",true);
							hongBaoService.addHongBao(user2J.getOpenid(),user2J.getId(),user2YJ,2,orderNo+"Y"+user2J.getId());
							hongBaoService.addHongBaoLog(user2J.getId(),orderId,user2YJ,temp,2);
						}
						return new RespData(200, "");
					}else{
						return new RespData(403,"订单已经处理过，"+orders.getDataStatus());
					}
				}
			}
		}else{
			System.out.println("签名错误，请检查");
			return new RespData(404,"金额有变化");
		}
    }

	public static String getXML(String orderNo,String oponid,BigDecimal totalFee,String ip){
		SortedMap<String,Object> parameters = WXSignUtils.createWeiParameters(orderNo,oponid,totalFee.multiply(new BigDecimal(100)),ip);
		String sign = WXSignUtils.createSign(ContantKey.chartsset,parameters);
		parameters.put("sign",sign);
		String xml = HttpXmlUtils.xmlInfoMap(parameters);
		System.out.println(xml);
		return xml;
	}

	@RequestMapping(value = "/getUserOrderInfo")
	public @ResponseBody RespData getUserOrderInfo(HttpServletRequest req){
		Object obj = req.getSession().getAttribute("user");
		User user = (User)obj;

		Orders orders = ordersService.getOrderByUserId(user.getId());
		if(orders!=null&&orders.getId()!=0){
			RespData data= new RespData(200,"");
			data.setObj(orders);
			return data;
		}else{
			return new RespData(100,"无待抽红包");
		}
	}

	/**
	 * 确认支付之后跳转到抽奖页面
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/confirmPay/{s}")
	public String getUserOrderInfo(HttpServletRequest req,@PathVariable("s")String s,String totalFee,int orderId,String orderNo){
		User user = (User)req.getSession().getAttribute("user");

		if(totalFee!=null){
			SortedMap<String, Object> parameters = new TreeMap<String, Object>();
			parameters.put("ip", PCAddress.getIpAddress(req));
			parameters.put("orderNo", orderNo);
			parameters.put("totalFee", totalFee);
			String st = WXSignUtils.createSign(ContantKey.chartsset,parameters);
			if(st.equals(s)){
				this.userService.updateUserBalance(user.getId(),new BigDecimal(totalFee),ContantType.balanceLogType_2,"砸蛋支付",false);
				ordersService.updateOrder(orderNo,100);
//				return "pay/toChb.html?orderId="+orderId+"&orderNo="+orderNo;
				req.setAttribute("orderId",orderId);
				req.setAttribute("orderNo",orderNo);
				return "view/chb";
			}else{
				//金额有变化
				return "redirect:/view/error/error_pay";
			}
		}else{
			//金额有变化
			return "redirect:/view/error/error_pay";
		}
	}

	@RequestMapping(value = "/toErrorPay")
	public String toErrorPay(){
		return "redirect:/view/terror/error_pay";
	}

	@RequestMapping(value = "/toChongzhi")
	public String toChongzhi(){
		return "view/chongzhi";
	}

	@RequestMapping(value = "/chongzhi")
	public String chongzhi(HttpServletRequest req){
		String orderAmt = req.getParameter("orderAmt");
		req.getParameter("payType");
        String returnURL = "http://"+ContantKey.domain+"/nologin/tosc.html";
        String notifyURL = "http://"+ContantKey.domain+"/pay/back.json";
		int userId = this.getUserId(req);
		SortedMap<String,Object> parameters = new TreeMap<String,Object>();
		parameters.put("orderAmt",orderAmt);
		parameters.put("curType","CNY");
		parameters.put("bankId","888C");
		parameters.put("returnURL",returnURL);
		parameters.put("notifyURL",notifyURL);
		parameters.put("cardType","01");
		parameters.put("userId",userId);
        parameters.put("goodsName" , req.getParameter("goodsName"));
        parameters.put("remark" , req.getParameter("remark"));
		parameters.put("goodsType",req.getParameter("goodsType"));
		//生成订单
		Orders orders = ordersService.addOrder("充值"+orderAmt+"元", new BigDecimal(orderAmt),userId,1);
		parameters.put("orderNo",orders.getOrderNo());
		String sign = WXSignUtils.createSign("utf-8",parameters);
		System.out.println("sign = " + sign);
		parameters.put("sign",sign);
		req.setAttribute("formParam",parameters);
		return "view/rz";
	}


}
