package cn.xry.pay.service.impl;

import cn.xry.common.service.impl.BaseService;
import cn.xry.common.util.NumberUtils;
import cn.xry.pay.dao.PassagewayMapper;
import cn.xry.pay.domain.Passageway;
import cn.xry.pay.service.PassagewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("passagewayService")
public class PassagewayServiceImpl extends BaseService<Passageway> implements PassagewayService {

    @Autowired
    private PassagewayMapper passagewayMapper;

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
}
