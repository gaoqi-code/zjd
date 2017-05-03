package com.bbc.service;

import com.bbc.entity.Cash;
import java.util.List;
import java.util.Map;

/**
 * Created by gonglixun on 2017/2/8.
 */
public interface CashService {

    public int addCash(Cash cash);


    public int update(Map<String,Object> map);


    public List<Cash> getCashList(Map<String,Object> map);


    public Cash getCashById(int id);

}
