package com.crm.basd.biz;

import java.util.List;

import com.crm.common.entity.Product;
import com.crm.util.Page;

public interface ProductBiz {

	// 根据产品条件实现分页查询
	@SuppressWarnings("unchecked")
	public List searchProductPage(Page page, Product condition);

	// 统计产品数据
	public Integer getCount(Product condition);

	@SuppressWarnings("unchecked")
	public List serachProductAll(Page page, Product condition);

}
