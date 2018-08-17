package cn.xry.pay.service;

import cn.xry.common.service.IService;
import cn.xry.pay.domain.Passageway;

import java.util.List;

public interface PassagewayService extends IService<Passageway> {

    int add(Passageway passageway);

    int update(Passageway passageway);

    List<Passageway> findAll();

    void deletePassageways(String ids);

    Passageway findPassagewayById(long id);

    int distribution(String passageId,String userIds,float settlementRate,boolean status);
}
