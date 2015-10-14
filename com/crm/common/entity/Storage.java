package com.crm.common.entity;


/**
 * 库存实体对象
 * @author Fiona
 *
 */
public class Storage implements java.io.Serializable {

	private static final long serialVersionUID = -5952888451052212411L;
	private Integer stkId;
	private Product product;
	private String stkWarehouse;
	private String stkWare;
	private Integer stkCount;
	private String stkMemo;

	public Storage() {
	}

	public Storage(Product product, String stkWarehouse, String stkWare,
			Integer stkCount) {
		this.product = product;
		this.stkWarehouse = stkWarehouse;
		this.stkWare = stkWare;
		this.stkCount = stkCount;
	}

	public Storage(Product product, String stkWarehouse, String stkWare,
			Integer stkCount, String stkMemo) {
		this.product = product;
		this.stkWarehouse = stkWarehouse;
		this.stkWare = stkWare;
		this.stkCount = stkCount;
		this.stkMemo = stkMemo;
	}

	public Integer getStkId() {
		return this.stkId;
	}

	public void setStkId(Integer stkId) {
		this.stkId = stkId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getStkWarehouse() {
		return this.stkWarehouse;
	}

	public void setStkWarehouse(String stkWarehouse) {
		this.stkWarehouse = stkWarehouse;
	}

	public String getStkWare() {
		return this.stkWare;
	}

	public void setStkWare(String stkWare) {
		this.stkWare = stkWare;
	}

	public Integer getStkCount() {
		return this.stkCount;
	}

	public void setStkCount(Integer stkCount) {
		this.stkCount = stkCount;
	}

	public String getStkMemo() {
		return this.stkMemo;
	}

	public void setStkMemo(String stkMemo) {
		this.stkMemo = stkMemo;
	}

}