package com.crm.cust.dao;

import java.util.List;
import com.crm.common.entity.CstActivity;

public interface ActivityDao {
	//����
	public boolean addCstActivity(CstActivity condition);

	// ɾ��XXX
	public boolean delCstActivity(CstActivity condition);

	// �޸�XXX
	public boolean updateCstActivity(CstActivity condition);

	// ��ѯȫ��
	@SuppressWarnings("unchecked")
	public List searchAll(CstActivity condition,String id);
	// ����
	public CstActivity loadCstActivity(String id);
	
	//���ݱ�Ż�ȡ��ϵ����Ϣ
	public CstActivity getCstActivityById(Integer id);
}