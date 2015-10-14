package com.crm.basd.biz.impl;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.crm.basd.biz.BasdBiz;
import com.crm.basd.dao.BasdDao;
import com.crm.common.entity.BasDict;
import com.crm.util.Page;

public class BasdBizImpl implements BasdBiz {
	private BasdDao basdDao;

	public void setBasdDao(BasdDao basdDao) {
		this.basdDao = basdDao;
	}

	// ���
	public boolean addBasDict(BasDict condition) {
		boolean flag = true;
		try {
			flag = this.basdDao.addBasDict(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// ɾ��
	public boolean delBasDict(BasDict condition) {
		boolean flag = true;
		try {
			BasDict bd = this.getBasDict(condition.getDictId());
			flag = this.basdDao.delBasDict(bd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// ����
	public BasDict getBasDict(Integer condition) {
		BasDict dict = null;
		try {
			dict = this.basdDao.getBasDict(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dict;
	}

	// ͳ��BaseDict
	public Integer getCount(BasDict condition) {
		Integer count = 0;
		try {
			count = this.basdDao.getCount(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	// ��ҳ��ѯBaseDict��Ϣ
	@SuppressWarnings("unchecked")
	public List searchPage(Page page, BasDict condition) {
		List list = null;
		try {
			list = this.basdDao.searchPage(page, condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// �޸�
	public boolean updateBasDict(BasDict condition) {
		boolean flag = true;
		try {
			flag = this.basdDao.updateBasDict(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// ��ѯ���е���Ϣ
	@SuppressWarnings("unchecked")
	public List serachAll(Page page, BasDict condition) {
		List list = null;
		try {
			list = this.basdDao.searchPage(page, condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// �Զ���ȫ
	@SuppressWarnings("unchecked")
	public List findTypeByName(String tName) {
		List list = null;
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"applicationContext*.xml");
			BasdDao bdao = (BasdDao) ctx.getBean("basdDaoImpl");
			list = bdao.findTypeByName(tName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
