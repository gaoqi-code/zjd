package com.bbc.service.impl;

import com.bbc.dao.AccusationDao;
import com.bbc.dao.HongBaoDao;
import com.bbc.dao.OrdersDao;
import com.bbc.entity.Accusation;
import com.bbc.entity.HongBao;
import com.bbc.entity.Orders;
import com.bbc.service.AccusationService;
import com.bbc.service.OrdersService;
import com.bbc.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by gonglixun on 2017/2/8.
 */
@Service
public class AccusationServiceImpl implements AccusationService {
    @Autowired
    private AccusationDao accusationDao;

    @Override
    public int addAccusation(Accusation a){
        accusationDao.addAccusation(a);
        return 1;
    }

}
