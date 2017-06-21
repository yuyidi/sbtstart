package com.yuyidi.business;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyidi 2017-06-15 10:58:30
 * @class com.yuyidi.business.PayEnum
 * @description 支付方式枚举
 */
public enum PayEnum implements CommonalityEnum{
    WECHAT(0, "微信"), ALIPAY(1, "支付宝");

    private static Map<Integer, PayEnum> valueMap = new HashMap<>();

    static {
        for (PayEnum payEnum : PayEnum.values()) {
            valueMap.put(payEnum.getIndex(), payEnum);
        }
    }

    private Integer index;
    private String payment;

    PayEnum(Integer index, String payment) {
        this.index = index;
        this.payment = payment;
    }

    public static PayEnum getByIndex(Integer index) {
        PayEnum result = valueMap.get(index);
        if (result == null) {
            throw new IllegalArgumentException("No element matches " + index);
        }
        return result;
    }

    @Override
    public Integer getIndex() {
        return this.index;
    }
    public String getPayment() {
        return payment;
    }
}
