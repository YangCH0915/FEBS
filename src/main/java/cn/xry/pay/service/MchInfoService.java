package cn.xry.pay.service;

import cn.xry.common.service.IService;
import cn.xry.pay.domain.MchInfo;
import cn.xry.pay.dto.MchInfoRelation;

import java.util.List;

public interface MchInfoService extends IService<MchInfo> {

    /**
     * 创建商户号
     * @param userId
     * @return
     */
    String createMchId(Long userId);

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

    /**
     * 根据商户号ID,通道ID更新状态
     * @param mchId
     * @param passagewayId
     * @param open
     * @return
     */
    int changeState(String mchId,String passagewayId,boolean open);

    /**
     * 根据商户号ID,通道ID解除绑定
     * @param mchId
     * @param passagewayId
     * @return
     */
    int deleteMchInfo(String mchId,String passagewayId);
}
