package com.crm.cust.dao;

import java.util.List;
import com.crm.common.entity.CstActivity;

public interface ActivityDao {
	//增加
	public boolean addCstActivity(CstActivity condition);

	// 删除XXX
	public boolean delCstActivity(CstActivity condition);

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
