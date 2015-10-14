package com.crm.basd.dao;

import java.util.List;

import com.crm.common.entity.BasDict;
import com.crm.util.Page;

public interface BasdDao {

	// 添加BaseDict
	public boolean addBasDict(BasDict condition);

	// 删除BaseDict
	public boolean delBasDict(BasDict condition);

	// 修改BaseDict
	public boolean updateBasDict(BasDict condition);

	// 加载BaseDict
	public BasDict getBasDict(Integer condition);

	// 根据条件实现分页查询

	@SuppressWarnings("unchecked")
	public List searchPage(Page page, BasDict condition);

	// 统计数据
	public Integer getCount(BasDict condition);

	// 自动补全
	@SuppressWarnings("unchecked")
	public List findTypeByName(String tName);
}
