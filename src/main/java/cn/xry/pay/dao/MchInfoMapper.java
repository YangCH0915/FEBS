package cn.xry.pay.dao;

import cn.xry.common.config.MyMapper;
import cn.xry.pay.domain.MchInfo;
import cn.xry.pay.dto.MchInfoRelation;

import java.util.List;

public interface MchInfoMapper extends MyMapper<MchInfo> {

    /**
     * 查询商户信息列表
     * @return
     */
    List<MchInfoRelation> findMchInfoRelation();

    /**
     * 根据商户号查询商户关联信息
     * @param mchId
     * @return
     */
    MchInfoRelation findMchInfoRelationByMchID(String mchId);
}