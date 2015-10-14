package com.crm.common.dao;

import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.crm.util.Page;

/**
 * 数据库操作基类
 *@author Fiona
 * 
 */
public abstract class BaseHibernateDAO extends HibernateDaoSupport {

	/**
	 * 加载数据(即根据id获取数据)
	 * 
	 * @param clz
	 *            要加载的对象
	 * @param id
	 *            要查询的对象的编号
	 * @return 符合条件的数据对象
	 */
	@SuppressWarnings("unchecked")
	protected Object load(Class clz, java.io.Serializable id) {
		Object ret = null;
		try {
			ret = this.getHibernateTemplate().get(clz, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * 保存数据
	 * 
	 * @param obj
	 *            要保存的对象
	 * @return true:保存成功，false:保存失败
	 */
	protected boolean add(Object obj) {
		boolean isNo = true;
		try {
			this.getHibernateTemplate().save(obj);
		} catch (HibernateException e) {
			isNo = false;
			e.printStackTrace();
		}
		return isNo;
	}

	/**
	 * 修改数据
	 * 
	 * @param obj
	 *            要修改的对象
	 * @return true:修改成功，false:修改失败
	 */
	protected boolean update(Object obj) {
		boolean isNo = true;
		try {
			this.getHibernateTemplate().update(obj);
		} catch (HibernateException e) {
			isNo = false;
			e.printStackTrace();
		}
		return isNo;
	}

	/**
	 * 删除数据
	 * 
	 * @param obj
	 *            要删除的对象
	 * @return true:删除成功，false:删除失败
	 */
	protected boolean delete(Object obj) {
		boolean isNo = true;
		try {
			this.getHibernateTemplate().delete(obj);
		} catch (HibernateException e) {
			isNo = false;
			e.printStackTrace();
		}
		return isNo;
	}

	/**
	 * 查询通用方法(通过键/值方式设置参数)
	 * 
	 * @param hql
	 *            查询语句
	 * @param params
	 *            条件参数
	 * @return 符合条件的记录
	 */
	@SuppressWarnings("unchecked")
	protected List list_params_M(String hql, Map params) {
		Query query = null;
		List list = null;// 返回值
		try {
			if (params != null && params.size() > 0) {//有参数
				query = this.getSession().createQuery(hql);// 创建查询
				Object[] keys = params.keySet().toArray();
				for (int i = 0; i < keys.length; i++) {
					query.setParameter(keys[i].toString(), params.get(keys[i]));
				}
				list = query.list();// 执行查询
			} else {//无参数
				list = this.getHibernateTemplate().find(hql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询通用方法(通过索引方式设置参数)
	 * 
	 * @param hql
	 *            查询语句
	 * @param params
	 *            条件参数
	 * @return 符合条件的记录
	 */
	@SuppressWarnings("unchecked")
	protected List list_params(String hql, List params) {
		Query query = null;
		List list = null;// 返回值
		try {
			if (params != null && params.size() > 0) {//有参数
				query = this.getSession().createQuery(hql);// 创建查询
				for (int i = 0; i < params.size(); i++) {
					query.setParameter(i, params.get(i));
				}
				list = query.list();// 执行查询
			} else {// 没有参数方式查询
				list = this.getHibernateTemplate().find(hql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 统计数据
	 * 
	 * @param hql
	 *            查询语句
	 * @param params
	 *            查询条件参数
	 * @return 符合条件的记录行数
	 */
	@SuppressWarnings("unchecked")
	protected int getCount(String hql, Map params) {
		Query query = null;
		int count = 0;
		try {
			if (params != null && params.size() > 0) {// 有参方式
				query = this.getSession().createQuery(hql);// 创建查询
				Object[] keys = params.keySet().toArray();
				for (int i = 0; i < keys.length; i++) {
					query.setParameter(keys[i].toString(), params.get(keys[i]));
				}
				count = Integer.parseInt(query.uniqueResult().toString());
			} else {// 无参方式
				count = Integer.parseInt(this.getHibernateTemplate().find(hql)
						.get(0).toString());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 *            分页类
	 * @param hql
	 *            查询语句
	 * @param params
	 *            条件参数
	 * @return 符合条件的数据集合
	 */
	@SuppressWarnings("unchecked")
	protected List searchPage(Page page, String hql, Map params) {
		Query query = null;
		List pageList = null;
		try {
			query = this.getSession().createQuery(hql);// 创建查询对象
			if (params != null && params.size() > 0) {//有参数
				query = this.getSession().createQuery(hql);// 创建查询
				Object[] keys = params.keySet().toArray();
				for (int i = 0; i <keys.length; i++) {
					query.setParameter(keys[i].toString(), params.get(keys[i]));
				}
			}
			// 查询指定索引范围的数据
			pageList = query.setFirstResult(
					(page.getCurrentPage() - 1) * page.getPageRow())
					.setMaxResults(page.getPageRow()).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return pageList;
	}
	
	protected List searchPage2(Page page, String sql) {
		Query query = null;
		List pageList = null;
		try {
			query = this.getSession().createSQLQuery(sql);// 创建查询对象
			
			// 查询指定索引范围的数据
			pageList = query.setFirstResult(
					(page.getCurrentPage() - 1) * page.getPageRow())
					.setMaxResults(page.getPageRow()).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return pageList;
	}
	protected List searchPage2(String sql) {
		Query query = null;
		List pageList = null;
		try {
			query = this.getSession().createSQLQuery(sql);// 创建查询对象
		pageList=query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return pageList;
	}
	
}
