package com.bbc.service.impl;

import com.bbc.dao.CashDao;
import com.bbc.dao.UserDao;
import com.bbc.entity.Cash;
import com.bbc.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by gonglixun on 2017/2/8.
 */
@Service
public class CashServiceImpl implements CashService{

    @Autowired
    private CashDao cashDao;

    @Autowired
    private UserDao userhDao;

    @Override
    public int addCash(Cash cash) {
        userhDao.updateUserJianBalance(cash.getUserId(),cash.getAmount());
        return cashDao.addCash(cash);
    }

    @Override
    public int update(Map<String, Object> map) {
        return cashDao.update(map);
    }

    @Override
    public List<Cash> getCashList(Map<String, Object> map) {
        return cashDao.getCashList(map);
    }
}
