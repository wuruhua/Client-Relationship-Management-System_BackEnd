package com.crm.common.entity;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单信息实体对象
 * 
 * @author Fiona
 * 
 */
public class Orders implements java.io.Serializable {

	private static final long serialVersionUID = -5601102134093980570L;
	private Integer odrId;
	private CstCustomer odrCustomer;
	private Date odrDate;
	private String odrAddr;
	private String odrStatus;
  
	
	@SuppressWarnings("unchecked")
	private List orderLines = new ArrayList();

	public Orders() {
	}

	public Orders(CstCustomer odrCustomer, Date odrDate, String odrStatus) {
		this.odrCustomer = odrCustomer;
		this.odrDate = odrDate;
		this.odrStatus = odrStatus;
	
	}

	@SuppressWarnings("unchecked")
	public Orders(CstCustomer odrCustomer, Date odrDate, String odrAddr,
			String odrStatus, List orderLines) {
		this.odrCustomer = odrCustomer;
		this.odrDate = odrDate;
		this.odrAddr = odrAddr;
		this.odrStatus = odrStatus;
		this.orderLines = orderLines;
		
	}

	public Integer getOdrId() {
		return this.odrId;
	}

	public void setOdrId(Integer odrId) {
		this.odrId = odrId;
	}

	public CstCustomer getOdrCustomer() {
		return this.odrCustomer;
	}

	public void setOdrCustomer(CstCustomer odrCustomer) {
		this.odrCustomer = odrCustomer;
	}

	public Date getOdrDate() {
		return this.odrDate;
	}

	public void setOdrDate(Date odrDate) {
		this.odrDate = odrDate;
	}

	public String getOdrAddr() {
		return this.odrAddr;
	}

	public void setOdrAddr(String odrAddr) {
		this.odrAddr = odrAddr;
	}

	public String getOdrStatus() {
		return this.odrStatus;
	}

	public void setOdrStatus(String odrStatus) {
		this.odrStatus = odrStatus;
	}

	@SuppressWarnings("unchecked")
	public List getOrderLines() {
		return this.orderLines;
	}

	@SuppressWarnings("unchecked")
	public void setOrderLines(List orderLines) {
		this.orderLines = orderLines;
	}

}