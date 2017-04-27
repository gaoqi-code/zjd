package com.bbc.service;

import com.bbc.entity.HongBao;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by gonglixun on 2017/2/8.
 */
public interface HongBaoService {

    public int addHongBao(String openid,int user,BigDecimal totalFee,int dataType,String orderNo);

    public int addHongBaoLog(int user,int order_id,BigDecimal totalFee,String desc,int logType);

    public List<HongBao> getHongBaoPager(int userId);


}
