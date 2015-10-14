package com.crm.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品信息实体对象
 * 
 * @author Fiona
 * 
 */
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = -3180046059826559931L;
	private Integer prodId;
	private String prodName;
	private String prodType;
	private String prodBatch;
	private String prodUnit;
	private Double prodPrice;
	private String prodMemo;
	@SuppressWarnings("unchecked")
	private List orderLines = new ArrayList();
	@SuppressWarnings("unchecked")
	private List storages = new ArrayList();

	public Product() {
	}

	public Product(String prodName, String prodType) {
		this.prodName = prodName;
		this.prodType = prodType;
	}

	@SuppressWarnings("unchecked")
	public Product(String prodName, String prodType, String prodBatch,
			String prodUnit, Double prodPrice, String prodMemo,
			List orderLines, List storages) {
		this.prodName = prodName;
		this.prodType = prodType;
		this.prodBatch = prodBatch;
		this.prodUnit = prodUnit;
		this.prodPrice = prodPrice;
		this.prodMemo = prodMemo;
		this.orderLines = orderLines;
		this.storages = storages;
	}

	public Integer getProdId() {
		return this.prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdType() {
		return this.prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public String getProdBatch() {
		return this.prodBatch;
	}

	public void setProdBatch(String prodBatch) {
		this.prodBatch = prodBatch;
	}

	public String getProdUnit() {
		return this.prodUnit;
	}

	public void setProdUnit(String prodUnit) {
		this.prodUnit = prodUnit;
	}

	public Double getProdPrice() {
		return this.prodPrice;
	}

	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdMemo() {
		return this.prodMemo;
	}

	public void setProdMemo(String prodMemo) {
		this.prodMemo = prodMemo;
	}

	@SuppressWarnings("unchecked")
	public List getOrderLines() {
		return this.orderLines;
	}

	@SuppressWarnings("unchecked")
	public void setOrderLines(List orderLines) {
		this.orderLines = orderLines;
	}

	@SuppressWarnings("unchecked")
	public List getStorages() {
		return this.storages;
	}

	@SuppressWarnings("unchecked")
	public void setStorages(List storages) {
		this.storages = storages;
	}

}