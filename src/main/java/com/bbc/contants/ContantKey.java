package com.bbc.contants;

import java.io.File;

public class ContantKey {

	public final static String HB_SECRET = "2017GLX";
	public final static String chartsset = "UTF-8";
	public final static String LOGINUSER = "loginUser";//当前登录的用户SESSION KEY
	public final static String COOKIEMYCART = "myCart";
	public final static String COOKIECARTCOUNT = "cartCount";
	public final static String JSPPATH ="view/";

//	public final static String domain = "192.168.191.3";
//	public final static String domain = "192.168.1.102";
public final static String domain = "test.open580.com";


//	//立勋测试号
//	public final static String appID ="wx969e4a683bb82a4e";
//	public final static String appsecret ="793e3f9889b373ea420d15823abbbe60";

//	public final static String appID ="wx421072b3938f9393";
//	public final static String appsecret ="12206c6bf42cecda0f098440a55930d0";

//	//志杰测试号
//	public final static String appID ="wx97334952e816d1ff";
//	public final static String appsecret ="aab3f99565e7d0095663384b048a2add";

	public final static String appID ="wx4d45cfca0d360c8a";
	public final static String appsecret ="3ea01e22c81f5a3907846768213ac9bb";



	public final static String mchId = "1438232702";


	//http://mch.weixin.qq.com/wiki/doc/api/index.php?chapter=4_3
	//商户Key：改成公司申请的即可
	//32位密码设置地址：http://www.sexauth.com/  jdex1hvufnm1sdcb0e81t36k0d0f15nc
	public final static String Key = "GLX19894270GLZ19894270GLX1989427";

	public final static int width = 300;
	public final static int height = 300;

	public final static String notifyUrl = "http://"+domain+"/pay/back.html";//回调地址

	public final static String QR_PATH = "D:"+ File.separator;

	public final static String ZS_PATH = File.separator+"payment"+ File.separator;

	//用户微信登录
	public final static String url_1 = "https://open.weixin.qq.com/connect/oauth2/authorize?";
	//用户付款URL
	public final static String url_2 = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	//企业付款URL
	public final static String url_3 = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";



}
