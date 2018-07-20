package cn.xry.job.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "admin_user")
public class AdminUer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * HEXID
     */
    private Long hexid;

    /**
     * 账户名
     */
    private String account;

    /**
     * 渠道Key，用于签名验证
     */
    @Column(name = "channel_key")
    private String channelKey;

    /**
     * 备注
     */
    private String ps;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码HASH值用户重置时使用
     */
    @Column(name = "password_hash")
    private String passwordHash;

    /**
     * 账户类型:0-管理员,1-平台账户,2-渠道账户
     */
    private Byte role;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 分成比例
     */
    @Column(name = "divide_per")
    private Float dividePer;

    /**
     * 是否启用
     */
    private Byte open;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取HEXID
     *
     * @return hexid - HEXID
     */
    public Long getHexid() {
        return hexid;
    }

    /**
     * 设置HEXID
     *
     * @param hexid HEXID
     */
    public void setHexid(Long hexid) {
        this.hexid = hexid;
    }

    /**
     * 获取账户名
     *
     * @return account - 账户名
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账户名
     *
     * @param account 账户名
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 获取渠道Key，用于签名验证
     *
     * @return channel_key - 渠道Key，用于签名验证
     */
    public String getChannelKey() {
        return channelKey;
    }

    /**
     * 设置渠道Key，用于签名验证
     *
     * @param channelKey 渠道Key，用于签名验证
     */
    public void setChannelKey(String channelKey) {
        this.channelKey = channelKey == null ? null : channelKey.trim();
    }

    /**
     * 获取备注
     *
     * @return ps - 备注
     */
    public String getPs() {
        return ps;
    }

    /**
     * 设置备注
     *
     * @param ps 备注
     */
    public void setPs(String ps) {
        this.ps = ps == null ? null : ps.trim();
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取密码HASH值用户重置时使用
     *
     * @return password_hash - 密码HASH值用户重置时使用
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * 设置密码HASH值用户重置时使用
     *
     * @param passwordHash 密码HASH值用户重置时使用
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash == null ? null : passwordHash.trim();
    }

    /**
     * 获取账户类型:0-管理员,1-平台账户,2-渠道账户
     *
     * @return role - 账户类型:0-管理员,1-平台账户,2-渠道账户
     */
    public Byte getRole() {
        return role;
    }

    /**
     * 设置账户类型:0-管理员,1-平台账户,2-渠道账户
     *
     * @param role 账户类型:0-管理员,1-平台账户,2-渠道账户
     */
    public void setRole(Byte role) {
        this.role = role;
    }

    /**
     * 获取ip地址
     *
     * @return ip - ip地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置ip地址
     *
     * @param ip ip地址
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 获取分成比例
     *
     * @return divide_per - 分成比例
     */
    public Float getDividePer() {
        return dividePer;
    }

    /**
     * 设置分成比例
     *
     * @param dividePer 分成比例
     */
    public void setDividePer(Float dividePer) {
        this.dividePer = dividePer;
    }

    /**
     * 获取是否启用
     *
     * @return open - 是否启用
     */
    public Byte getOpen() {
        return open;
    }

    /**
     * 设置是否启用
     *
     * @param open 是否启用
     */
    public void setOpen(Byte open) {
        this.open = open;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}