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

    /**
     * 通过通道Id查询匹配出未分配的渠道列表
     * @param passagewayId
     * @return
     */
    List<AdminUser> findUserByPassagewayId(String passagewayId);
}