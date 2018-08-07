package cn.xry.system.domain;

import java.util.List;

public class AdminUserWithRole extends AdminUser{
	
	private static final long serialVersionUID = -5680235862276163462L;
	
	private Long roleId;
	
	private List<Long> roleIds;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		roleId = roleId;
	}

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}
	
}