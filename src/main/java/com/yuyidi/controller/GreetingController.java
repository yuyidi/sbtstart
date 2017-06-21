package com.yuyidi.controller;

import com.yuyidi.entity.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Administrator on 2017/6/13.
 */
@RestController
public class GreetingController {

    Logger logger = LoggerFactory.getLogger(GreetingController.class);
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping(value = "/greeting")
//    public Greeting greeting(@RequestParam(value="name",defaultValue = "World") String name) {
//        long id = counter.getAndIncrement();
//        logger.info("id:{}",id);
//        return new Greeting(id, String.format(template,name));
//    }

//    @RequestMapping("/greeting")
//    public ModelAndView greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("greeting");
//        model.addObject("name", name);
//        return model;
//    }

    @RequestMapping("/greeting")
    public Greeting greeting(Greeting greeting) {
        return greeting;
    }

    @RequestMapping("/pay")
    public ModelAndView pay() {
        logger.info("你好，欢迎进入支付页面");
        ModelAndView model = new ModelAndView();
        model.setViewName("pay");
        return model;
    }
}
