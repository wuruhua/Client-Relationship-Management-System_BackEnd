package com.crm.cust.dao.impl;

import java.util.List;
import java.util.Map;
import com.crm.common.dao.BaseHibernateDAO;
import com.crm.common.entity.OrderLine;
import com.crm.common.entity.Orders;
import com.crm.cust.dao.OrdersDao;
import com.crm.util.Page;

public class OrdersDaoImpl extends BaseHibernateDAO implements OrdersDao {
	public Orders loadOrders(Integer id) {

		return (Orders) this.load(Orders.class, id);
	}

	@SuppressWarnings("unchecked")
	public Integer getCount(Orders condition) {
		Map params = null;
		Integer count = null;
		String hql = "select count(c) from Orders c where 1=1";
		count = this.getCount(hql, params);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List searchPage(Page page, Orders condition) {
		List list = null;
		Map params = null;
		String hql = "select c from Orders c where 1=1";
		list = this.searchPage(page, hql, params);// 调用基类通用方法
		return list;
	}

	@SuppressWarnings("unchecked")
	public List searOrderLine(OrderLine line,Integer id) {
		String hql= "select c from OrderLine c where c.orders.odrId="+id;
		List list=this.list_params(hql, null);
		return list;
	}
}
