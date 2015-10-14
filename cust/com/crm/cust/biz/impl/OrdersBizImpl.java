package com.crm.cust.biz.impl;


import java.util.List;



import com.crm.common.entity.OrderLine;
import com.crm.common.entity.Orders;
import com.crm.cust.biz.OrdersBiz;
import com.crm.cust.dao.OrdersDao;
import com.crm.util.Page;

public class OrdersBizImpl implements OrdersBiz {

	private OrdersDao ordersDao;

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	


	public Orders loadOrders(Integer id) {

		Orders orders = null;
		try {
			orders = this.ordersDao.loadOrders(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	public Integer getCount(Orders condition) {
		Integer count = 0;
		try {
			count = this.ordersDao.getCount(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public List searchPage(Page page, Orders condition) {
		List list = null;
		try {
			list = this.ordersDao.searchPage(page, condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List searOrderLine(OrderLine line,Integer id) {
		List list =null;
		try{
			list=this.ordersDao.searOrderLine(line,id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
