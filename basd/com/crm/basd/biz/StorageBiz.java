package com.crm.basd.biz;

import java.util.List;

import com.crm.common.entity.Storage;
import com.crm.util.Page;

public interface StorageBiz {
	// ����Storage
	public Storage getStorage(Integer condition);

	// ���ݲ�Ʒ����ʵ�ַ�ҳ��ѯ�����Ϣ
	@SuppressWarnings("unchecked")
	public List searchStoragePage(Page page, Storage condition);

	// ͳ�ƿ������
	public Integer getCount(Storage condition);

	@SuppressWarnings("unchecked")
	public List serachStorageAll(Page page, Storage condition);
}
