package com.crm.common.entity;

/**
 * 数据库字典实体对象
 * 
 * @author Fiona
 */
@SuppressWarnings("serial")
public class BasDict implements java.io.Serializable {

	private Integer dictId;
	private String dictType;
	private String dictItem;
	private String dictValue;
	private Boolean dictIsEditable;

	public BasDict() {
	}

	public BasDict(String dictType, String dictItem, String dictValue,
			Boolean dictIsEditable) {
		this.dictType = dictType;
		this.dictItem = dictItem;
		this.dictValue = dictValue;
		this.dictIsEditable = dictIsEditable;
	}

	public Integer getDictId() {
		return this.dictId;
	}

	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}

	public String getDictType() {
		return this.dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictItem() {
		return this.dictItem;
	}

	public void setDictItem(String dictItem) {
		this.dictItem = dictItem;
	}

	public String getDictValue() {
		return this.dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	public Boolean getDictIsEditable() {
		return this.dictIsEditable;
	}

	public void setDictIsEditable(Boolean dictIsEditable) {
		this.dictIsEditable = dictIsEditable;
	}

}