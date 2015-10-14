package com.crm.basd.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.crm.basd.dao.BasdDao;
import com.crm.common.dao.BaseHibernateDAO;
import com.crm.common.entity.BasDict;
import com.crm.util.Page;

public class BasdDaoImpl extends BaseHibernateDAO implements BasdDao {

	// 新建
	public boolean addBasDict(BasDict condition) {
		return super.add(condition);
	}

	// 删除
	public boolean delBasDict(BasDict condition) {
		return super.delete(condition);
	}

	// 加载
	public BasDict getBasDict(Integer condition) {
		return (BasDict) super.load(BasDict.class, condition);
	}

	// 根据其他条件查询
	@SuppressWarnings("unchecked")
	public List searchBasDict(BasDict condition) {
		return null;
	}

	// 分页查询

	@SuppressWarnings("unchecked")
	public List searchPage(Page page, BasDict condition) {
		List list = null;
		Map params = new HashMap();
		String hql = "select b from  BasDict b where 1=1";
		if (condition != null) {
			if (condition.getDictType() != null
					&& !condition.getDictType().equals("")) {
				hql += " and b.dictType like:dictType";
				params.put("dictType", "%" + condition.getDictType() + "%");
			}
			if (condition.getDictItem() != null
					&& !condition.getDictItem().equals("")) {
				hql += " and b.dictItem like :dictItem";
				params.put("dictItem", "%" + condition.getDictItem() + "%");
			}
			if (condition.getDictValue() != null
					&& !condition.getDictValue().equals("")) {
				hql += " and b.dictValue like :dictValue";
				params.put("dictValue", "%" + condition.getDictValue() + "%");
			}
		}
		list = super.searchPage(page, hql, params);
		return list;
	}

	// 编辑
	public boolean updateBasDict(BasDict condition) {
		// TODO Auto-generated method stub
		return super.update(condition);
	}

	// 统计数据
	@SuppressWarnings("unchecked")
	public Integer getCount(BasDict condition) {
		Integer count = 0;
		Map params = new HashMap();
		String hql = "select count(b) from  BasDict b where 1=1";
		if (condition != null) {
			if (condition.getDictType() != null
					&& !condition.getDictType().equals("")) {
				hql += " and b.dictType like:dictType";
				params.put("dictType", "%" + condition.getDictType() + "%");
			}
			if (condition.getDictItem() != null
					&& !condition.getDictItem().equals("")) {
				hql += " and b.dictItem like :dictItem";
				params.put("dictItem", "%" + condition.getDictItem() + "%");
			}
			if (condition.getDictValue() != null
					&& !condition.getDictValue().equals("")) {
				hql += " and b.dictValue like :dictValue";
				params.put("dictValue", "%" + condition.getDictValue() + "%");
			}
		}
		count = super.getCount(hql, params);
		return count;
	}

	// 自动补全
	@SuppressWarnings("unchecked")
	public List findTypeByName(String tName) {
		String hql = "";
		List list = null;
		if (tName != null && !tName.equals("")) {
			hql = "select distinct d.dictType from BasDict as d where d.dictType like '%"
					+ tName + "%'";
			list = super.getHibernateTemplate().find(hql);
		}
		return list;
	}
}
