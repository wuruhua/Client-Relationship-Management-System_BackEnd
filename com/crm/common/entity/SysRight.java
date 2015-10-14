package com.crm.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Ȩ��ʵ�����
 * 
 * @author Fiona
 * 
 */
public class SysRight implements java.io.Serializable {

	private static final long serialVersionUID = -7985196623185468668L;

	private String rightCode;// Ȩ�ޱ��
	private String rightParentCode;// ���˵����
	private String rightType;// Ȩ������
	private String rightText;// Ȩ������
	private String rightUrl;// ���ӵ�ַ
	private String rightTip;// Ȩ����ģ������
	@SuppressWarnings("unchecked")
	private List roles = new ArrayList();// ��Ȩ�޵�������ɫ

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