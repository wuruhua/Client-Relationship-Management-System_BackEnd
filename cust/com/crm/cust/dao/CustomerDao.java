package com.crm.cust.dao;

import java.util.List;
import com.crm.common.entity.CstCustomer;
import com.crm.util.Page;

public interface CustomerDao {

	// 添加
	public boolean addCstCustomer(CstCustomer condition);

	// 删除
	public boolean delCstCustomer(CstCustomer condition);

	// 修改
	public boolean updateCstCustomer(CstCustomer condition);

	// 加载
	public CstCustomer loadCstCustomer(String id);

	// 根据条件实现分页查询
	@SuppressWarnings("unchecked")
	public List searchPage(Page page, CstCustomer condition);

	// 按其他条件查询
	@SuppressWarnings("unchecked")
	public List searchCstCustomer(CstCustomer condition);

	// 统计数据
	public Integer getCount(CstCustomer condition);

	@SuppressWarnings("unchecked")
	public List getList(String hql);
}
