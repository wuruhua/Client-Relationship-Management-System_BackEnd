package com.crm.basd.biz;

import java.util.List;

import com.crm.common.entity.Storage;
import com.crm.util.Page;

public interface StorageBiz {
	// 加载Storage
	public Storage getStorage(Integer condition);

	// 根据产品条件实现分页查询库存信息
	@SuppressWarnings("unchecked")
	public List searchStoragePage(Page page, Storage condition);

	// 统计库存数据
	public Integer getCount(Storage condition);

	@SuppressWarnings("unchecked")
	public List serachStorageAll(Page page, Storage condition);
}
