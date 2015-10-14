package com.crm.cust.biz.impl;

import java.util.List;
import com.crm.common.entity.CstLinkman;
import com.crm.cust.biz.LinkmanBiz;
import com.crm.cust.dao.LinkmanDao;

public class LinkmanBizImpl implements LinkmanBiz {

	private LinkmanDao linkmanDao;

	public void setLinkmanDao(LinkmanDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}

	public boolean addCstLinkman(CstLinkman condition) {
		boolean flag = true;
		try {
			flag = this.linkmanDao.addCstLinkman(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean delCstLinkman(Integer condition) {
		boolean flag = true;
		try {
			flag = linkmanDao.delCstLinkman(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public List searchAll(CstLinkman condition, String id) {
		List list = null;
		try {
			list = linkmanDao.searchAll(condition, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateCstLinkman(CstLinkman condition) {
		boolean flag = true;
		try {
			flag = this.linkmanDao.updateCstLinkman(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 加载
	public CstLinkman loadCstLinkman(String id) {
		CstLinkman ck = null;
		try {
			ck = linkmanDao.loadCstLinkman(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ck;
	}

	// 根据编号获取联系人信息
	public CstLinkman getCstLinkmanById(Integer id) {
		CstLinkman linkman = null;
		try {
			linkman = this.linkmanDao.getCstLinkmanById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return linkman;
	}

}
