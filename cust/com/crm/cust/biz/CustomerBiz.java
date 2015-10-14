package com.crm.cust.biz;

import java.util.List;
import com.crm.common.entity.CstCustomer;
import com.crm.util.Page;

public interface CustomerBiz {

	// ����
	public boolean addCstCustomer(CstCustomer condition);

	// ɾ��XXX
	public boolean delCstCustomer(CstCustomer condition);

	// �޸�XXX
	public boolean updateCstCustomer(CstCustomer condition);

	// ����
	public CstCustomer loadCstCustomer(String id);

	// ��ѯȫ��
	@SuppressWarnings("unchecked")
	public List searchAll(Page page, CstCustomer condition);

	// ��������ʵ�ַ�ҳ��ѯ
	@SuppressWarnings("unchecked")
	public List searchPage(Page page, CstCustomer condition);

	// ͳ������
	public Integer getCount(CstCustomer condition);

	@SuppressWarnings("unchecked")
	public List getList(String hql);
}
