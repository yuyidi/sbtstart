package com.yuyidi.business.pojo;

import com.yuyidi.awre.annotation.Realize;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Created by yuyidi on 2017/6/16.
 * @desc
 */
@Realize
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AliPayOrderResponse implements OrderResponse {
}
