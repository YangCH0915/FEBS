package cn.xry.system.dao;

import cn.xry.common.config.MyMapper;
import cn.xry.system.domain.AdminUser;
import cn.xry.system.domain.AdminUserWithRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserMapper extends MyMapper<AdminUser> {

    List<AdminUser> findAdminUser(@Param("au") AdminUser user);

    List<AdminUserWithRole> findAdminUserWithRole(Long userId);

    AdminUser findAdminUserAndRoleName(Long userId);
}