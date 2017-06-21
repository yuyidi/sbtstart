package com.yuyidi.business.pojo;

import com.yuyidi.awre.annotation.Realize;
import com.yuyidi.business.PayEnum;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author yuyidi 2017-06-14 16:31:03
 * @class com.yuyidi.business.pojo.WechatOrderParameter
 * @description 微信下单请求
 */
@Realize
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class WechatOrderParameter extends WechatCommonalityProperty implements OrderParameter {

    //签名类型，目前支持HMAC-SHA256和MD5，默认为MD5 非必填
    private String signType;
    //商品描述 商品简单描述，该字段须严格按照规范传递 https://pay.weixin.qq.com/wiki/doc/api/H5.php?chapter=4_2
    private String body;
    //商品详情 非必填
    private String detail;
    //附加数据 在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据 非必填
    private String attach;
    //商户订单号 商户系统内部的订单号,32个字符内
    private String outTradeNo;
    //货币类型 符合ISO 4217标准的三位字母代码，默认人民币：CNY 非必填
    private String feeType;
    //总金额 订单总金额，单位为分
    private Integer totalFee;
    //终端IP 必须传正确的用户端IP
    private String spbillCreateIp;
    //交易起始时间 非必填
    private Date timeStart;
    //交易结束时间 订单失效时间 最短失效时间间隔必须大于5分钟 非必填
    private Date timeExpire;
    //商品标记  商品标记，代金券或立减优惠功能的参数 非必填
    private String goodsTag;
    //通知地址 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数
    private String notifyUrl;
    //交易类型  H5支付的交易类型为MWEB  NATIVE JSAPI
    private String tradeType;
    //商品ID trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义 非必填
    private String productId;
    //指定支付方式 no_credit--指定不能使用信用卡支付 非必填
    private String limitPay;
    //用户标识 trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识 非必填
    private String openId;
    //场景信息 用于上报支付的场景信息
    private String sceneInfo;

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(Date timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(String sceneInfo) {
        this.sceneInfo = sceneInfo;
    }
}
