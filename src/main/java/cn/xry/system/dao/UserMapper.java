package cn.xry.system.dao;

import cn.xry.common.config.MyMapper;
import cn.xry.system.domain.User;
import cn.xry.system.domain.UserWithRole;

import java.util.List;

public interface UserMapper extends MyMapper<User> {

	List<User> findUserWithDept(User user);
	
	List<UserWithRole> findUserWithRole(Long userId);
	
	User findUserProfile(User user);
}