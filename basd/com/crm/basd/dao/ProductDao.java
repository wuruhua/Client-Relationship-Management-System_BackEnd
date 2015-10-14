package com.crm.basd.dao;

import java.util.List;

import com.crm.common.entity.Product;
import com.crm.util.Page;

public interface ProductDao {

	// 根据产品条件实现分页查询
	@SuppressWarnings("unchecked")
	public List searchProductPage(Page page, Product condition);

	// 统计产品数据
	public Integer getCount(Product condition);

}
