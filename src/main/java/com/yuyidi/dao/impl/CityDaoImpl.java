package com.yuyidi.dao.impl;

import com.yuyidi.dao.CityDao;
import com.yuyidi.dao.impl.jpa.CityRespository;
import com.yuyidi.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * @author Created by yuyidi on 2017/6/27.
 * @desc
 */
@Repository
public class CityDaoImpl implements CityDao {

    @Autowired
    private CityRespository respository;

    @Override
    public City getCityById(Long id) {
        return respository.getCityById(id);
    }

    @Override
    public Page<City> getCitys(Pageable pageable) {
        return respository.findAll(pageable);
    }
}
