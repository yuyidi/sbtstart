package com.yuyidi.awre;

import com.yuyidi.business.OrderBusiness;
import com.yuyidi.business.PayEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
* @author yuyidi 2017-06-15 11:14:41
* @class com.yuyidi.awre.OrderBusinessFactory
* @description 初始化订单交易类型实现
*/
@Component
public class OrderBusinessFactory implements ApplicationContextAware {

    private static  Map<PayEnum, OrderBusiness> orderBusinessMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, OrderBusiness> map = applicationContext.getBeansOfType(OrderBusiness.class);
        orderBusinessMap = new HashMap<>();
        for(Map.Entry<String,OrderBusiness> entry : map.entrySet()){
            OrderBusiness orderBusiness = entry.getValue();
            orderBusinessMap.put(orderBusiness.payment(), orderBusiness);
        }
    }
    @SuppressWarnings("unchecked")
    public static <T extends OrderBusiness> T getOrderBusiness(PayEnum payEnum){
        return (T) orderBusinessMap.get(payEnum);
    }
}
