package com.bbc.action;

import com.bbc.util.ChkUtil;
import com.bbc.util.MsgUtil;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Controller
@RequestMapping("yz")
public class YZAction{
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the Servlet.step 1 for connecting weixin <br>
	 */
	@RequestMapping(value = "/yzGet")
	public @ResponseBody String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get ok\n");
		String signature=req.getParameter("signature");
		String timestamp=req.getParameter("timestamp");
		String nonce=req.getParameter("nonce");
		String echostr=req.getParameter("echostr");
//		PrintWriter pw=resp.getWriter();
		if(ChkUtil.chkSignature(signature,timestamp,nonce)){
//			pw.print(echostr);
			return echostr;
		}
		return "验证失败";
	}

	/**
	 * The doPost method of the Servlet. <br>
	 */
	public @ResponseBody String doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,java.lang.NullPointerException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
//		PrintWriter pw=resp.getWriter();

		//text receiving and responsing
		try{
			Map<String,String> map = MsgUtil.Xml2Map(req);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			String msg=null;

	        /*
	        System.out.print("fromUserName : "+fromUserName+"\n");
	        System.out.print("toUserName : "+toUserName+"\n");
	        System.out.print("msgType : "+msgType+"\n");
	        System.out.print("content : "+content+"\n");
	        */

			System.out.print("msgType?\n");
			if(MsgUtil.MSG_TEXT.equals(msgType)){
				//key word reply
				if("1".equals(content)){
					msg=MsgUtil.initText(toUserName,fromUserName,MsgUtil.oneText());
				}else if("2".equals(content)){
					msg=MsgUtil.initText(toUserName,fromUserName,MsgUtil.twoText());
				}else if("?".equals(content)||"？".equals(content)){
					msg=MsgUtil.initText(toUserName,fromUserName,MsgUtil.menuText());
				}else if(MsgUtil.MSG_EVENT.equals(msgType)){
					String eventType=map.get("event");
					if(MsgUtil.MSG_SUBSCRIBE.equals(eventType)){
						msg=MsgUtil.initText(toUserName,fromUserName,MsgUtil.menuText());
					}
				}else{
					msg=MsgUtil.initText(toUserName,fromUserName,MsgUtil.menuText());
				}
//				pw.print(msg);
				return msg;
			}
			return "验证失败";
		}catch(DocumentException e){
			e.printStackTrace();
		}
		return "";
	}
}
