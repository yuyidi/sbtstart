package com.yuyidi.business;

import com.yuyidi.business.pojo.OrderParameter;
import com.yuyidi.business.pojo.OrderResponse;

/**
 * @author yuyidi 2017-06-14 15:42:28
 * @class com.yuyidi.business.OrderBusiness
 * @description 订单业务接口
 */
public interface OrderBusiness {
    PayEnum payment();
    /**
     * @param parameter 订单参数
     * @return com.yuyidi.business.pojo.OrderResponse
     * @author yuyidi 2017-06-14 16:01:43
     * @method generateOrder
     * @description 第三方下单
     */
    OrderResponse generateOrder(OrderParameter parameter);
}
