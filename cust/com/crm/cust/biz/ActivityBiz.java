package com.crm.cust.biz;

import java.util.List;

import com.crm.common.entity.CstActivity;

public interface ActivityBiz {
	//增加
	public boolean addCstActivity(CstActivity condition);

	// 删除XXX
	public boolean delCstActivity(Integer condition);

	// 修改XXX
	public boolean updateCstActivity(CstActivity condition);

	// 查询全部
	@SuppressWarnings("unchecked")
	public List searchAll(CstActivity condition,String id);
	// 加载
	public CstActivity loadCstActivity(String id);
	
	//根据编号获取联系人信息
	public CstActivity getCstActivityById(Integer id);

}
