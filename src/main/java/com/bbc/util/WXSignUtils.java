package com.bbc.util;

import com.bbc.contants.ContantKey;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * 微信支付签名
 * @author gonglixun
 * @date 2016年10月25日下午4:47:07
 */
public class WXSignUtils {

    /**
     * 微信支付签名算法sign
     * @param characterEncoding
     * @param parameters
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String createSign(String characterEncoding,SortedMap<String,Object> parameters){


        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + ContantKey.Key);
        System.out.println("字符串拼接后是："+sb.toString());
//        DigestUtils..md5DigestAsHex();(sb.toString().getBytes(characterEncoding));
//        DigestUtils.md5DigestAsHex(sb.toString().getBytes());
//        String sign = DigestUtils.md5DigestAsHex(sb.toString().getBytes()).toUpperCase();//MD5Util.MD5Encode(sb.toString()).toUpperCase();
        String sign = MD5Util.MD5Encode(sb.toString(),characterEncoding).toUpperCase();
        return sign;
    }

    String check_name = "NO_CHECK";
    public static SortedMap<String,Object> createWeiParameters(String orderNo, String openid, BigDecimal amount, String ip){
        String nonce_str = HBMoneyUtil.getRamd();

        SortedMap<String,Object> parameters = new TreeMap<String,Object>();
        parameters.put("mch_appid",ContantKey.appID);
        parameters.put("mchid",ContantKey.mchId);
        parameters.put("nonce_str",nonce_str);

        parameters.put("partner_trade_no",orderNo);
        parameters.put("openid",openid);
        parameters.put("check_name","NO_CHECK");
        parameters.put("amount",amount.intValue());
        parameters.put("desc","墨迪新时代");
        parameters.put("spbill_create_ip",ip);

        return parameters;
    }


    public static void main(String[] args) {
        SortedMap<String, Object> map = new TreeMap<String, Object>();
        map.put("a","123");
        String sign = createSign("utf-8",map);
        System.out.println(sign);
    }
}