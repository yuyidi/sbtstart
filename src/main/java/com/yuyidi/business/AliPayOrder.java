package com.yuyidi.business;

import com.yuyidi.business.pojo.AliPayOrderResponse;
import com.yuyidi.business.pojo.OrderParameter;
import com.yuyidi.business.pojo.OrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yuyidi 2017-06-15 10:32:50
 * @class com.yuyidi.business.AliPayOrder
 * @description 支付宝支付
 */
@Component(value = "alipayOrder")
public class AliPayOrder implements OrderBusiness {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public PayEnum payment() {
        return PayEnum.ALIPAY;
    }

    @Override
    public OrderResponse generateOrder(OrderParameter parameter) {
        logger.info("执行支付宝支付");
        return new AliPayOrderResponse();
    }
}
