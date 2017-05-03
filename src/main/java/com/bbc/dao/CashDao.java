package com.bbc.dao;

import com.bbc.entity.Cash;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CashDao extends BaseDao<Cash>{

	public int addCash(Cash cash){
		this.addObj("CashDao.addCash",cash);
		return 1;
	}


	public int update(Map<String,Object> map){
		this.updateByIf("CashDao.update",map);
		return 1;
	}


	public List<Cash> getCashList(Map<String,Object> map){
		return this.getAllByPage("CashDao.getCashList",map);
	}

	public Cash getCashById(int id){
		return this.getInfoById("CashDao.getCashById",id);
	}

}
