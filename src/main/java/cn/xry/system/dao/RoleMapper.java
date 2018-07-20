package cn.xry.system.dao;

import cn.xry.common.config.MyMapper;
import cn.xry.system.domain.Role;
import cn.xry.system.domain.RoleWithMenu;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
	
	List<Role> findUserRole(String userName);
	
	List<RoleWithMenu> findById(Long roleId);
}