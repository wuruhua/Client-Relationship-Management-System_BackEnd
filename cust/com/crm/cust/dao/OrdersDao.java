package com.crm.cust.dao;

import java.util.List;
import com.crm.common.entity.OrderLine;
import com.crm.common.entity.Orders;
import com.crm.util.Page;

public interface OrdersDao {
	// 加载
	public Orders loadOrders(Integer id);

	// 根据条件实现分页查询
	@SuppressWarnings("unchecked")
	public List searchPage(Page page, Orders condition);

	// 统计数据
	public Integer getCount(Orders condition);
	
	@SuppressWarnings("unchecked")
	public List searOrderLine(OrderLine line,Integer id);
}
