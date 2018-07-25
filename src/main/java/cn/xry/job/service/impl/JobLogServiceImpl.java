package cn.xry.job.service.impl;


import cn.xry.common.service.impl.BaseService;
import cn.xry.job.dao.JobMapper;
import cn.xry.job.domain.Job;
import cn.xry.job.domain.JobLog;
import cn.xry.job.service.JobLogService;
import cn.xry.job.util.ScheduleUtils;
import org.apache.commons.lang.StringUtils;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("JobLogService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class JobLogServiceImpl extends BaseService<JobLog> implements JobLogService {

	@Autowired
	private Scheduler scheduler;

	@Autowired
	private JobMapper jobMapper;


	/**
	 * 项目启动时，初始化定时器
	 */
	@PostConstruct
	public void init() {
		List<Job> scheduleJobList = this.jobMapper.queryList();
		// 如果不存在，则创建
		scheduleJobList.forEach(scheduleJob -> {
			CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, scheduleJob.getJobId());
			if (cronTrigger == null) {
				ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
			} else {
				ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
			}
		});
	}


	@Override
	public List<JobLog> findAllJobLogs(JobLog jobLog) {
		try {
			Example example = new Example(JobLog.class);
			Criteria criteria = example.createCriteria();
			if (StringUtils.isNotBlank(jobLog.getBeanName())) {
				criteria.andCondition("bean_name=", jobLog.getBeanName());
			}
			if (StringUtils.isNotBlank(jobLog.getMethodName())) {
				criteria.andCondition("method_name=", jobLog.getMethodName());
			}
			if (StringUtils.isNotBlank(jobLog.getStatus())) {
				criteria.andCondition("status=", Long.valueOf(jobLog.getStatus()));
			}
			example.setOrderByClause("log_id");
			return this.selectByExample(example);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	@Transactional
	public void saveJobLog(JobLog log) {
		this.save(log);
	}

	@Override
	@Transactional
	public void deleteBatch(String jobLogIds) {
		List<String> list = Arrays.asList(jobLogIds.split(","));
		this.batchDelete(list, "logId", JobLog.class);
	}

}
