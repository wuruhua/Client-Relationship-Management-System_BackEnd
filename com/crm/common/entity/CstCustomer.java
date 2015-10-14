package com.crm.common.entity;

import java.util.ArrayList;

import java.util.List;




/**
 * 客户信息实体对象
 * 
 * @author Fiona
 * 
 */
public class CstCustomer implements java.io.Serializable {

	private static final long serialVersionUID = 8768259867647205327L;

	
	private String custNo;


	private String custName;

	private String custRegion;

	private Integer custManagerId;

	private String custManagerName;

	private Integer custLevel;

	private String custLevelLabel;

	private Integer custSatisfy;

	private Integer custCredit;

	private String custAddr;

	private String custZip;

	private String custTel;

	private String custFax;

	private String custWebsite;

	private String custLicenceNo;

	private String custChieftain;

	private Integer custBankroll;

	private Integer custTurnover;

	private String custBank;

	private String custBankAccount;

	private String custLocalTaxNo;

	private String custNationalTaxNo;

	private String custStatus;

	@SuppressWarnings("unchecked")
	private List cstServices = new ArrayList();

	@SuppressWarnings("unchecked")
	private List cstLinkmans = new ArrayList();

	@SuppressWarnings("unchecked")
	private List cstActivities = new ArrayList();

	@SuppressWarnings("unchecked")
	private List cstLosts = new ArrayList();

    private List cstOders=new ArrayList();

	public List getCstOders() {
		return cstOders;
	}

	public void setCstOders(List cstOders) {
		this.cstOders = cstOders;
	}

	public CstCustomer() {
	}

	public CstCustomer(String custName) {
		this.custName = custName;
	}

	@SuppressWarnings("unchecked")
	public CstCustomer(String custName, String custRegion,
			Integer custManagerId, String custManagerName, Integer custLevel,
			String custLevelLabel, Integer custSatisfy, Integer custCredit,
			String custAddr, String custZip, String custTel, String custFax,
			String custWebsite, String custLicenceNo, String custChieftain,
			Integer custBankroll, Integer custTurnover, String custBank,
			String custBankAccount, String custLocalTaxNo,
			String custNationalTaxNo, String custStatus, List cstServices,
			List cstLinkmans, List cstActivities, List cstLosts,List cstOders) {
		this.custName = custName;
		this.custRegion = custRegion;
		this.custManagerId = custManagerId;
		this.custManagerName = custManagerName;
		this.custLevel = custLevel;
		this.custLevelLabel = custLevelLabel;
		this.custSatisfy = custSatisfy;
		this.custCredit = custCredit;
		this.custAddr = custAddr;
		this.custZip = custZip;
		this.custTel = custTel;
		this.custFax = custFax;
		this.custWebsite = custWebsite;
		this.custLicenceNo = custLicenceNo;
		this.custChieftain = custChieftain;
		this.custBankroll = custBankroll;
		this.custTurnover = custTurnover;
		this.custBank = custBank;
		this.custBankAccount = custBankAccount;
		this.custLocalTaxNo = custLocalTaxNo;
		this.custNationalTaxNo = custNationalTaxNo;
		this.custStatus = custStatus;
		this.cstServices = cstServices;
		this.cstLinkmans = cstLinkmans;
		this.cstActivities = cstActivities;
		this.cstLosts = cstLosts;
		this.cstOders=cstOders;
	}



	public String getCustNo() {
		return this.custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustRegion() {
		return this.custRegion;
	}

	public void setCustRegion(String custRegion) {
		this.custRegion = custRegion;
	}

	public Integer getCustManagerId() {
		return this.custManagerId;
	}

	public void setCustManagerId(Integer custManagerId) {
		this.custManagerId = custManagerId;
	}

	public String getCustManagerName() {
		return this.custManagerName;
	}

	public void setCustManagerName(String custManagerName) {
		this.custManagerName = custManagerName;
	}

	public Integer getCustLevel() {
		return this.custLevel;
	}

	public void setCustLevel(Integer custLevel) {
		this.custLevel = custLevel;
	}

	public String getCustLevelLabel() {
		return this.custLevelLabel;
	}

	public void setCustLevelLabel(String custLevelLabel) {
		this.custLevelLabel = custLevelLabel;
	}

	public Integer getCustSatisfy() {
		return this.custSatisfy;
	}

	public void setCustSatisfy(Integer custSatisfy) {
		this.custSatisfy = custSatisfy;
	}

	public Integer getCustCredit() {
		return this.custCredit;
	}

	public void setCustCredit(Integer custCredit) {
		this.custCredit = custCredit;
	}

	public String getCustAddr() {
		return this.custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public String getCustZip() {
		return this.custZip;
	}

	public void setCustZip(String custZip) {
		this.custZip = custZip;
	}

	public String getCustTel() {
		return this.custTel;
	}

	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}

	public String getCustFax() {
		return this.custFax;
	}

	public void setCustFax(String custFax) {
		this.custFax = custFax;
	}

	public String getCustWebsite() {
		return this.custWebsite;
	}

	public void setCustWebsite(String custWebsite) {
		this.custWebsite = custWebsite;
	}

	public String getCustLicenceNo() {
		return this.custLicenceNo;
	}

	public void setCustLicenceNo(String custLicenceNo) {
		this.custLicenceNo = custLicenceNo;
	}

	public String getCustChieftain() {
		return this.custChieftain;
	}

	public void setCustChieftain(String custChieftain) {
		this.custChieftain = custChieftain;
	}

	public Integer getCustBankroll() {
		return this.custBankroll;
	}

	public void setCustBankroll(Integer custBankroll) {
		this.custBankroll = custBankroll;
	}

	public Integer getCustTurnover() {
		return this.custTurnover;
	}

	public void setCustTurnover(Integer custTurnover) {
		this.custTurnover = custTurnover;
	}

	public String getCustBank() {
		return this.custBank;
	}

	public void setCustBank(String custBank) {
		this.custBank = custBank;
	}

	public String getCustBankAccount() {
		return this.custBankAccount;
	}

	public void setCustBankAccount(String custBankAccount) {
		this.custBankAccount = custBankAccount;
	}

	public String getCustLocalTaxNo() {
		return this.custLocalTaxNo;
	}

	public void setCustLocalTaxNo(String custLocalTaxNo) {
		this.custLocalTaxNo = custLocalTaxNo;
	}

	public String getCustNationalTaxNo() {
		return this.custNationalTaxNo;
	}

	public void setCustNationalTaxNo(String custNationalTaxNo) {
		this.custNationalTaxNo = custNationalTaxNo;
	}

	public String getCustStatus() {
		return this.custStatus;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}

	@SuppressWarnings("unchecked")
	public List getCstServices() {
		return this.cstServices;
	}

	@SuppressWarnings("unchecked")
	public void setCstServices(List cstServices) {
		this.cstServices = cstServices;
	}

	@SuppressWarnings("unchecked")
	public List getCstLinkmans() {
		return this.cstLinkmans;
	}

	@SuppressWarnings("unchecked")
	public void setCstLinkmans(List cstLinkmans) {
		this.cstLinkmans = cstLinkmans;
	}

	@SuppressWarnings("unchecked")
	public List getCstActivities() {
		return this.cstActivities;
	}

	@SuppressWarnings("unchecked")
	public void setCstActivities(List cstActivities) {
		this.cstActivities = cstActivities;
	}

	@SuppressWarnings("unchecked")
	public List getCstLosts() {
		return this.cstLosts;
	}

	@SuppressWarnings("unchecked")
	public void setCstLosts(List cstLosts) {
		this.cstLosts = cstLosts;
	}

}