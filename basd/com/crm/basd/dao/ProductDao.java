package com.crm.basd.dao;

import java.util.List;

import com.crm.common.entity.Product;
import com.crm.util.Page;

public interface ProductDao {

	// ���ݲ�Ʒ����ʵ�ַ�ҳ��ѯ
	@SuppressWarnings("unchecked")
	public List searchProductPage(Page page, Product condition);

	// ͳ�Ʋ�Ʒ����
	public Integer getCount(Product condition);

}
