package cn.xry.pay.dao;

import cn.xry.common.config.MyMapper;
import cn.xry.pay.domain.UserMchPay;
import org.apache.ibatis.annotations.Param;

public interface UserMchPayMapper extends MyMapper<UserMchPay> {

    int changeState(@Param("mchId") String mchId, @Param("passagewayId")String passagewayId,@Param("valid") boolean valid);

    int deleteMchInfo(@Param("mchId") String mchId, @Param("passagewayId")String passagewayId);
}