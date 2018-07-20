package cn.xry.system.service;

import cn.xry.common.service.IService;
import cn.xry.system.domain.Dict;

import java.util.List;

public interface DictService extends IService<Dict> {

	List<Dict> findAllDicts(Dict dict);

	Dict findById(Long dictId);

	void addDict(Dict dict);

	void deleteDicts(String dictIds);

	void updateDict(Dict dicdt);
}
