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

	// 添加
	public boolean addBasDict(BasDict condition) {
		boolean flag = true;
		try {
			flag = this.basdDao.addBasDict(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 删除
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

	// 加载
	public BasDict getBasDict(Integer condition) {
		BasDict dict = null;
		try {
			dict = this.basdDao.getBasDict(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dict;
	}

	// 统计BaseDict
	public Integer getCount(BasDict condition) {
		Integer count = 0;
		try {
			count = this.basdDao.getCount(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	// 分页查询BaseDict信息
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

	// 修改
	public boolean updateBasDict(BasDict condition) {
		boolean flag = true;
		try {
			flag = this.basdDao.updateBasDict(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 查询所有的信息
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

	// 自动补全
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
