package com.bbc.util;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;

public class OrderUtil {

	public static String getOrderNo(int orderId){
		StringBuffer sbh = new StringBuffer("H");
		sbh.append(DateUtils.getFormatDate(new Date(),"yyMMdd")).append(orderId);
		return sbh.toString();
	}

}
