package cn.xry.system.service;

import cn.xry.common.service.IService;
import cn.xry.system.domain.SysLog;

import java.util.List;

public interface LogService extends IService<SysLog> {
	
	List<SysLog> findAllLogs(SysLog log);
	
	void deleteLogs(String logIds);
}
