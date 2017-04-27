package com.bbc.service.impl;

import com.bbc.dao.HongBaoDao;
import com.bbc.entity.HongBao;
import com.bbc.service.HongBaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gonglixun on 2017/2/8.
 */
@Service
public class HongBaoServiceImpl implements HongBaoService {
    @Autowired
    private HongBaoDao hongBaoDao;

    @Override
    public int addHongBao(String openid,int userId,BigDecimal totalFee,int dataType,String orderNo){
        HongBao hongBao = new HongBao();
        hongBao.setOpenid(openid);
        hongBao.setUserId(userId);
        hongBao.setTotalFee(totalFee);
        hongBao.setDataType(dataType);
        hongBao.setOrderNo(orderNo);
        return hongBaoDao.addHongBao(hongBao);
    }

    @Override
    public int addHongBaoLog(int userId,int orderId,BigDecimal totalFee,String desc,int logType){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userId",userId);
        map.put("orderId",orderId);
        map.put("totalFee",totalFee);
        map.put("desc",desc);
        map.put("logType",logType);
        return hongBaoDao.addHongBaoLog(map);
    }

    @Override
    public List<HongBao> getHongBaoPager(int userId){
        return hongBaoDao.getHongBaoPager(userId);
    }

}
