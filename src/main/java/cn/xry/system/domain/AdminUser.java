package cn.xry.system.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Table(name = "admin_user")
public class AdminUser implements Serializable {

    private static final long serialVersionUID = -1714476694755654920L;

    /**
     * 账户状态
     */
    public static final String STATUS_VALID = "1";

    public static final String STATUS_LOCK = "0";

    public static final String DEFAULT_THEME = "green";

    public static final String DEFAULT_AVATAR = "default.jpg";

    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 分成比例
     */
    @Column(name = "divide_per")
    private Float dividePer;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 最近访问时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 银行账户名
     */
    @Column(name = "account_name")
    private String accountName;

    /**
     * 银行收款账号
     */
    @Column(name = "bank_account")
    private String bankAccount;

    /**
     * 开户银行地址
     */
    @Column(name = "opening_bank")
    private String openingBank;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态 0锁定 1有效
     */
    private String status;

    /**
     * 角色ID
     */
    @Transient
    private String roleName;

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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
     * 获取联系电话
     *
     * @return mobile - 联系电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置联系电话
     *
     * @param mobile 联系电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
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
     * 获取最近访问时间
     *
     * @return last_login_time - 最近访问时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最近访问时间
     *
     * @param lastLoginTime 最近访问时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取银行账户名
     *
     * @return account_name - 银行账户名
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 设置银行账户名
     *
     * @param accountName 银行账户名
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    /**
     * 获取银行收款账号
     *
     * @return bank_account - 银行收款账号
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 设置银行收款账号
     *
     * @param bankAccount 银行收款账号
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    /**
     * 获取开户银行地址
     *
     * @return opening_bank - 开户银行地址
     */
    public String getOpeningBank() {
        return openingBank;
    }

    /**
     * 设置开户银行地址
     *
     * @param openingBank 开户银行地址
     */
    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank == null ? null : openingBank.trim();
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
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取状态 0锁定 1有效
     *
     * @return status - 状态 0锁定 1有效
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态 0锁定 1有效
     *
     * @param status 状态 0锁定 1有效
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", dividePer=" + dividePer +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", lastLoginTime=" + lastLoginTime +
                ", accountName='" + accountName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", openingBank='" + openingBank + '\'' +
                ", avatar='" + avatar + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", roleName=" + roleName +
                '}';
    }
}