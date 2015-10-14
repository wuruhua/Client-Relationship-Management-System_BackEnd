package com.crm.basd.biz.impl;

import java.util.List;

import com.crm.basd.biz.ProductBiz;
import com.crm.basd.dao.ProductDao;
import com.crm.common.entity.Product;
import com.crm.util.Page;

public class ProductBizImple implements ProductBiz {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	// 统计产品信息
	public Integer getCount(Product condition) {
		Integer count = 0;
		try {
			count = this.productDao.getCount(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	// 根据条件实现产品的分页查询
	@SuppressWarnings("unchecked")
	public List searchProductPage(Page page, Product condition) {
		List list = null;
		try {
			list = this.productDao.searchProductPage(page, condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 查询所有的产品
	@SuppressWarnings("unchecked")
	public List serachProductAll(Page page, Product condition) {
		List list = null;
		try {
			list = this.productDao.searchProductPage(page, condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
