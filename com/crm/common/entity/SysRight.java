package com.crm.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限实体对象
 * 
 * @author Fiona
 * 
 */
public class SysRight implements java.io.Serializable {

	private static final long serialVersionUID = -7985196623185468668L;

	private String rightCode;// 权限编号
	private String rightParentCode;// 父菜单编号
	private String rightType;// 权限类型
	private String rightText;// 权限名称
	private String rightUrl;// 连接地址
	private String rightTip;// 权限主模块名称
	@SuppressWarnings("unchecked")
	private List roles = new ArrayList();// 该权限的所欲角色

	public SysRight() {
	}

	@SuppressWarnings("unchecked")
	public SysRight(String rightParentCode, String rightType, String rightText,
			String rightUrl, String rightTip, List roles) {
		this.rightParentCode = rightParentCode;
		this.rightType = rightType;
		this.rightText = rightText;
		this.rightUrl = rightUrl;
		this.rightTip = rightTip;
		this.roles = roles;
	}

	public String getRightCode() {
		return this.rightCode;
	}

	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}

	public String getRightParentCode() {
		return this.rightParentCode;
	}

	public void setRightParentCode(String rightParentCode) {
		this.rightParentCode = rightParentCode;
	}

	public String getRightType() {
		return this.rightType;
	}

	public void setRightType(String rightType) {
		this.rightType = rightType;
	}

	public String getRightText() {
		return this.rightText;
	}

	public void setRightText(String rightText) {
		this.rightText = rightText;
	}

	public String getRightUrl() {
		return this.rightUrl;
	}

	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}

	public String getRightTip() {
		return this.rightTip;
	}

	public void setRightTip(String rightTip) {
		this.rightTip = rightTip;
	}

	@SuppressWarnings("unchecked")
	public List getRoles() {
		return roles;
	}

	@SuppressWarnings("unchecked")
	public void setRoles(List roles) {
		this.roles = roles;
	}
}