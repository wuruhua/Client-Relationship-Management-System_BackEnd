package com.crm.common.entity;

/**
 * 角色实体对象和权限实体对象的关联对象
 * 
 *@author Fiona
 * 
 */
public class SysRoleRight implements java.io.Serializable {

	private static final long serialVersionUID = -5339189492766129750L;
	private Integer rfId;
	private String rfRightCode;// 权限编号
	private Integer rfRoleId;// 角色编号

	public SysRoleRight() {
	}

	public SysRoleRight(String rfRightCode, Integer rfRoleId) {
		this.rfRightCode = rfRightCode;
		this.rfRoleId = rfRoleId;
	}

	public Integer getRfId() {
		return rfId;
	}

	public void setRfId(Integer rfId) {
		this.rfId = rfId;
	}

	public String getRfRightCode() {
		return rfRightCode;
	}

	public void setRfRightCode(String rfRightCode) {
		this.rfRightCode = rfRightCode;
	}

	public Integer getRfRoleId() {
		return rfRoleId;
	}

	public void setRfRoleId(Integer rfRoleId) {
		this.rfRoleId = rfRoleId;
	}
}