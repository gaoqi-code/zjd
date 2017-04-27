package com.bbc.dao;

import com.bbc.entity.User;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao extends BaseDao<User>{

	public int addUser(User user){
		return this.addInfo("UserDao.addUser",user);
	}

	public User getUserByUnionid(String unionid){
		return this.getInfoById("UserDao.getUserByUnionid",unionid);


	}

	public User getUserByParentId(int parentId){
		return this.getInfoById("UserDao.getUserByParentId",parentId);
	}

	public int updateUserJianBalance(int userId,BigDecimal totalFee){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id",userId);
		map.put("totalFee",totalFee);
		return this.updateByIf("UserDao.updateUserJianBalance" +
				"",map);
	}

	public int updateUserJiaBalance(int userId,BigDecimal totalFee){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id",userId);
		map.put("totalFee",totalFee);
		return this.updateByIf("UserDao.updateUserJiaBalance",map);
	}

	public int addUserBalanceLog(Map<String,Object> map){
		return this.delByIf("UserDao.addUserBalanceLog",map);
	}

}
