package com.crm.cust.dao;

import java.util.List;

import com.crm.common.entity.CstLinkman;

public interface LinkmanDao {
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
	
	//���ݱ�Ż�ȡ��ϵ����Ϣ
	public CstLinkman getCstLinkmanById(Integer id);
}
