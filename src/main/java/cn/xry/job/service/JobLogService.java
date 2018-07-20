package cn.xry.job.service;


import cn.xry.common.service.IService;
import cn.xry.job.domain.JobLog;

import java.util.List;

public interface JobLogService extends IService<JobLog> {

	List<JobLog> findAllJobLogs(JobLog jobLog);

	void saveJobLog(JobLog log);
	
	void deleteBatch(String jobLogIds);
}
