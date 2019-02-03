package org.system.entity;

import org.zero.spring.mybatis.BaseEntity;

public class ScRolePermission extends BaseEntity {

	private static final long serialVersionUID = 712703113270264038L;

	/**
	 * 角色编码
	 */
	private String roleCode;

	/**
	 * 权限编码
	 */
	private String permissionCode;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

}