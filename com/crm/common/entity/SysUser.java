package com.crm.common.entity;

import java.util.Date;

/**
 * 用户实体对象
 * 
 * @author Fiona
 * 
 */
public class SysUser implements java.io.Serializable {

	private static final long serialVersionUID = -4334089105096492937L;
	private Integer usrId;
	private SysRole sysRole;// 角色对象
	private String usrName;// 用户名
	private String usrPassword;// 用户密码
	private Integer usrFlag;// 用户状态
	private Date usrRegtime;// 注册时间
	private Integer usrSex;// 性别

	public SysUser() {
	}

	public SysUser(String usrName, String usrPassword, Integer usrFlag) {
		this.usrName = usrName;
		this.usrPassword = usrPassword;
		this.usrFlag = usrFlag;
	}

	public SysUser(SysRole sysRole, String usrName, String usrPassword,
			Integer usrFlag) {
		this.sysRole = sysRole;
		this.usrName = usrName;
		this.usrPassword = usrPassword;
		this.usrFlag = usrFlag;
	}
	
	
	public Integer getUsrSex() {
		return usrSex;
	}

	public void setUsrSex(Integer usrSex) {
		this.usrSex = usrSex;
	}

	public Date getUsrRegtime() {
		return usrRegtime;
	}

	public void setUsrRegtime(Date usrRegtime) {
		this.usrRegtime = usrRegtime;
	}
	
	public Integer getUsrId() {
		return this.usrId;
	}

	public void setUsrId(Integer usrId) {
		this.usrId = usrId;
	}

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public String getUsrName() {
		return this.usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrPassword() {
		return this.usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public Integer getUsrFlag() {
		return this.usrFlag;
	}

	public void setUsrFlag(Integer usrFlag) {
		this.usrFlag = usrFlag;
	}

}