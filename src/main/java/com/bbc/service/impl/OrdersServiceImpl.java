package com.bbc.service.impl;

import com.bbc.dao.HongBaoDao;
import com.bbc.dao.OrdersDao;
import com.bbc.entity.HongBao;
import com.bbc.entity.Orders;
import com.bbc.service.OrdersService;
import com.bbc.util.DateUtils;
import com.bbc.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gonglixun on 2017/2/8.
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private HongBaoDao hongBaoDao;

    @Override
    public Orders addOrder(String productName, BigDecimal totalFee, int userId){
        Orders orders = new Orders();
        orders.setProductName(productName);
        orders.setTotalFee(totalFee);
        orders.setUserId(userId);
        ordersDao.addOrder(orders);
        String orderNo = OrderUtil.getOrderNo(orders.getId());
        orders.setOrderNo(orderNo);
        ordersDao.updateOrderById(orderNo,orders.getId());
        return orders;
    }

    @Override
    public Orders getOrderByUserIdAndOrderId(int userId,int orderId){
        return ordersDao.getOrderByUserIdAndOrderId(userId,orderId);
    }

    @Override
    public Orders getOrderByUserId(int userId){
        return ordersDao.getOrderByUserId(userId);
    }


    @Override
    public Orders getOrderByOrderNo(String orderNo){
        return ordersDao.getOrderByOrderNo(orderNo);
    }


    @Override
    public int updateOrder(int  userId,int id,int dataStatus){
        return ordersDao.updateOrder(userId,id,dataStatus);
    }

    /**
     * 支付回调专业用，不能修改
     * @param orderNo
     * @param dataStatus
     * @return
     */
    @Override
    public int updateOrder(String orderNo,int dataStatus){
        return ordersDao.updateOrder(orderNo,dataStatus);
    }

    @Override
    public int updateHandlerOrder(int  userId,int id,int dataStatus,String openid,BigDecimal totalFee,String orderNo){
        ordersDao.updateOrder(userId,id,dataStatus);
        HongBao hongBao = new HongBao();
        hongBao.setOpenid(openid);
        hongBao.setUserId(userId);
        hongBao.setTotalFee(totalFee);
        hongBao.setOrderNo(orderNo);
        hongBao.setDataType(0);
        hongBaoDao.addHongBao(hongBao);
        return 1;
    }
}
