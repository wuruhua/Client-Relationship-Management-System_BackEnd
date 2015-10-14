package com.crm.cust.dao.impl;

import java.util.List;
import java.util.Map;
import com.crm.common.dao.BaseHibernateDAO;
import com.crm.common.entity.CstActivity;
import com.crm.cust.dao.ActivityDao;


public class ActivityDaoImpl extends BaseHibernateDAO implements ActivityDao {

	public boolean addCstActivity(CstActivity condition) {

		return this.add(condition);
	}

	// 删除交往记录
	public boolean delCstActivity(CstActivity condition) {
		return this.delete(condition);
	}

	// 根据交往记录编号获取交往记录
	@SuppressWarnings("unchecked")
	public CstActivity getCstActivityById(Integer id) {
		CstActivity activity = null;
		List list = null;
		String hql = "select s from CstActivity s where s.atvId='" + id + "'";
		list = this.list_params(hql, null);
		if (list != null && list.size() > 0) {
			activity = (CstActivity) this.list_params(hql, null).get(0);
		}
		return activity;
	}

	public CstActivity loadCstActivity(String id) {

		return null;
	}

	@SuppressWarnings("unchecked")
	public List searchAll(CstActivity condition, String id) {
		Map params = null;
		String hql = "select c from CstActivity c where c.cstCustomer.custNo='"
				+ id + "'";
		return this.list_params_M(hql, params);
	}

	public boolean updateCstActivity(CstActivity condition) {

		return this.update(condition);
	}

}
