package com.weixin.datacore.dao.hibernate;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * GenericDAO implementation. Register as singleton service
 * 
 * @author Liang Dong
 */
@SuppressWarnings("rawtypes")
@Component("hibernateDAO")
public class HibernateDAOImpl implements HibernateDAO {

	private static String GET_ENTITIIES_BY_IDS_TEMPLATE = "from %s where %s in (%s) order by case %s end";

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public String formatGetEntitiesByIdsQuery(String entityByName, String idPropertyName, List ids) {
		Assert.notEmpty(ids);
		Assert.hasText(entityByName);
		Assert.hasText(idPropertyName);
		int count = 1;
		String idStr = "";
		String whenClause = "";
		for (Object object : ids) {
			if (object instanceof Number) {
				idStr += String.valueOf(object) + ",";
				whenClause += " when " + idPropertyName + "=" + String.valueOf(object) + " then " + count++ + " ";
			} else {
				idStr += "\"" + String.valueOf(object) + "\",";
				whenClause += " when " + idPropertyName + "=\"" + String.valueOf(object) + "\" then " + count++ + " ";
			}
		}
		// remove last comma
		idStr = idStr.substring(0, idStr.length() - 1);
		return String.format(GET_ENTITIIES_BY_IDS_TEMPLATE, entityByName, idPropertyName, idStr, whenClause);
	}

	public List findAll(Class entityClass) {
		return sessionFactory.getCurrentSession().createCriteria(entityClass).list();
	}

	public List findByHql(String hql, Object[] params) {
		Assert.hasText(hql);
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				q.setParameter(i, params[i]);
			}
		}
		return q.list();
	}

	public List findByHql(String hql, Object[] params, int start, int max) {
		Assert.hasText(hql);
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				q.setParameter(i, params[i]);
			}
		}
		q.setFirstResult(start);
		q.setMaxResults(max);
		return q.list();
	}

	public List findByCriteria(DetachedCriteria ca) {
		Assert.notNull(ca);
		Criteria criteria = ca.getExecutableCriteria(sessionFactory.getCurrentSession());
		return criteria.list();
	}

	public List findByCriteria(DetachedCriteria ca, int start, int max) {
		Assert.notNull(ca);
		Criteria criteria = ca.getExecutableCriteria(sessionFactory.getCurrentSession()).setFirstResult(start)
				.setMaxResults(max);
		return criteria.list();
	}

	public long getTotalCount(Class entityClass) {
		Criteria ca = sessionFactory.getCurrentSession().createCriteria(entityClass);
		ca.setProjection(Projections.rowCount());
		List counts = ca.list();
		return (Long) counts.get(0);
	}

	public Session getManagedSession() {
		return sessionFactory.getCurrentSession();
	}

	public Session openSession() {
		return sessionFactory.openSession();
	}

	public void save(Object entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	public void delete(Object entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	public void deleteById(Class entityClass, Serializable id) {
		Object o = sessionFactory.getCurrentSession().get(entityClass, id);
		if (o != null) {
			delete(o);
		}
	}

	public void saveorupdate(Object entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	public Object findById(Class entityClass, Serializable id) {
		return sessionFactory.getCurrentSession().get(entityClass, id);
	}

	public int executeUpdate(String hql, Object[] params) throws Exception {
		Assert.hasText(hql);
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				q.setParameter(i, params[i]);
			}
		}
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		try {
			int count = q.executeUpdate();
			tx.commit();
			return count;
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
	}

	public void addAll(List entities) {
		Assert.notEmpty(entities);
		for (Object object : entities) {
			save(object);
		}
	}

	public void delAll(List entities) {
		Assert.notEmpty(entities);
		Iterator i = entities.iterator();
		while (i.hasNext()) {
			Object object = (Object) i.next();
			delete(object);
		}
	}

	public void updateAll(List entities) {
		Assert.notEmpty(entities);
		for (Object object : entities) {
			saveorupdate(object);
		}
	}
}
