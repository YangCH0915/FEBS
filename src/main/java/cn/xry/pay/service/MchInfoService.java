package cn.xry.pay.service;

import cn.xry.common.service.IService;
import cn.xry.pay.domain.MchInfo;

public interface MchInfoService extends IService<MchInfo> {

    String createMchId(Long userId);

    MchInfo findMchInfoByUserId();

}
