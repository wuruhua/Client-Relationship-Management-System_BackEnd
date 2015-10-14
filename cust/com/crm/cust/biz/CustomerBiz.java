package com.crm.cust.biz;

import java.util.List;
import com.crm.common.entity.CstCustomer;
import com.crm.util.Page;

public interface CustomerBiz {

	// 增加
	public boolean addCstCustomer(CstCustomer condition);

	// 删除XXX
	public boolean delCstCustomer(CstCustomer condition);

	// 修改XXX
	public boolean updateCstCustomer(CstCustomer condition);

	// 加载
	public CstCustomer loadCstCustomer(String id);

	// 查询全部
	@SuppressWarnings("unchecked")
	public List searchAll(Page page, CstCustomer condition);

	// 根据条件实现分页查询
	@SuppressWarnings("unchecked")
	public List searchPage(Page page, CstCustomer condition);

	// 统计数据
	public Integer getCount(CstCustomer condition);

	@SuppressWarnings("unchecked")
	public List getList(String hql);
}
