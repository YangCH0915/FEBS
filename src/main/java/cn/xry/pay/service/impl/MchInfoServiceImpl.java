package cn.xry.pay.service.impl;

import cn.xry.common.service.impl.BaseService;
import cn.xry.common.util.MD5Utils;
import cn.xry.common.util.NumberUtils;
import cn.xry.pay.dao.MchInfoMapper;
import cn.xry.pay.dao.UserMchPayMapper;
import cn.xry.pay.domain.MchInfo;
import cn.xry.pay.domain.Passageway;
import cn.xry.pay.domain.UserMchPay;
import cn.xry.pay.dto.MchInfoRelation;
import cn.xry.pay.service.MchInfoService;
import cn.xry.system.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("mchInfoService")
public class MchInfoServiceImpl extends BaseService<MchInfo> implements MchInfoService {

    @Autowired
    private MchInfoMapper mchInfoMapper;

    @Autowired
    private UserMchPayMapper userMchPayMapper;

    @Override
    @Transient
    public String createMchId(Long userId) {
        String id = NumberUtils.getId();
        Example example = new Example(Role.class);
        example.createCriteria().andCondition("mch_id=", id);
        List<MchInfo> mchInfos = mchInfoMapper.selectByExample(example);
        if (mchInfos == null) {
            id = NumberUtils.getId();
        }
        insertMchInfo(id, userId);
        return id;
    }

    @Override
    public List<MchInfoRelation> findMchInfoRelation() {
        List<MchInfoRelation> mchInfoRelations = new ArrayList<>();
        List<MchInfoRelation> mchInfoRelation = mchInfoMapper.findMchInfoRelation();
        for (MchInfoRelation m : mchInfoRelation) {
            mchInfoRelations.add(matching(m));
        }
        return mchInfoRelations;
    }

    @Override
    public MchInfoRelation findMchInfoRelationByMchID(String mchId) {
        MchInfoRelation m = mchInfoMapper.findMchInfoRelationByMchID(mchId);
        return matching(m);
    }

    private MchInfoRelation matching(MchInfoRelation m){
        List<UserMchPay> userMchPay = m.getUserMchPays();
        List<Passageway> passageways = m.getPassageways();
        for (UserMchPay ump : userMchPay) {
            for (Passageway p : passageways) {
                if (ump.getPassagewayId().equals(p.getPassagewayId())) {
                    if (p.getStatus()) {
                        p.setOpen(ump.getStatus());
                    } else {
                        p.setOpen(p.getStatus());
                    }
                    p.setSettlementRate(ump.getSettlementRate());
                }
            }
        }
        m.setUserMchPays(null);
        return m;
    }

    private void insertMchInfo(String mchId, long userId) {
        MchInfo mchInfo = new MchInfo();
        mchInfo.setMchId(mchId);
        String mchKey = MD5Utils.encrypt(userId + "", mchId);
        mchInfo.setMchKey(mchKey);
        mchInfo.setStatus(true);
        mchInfo.setCreateTime(new Date());
        mchInfoMapper.insert(mchInfo);
    }


}
