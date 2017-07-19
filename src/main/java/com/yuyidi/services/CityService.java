package com.yuyidi.services;

import com.yuyidi.dao.CityDao;
import com.yuyidi.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Created by yuyidi on 2017/6/26.
 * @desc
 */
@Service
public class CityService {

    @Autowired
    private CityDao cityDao;

    public City getCityInfo(Long id) {
        return cityDao.getCityById(id);
    }

    public Page<City> getCitys(int offset, int limit) {
        return cityDao.getCitys(new PageRequest(offset, limit));
    }
}
