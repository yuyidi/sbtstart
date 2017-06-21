package com.yuyidi.business;

import com.yuyidi.business.pojo.OrderParameter;
import com.yuyidi.business.pojo.OrderResponse;
import com.yuyidi.business.pojo.WechatOrderParameter;
import com.yuyidi.business.pojo.WechatOrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yuyidi 2017-06-14 16:27:50
 * @class com.yuyidi.business.WechatOrder
 * @description 微信订单业务实现
 */
@Component(value = "wechatOrder")
public class WechatOrder implements OrderBusiness {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public PayEnum payment() {
        return PayEnum.WECHAT;
    }

    @Override
    public OrderResponse generateOrder(OrderParameter parameter) {
        WechatOrderParameter wechatOrderParameter = (WechatOrderParameter) parameter;
        logger.info("appid:{}", wechatOrderParameter.getAppId());
        logger.info("执行微信支付");
        return new WechatOrderResponse();
    }
}