package com.yuyidi.business.pojo;

/**
* @author yuyidi 2017-06-14 18:03:47
* @class com.yuyidi.business.pojo.WechatCommonalityProperty
* @description 微信订单请求响应公共参数
*/
public class WechatCommonalityProperty{
    //公众账号ID 微信分配的公众账号ID
    protected String appId;
    //商户号 微信支付分配的商户号
    protected String mchId;
    //设备号  PC网页或公众号内支付请传"WEB" 非必填
    protected String deviceInfo;
    //随机字符串
    protected String nonceStr;
    //签名
    protected String sign;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
