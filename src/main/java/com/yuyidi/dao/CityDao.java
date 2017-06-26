package com.yuyidi.dao;

import com.yuyidi.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Created by yuyidi on 2017/6/26.
 * @desc
 */
public interface CityDao {
    City getCityById(Long id);

    Page<City> getCitys(Pageable pageable);
}
