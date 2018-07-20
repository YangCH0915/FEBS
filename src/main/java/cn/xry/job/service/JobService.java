package cn.xry.job.service;

import cn.xry.common.service.IService;
import cn.xry.job.domain.Job;

import java.util.List;

public interface JobService extends IService<Job> {
	
	Job findJob(Long jobId);

	List<Job> findAllJobs(Job job);

	void addJob(Job job);

	void updateJob(Job job);

	void deleteBatch(String jobIds);

	int updateBatch(String jobIds, String status);

	void run(String jobIds);

	void pause(String jobIds);

	void resume(String jobIds);
}
