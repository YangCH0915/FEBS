package cn.xry.pay.dto;

import cn.xry.pay.domain.MchInfo;
import cn.xry.pay.domain.Passageway;
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
     * 通道列表
     */
    private List<Passageway> passageways;

    public AdminUser getChannel() {
        return channel;
    }

    public void setChannel(AdminUser channel) {
        this.channel = channel;
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
