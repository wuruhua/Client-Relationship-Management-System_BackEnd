package com.crm.cust.biz;

import java.util.List;

import com.crm.common.entity.CstLost;
import com.crm.util.Page;

public interface LostBiz {
	//修改
	public boolean updateCstLost(CstLost condition);

	// 加载
	public CstLost loadCstLost(Integer id);
	
	// 根据条件实现分页查询
	@SuppressWarnings("unchecked")
	public List searchPage(Page page, CstLost condition);

	// 按其他条件查询
	@SuppressWarnings("unchecked")
	public List searchCstLost(String condition);
	// 统计数据
	public Integer getCount(CstLost condition) ;
	
	public boolean delCstLost(CstLost condition);
}
