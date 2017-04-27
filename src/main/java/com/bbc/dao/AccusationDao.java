package com.bbc.dao;

import com.bbc.entity.Accusation;
import com.bbc.entity.Orders;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AccusationDao extends BaseDao<Accusation>{

	public int addAccusation(Accusation accusation){
		return this.addInfo("AccusationDao.addAccusation",accusation);
	}
}
