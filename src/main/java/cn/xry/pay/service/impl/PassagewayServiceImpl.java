package cn.xry.pay.service.impl;

import cn.xry.common.service.impl.BaseService;
import cn.xry.pay.dao.PassagewayMapper;
import cn.xry.pay.domain.Passageway;
import cn.xry.pay.service.PassagewayService;
import cn.xry.system.domain.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("passagewayService")
public class PassagewayServiceImpl extends BaseService<Passageway> implements PassagewayService {

    @Autowired
    private PassagewayMapper passagewayMapper;

    @Override
    public void deletePassageways(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        this.batchDelete(list, "passagewayId", Passageway.class);
    }
}
