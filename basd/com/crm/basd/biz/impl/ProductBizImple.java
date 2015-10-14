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

	// ͳ�Ʋ�Ʒ��Ϣ
	public Integer getCount(Product condition) {
		Integer count = 0;
		try {
			count = this.productDao.getCount(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	// ��������ʵ�ֲ�Ʒ�ķ�ҳ��ѯ
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

	// ��ѯ���еĲ�Ʒ
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
