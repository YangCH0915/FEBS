package cn.xry.pay.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Order {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户ID
     */
    @Column(name = "mch_id")
    private Long mchId;

    /**
     * 支付通道ID
     */
    @Column(name = "passageway_id")
    private Long passagewayId;

    /**
     * 渠道用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 商户订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 平台订单号
     */
    @Column(name = "trade_no")
    private String tradeNo;

    /**
     * 支付类型
     */
    @Column(name = "pay_type")
    private String payType;

    /**
     * 金额，单位为分
     */
    private Integer amount;

    /**
     * 订单状态:0-已取消,1-未支付,2-已支付
     */
    private String status;

    /**
     * 产品ID
     */
    @Column(name = "product_id")
    private String productId;

    /**
     * 是否已同步渠道,0-3未同步或未成功,9-成功
     */
    @Column(name = "callback_status")
    private String callbackStatus;

    /**
     * 用户IP
     */
    @Column(name = "user_ip")
    private String userIp;

    /**
     * 商品名称
     */
    private String body;

    /**
     * 随机字符串
     */
    @Column(name = "nonce_str")
    private String nonceStr;

    /**
     * 拓展字段，异步通知数据原样返回
     */
    private String attach;

    /**
     * 异步通知地址
     */
    @Column(name = "notify_url")
    private String notifyUrl;

    /**
     * 前端回调地址
     */
    @Column(name = "callback_url")
    private String callbackUrl;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否限制使用信用卡
     */
    @Column(name = "limit_pay")
    private String limitPay;

    /**
     * 场景信息
     */
    @Column(name = "scene_info")
    private String sceneInfo;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商户ID
     *
     * @return mch_id - 商户ID
     */
    public Long getMchId() {
        return mchId;
    }

    /**
     * 设置商户ID
     *
     * @param mchId 商户ID
     */
    public void setMchId(Long mchId) {
        this.mchId = mchId;
    }

    /**
     * 获取支付通道ID
     *
     * @return passageway_id - 支付通道ID
     */
    public Long getPassagewayId() {
        return passagewayId;
    }

    /**
     * 设置支付通道ID
     *
     * @param passagewayId 支付通道ID
     */
    public void setPassagewayId(Long passagewayId) {
        this.passagewayId = passagewayId;
    }

    /**
     * 获取渠道用户ID
     *
     * @return user_id - 渠道用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置渠道用户ID
     *
     * @param userId 渠道用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取商户订单号
     *
     * @return order_no - 商户订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置商户订单号
     *
     * @param orderNo 商户订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 获取平台订单号
     *
     * @return trade_no - 平台订单号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置平台订单号
     *
     * @param tradeNo 平台订单号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * 获取支付类型
     *
     * @return pay_type - 支付类型
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置支付类型
     *
     * @param payType 支付类型
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * 获取金额，单位为分
     *
     * @return amount - 金额，单位为分
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 设置金额，单位为分
     *
     * @param amount 金额，单位为分
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 获取订单状态:0-已取消,1-未支付,2-已支付
     *
     * @return status - 订单状态:0-已取消,1-未支付,2-已支付
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置订单状态:0-已取消,1-未支付,2-已支付
     *
     * @param status 订单状态:0-已取消,1-未支付,2-已支付
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取产品ID
     *
     * @return product_id - 产品ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 设置产品ID
     *
     * @param productId 产品ID
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * 获取是否已同步渠道,0-3未同步或未成功,9-成功
     *
     * @return callback_status - 是否已同步渠道,0-3未同步或未成功,9-成功
     */
    public String getCallbackStatus() {
        return callbackStatus;
    }

    /**
     * 设置是否已同步渠道,0-3未同步或未成功,9-成功
     *
     * @param callbackStatus 是否已同步渠道,0-3未同步或未成功,9-成功
     */
    public void setCallbackStatus(String callbackStatus) {
        this.callbackStatus = callbackStatus == null ? null : callbackStatus.trim();
    }

    /**
     * 获取用户IP
     *
     * @return user_ip - 用户IP
     */
    public String getUserIp() {
        return userIp;
    }

    /**
     * 设置用户IP
     *
     * @param userIp 用户IP
     */
    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    /**
     * 获取商品名称
     *
     * @return body - 商品名称
     */
    public String getBody() {
        return body;
    }

    /**
     * 设置商品名称
     *
     * @param body 商品名称
     */
    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    /**
     * 获取随机字符串
     *
     * @return nonce_str - 随机字符串
     */
    public String getNonceStr() {
        return nonceStr;
    }

    /**
     * 设置随机字符串
     *
     * @param nonceStr 随机字符串
     */
    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr == null ? null : nonceStr.trim();
    }

    /**
     * 获取拓展字段，异步通知数据原样返回
     *
     * @return attach - 拓展字段，异步通知数据原样返回
     */
    public String getAttach() {
        return attach;
    }

    /**
     * 设置拓展字段，异步通知数据原样返回
     *
     * @param attach 拓展字段，异步通知数据原样返回
     */
    public void setAttach(String attach) {
        this.attach = attach == null ? null : attach.trim();
    }

    /**
     * 获取异步通知地址
     *
     * @return notify_url - 异步通知地址
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * 设置异步通知地址
     *
     * @param notifyUrl 异步通知地址
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    /**
     * 获取前端回调地址
     *
     * @return callback_url - 前端回调地址
     */
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * 设置前端回调地址
     *
     * @param callbackUrl 前端回调地址
     */
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl == null ? null : callbackUrl.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取是否限制使用信用卡
     *
     * @return limit_pay - 是否限制使用信用卡
     */
    public String getLimitPay() {
        return limitPay;
    }

    /**
     * 设置是否限制使用信用卡
     *
     * @param limitPay 是否限制使用信用卡
     */
    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay == null ? null : limitPay.trim();
    }

    /**
     * 获取场景信息
     *
     * @return scene_info - 场景信息
     */
    public String getSceneInfo() {
        return sceneInfo;
    }

    /**
     * 设置场景信息
     *
     * @param sceneInfo 场景信息
     */
    public void setSceneInfo(String sceneInfo) {
        this.sceneInfo = sceneInfo == null ? null : sceneInfo.trim();
    }
}