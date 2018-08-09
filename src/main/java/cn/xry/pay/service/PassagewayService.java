package cn.xry.pay.service;

import cn.xry.common.service.IService;
import cn.xry.pay.domain.Passageway;

public interface PassagewayService extends IService<Passageway> {

    void deletePassageways(String ids);
}
