package cn.xry.system.service;

import cn.xry.common.service.IService;
import cn.xry.system.domain.AdminUser;
import cn.xry.system.domain.AdminUserWithRole;

import java.util.List;

public interface UserService extends IService<AdminUser> {

	AdminUser findByName(String userName);

	List<AdminUser> findUser(AdminUser user);

	void registerUser(AdminUser user);

	void addUser(AdminUser user, Long[] roles);

	void updateUser(AdminUser user, Long[] roles);
	
	void deleteUsers(String userIds);

	void updateLoginTime(String userName);
	
	void updatePassword(String password);
	
	AdminUser findUserProfile(AdminUser user);

	AdminUserWithRole findAdminUserWithRole(Long userId);

	/**
	 * 通过通道Id查询匹配出未分配的渠道列表
	 * @param passagewayId
	 * @return
	 */
	List<AdminUser> findUserByPassagewayId(String passagewayId);
}
