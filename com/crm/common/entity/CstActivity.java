package com.crm.common.entity;

import java.util.Date;

/**
 * 交往记录实体对象
 * @author Fiona
 * 
 * 
 */
public class CstActivity implements java.io.Serializable {

	private static final long serialVersionUID = 843151596276798411L;
	
	private Integer atvId;
	private CstCustomer cstCustomer;
	private String atvCustName;
	private Date atvDate;
	private String atvPlace;
	private String atvTitle;
	private String atvDesc;

	public CstActivity() {
	}

	public CstActivity(Date atvDate, String atvPlace, String atvTitle) {
		this.atvDate = atvDate;
		this.atvPlace = atvPlace;
		this.atvTitle = atvTitle;
	}

	public CstActivity(CstCustomer cstCustomer, String atvCustName,
			Date atvDate, String atvPlace, String atvTitle, String atvDesc) {
		this.cstCustomer = cstCustomer;
		this.atvCustName = atvCustName;
		this.atvDate = atvDate;
		this.atvPlace = atvPlace;
		this.atvTitle = atvTitle;
		this.atvDesc = atvDesc;
	}

	public Integer getAtvId() {
		return this.atvId;
	}

	public void setAtvId(Integer atvId) {
		this.atvId = atvId;
	}

	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public String getAtvCustName() {
		return this.atvCustName;
	}

	public void setAtvCustName(String atvCustName) {
		this.atvCustName = atvCustName;
	}

	public Date getAtvDate() {
		return this.atvDate;
	}

	public void setAtvDate(Date atvDate) {
		this.atvDate = atvDate;
	}

	public String getAtvPlace() {
		return this.atvPlace;
	}

	public void setAtvPlace(String atvPlace) {
		this.atvPlace = atvPlace;
	}

	public String getAtvTitle() {
		return this.atvTitle;
	}

	public void setAtvTitle(String atvTitle) {
		this.atvTitle = atvTitle;
	}

	public String getAtvDesc() {
		return this.atvDesc;
	}

	public void setAtvDesc(String atvDesc) {
		this.atvDesc = atvDesc;
	}

}