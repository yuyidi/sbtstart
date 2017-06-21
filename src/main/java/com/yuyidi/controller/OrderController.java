package com.yuyidi.controller;

import com.yuyidi.awre.OrderBusinessFactory;
import com.yuyidi.awre.annotation.Interface;
import com.yuyidi.business.OrderBusiness;
import com.yuyidi.business.PayEnum;
import com.yuyidi.business.pojo.AliPayOrderParameter;
import com.yuyidi.business.pojo.OrderParameter;
import com.yuyidi.business.pojo.OrderResponse;
import com.yuyidi.business.pojo.WechatOrderParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Created by yuyidi on 2017/6/15.
 * @desc
 */
@RestController
public class OrderController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("/generateByPayment")
    public ModelAndView generateOrder(PayEnum payEnum) {
        ModelAndView mv = new ModelAndView();
        OrderResponse orderResponse = null;
        OrderBusiness orderBusiness = OrderBusinessFactory.getOrderBusiness(payEnum);
        if (payEnum == PayEnum.WECHAT) {
            orderResponse = orderBusiness.generateOrder(new WechatOrderParameter());
        } else if (payEnum == PayEnum.ALIPAY) {
            orderResponse = orderBusiness.generateOrder(new AliPayOrderParameter());
        }
        mv.addObject("result", orderResponse);
        mv.setViewName("pay");
        return mv;
    }

    @RequestMapping("/generate")
    public ModelAndView generateOrder(PayEnum payEnum, @Interface OrderParameter parameter) {
        ModelAndView mv = new ModelAndView();
        OrderResponse orderResponse = OrderBusinessFactory.getOrderBusiness(payEnum).generateOrder(parameter);
        mv.addObject("result", orderResponse);
        mv.setViewName("pay");
        return mv;
    }
}
