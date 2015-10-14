package com.crm.cust.biz;

import java.util.List;

import com.crm.common.entity.CstLost;
import com.crm.util.Page;

public interface LostBiz {
	//�޸�
	public boolean updateCstLost(CstLost condition);

	// ����
	public CstLost loadCstLost(Integer id);
	
	// ��������ʵ�ַ�ҳ��ѯ
	@SuppressWarnings("unchecked")
	public List searchPage(Page page, CstLost condition);

	// ������������ѯ
	@SuppressWarnings("unchecked")
	public List searchCstLost(String condition);
	// ͳ������
	public Integer getCount(CstLost condition) ;
	
	public boolean delCstLost(CstLost condition);
}
