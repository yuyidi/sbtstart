package com.yuyidi.business.pojo;

import com.yuyidi.awre.annotation.Realize;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author yuyidi 2017-06-14 17:54:47
 * @class com.yuyidi.business.pojo.WechatOrderResponse
 * @description 微信订单下单成功响应
 */
@Realize
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class WechatOrderResponse extends WechatCommonalityProperty implements OrderResponse{
    //返回状态码
    private String returnCode;
    //返回信息     返回信息，如非空，为错误原因   签名失败    参数格式校验错误
    private String returnMsg;

    //业务结果 SUCCESS/FAIL   必填项
    private String resultCode;
    //错误代码                非必填
    private String errCode;
    //错误代码描述 错误返回的信息描述 非必填
    private String errCodeDes;
    //交易类型     调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，,H5支付固定传MWEB
    private String tradeType;
    //预支付交易会话标识   微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时,针对H5支付此参数无特殊用途
    private String prepayId;
    //支付跳转链接
    private String mwebUrl;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getMwebUrl() {
        return mwebUrl;
    }

    public void setMwebUrl(String mwebUrl) {
        this.mwebUrl = mwebUrl;
    }
}
