package com.crm.basd.biz.impl;

import java.util.List;

import com.crm.basd.biz.StorageBiz;
import com.crm.basd.dao.StorageDao;
import com.crm.common.entity.Storage;
import com.crm.util.Page;

public class StorageBizImple implements StorageBiz {
	private StorageDao storageDao;

	public void setStorageDao(StorageDao storageDao) {
		this.storageDao = storageDao;
	}

	// 统计库存信息
	public Integer getCount(Storage condition) {
		Integer count = 0;
		try {
			count = this.storageDao.getCount(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	// 加载库存
	public Storage getStorage(Integer condition) {
		Storage storage = null;
		try {
			storage = this.storageDao.getStorage(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return storage;
	}

	// 根据条件实现库存的分页查询
	@SuppressWarnings("unchecked")
	public List searchStoragePage(Page page, Storage condition) {
		List list = null;
		try {
			list = this.storageDao.searchStoragePage(page, condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 查询所有的产品
	@SuppressWarnings("unchecked")
	public List serachStorageAll(Page page, Storage condition) {
		List list = null;
		try {
			list = this.storageDao.searchStoragePage(page, condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
