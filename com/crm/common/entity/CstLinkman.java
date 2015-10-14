package com.crm.common.entity;

/**
 * 联系人实体对象
 * 
 * @author Fiona
 * 
 */
public class CstLinkman implements java.io.Serializable {

	private static final long serialVersionUID = -3522887279037000267L;
	private Integer lkmId;
	private CstCustomer cstCustomer;

	private String lkmName;
	private String lkmSex;
	private String lkmPostion;
	private String lkmTel;
	private String lkmMobile;
	private String lkmMemo;

	public CstLinkman() {
	}

	public CstLinkman(CstCustomer cstCustomer, String lkmName, String lkmTel) {
		this.cstCustomer = cstCustomer;
		this.lkmName = lkmName;
		this.lkmTel = lkmTel;
	}

	public CstLinkman(CstCustomer cstCustomer,
			String lkmName, String lkmSex, String lkmPostion, String lkmTel,
			String lkmMobile, String lkmMemo) {
		this.cstCustomer = cstCustomer;

		this.lkmName = lkmName;
		this.lkmSex = lkmSex;
		this.lkmPostion = lkmPostion;
		this.lkmTel = lkmTel;
		this.lkmMobile = lkmMobile;
		this.lkmMemo = lkmMemo;
	}

	public Integer getLkmId() {
		return this.lkmId;
	}

	public void setLkmId(Integer lkmId) {
		this.lkmId = lkmId;
	}

	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}


	public String getLkmName() {
		return this.lkmName;
	}

	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}

	public String getLkmSex() {
		return this.lkmSex;
	}

	public void setLkmSex(String lkmSex) {
		this.lkmSex = lkmSex;
	}

	public String getLkmPostion() {
		return this.lkmPostion;
	}

	public void setLkmPostion(String lkmPostion) {
		this.lkmPostion = lkmPostion;
	}

	public String getLkmTel() {
		return this.lkmTel;
	}

	public void setLkmTel(String lkmTel) {
		this.lkmTel = lkmTel;
	}

	public String getLkmMobile() {
		return this.lkmMobile;
	}

	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}

	public String getLkmMemo() {
		return this.lkmMemo;
	}

	public void setLkmMemo(String lkmMemo) {
		this.lkmMemo = lkmMemo;
	}

}