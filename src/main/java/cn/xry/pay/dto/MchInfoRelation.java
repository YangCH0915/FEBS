package cn.xry.pay.dto;

import cn.xry.pay.domain.MchInfo;
import cn.xry.pay.domain.Passageway;
import cn.xry.pay.domain.UserMchPay;
import cn.xry.system.domain.AdminUser;

import java.util.List;

/**
 * 储存商户信息，包含支付通道，渠道用户Id,渠道名称
 */
public class MchInfoRelation extends MchInfo {

    /**
     * 渠道用户
     */
    private AdminUser channel;

    /**
     * 管理信息，主要作用是查询所分配的这个渠道的这个通道是否停用
     */
    private List<UserMchPay> userMchPays;
    /**
     * 通道列表
     */
    private List<Passageway> passageways;

    public AdminUser getChannel() {
        return channel;
    }

    public void setChannel(AdminUser channel) {
        this.channel = channel;
    }

    public List<UserMchPay> getUserMchPays() {
        return userMchPays;
    }

    public void setUserMchPays(List<UserMchPay> userMchPays) {
        this.userMchPays = userMchPays;
    }

    public List<Passageway> getPassageways() {
        return passageways;
    }

    public void setPassageways(List<Passageway> passageways) {
        this.passageways = passageways;
    }

    @Override
    public String toString() {
        return "MchInfoRelation{" +
                "channel=" + channel +
                ", passageways=" + passageways +
                '}';
    }
}
