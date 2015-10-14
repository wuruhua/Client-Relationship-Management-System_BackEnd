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
		// ������Ҫ���Եķ���
		//Page page = new Page();
		CstCustomer cc=biz.loadCstCustomer("KH07122406540272");
		
		boolean del = biz.delCstCustomer(cc);
		if(del==true){
			System.out.print("ɾ���ɹ�!");
		}else{
			System.out.print("ɾ��ʧ��!");
		}
	}
}
