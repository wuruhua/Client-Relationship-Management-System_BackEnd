package com.crm.cust.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import com.crm.common.entity.CstLost;
import com.crm.cust.biz.LostBiz;
import com.crm.cust.dao.LostDao;
import com.crm.util.Page;

public class LostBizImpl implements LostBiz {

	private LostDao lostDao;
    private CstLost cstLost;
	public CstLost getCstLost() {
		return cstLost;
	}

	public void setCstLost(CstLost cstLost) {
		this.cstLost = cstLost;
	}

	public void setLostDao(LostDao lostDao) {
		this.lostDao = lostDao;
	}

	public CstLost loadCstLost(Integer id) {
		CstLost lost=null;
		try{
			lost=this.lostDao.loadCstLost(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return lost;
	}
	
	
	@SuppressWarnings("unchecked")
	public void test() throws Exception{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		 Thread.sleep(5000);
		System.out.println("正在扫描客户信息······"+"\t"+"系统当前时间："+df.format(Calendar.getInstance().getTime())); 
            System.out.println();
//            Thread.sleep(2000);
            String str="1";
            List list=lostDao.searchCstLost(str);
    	    System.out.println();
	          System.out.println("扫描客户信息任务结束！"); 
            if(null!=list&&list.size()>0){
            	System.out.println("发现有客户六个月没有下订单，请前去处理客户信息！");
            }else{
			System.out.println("没有发现任何客户流失预警，您可以执行其他工作！");
            }
	}

	@SuppressWarnings("unchecked")
	public List searchCstLost(String condition) {	
      List list=lostDao.searchCstLost(condition);

		return list;
	}

	public boolean updateCstLost(CstLost condition) {
		@SuppressWarnings("unused")
		boolean lost=true;
		try{
			lost=this.lostDao.updateCstLost(condition);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	@SuppressWarnings("unchecked")
	public List searchPage(Page page, CstLost condition) {
		List list=null;
		try{			
			list=this.lostDao.searchPage(page, condition);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public Integer getCount(CstLost condition) {
		Integer count=0;
		try{
			count=this.lostDao.getCount(condition);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	public boolean delCstLost(CstLost condition) {
		boolean del=true;
		try{
			del =this.lostDao.delCstLost(condition);
		}catch(Exception e){
			e.printStackTrace();
		}
		return del;
	}
}
