package com.crm.cust.dao;

import java.util.List;
import com.crm.common.entity.OrderLine;
import com.crm.common.entity.Orders;
import com.crm.util.Page;

public interface OrdersDao {
	// ����
	public Orders loadOrders(Integer id);

	// ��������ʵ�ַ�ҳ��ѯ
	@SuppressWarnings("unchecked")
	public List searchPage(Page page, Orders condition);

	// ͳ������
	public Integer getCount(Orders condition);
	
	@SuppressWarnings("unchecked")
	public List searOrderLine(OrderLine line,Integer id);
}
