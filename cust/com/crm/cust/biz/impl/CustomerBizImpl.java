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

	// ����
	public boolean addCstCustomer(CstCustomer condition) {
		boolean falg = true;
		try {
			falg = this.customerDao.addCstCustomer(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return falg;
	}

	// ɾ��
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

	// ����
	public CstCustomer loadCstCustomer(String id) {
		CstCustomer customer = null;
		try {
			customer = customerDao.loadCstCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	// ��ѯȫ��
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

	// ��������ʵ�ַ�ҳ��ѯ
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

	// ����
	public boolean updateCstCustomer(CstCustomer condition) {
		boolean falg = true;
		try {
			falg = this.customerDao.updateCstCustomer(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return falg;
	}

	// ͳ������
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
