package com.crm.basd.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.basd.dao.StorageDao;
import com.crm.common.dao.BaseHibernateDAO;
import com.crm.common.entity.Storage;
import com.crm.util.Page;

public class StorageDaoImple extends BaseHibernateDAO implements StorageDao {

	public Storage getStorage(Integer condition) {
		// TODO Auto-generated method stub
		return (Storage) super.load(Storage.class, condition);
	}

	/**
	 * 根据条件实现分页查询库存
	 */
	@SuppressWarnings("unchecked")
	public List searchStoragePage(Page page, Storage condition) {
		List list = null;
		Map params = new HashMap();
		String hql = "select s from  Storage s where 1=1";
		if (condition != null) {
			if (condition.getProduct().getProdName() != null
					&& !condition.getProduct().getProdName().trim().equals("")) {
				hql += " and s.product.prodName like :product";
				params.put("product", "%" + condition.getProduct().getProdName() + "%");
			}
			
			if (condition.getStkWarehouse() != null
					&& !condition.getStkWarehouse().trim().equals("")) {
				hql += " and s.stkWarehouse like :stkWarehouse";
				params.put("stkWarehouse", "%" + condition.getStkWarehouse()
						+ "%");
			}

		}
		list = super.searchPage(page, hql, params);
		return list;
	}

	// 统计库存数据
	@SuppressWarnings("unchecked")
	public Integer getCount(Storage condition) {
		Integer count = 0;
		Map params = new HashMap();
		String hql = "select count(s) from  Storage s where 1=1";
		if (condition != null) {
			if (condition.getProduct() != null
					&& !condition.getProduct().equals("")) {
				hql += " and s.product.prodName like :product";
				params.put("product", "%" + condition.getProduct().getProdName() + "%");
			}
			if (condition.getStkWarehouse() != null
					&& !condition.getStkWarehouse().trim().equals("")) {
				hql += " and s.stkWarehouse like :stkWarehouse";
				params.put("stkWarehouse", "%" + condition.getStkWarehouse()
						+ "%");
			}

		}
		count = super.getCount(hql, params);
		return count;
	}

}
