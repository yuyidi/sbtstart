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
public class AliPayOrderParameter implements OrderParameter {
    private String alipayId;
    private String appid;

    public String getAlipayId() {
        return alipayId;
    }

    public void setAlipayId(String alipayId) {
        this.alipayId = alipayId;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
