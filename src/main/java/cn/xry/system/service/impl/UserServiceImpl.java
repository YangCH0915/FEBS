package cn.xry.system.service.impl;

import cn.xry.common.service.impl.BaseService;
import cn.xry.common.util.MD5Utils;
import cn.xry.system.dao.AdminUserMapper;
import cn.xry.system.dao.UserRoleMapper;
import cn.xry.system.domain.AdminUser;
import cn.xry.system.domain.AdminUserWithRole;
import cn.xry.system.domain.UserRole;
import cn.xry.system.service.UserRoleService;
import cn.xry.system.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends BaseService<AdminUser> implements UserService {

	@Autowired
	private AdminUserMapper userMapper;

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Autowired
	private UserRoleService userRoleService;


	@Override
	public AdminUser findByName(String userName) {
		Example example = new Example(AdminUser.class);
		example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
		List<AdminUser> users = this.selectByExample(example);
		if (users.size() == 0) {
			return null;
		} else {
			return users.get(0);
		}
	}

	@Override
	public List<AdminUser> findUser(AdminUser user) {
		try {
			return this.userMapper.findAdminUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	@Transactional
	public void registerUser(AdminUser user) {
		user.setCreateTime(new Date());
		user.setAvatar(AdminUser.DEFAULT_AVATAR);
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		this.save(user);
		UserRole ur = new UserRole();
		ur.setUserId(user.getUserId());
		ur.setRoleId(3L);
		this.userRoleMapper.insert(ur);
	}

	@Override
	@Transactional
	public void addUser(AdminUser user, Long[] roles) {
		user.setCreateTime(new Date());
		user.setAvatar(AdminUser.DEFAULT_AVATAR);
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		this.save(user);
		System.out.println(user.toString());
		setUserRoles(user, roles);
	}

	private void setUserRoles(AdminUser user, Long[] roles) {
		for (Long roleId : roles) {
			UserRole ur = new UserRole();
			ur.setUserId(user.getUserId());
			ur.setRoleId(roleId);
			this.userRoleMapper.insert(ur);
		}
	}

	@Override
	@Transactional
	public void updateUser(AdminUser user, Long[] roles) {
		user.setPassword(null);
		user.setUsername(null);
		user.setModifyTime(new Date());
		this.updateNotNull(user);
		Example example = new Example(UserRole.class);
		example.createCriteria().andCondition("user_id=", user.getUserId());
		this.userRoleMapper.deleteByExample(example);
		setUserRoles(user, roles);
	}

	@Override
	@Transactional
	public void deleteUsers(String userIds) {
		List<String> list = Arrays.asList(userIds.split(","));
		this.batchDelete(list, "userId", AdminUser.class);
		this.userRoleService.deleteUserRolesByUserId(userIds);
	}

	@Override
	@Transactional
	public void updateLoginTime(String userName) {
		Example example = new Example(AdminUser.class);
		example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
		AdminUser user = new AdminUser();
		user.setLastLoginTime(new Date());
		this.userMapper.updateByExampleSelective(user, example);
	}

	@Override
	@Transactional
	public void updatePassword(String password) {
		AdminUser user = (AdminUser) SecurityUtils.getSubject().getPrincipal();
		Example example = new Example(AdminUser.class);
		example.createCriteria().andCondition("username=", user.getUsername());
		String newPassword = MD5Utils.encrypt(user.getUsername().toLowerCase(), password);
		user.setPassword(newPassword);
		this.userMapper.updateByExampleSelective(user, example);
	}

	@Override
	public AdminUser findUserProfile(AdminUser user) {
		return this.userMapper.findAdminUserAndRoleName(user.getUserId());
	}

	@Override
	public AdminUserWithRole findAdminUserWithRole(Long userId) {
		List<Long> roleList = new ArrayList<>();
		List<AdminUserWithRole> list = this.userMapper.findAdminUserWithRole(userId);
		for (AdminUserWithRole uwr : list) {
			roleList.add(uwr.getRoleId());
		}
		if (list.size() == 0) {
			return null;
		}
		AdminUserWithRole userWithRole = list.get(0);
		userWithRole.setRoleIds(roleList);
		return userWithRole;
	}
}
