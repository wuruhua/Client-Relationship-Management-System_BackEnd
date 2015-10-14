package com.crm.cust.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.crm.common.dao.BaseHibernateDAO;
import com.crm.common.entity.CstCustomer;
import com.crm.cust.dao.CustomerDao;
import com.crm.util.Page;

public class CustomerDaoImpl extends BaseHibernateDAO implements CustomerDao {

	/**
	 * 添加
	 */
	public boolean addCstCustomer(CstCustomer condition) {
		boolean add = super.add(condition);
		return add;
	}

	/**
	 * 删除
	 */
	public boolean delCstCustomer(CstCustomer condition) {
		boolean del = super.delete(condition);
		return del;
	}

	/**
	 * 加载
	 */
	public CstCustomer loadCstCustomer(String id) {
		return (CstCustomer) this.load(CstCustomer.class, id);
	}

	/**
	 * 查询指定条件的数据
	 */
	@SuppressWarnings( { "unchecked" })
	public List searchCstCustomer(CstCustomer condition) {
		Map params = null;
		String hql = "select s from CstCustomer s where 1=1";
		if (condition != null) {
			if (condition.getCustNo() != null) {
				hql += " and s.custNo=:custNo";
				params = new HashMap();
				params.put("custNo", condition.getCustNo());
			}
			
		}
		return this.list_params_M(hql, params);// 调用基类通用方法
	}

	/**
	 * 根据指定条件查询数据，并实现分页
	 */
	@SuppressWarnings( { "unchecked" })
	public List searchPage(Page page, CstCustomer condition) {
		List list = null;
		Map params  = new HashMap();
		String hql = "select c from CstCustomer c where 1=1";
		if (condition != null) {
			if (condition.getCustNo() != null
					&& !condition.getCustNo().equals("")) {
				hql += " and c.custNo like :custNo";
				params.put("custNo", "%" + condition.getCustNo().trim() + "%");// 设置参数
			}
			if (condition.getCustName() != null
					&& !condition.getCustName().equals("")) {
				hql += " and c.custName like :custName";
				params.put("custName", "%" + condition.getCustName().trim() + "%");
			}
			if (condition.getCustRegion() != null
					&& !condition.getCustRegion().equals("-1")) {
				hql += " and c.custRegion = :custRegion";
				params.put("custRegion", condition.getCustRegion());
			}
			if (condition.getCustManagerName() != null
					&& !condition.getCustManagerName().equals("")) {
				hql += " and c.custManagerName like :custManagerName";
				params.put("custManagerName", "%"
						+ condition.getCustManagerName().trim() + "%");
			}
			if (condition.getCustLevel() != null
					&& !condition.getCustLevel().equals(0)) {
				hql += " and c.custLevel = :custLevel";
				params.put("custLevel", condition.getCustLevel());
			}
		}
		list = this.searchPage(page, hql, params);// 调用基类通用方法
		return list;
	}

	/**
	 * 更新
	 */
	public boolean updateCstCustomer(CstCustomer condition) {

		return super.update(condition);
	}

	/**
	 * 根据条件获取总记录数
	 */
	@SuppressWarnings("unchecked")
	public Integer getCount(CstCustomer condition) {
		Map params = new HashMap();
		Integer count = null;
		String hql = "select count(c) from CstCustomer c where 1=1";
		if (condition != null) {
			if (condition.getCustNo() != null
					&& !condition.getCustNo().equals("")) {
				hql += " and c.custNo like :custNo";
				params.put("custNo", "%" + condition.getCustNo().trim() + "%");
			}
			if (condition.getCustName() != null
					&& !condition.getCustName().equals("")) {
				hql += " and c.custName like :custName";
				params.put("custName", "%" + condition.getCustName().trim() + "%");
			}
			if (condition.getCustRegion() != null
					&& !condition.getCustRegion().equals("-1")) {
				hql += " and c.custRegion = :custRegion";
				params.put("custRegion", condition.getCustRegion());
			}
			if (condition.getCustManagerName() != null
					&& !condition.getCustManagerName().equals("")) {
				hql += " and c.custManagerName like :custManagerName";
				params.put("custManagerName", "%"
						+ condition.getCustManagerName().trim() + "%");
			}
			if (condition.getCustLevel() != null
					&& !condition.getCustLevel().equals(0)) {
				hql += " and c.custLevel = :custLevel";
				params.put("custLevel", condition.getCustLevel());
			}
		}
		count = this.getCount(hql, params);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List getList(String hql) {
		return this.list_params(hql, null);
	}
}
