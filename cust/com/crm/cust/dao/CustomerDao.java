package com.crm.cust.dao;

import java.util.List;
import com.crm.common.entity.CstCustomer;
import com.crm.util.Page;

public interface CustomerDao {

	// ���
	public boolean addCstCustomer(CstCustomer condition);

	// ɾ��
	public boolean delCstCustomer(CstCustomer condition);

	// �޸�
	public boolean updateCstCustomer(CstCustomer condition);

	// ����
	public CstCustomer loadCstCustomer(String id);

	// ��������ʵ�ַ�ҳ��ѯ
	@SuppressWarnings("unchecked")
	public List searchPage(Page page, CstCustomer condition);

	// ������������ѯ
	@SuppressWarnings("unchecked")
	public List searchCstCustomer(CstCustomer condition);

	// ͳ������
	public Integer getCount(CstCustomer condition);

	@SuppressWarnings("unchecked")
	public List getList(String hql);
}
