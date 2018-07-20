package cn.xry.system.service;

import cn.xry.common.service.IService;
import cn.xry.system.domain.UserRole;

public interface UserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(String roleIds);

	void deleteUserRolesByUserId(String userIds);
}
