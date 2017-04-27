package com.bbc.dao;

import com.bbc.entity.HongBao;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HongBaoDao extends BaseDao<HongBao>{

		public int addHongBao(HongBao hongBao){
			return this.addInfo("HongBaoDao.addHongBao",hongBao);
		}

	public int addHongBaoLog(Map<String,Object> map){
		return this.addObj("HongBaoDao.addHongBaoLog",map);
	}

		public List<HongBao> getHongBaoPager(int userId){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userId",userId);
			return this.getAllByPage("HongBaoDao.getHongBaoPager",map);
		}
	
}
