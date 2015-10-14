package com.crm.cust.biz.impl;

import java.util.Date;
import java.util.List;

import com.crm.common.entity.CstActivity;
import com.crm.cust.biz.ActivityBiz;
import com.crm.cust.dao.ActivityDao;

public class ActivityBizImpl implements ActivityBiz {
	ActivityDao activityDao;

	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	// 新建交往记录
	public boolean addCstActivity(CstActivity condition) {
		boolean flag = true;
		try {
			condition.setAtvDate(new Date());// 获取当前系统时间
			flag = activityDao.addCstActivity(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
    //删除交往记录
	public boolean delCstActivity(Integer activityId) {
		boolean flag=true;
		try{
			CstActivity ac=this.getCstActivityById(activityId);
			flag=this.activityDao.delCstActivity(ac);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	public CstActivity getCstActivityById(Integer id) {
		CstActivity activity=null;
		try{
			activity=this.activityDao.getCstActivityById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return activity;
	}

	public CstActivity loadCstActivity(String id) {
		CstActivity activity=null;
		try{	
		}catch(Exception e){
			this.activityDao.loadCstActivity(id);
		}
		return activity;
	}

	@SuppressWarnings("unchecked")
	public List searchAll(CstActivity condition, String id) {
		List list =null;
		try{
			list = this.activityDao.searchAll(condition, id);
		}catch(Exception e){
			e.printStackTrace();
		}	
		return list;
	}

	public boolean updateCstActivity(CstActivity condition) {
		boolean falg = true;
		try {
			falg = this.activityDao.updateCstActivity(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return falg;
	}

}
