package com.bbc.dao;

import com.bbc.entity.Orders;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrdersDao extends BaseDao<Orders>{

	public int addOrder(Orders Orders){
		return this.addInfo("OrdersDao.addOrder",Orders);
	}

	public int updateOrder(int userId,int id,int dataStatus){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId",userId);
		map.put("id",id);
		map.put("dataStatus",dataStatus);
		this.updateByIf("OrdersDao.updateOrder",map);
		return 1;
	}

	public int updateOrder(String orderNo,int dataStatus){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderNo",orderNo);
		map.put("dataStatus",dataStatus);
		this.updateByIf("OrdersDao.updateOrderByOrderNo",map);
		return 1;
	}

	public int updateOrderById(String orderNo,int id){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderNo",orderNo);
		map.put("id",id);
		this.updateByIf("OrdersDao.updateOrderById",map);
		return 1;
	}
	public Orders getOrderByUserIdAndOrderId(int userId,int orderId){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId",userId);
		map.put("orderId",orderId);
		return this.getSqlSession().selectOne("OrdersDao.getOrderByUserIdAndOrderId",map);
	}

	/**
	 * 通过订单号获得订单信息
	 * @param orderNo
	 * @return
	 */
	public Orders getOrderByOrderNo(String orderNo){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderNo",orderNo);
		return this.getSqlSession().selectOne("OrdersDao.getOrderByOrderNo",map);
	}

	public Orders getOrderByUserId(int userId){
		return this.getSqlSession().selectOne("OrdersDao.getOrderByUserId",userId);
	}
	
}
