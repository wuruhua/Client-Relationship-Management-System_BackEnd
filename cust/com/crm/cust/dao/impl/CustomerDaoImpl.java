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
	 * ���
	 */
	public boolean addCstCustomer(CstCustomer condition) {
		boolean add = super.add(condition);
		return add;
	}

	/**
	 * ɾ��
	 */
	public boolean delCstCustomer(CstCustomer condition) {
		boolean del = super.delete(condition);
		return del;
	}

	/**
	 * ����
	 */
	public CstCustomer loadCstCustomer(String id) {
		return (CstCustomer) this.load(CstCustomer.class, id);
	}

	/**
	 * ��ѯָ������������
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
		return this.list_params_M(hql, params);// ���û���ͨ�÷���
	}

	/**
	 * ����ָ��������ѯ���ݣ���ʵ�ַ�ҳ
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
				params.put("custNo", "%" + condition.getCustNo().trim() + "%");// ���ò���
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
		list = this.searchPage(page, hql, params);// ���û���ͨ�÷���
		return list;
	}

	/**
	 * ����
	 */
	public boolean updateCstCustomer(CstCustomer condition) {

		return super.update(condition);
	}

	/**
	 * ����������ȡ�ܼ�¼��
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
