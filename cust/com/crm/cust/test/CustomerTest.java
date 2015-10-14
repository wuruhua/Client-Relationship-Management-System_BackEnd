package com.crm.cust.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.crm.common.entity.CstCustomer;
import com.crm.cust.biz.CustomerBiz;

public class CustomerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext*.xml");
		CustomerBiz biz = (CustomerBiz) ctx.getBean("customerBizImpl");
		// 调用想要测试的方法
		//Page page = new Page();
		CstCustomer cc=biz.loadCstCustomer("KH07122406540272");
		
		boolean del = biz.delCstCustomer(cc);
		if(del==true){
			System.out.print("删除成功!");
		}else{
			System.out.print("删除失败!");
		}
	}
}
