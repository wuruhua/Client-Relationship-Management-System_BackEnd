package com.crm.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 角色实体对象
 * 
 * @author Fiona
 * 
 */
public class SysRole implements java.io.Serializable {

	private static final long serialVersionUID = -8860542361421408809L;
	private Integer roleId;// 角色编号
	private String roleName;// 角色名称
	private String roleDesc;// 角色描述
	private Integer roleFlag;// 角色状态
	@SuppressWarnings("unchecked")
	private List sysUsers = new ArrayList();// 该角色下的所有用户
	@SuppressWarnings("unchecked")
	private List sysRights = new ArrayList();// 该角色的所有权限
	private Date roleRegtime;// 注册时间

	public SysRole() {
	}

	public SysRole(String roleName) {
		this.roleName = roleName;
	}

	@SuppressWarnings("unchecked")
	public SysRole(String roleName, String roleDesc, Integer roleFlag,
			List sysUsers, List sysRights) {
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.roleFlag = roleFlag;
		this.sysUsers = sysUsers;
		this.sysRights = sysRights;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Integer getRoleFlag() {
		return this.roleFlag;
	}

	public void setRoleFlag(Integer roleFlag) {
		this.roleFlag = roleFlag;
	}

	@SuppressWarnings("unchecked")
	public List getSysUsers() {
		return sysUsers;
	}

	@SuppressWarnings("unchecked")
	public void setSysUsers(List sysUsers) {
		this.sysUsers = sysUsers;
	}

	@SuppressWarnings("unchecked")
	public List getSysRights() {
		return sysRights;
	}

	@SuppressWarnings("unchecked")
	public void setSysRights(List sysRights) {
		this.sysRights = sysRights;
	}

	public Date getRoleRegtime() {
		return roleRegtime;
	}

	public void setRoleRegtime(Date roleRegtime) {
		this.roleRegtime = roleRegtime;
	}

}