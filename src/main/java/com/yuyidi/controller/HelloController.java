package com.yuyidi.controller;

import com.yuyidi.awre.annotation.Interface;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/13.
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(@Interface Map map) {
        return "hello spring-boot";
    }
}
