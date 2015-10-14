package com.crm.basd.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.basd.dao.ProductDao;
import com.crm.common.dao.BaseHibernateDAO;
import com.crm.common.entity.Product;
import com.crm.util.Page;

public class ProductDaoImple extends BaseHibernateDAO implements ProductDao {

	/**
	 * 根据条件实现分页查询产品信息
	 */
	@SuppressWarnings("unchecked")
	public List searchProductPage(Page page, Product condition) {
		List list = null;
		Map params = new HashMap();
		String hql = "select p from  Product p where 1=1";
		if (condition != null) {
			if (condition.getProdName() != null
					&& !condition.getProdName().trim().equals("")) {
				hql += " and p.prodName like:prodName";
				params.put("prodName", "%" + condition.getProdName() + "%");
			}
			if (condition.getProdType() != null
					&& !condition.getProdType().trim().equals("")) {
				hql += " and p.prodType like:prodType";
				params.put("prodType", "%" + condition.getProdType() + "%");
			}
			if (condition.getProdBatch() != null
					&& !condition.getProdBatch().trim().equals("")) {
				hql += " and p.prodBatch like:prodBatch";
				params.put("prodBatch", "%" + condition.getProdBatch() + "%");
			}
		}
		list = super.searchPage(page, hql, params);
		return list;
	}

	// 统计产品信息数据
	@SuppressWarnings("unchecked")
	public Integer getCount(Product condition) {
		Integer count = 0;
		Map params = new HashMap();
		String hql = "select count(p) from  Product p where 1=1";
		if (condition != null) {
			if (condition.getProdName() != null
					&& !condition.getProdName().equals("")) {
				hql += " and p.prodName like:prodName";
				params.put("prodName", "%" + condition.getProdName() + "%");
			}
			if (condition.getProdType() != null
					&& !condition.getProdType().equals("")) {
				hql += " and p.prodType like:prodType";
				params.put("prodType", "%" + condition.getProdType() + "%");
			}
			if (condition.getProdBatch() != null
					&& !condition.getProdBatch().equals("")) {
				hql += " and p.prodBatch like:prodBatch";
				params.put("prodBatch", "%" + condition.getProdBatch() + "%");
			}
		}
		count = super.getCount(hql, params);
		return count;
	}

}
