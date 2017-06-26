package com.yuyidi.controller;

import com.yuyidi.entity.City;
import com.yuyidi.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by yuyidi on 2017/6/26.
 * @desc
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/{id}")
    public City fetchCityInfo(@PathVariable("id") Long id) {
        return cityService.getCityInfo(id);
    }
}
