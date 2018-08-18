package cn.xry.pay.domain;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Date;

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
    private String mchId;

    /**
     * 商户秘钥
     */
    @Column(name = "mch_key")
    private String mchKey;

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

    @Override
    public String toString() {
        return "MchInfo{" +
                "id=" + id +
                ", mchId='" + mchId + '\'' +
                ", mchKey='" + mchKey + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", status=" + status +
                '}';
    }
}