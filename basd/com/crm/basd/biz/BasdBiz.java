package com.crm.basd.biz;

import java.util.List;
import com.crm.common.entity.BasDict;
import com.crm.util.Page;

/**
 * �����ֵ����
 * 

 * 
 */
public interface BasdBiz {

	// ���BaseDict
	public boolean addBasDict(BasDict condition);

	// ɾ��BaseDict
	public boolean delBasDict(BasDict condition);

	// �޸�BaseDict
	public boolean updateBasDict(BasDict condition);

	// ����BaseDict
	public BasDict getBasDict(Integer condition);

	// ��������ʵ�ַ�ҳ��ѯ
	@SuppressWarnings("unchecked")
	public List searchPage(Page page, BasDict condition);

	// ͳ������
	public Integer getCount(BasDict condition);

	// ��ѯ���е���Ϣ
	@SuppressWarnings("unchecked")
	public List serachAll(Page page, BasDict condition);
	
	// �Զ���ȫ
	@SuppressWarnings("unchecked")
	public List findTypeByName(String tName);
}
