package com.crm.cust.dao.impl;

import java.util.List;
import java.util.Map;
import com.crm.common.dao.BaseHibernateDAO;
import com.crm.common.entity.CstLinkman;
import com.crm.cust.dao.LinkmanDao;

public class LinkmanDaoImpl extends BaseHibernateDAO implements LinkmanDao {

	/**
	 * ����
	 */
	public boolean addCstLinkman(CstLinkman condition) {
		// TODO Auto-generated method stub
		return super.add(condition);
	}

	/**
	 * ɾ��
	 */
	public boolean delCstLinkman(Integer condition) {
		// TODO Auto-generated method stub
		return super.delete(load(CstLinkman.class, condition));
	}

	/**
	 * ��ѯ
	 */
	@SuppressWarnings("unchecked")
	public List searchAll(CstLinkman condition, String id) {
		Map params = null;
		String hql = "select s from CstLinkman s where s.cstCustomer.custNo='"
				+ id + "'";
		return this.list_params_M(hql, params);// ���û���ͨ�÷���
	}

	// ���ݱ�Ų�����Ϣ
	@SuppressWarnings("unchecked")
	public CstLinkman getCstLinkmanById(Integer id) {
		CstLinkman cstLinkman = null;
		List list = null;
		String hql = "select s from CstLinkman s where s.lkmId='" + id + "'";
		list = this.list_params(hql, null);
		if (list != null && list.size() > 0) {
			cstLinkman = (CstLinkman) this.list_params(hql, null).get(0);
		}
		return cstLinkman;
	}

	/**
	 * �޸�
	 */
	public boolean updateCstLinkman(CstLinkman condition) {
		return this.update(condition);
	}

	// ����
	@SuppressWarnings("unchecked")
	public CstLinkman loadCstLinkman(String id) {
		CstLinkman cstLinkman = null;
		List list = null;
		String hql = "select s from CstLinkman s where s.cstCustomer.custNo='"
				+ id + "'";
		list = this.list_params(hql, null);
		if (list != null && list.size() > 0) {
			cstLinkman = (CstLinkman) this.list_params(hql, null).get(0);
		}
		return cstLinkman;
	}
}
