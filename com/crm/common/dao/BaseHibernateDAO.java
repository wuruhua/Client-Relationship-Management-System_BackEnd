package com.crm.common.dao;

import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.crm.util.Page;

/**
 * ���ݿ��������
 *@author Fiona
 * 
 */
public abstract class BaseHibernateDAO extends HibernateDaoSupport {

	/**
	 * ��������(������id��ȡ����)
	 * 
	 * @param clz
	 *            Ҫ���صĶ���
	 * @param id
	 *            Ҫ��ѯ�Ķ���ı��
	 * @return �������������ݶ���
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
	 * ��������
	 * 
	 * @param obj
	 *            Ҫ����Ķ���
	 * @return true:����ɹ���false:����ʧ��
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
	 * �޸�����
	 * 
	 * @param obj
	 *            Ҫ�޸ĵĶ���
	 * @return true:�޸ĳɹ���false:�޸�ʧ��
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
	 * ɾ������
	 * 
	 * @param obj
	 *            Ҫɾ���Ķ���
	 * @return true:ɾ���ɹ���false:ɾ��ʧ��
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
	 * ��ѯͨ�÷���(ͨ����/ֵ��ʽ���ò���)
	 * 
	 * @param hql
	 *            ��ѯ���
	 * @param params
	 *            ��������
	 * @return ���������ļ�¼
	 */
	@SuppressWarnings("unchecked")
	protected List list_params_M(String hql, Map params) {
		Query query = null;
		List list = null;// ����ֵ
		try {
			if (params != null && params.size() > 0) {//�в���
				query = this.getSession().createQuery(hql);// ������ѯ
				Object[] keys = params.keySet().toArray();
				for (int i = 0; i < keys.length; i++) {
					query.setParameter(keys[i].toString(), params.get(keys[i]));
				}
				list = query.list();// ִ�в�ѯ
			} else {//�޲���
				list = this.getHibernateTemplate().find(hql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ��ѯͨ�÷���(ͨ��������ʽ���ò���)
	 * 
	 * @param hql
	 *            ��ѯ���
	 * @param params
	 *            ��������
	 * @return ���������ļ�¼
	 */
	@SuppressWarnings("unchecked")
	protected List list_params(String hql, List params) {
		Query query = null;
		List list = null;// ����ֵ
		try {
			if (params != null && params.size() > 0) {//�в���
				query = this.getSession().createQuery(hql);// ������ѯ
				for (int i = 0; i < params.size(); i++) {
					query.setParameter(i, params.get(i));
				}
				list = query.list();// ִ�в�ѯ
			} else {// û�в�����ʽ��ѯ
				list = this.getHibernateTemplate().find(hql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ͳ������
	 * 
	 * @param hql
	 *            ��ѯ���
	 * @param params
	 *            ��ѯ��������
	 * @return ���������ļ�¼����
	 */
	@SuppressWarnings("unchecked")
	protected int getCount(String hql, Map params) {
		Query query = null;
		int count = 0;
		try {
			if (params != null && params.size() > 0) {// �вη�ʽ
				query = this.getSession().createQuery(hql);// ������ѯ
				Object[] keys = params.keySet().toArray();
				for (int i = 0; i < keys.length; i++) {
					query.setParameter(keys[i].toString(), params.get(keys[i]));
				}
				count = Integer.parseInt(query.uniqueResult().toString());
			} else {// �޲η�ʽ
				count = Integer.parseInt(this.getHibernateTemplate().find(hql)
						.get(0).toString());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param page
	 *            ��ҳ��
	 * @param hql
	 *            ��ѯ���
	 * @param params
	 *            ��������
	 * @return �������������ݼ���
	 */
	@SuppressWarnings("unchecked")
	protected List searchPage(Page page, String hql, Map params) {
		Query query = null;
		List pageList = null;
		try {
			query = this.getSession().createQuery(hql);// ������ѯ����
			if (params != null && params.size() > 0) {//�в���
				query = this.getSession().createQuery(hql);// ������ѯ
				Object[] keys = params.keySet().toArray();
				for (int i = 0; i <keys.length; i++) {
					query.setParameter(keys[i].toString(), params.get(keys[i]));
				}
			}
			// ��ѯָ��������Χ������
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
			query = this.getSession().createSQLQuery(sql);// ������ѯ����
			
			// ��ѯָ��������Χ������
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
			query = this.getSession().createSQLQuery(sql);// ������ѯ����
		pageList=query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return pageList;
	}
	
}
