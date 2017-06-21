package com.yuyidi.awre;

import com.yuyidi.business.PayEnum;
import org.springframework.core.convert.converter.Converter;

/**
* @author yuyidi 2017-06-15 11:35:56
* @class com.yuyidi.awre.StringToPayEnumConverter
* @description 请求参数转支付枚举  单个枚举转换类  只能转换成一种类型
*/
public class StringToPayEnumConverter implements Converter<String,PayEnum> {
    @Override
    public PayEnum convert(String source) {
        return PayEnum.getByIndex(Integer.valueOf(source));
    }
}

