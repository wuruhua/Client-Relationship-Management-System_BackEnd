package com.crm.cust.biz;

import java.util.List;
import com.crm.common.entity.CstLinkman;

public interface LinkmanBiz {
	//增加
	public boolean addCstLinkman(CstLinkman condition);

	// 删除XXX
	public boolean delCstLinkman(Integer condition);

	// 修改XXX
	public boolean updateCstLinkman(CstLinkman condition);

	// 查询全部
	@SuppressWarnings("unchecked")
	public List searchAll(CstLinkman condition,String id);
	// 加载
	public CstLinkman loadCstLinkman(String id);
	
	//根据ID获取联系人信息
	public CstLinkman getCstLinkmanById(Integer id);
   
}
