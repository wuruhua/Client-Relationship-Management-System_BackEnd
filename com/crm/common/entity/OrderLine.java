package com.crm.common.entity;

/**
 * 订单信息实体对象
 * 
 * @author Fiona
 * 
 */
public class OrderLine implements java.io.Serializable {

	private static final long serialVersionUID = -5893130836268867704L;
	private Integer oddId;
	private Orders orders;
	private Product product;
	private Integer oddCount;
	private String oddUnit;
	private Double oddPrice;

	public OrderLine() {
	}

	public OrderLine(Orders orders, Product product, Integer oddCount) {
		this.orders = orders;
		this.product = product;
		this.oddCount = oddCount;
	}

	public OrderLine(Orders orders, Product product, Integer oddCount,
			String oddUnit, Double oddPrice) {
		this.orders = orders;
		this.product = product;
		this.oddCount = oddCount;
		this.oddUnit = oddUnit;
		this.oddPrice = oddPrice;
	}

	public Integer getOddId() {
		return this.oddId;
	}

	public void setOddId(Integer oddId) {
		this.oddId = oddId;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getOddCount() {
		return this.oddCount;
	}

	public void setOddCount(Integer oddCount) {
		this.oddCount = oddCount;
	}

	public String getOddUnit() {
		return this.oddUnit;
	}

	public void setOddUnit(String oddUnit) {
		this.oddUnit = oddUnit;
	}

	public Double getOddPrice() {
		return this.oddPrice;
	}

	public void setOddPrice(Double oddPrice) {
		this.oddPrice = oddPrice;
	}

}