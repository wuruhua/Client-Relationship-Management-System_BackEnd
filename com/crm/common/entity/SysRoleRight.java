package com.crm.common.entity;

/**
 * ��ɫʵ������Ȩ��ʵ�����Ĺ�������
 * 
 *@author Fiona
 * 
 */
public class SysRoleRight implements java.io.Serializable {

	private static final long serialVersionUID = -5339189492766129750L;
	private Integer rfId;
	private String rfRightCode;// Ȩ�ޱ��
	private Integer rfRoleId;// ��ɫ���

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