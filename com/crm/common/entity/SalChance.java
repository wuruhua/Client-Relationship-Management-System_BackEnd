package com.crm.common.entity;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 销售机会实体对象
 * 
 * @author Fiona
 * 
 */
public class SalChance implements java.io.Serializable {

	private static final long serialVersionUID = -3010180767763164464L;
	private Integer chcId;
	private String chcSource;
	private String chcCustName;
	private String chcTitle;
	private Integer chcRate;
	private String chcLinkman;
	private String chcTel;
	private String chcDesc;
	private Integer chcCreateId;
	private String chcCreateBy;
	private Date chcCreateDate;
	private Integer chcDueId;
	private String chcDueTo;
	private Date chcDueDate;
	private String chcStatus;
	@SuppressWarnings("unchecked")
	private List salPlans = new ArrayList();

	public SalChance() {
	}

	public SalChance(String chcCustName, String chcTitle, Integer chcRate,
			String chcDesc, Integer chcCreateId, String chcCreateBy,
			Date chcCreateDate, String chcStatus) {
		this.chcCustName = chcCustName;
		this.chcTitle = chcTitle;
		this.chcRate = chcRate;
		this.chcDesc = chcDesc;
		this.chcCreateId = chcCreateId;
		this.chcCreateBy = chcCreateBy;
		this.chcCreateDate = chcCreateDate;
		this.chcStatus = chcStatus;
	}

	@SuppressWarnings("unchecked")
	public SalChance(String chcSource, String chcCustName, String chcTitle,
			Integer chcRate, String chcLinkman, String chcTel, String chcDesc,
			Integer chcCreateId, String chcCreateBy, Date chcCreateDate,
			Integer chcDueId, String chcDueTo, Date chcDueDate,
			String chcStatus, List salPlans) {
		this.chcSource = chcSource;
		this.chcCustName = chcCustName;
		this.chcTitle = chcTitle;
		this.chcRate = chcRate;
		this.chcLinkman = chcLinkman;
		this.chcTel = chcTel;
		this.chcDesc = chcDesc;
		this.chcCreateId = chcCreateId;
		this.chcCreateBy = chcCreateBy;
		this.chcCreateDate = chcCreateDate;
		this.chcDueId = chcDueId;
		this.chcDueTo = chcDueTo;
		this.chcDueDate = chcDueDate;
		this.chcStatus = chcStatus;
		this.salPlans = salPlans;
	}

	public Integer getChcId() {
		return this.chcId;
	}

	public void setChcId(Integer chcId) {
		this.chcId = chcId;
	}

	public String getChcSource() {
		return this.chcSource;
	}

	public void setChcSource(String chcSource) {
		this.chcSource = chcSource;
	}

	public String getChcCustName() {
		return this.chcCustName;
	}

	public void setChcCustName(String chcCustName) {
		this.chcCustName = chcCustName;
	}

	public String getChcTitle() {
		return this.chcTitle;
	}

	public void setChcTitle(String chcTitle) {
		this.chcTitle = chcTitle;
	}

	public Integer getChcRate() {
		return this.chcRate;
	}

	public void setChcRate(Integer chcRate) {
		this.chcRate = chcRate;
	}

	public String getChcLinkman() {
		return this.chcLinkman;
	}

	public void setChcLinkman(String chcLinkman) {
		this.chcLinkman = chcLinkman;
	}

	public String getChcTel() {
		return this.chcTel;
	}

	public void setChcTel(String chcTel) {
		this.chcTel = chcTel;
	}

	public String getChcDesc() {
		return this.chcDesc;
	}

	public void setChcDesc(String chcDesc) {
		this.chcDesc = chcDesc;
	}

	public Integer getChcCreateId() {
		return this.chcCreateId;
	}

	public void setChcCreateId(Integer chcCreateId) {
		this.chcCreateId = chcCreateId;
	}

	public String getChcCreateBy() {
		return this.chcCreateBy;
	}

	public void setChcCreateBy(String chcCreateBy) {
		this.chcCreateBy = chcCreateBy;
	}

	public Date getChcCreateDate() {
		return this.chcCreateDate;
	}

	public void setChcCreateDate(Date chcCreateDate) {
		this.chcCreateDate = chcCreateDate;
	}

	public Integer getChcDueId() {
		return this.chcDueId;
	}

	public void setChcDueId(Integer chcDueId) {
		this.chcDueId = chcDueId;
	}

	public String getChcDueTo() {
		return this.chcDueTo;
	}

	public void setChcDueTo(String chcDueTo) {
		this.chcDueTo = chcDueTo;
	}

	public Date getChcDueDate() {
		return this.chcDueDate;
	}

	public void setChcDueDate(Date chcDueDate) {
		this.chcDueDate = chcDueDate;
	}

	public String getChcStatus() {
		return this.chcStatus;
	}

	public void setChcStatus(String chcStatus) {
		this.chcStatus = chcStatus;
	}

	@SuppressWarnings("unchecked")
	public List getSalPlans() {
		return this.salPlans;
	}

	@SuppressWarnings("unchecked")
	public void setSalPlans(List salPlans) {
		this.salPlans = salPlans;
	}

}