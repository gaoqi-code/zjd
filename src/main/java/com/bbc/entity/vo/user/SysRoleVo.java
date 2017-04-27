package com.bbc.entity.vo.user;

import com.bbc.entity.vo.AjaxPage;

public class SysRoleVo extends AjaxPage{
	
	private Integer roleId;
	private String roleName;
	private Integer state;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

}
