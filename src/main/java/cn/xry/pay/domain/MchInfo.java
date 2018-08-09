package cn.xry.pay.domain;

import javax.persistence.*;

@Table(name = "mch_info")
public class MchInfo {
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
    private Long mchId;

    /**
     * 商户秘钥
     */
    @Column(name = "mch_key")
    private String mchKey;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private String modifyTime;

    /**
     * 启用状态:0-关闭,1-开启
     */
    private Boolean status;

    /**
     * 表名
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 表名
     */
    @Column(name = "passageway_id")
    private String passagewayId;

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
    public Long getMchId() {
        return mchId;
    }

    /**
     * 设置商户号ID
     *
     * @param mchId 商户号ID
     */
    public void setMchId(Long mchId) {
        this.mchId = mchId;
    }

    /**
     * 获取商户秘钥
     *
     * @return mch_key - 商户秘钥
     */
    public String getMchKey() {
        return mchKey;
    }

    /**
     * 设置商户秘钥
     *
     * @param mchKey 商户秘钥
     */
    public void setMchKey(String mchKey) {
        this.mchKey = mchKey == null ? null : mchKey.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public String getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
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
     * 获取表名
     *
     * @return user_id - 表名
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置表名
     *
     * @param userId 表名
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取表名
     *
     * @return passageway_id - 表名
     */
    public String getPassagewayId() {
        return passagewayId;
    }

    /**
     * 设置表名
     *
     * @param passagewayId 表名
     */
    public void setPassagewayId(String passagewayId) {
        this.passagewayId = passagewayId == null ? null : passagewayId.trim();
    }
}