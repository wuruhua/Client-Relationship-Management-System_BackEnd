package com.crm.cust.biz;

import java.util.List;
import com.crm.common.entity.CstLinkman;

public interface LinkmanBiz {
	//����
	public boolean addCstLinkman(CstLinkman condition);

	// ɾ��XXX
	public boolean delCstLinkman(Integer condition);

	// �޸�XXX
	public boolean updateCstLinkman(CstLinkman condition);

	// ��ѯȫ��
	@SuppressWarnings("unchecked")
	public List searchAll(CstLinkman condition,String id);
	// ����
	public CstLinkman loadCstLinkman(String id);
	
	//����ID��ȡ��ϵ����Ϣ
	public CstLinkman getCstLinkmanById(Integer id);
   
}
