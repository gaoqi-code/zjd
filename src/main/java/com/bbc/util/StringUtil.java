package com.bbc.util;

public class StringUtil {

	public static String stringAppend(String p1,String p2,String split){
		StringBuffer sb = new StringBuffer(p1);
		return sb.append(split).append(p2).toString();
	}
	
}
