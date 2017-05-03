package com.bbc.action;

import com.bbc.contants.ContantKey;
import com.bbc.entity.Cash;
import com.bbc.entity.User;
import com.bbc.entity.bo.Data;
import com.bbc.service.CashService;
import com.bbc.service.HongBaoService;
import com.bbc.service.UserService;
import com.bbc.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

@Controller
@RequestMapping("manage")
public class CashManageAction {

    @Autowired
    private CashService cashService;
    @Autowired
    private HongBaoService hongBaoService;
    @Autowired
    private UserService userService;

    /**
     * Created by gonglixun on 2016/12/13.
     * 跳转到网站首页
     */
    @RequestMapping(value = "/toList")
    public String toIndex(HttpServletRequest request, int dataStatus) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dataStatus", dataStatus);
        request.setAttribute("list", cashService.getCashList(map));
        return "view/manage/list";
    }

    @RequestMapping(value = "/updateWithDaKuan")
    public
    @ResponseBody
    Data updateWithDaKuan(HttpServletRequest request, int id) {
        Cash cash = cashService.getCashById(id);
        if(cash==null){
            return new Data(202,"parameter is error");
        }
        if(cash.getDataStatus()!=1){
            return new Data(203,"cash is hander");
        }
        User user = userService.getUserByParentId(cash.getUserId());
        if(user==null||user.getId()==0){
            return new Data(201,"parameter is error");
        }
        try {
            String temp = ClientCustomSSL.clientCustomSLL(ContantKey.mchId, ContantKey.url_3, getXML(OrderUtil.getOrderNo(id), user.getOpenid(), cash.getAmount(), PCAddress.getIpAddress(request)));
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("dataStatus",2);
            map.put("id",id);
            map.put("userId",cash.getUserId());
            map.put("remark",temp);
            cashService.update(map);
            return new Data(200, "");
        } catch (Exception e) {
            Map<String,Object> map = new HashMap<String,Object>();
            e.printStackTrace();
            map.put("id",id);
            map.put("userId",cash.getUserId());
            map.put("remark",e.getMessage());
            map.put("dataStatus",2);
            cashService.update(map);
            return new Data(200, "");
        }
    }


    public static String getXML(String orderNo, String oponid, BigDecimal totalFee, String ip){
        SortedMap<String,Object> parameters = WXSignUtils.createWeiParameters(orderNo,oponid,totalFee.multiply(new BigDecimal(100)),ip);
        String sign = WXSignUtils.createSign(ContantKey.chartsset,parameters);
        parameters.put("sign",sign);
        String xml = HttpXmlUtils.xmlInfoMap(parameters);
        System.out.println(xml);
        return xml;
    }


}
