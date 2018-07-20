package cn.xry.job.dao;

import cn.xry.common.config.MyMapper;
import cn.xry.job.domain.Job;

import java.util.List;

public interface JobMapper extends MyMapper<Job> {
	
	List<Job> queryList();
}