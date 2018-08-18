package cn.xry.pay.domain;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class Passageway implements Serializable {

    private static final long serialVersionUID = -10000L;
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 支付商户号ID
     */
    @Column(name = "pay_id")
    private String payId;

    /**
     * 支付秘钥，根据加密类型区分
     */
    @Column(name = "pay_key")
    private String payKey;

    /**
     * 支付秘钥，根据加密类型区分,RSA类型需要此秘钥解密
     */
    @Column(name = "public_key")
    private String publicKey;

    /**
     * 签名类型
     */
    @Column(name = "sign_type")
    private String signType;
    /**
     * 产品ID
     */
    @Column(name = "app_id")
    private String appId;

    /**
     * 支付类型
     */
    @Column(name = "pay_type")
    private String payType;

    /**
     * 创建时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 启用状态:0-关闭,1-开启
     */
    private Boolean status;

    /**
     * 通道标识ID
     */
    @Column(name = "passageway_id")
    private String passagewayId;

    /**
     * 通道名称
     */
    @Column(name = "passageway_name")
    private String passagewayName;

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
     * 获取支付商户号ID
     *
     * @return pay_id - 支付商户号ID
     */
    public String getPayId() {
        return payId;
    }

    /**
     * 设置支付商户号ID
     *
     * @param payId 支付商户号ID
     */
    public void setPayId(String payId) {
        this.payId = payId == null ? null : payId.trim();
    }

    /**
     * 获取支付秘钥，根据加密类型区分
     *
     * @return pay_key - 支付秘钥，根据加密类型区分
     */
    public String getPayKey() {
        return payKey;
    }

    /**
     * 设置支付秘钥，根据加密类型区分
     *
     * @param payKey 支付秘钥，根据加密类型区分
     */
    public void setPayKey(String payKey) {
        this.payKey = payKey == null ? null : payKey.trim();
    }

    /**
     * 获取支付秘钥，根据加密类型区分,RSA类型需要此秘钥解密
     *
     * @return public_key - 支付秘钥，根据加密类型区分,RSA类型需要此秘钥解密
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * 设置支付秘钥，根据加密类型区分,RSA类型需要此秘钥解密
     *
     * @param publicKey 支付秘钥，根据加密类型区分,RSA类型需要此秘钥解密
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey == null ? null : publicKey.trim();
    }

    /**
     * 获取签名类型
     *
     * @return sign_type - 签名类型
     */
    public String getSignType() {
        return signType;
    }

    /**
     * 设置签名类型
     *
     * @param signType 签名类型
     */
    public void setSignType(String signType) {
        this.signType = signType == null ? null : signType.trim();
    }

    /**
     * 获取产品ID
     *
     * @return app_id - 产品ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置产品ID
     *
     * @param appId 产品ID
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
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
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取启用状态:0-关闭,1-开启
     *
     * @return status - 启用状态:0-关闭,1-开启
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置启用状态:0-关闭,1-开启
     *
     * @param status 启用状态:0-关闭,1-开启
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取通道标识ID
     *
     * @return passageway_id - 通道标识ID
     */
    public String getPassagewayId() {
        return passagewayId;
    }

    /**
     * 设置通道标识ID
     *
     * @param passagewayId 通道标识ID
     */
    public void setPassagewayId(String passagewayId) {
        this.passagewayId = passagewayId == null ? null : passagewayId.trim();
    }

    /**
     * 获取通道名称
     *
     * @return passageway_name - 通道名称
     */
    public String getPassagewayName() {
        return passagewayName;
    }

    /**
     * 设置通道名称
     *
     * @param passagewayName 通道名称
     */
    public void setPassagewayName(String passagewayName) {
        this.passagewayName = passagewayName == null ? null : passagewayName.trim();
    }

    @Override
    public String toString() {
        return "Passageway{" +
                "id=" + id +
                ", payId='" + payId + '\'' +
                ", payKey='" + payKey + '\'' +
                ", publicKey='" + publicKey + '\'' +
                ", signType='" + signType + '\'' +
                ", appId='" + appId + '\'' +
                ", payType='" + payType + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", status=" + status +
                ", passagewayId='" + passagewayId + '\'' +
                ", passagewayName='" + passagewayName + '\'' +
                '}';
    }
}