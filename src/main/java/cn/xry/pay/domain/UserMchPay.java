package cn.xry.pay.domain;

import javax.persistence.*;

@Table(name = "user_mch_pay")
public class UserMchPay {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户号ID
     */
    @Column(name = "mch_id")
    private String mchId;

    /**
     * 商户秘钥
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 创建时间
     */
    @Column(name = "passageway_id")
    private String passagewayId;

    /**
     * 费率
     */
    @Column(name = "settlement_rate")
    private Float settlementRate;

    /**
     * 启用状态:0-关闭,1-开启
     */
    private Boolean status;

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
     * 获取商户号ID
     *
     * @return mch_id - 商户号ID
     */
    public String getMchId() {
        return mchId;
    }

    /**
     * 设置商户号ID
     *
     * @param mchId 商户号ID
     */
    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    /**
     * 获取商户秘钥
     *
     * @return user_id - 商户秘钥
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置商户秘钥
     *
     * @param userId 商户秘钥
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取创建时间
     *
     * @return passageway_id - 创建时间
     */
    public String getPassagewayId() {
        return passagewayId;
    }

    /**
     * 设置创建时间
     *
     * @param passagewayId 创建时间
     */
    public void setPassagewayId(String passagewayId) {
        this.passagewayId = passagewayId == null ? null : passagewayId.trim();
    }

    /**
     * 获取费率
     *
     * @return settlement_rate - 费率
     */
    public Float getSettlementRate() {
        return settlementRate;
    }

    /**
     * 设置费率
     *
     * @param settlementRate 费率
     */
    public void setSettlementRate(Float settlementRate) {
        this.settlementRate = settlementRate;
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
}