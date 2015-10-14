package com.crm.cust.biz.impl;

import java.util.List;
import com.crm.common.entity.CstCustomer;
import com.crm.cust.biz.CustomerBiz;
import com.crm.cust.dao.CustomerDao;
import com.crm.util.Page;

public class CustomerBizImpl implements CustomerBiz {

	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	// 增加
	public boolean addCstCustomer(CstCustomer condition) {
		boolean falg = true;
		try {
			falg = this.customerDao.addCstCustomer(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return falg;
	}

	// 删除
	public boolean delCstCustomer(CstCustomer condition) {
		boolean falg = true;
		try {
			CstCustomer cc = this.loadCstCustomer(condition.getCustNo());
			falg = this.customerDao.delCstCustomer(cc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return falg;

	}

	// 加载
	public CstCustomer loadCstCustomer(String id) {
		CstCustomer customer = null;
		try {
			customer = customerDao.loadCstCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	// 查询全部
	@SuppressWarnings("unchecked")
	public List searchAll(Page page, CstCustomer condition) {
		List list = null;
		try {
			list = customerDao.searchPage(page, condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 根据条件实现分页查询
	@SuppressWarnings("unchecked")
	public List searchPage(Page page, CstCustomer condition) {
		List list = null;
		try {
			
			list = customerDao.searchPage(page, condition);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 更新
	public boolean updateCstCustomer(CstCustomer condition) {
		boolean falg = true;
		try {
			falg = this.customerDao.updateCstCustomer(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return falg;
	}

	// 统计数据
	public Integer getCount(CstCustomer condition) {
		Integer count = 0;
		try {
			count = this.customerDao.getCount(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public List getList(String hql) {
		return this.customerDao.getList(hql);
	}
}
