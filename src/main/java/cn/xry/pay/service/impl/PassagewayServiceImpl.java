package cn.xry.pay.service.impl;

import cn.xry.common.service.impl.BaseService;
import cn.xry.common.util.NumberUtils;
import cn.xry.pay.dao.MchInfoMapper;
import cn.xry.pay.dao.PassagewayMapper;
import cn.xry.pay.dao.UserMchPayMapper;
import cn.xry.pay.domain.Passageway;
import cn.xry.pay.domain.UserMchPay;
import cn.xry.pay.service.MchInfoService;
import cn.xry.pay.service.PassagewayService;
import cn.xry.system.domain.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("passagewayService")
public class PassagewayServiceImpl extends BaseService<Passageway> implements PassagewayService {

    @Autowired
    private PassagewayMapper passagewayMapper;

    @Autowired
    private UserMchPayMapper userMchPayMapper;

    @Autowired
    private MchInfoService mchInfoService;

    @Override
    public int add(Passageway passageway) {
        if(passageway.getStatus() == null){
            passageway.setStatus(false);
        }
        passageway.setPassagewayId(NumberUtils.getId());
        passageway.setCreateTime(new Date());
        return save(passageway);
    }

    @Override
    public int update(Passageway passageway) {
        if(passageway.getStatus() == null){
            passageway.setStatus(false);
        }
        passageway.setModifyTime(new Date());
        return updateNotNull(passageway);
    }

    @Override
    public List<Passageway> findAll() {
        return selectAll();
    }

    @Override
    public void deletePassageways(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        this.batchDelete(list, "passagewayId", Passageway.class);
    }

    @Override
    public Passageway findPassagewayById(long id) {
        return this.selectByKey(id);
    }


    @Override
    public int distribution(String passageId, String userIds, float settlementRate, boolean status) {
        List<UserMchPay> userMchPays = userMchPayMapper.selectAll();
        if(userIds.contains(",")){
            String[] split = userIds.split(",");
            for(String userId : split){
                if(userId != null && userId != ""){
                     long uId = Long.valueOf(userId);
                     insert(passageId,getMchId(userMchPays,uId),uId,settlementRate,status);
                }
            }
        }else{
            if(userIds != null && userIds != ""){
                long uId = Long.valueOf(userIds);
                insert(passageId,getMchId(userMchPays,uId),uId,settlementRate,status);
            }
        }
        return 0;
    }

    private String getMchId(List<UserMchPay> userMchPays,long userId ){
        for(UserMchPay userMchPay:userMchPays){
            if(userId == userMchPay.getUserId()){
                return userMchPay.getMchId();
            }
        }
        return mchInfoService.createMchId(userId);
    }

    private void insert(String passageId,String mchId, Long uId, float settlementRate, boolean status){
        UserMchPay userMchPay = new UserMchPay();
        userMchPay.setMchId(mchId);
        userMchPay.setPassagewayId(passageId);
        userMchPay.setUserId(uId);
        userMchPay.setStatus(status);
        userMchPay.setSettlementRate(settlementRate);
        userMchPayMapper.insert(userMchPay);
    }
}
