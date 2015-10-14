package com.crm.cust.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.crm.common.dao.BaseHibernateDAO;
import com.crm.common.entity.CstLost;
import com.crm.cust.dao.LostDao;
import com.crm.util.Page;

public class LostDaoImpl extends BaseHibernateDAO implements LostDao {

	public CstLost loadCstLost(Integer id) {
		return (CstLost) this.load(CstLost.class, id);
	}

	@SuppressWarnings("unchecked")
	public List searchCstLost(String condition) {
          String hql="from CstLost c where c.lstStatus=?";
//          condition="Ô¤¾¯";
		List list=getHibernateTemplate().find(hql,condition);
		return list;
		
	}

	public boolean updateCstLost(CstLost condition) {
		return super.update(condition);
	}

	@SuppressWarnings("unchecked")
	public List searchPage(Page page, CstLost condition) {
		List list = null;
		Map params = new HashMap();
		String hql = "select c from CstLost c where 1=1";
		if (condition != null) {
			if (condition.getLstCustName() != null
					&& !condition.getLstCustName().trim().equals("")) {
				hql += " and c.lstCustName like :lstCustName";
				params.put("lstCustName", "%" + condition.getLstCustName()
						+ "%");
			}
			if (condition.getLstCustManagerName() != null
					&& !condition.getLstCustManagerName().trim().equals("")) {
				hql += " and c.lstCustManagerName like :managerName";
				params.put("managerName", "%"
						+ condition.getLstCustManagerName() + "%");
			}
			if (condition.getLstStatus() != null
					&& !condition.getLstStatus().equals("0")) {
				hql += " and c.lstStatus =:status";
				params.put("status", condition.getLstStatus());
			}
		}
		list = this.searchPage(page, hql, params);
		return list;
	}

	@SuppressWarnings("unchecked")
	public Integer getCount(CstLost condition) {
		Map params = new HashMap();
		Integer count = null;
		String hql = "select count(c) from CstLost c where 1=1";
		if (condition != null) {
			if (condition.getLstCustName() != null
					&& !condition.getLstCustName().trim().equals("")) {
				hql += " and c.lstCustName like :lstCustName";
				params.put("custNo", "%" + condition.getLstCustName() + "%");
			}
			if (condition.getLstCustManagerName() != null
					&& !condition.getLstCustManagerName().trim().equals("")) {
				hql += " and c.lstCustManagerName like :managerName";
				params.put("managerName", "%"
						+ condition.getLstCustManagerName() + "%");
			}
			if (condition.getLstStatus() != null
					&& !condition.getLstStatus().equals("0")) {
				hql += " and c.lstStatus =:status";
				params.put("status", condition.getLstStatus());
			}
		}
		count = this.getCount(hql, params);
		return count;
	}

	public boolean delCstLost(CstLost condition) {
		
		return super.delete(condition);
	}
}
