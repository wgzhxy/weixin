package com.weixin.datacore.core.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.HibernateDAO;

/**
 * GenericDAO implementation. Register as singleton service
 * 
 * @author wang.g.z
 */
@SuppressWarnings("unchecked")
@Component("hibernateGenericDAO")
public class HibernateDAOImpl<T extends Serializable, K extends Serializable, PK extends Serializable> extends
		HibernateDaoSupport implements HibernateDAO<T, K, PK> {

	private Class<T> entityClass = null;

	public HibernateDAOImpl() {
		Class c = getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			this.entityClass = (Class<T>) p[0];
		}
	}

	public String formatGetEntitiesByIdsQuery(String entityByName, String idPropertyName, List<PK> ids) {
		int count = 1;
		String idStr = "";
		String whenClause = "";
		for (Object object : ids) {
			if (object instanceof Long || object instanceof Integer || object instanceof Float) {
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

	public void deleteById(Class<T> entityClass, PK id) {
		super.getHibernateTemplate().delete(findById(entityClass, id));

	}

	public void saveorupdate(T entity) {
		super.getHibernateTemplate().saveOrUpdate(entity);

	}

	public void update(String hql, Object[] params) {
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		query.executeUpdate();
	}
	
	public void delete(String hql, Object[] params){
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		query.executeUpdate();
	}

	public List<T> findAll(Class entityClass) {
		return super.getHibernateTemplate().loadAll(entityClass);
	}

	public List<T> findAll(Class entityClass, String hql, Object[] params, int start, int limit) {
		Query query = this.getSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		if (start >= 0 && limit != 0) {
			query.setFirstResult(start).setMaxResults(limit);
		}
		return query.list();
	}

	public List<T> findByExample(T entity) {
		return super.getHibernateTemplate().findByExample(entity);
	}

	public List<T> findByHql(String hql, Object[] params) {
		Query query = this.getSession().createQuery(hql);
		if (null != params && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		return query.list();
	}

	public T findById(Class<T> entityClass, PK id) {
		return (T) super.getHibernateTemplate().get(entityClass, (Serializable) id);
	}

	public List<T> findByProperty(Class entityClass, String propertyName, Object value) {
		String queryString = "from " + entityClass.getName() + " as model where model." + propertyName + "=?";
		return super.getHibernateTemplate().find(queryString, value);
	}

	public int getTotalCount(Class entityClass) {
		return (Integer) this.getSession().createQuery("select count(o) from " + entityClass.getName() + " o")
				.uniqueResult();
	}

	public void deleteAll(List<T> entities) {
		super.getHibernateTemplate().deleteAll(entities);
	}

	public Session getManagedSession() {
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	public Session openSession() {
		return super.getSessionFactory().openSession();
	}

	public List<T> findByHql(String hql, Object[] params, int startNo, int maxNo) {
		Query query = this.getSession().createQuery(hql);
		if (null != params && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		query.setFirstResult(startNo);
		query.setMaxResults(maxNo);
		return query.list();
	}

	public T get(PK id) {
		try {
			return (T) getHibernateTemplate().get(entityClass, id);
		} catch (ObjectNotFoundException e) {
			return null;
		}
	}

	public T getWithLock(PK id, LockMode lock) {
		T t = (T) getHibernateTemplate().get(entityClass, id, lock);
		if (t != null) {
			this.flush();
		}
		return t;
	}

	public T load(PK id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	public T loadWithLock(PK id, LockMode lock) {
		T t = (T) getHibernateTemplate().load(entityClass, id, lock);
		if (t != null) {
			this.flush();
		}
		return t;
	}

	public List<T> loadAll() {
		return (List<T>) getHibernateTemplate().loadAll(entityClass);
	}

	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	public T merge(T entity) {
		return (T) getHibernateTemplate().merge(entity);
	}

	public void updateWithLock(T entity, LockMode lock) {
		getHibernateTemplate().update(entity, lock);
		this.flush();
	}

	public void saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void saveOrUpdateAll(Collection<T> entities) {
		getHibernateTemplate().saveOrUpdateAll(entities);
	}

	public void deleteWithLock(T entity, LockMode lock) {
		getHibernateTemplate().delete(entity, lock);
		this.flush();
	}

	public void deleteByKeyWithLock(PK id, LockMode lock) {
		this.deleteWithLock(this.load(id), lock);
		this.flush();
	}

	public void deleteAll(Collection<T> entities) {
		getHibernateTemplate().deleteAll(entities);
	}

	public int bulkUpdate(String queryString) {
		return getHibernateTemplate().bulkUpdate(queryString);
	}

	public int bulkUpdate(String queryString, Object[] values) {
		return getHibernateTemplate().bulkUpdate(queryString, values);
	}

	public List<T> find(String queryString) {
		return getHibernateTemplate().find(queryString);
	}

	public List<T> find(String queryString, Object value) {
		return getHibernateTemplate().find(queryString, value);
	}

	public List<T> find(String queryString, Object[] values) {
		return getHibernateTemplate().find(queryString, values);
	}

	public List<T> findByNamedParam(String queryString, String[] paramNames, Object[] values) {
		return getHibernateTemplate().findByNamedParam(queryString, paramNames, values);
	}

	public List<T> findByNamedQuery(String queryName) {
		return getHibernateTemplate().findByNamedQuery(queryName);
	}

	public List<T> findByNamedQuery(String queryName, Object[] values) {
		return getHibernateTemplate().findByNamedQuery(queryName, values);
	}

	public List<T> findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values) {
		return getHibernateTemplate().findByNamedQueryAndNamedParam(queryName, paramNames, values);
	}

	public Iterator<?> iterate(String queryString) {
		return getHibernateTemplate().iterate(queryString);
	}

	public Iterator<?> iterate(String queryString, Object[] values) {
		return getHibernateTemplate().iterate(queryString, values);
	}

	public void closeIterator(Iterator<?> it) {
		getHibernateTemplate().closeIterator(it);
	}

	public DetachedCriteria createDetachedCriteria() {
		return DetachedCriteria.forClass(this.entityClass);
	}

	public Criteria createCriteria() {
		return this.createDetachedCriteria().getExecutableCriteria(this.getSession());
	}

	public List<T> findByCriteria(DetachedCriteria criteria) {
		return getHibernateTemplate().findByCriteria(criteria);
	}

	public List<T> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) {
		return getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

	public List<T> findEqualByEntity(T entity, String[] propertyNames) {
		Criteria criteria = this.createCriteria();
		Example exam = Example.create(entity);
		exam.excludeZeroes();
		String[] defPropertys = getSessionFactory().getClassMetadata(entityClass).getPropertyNames();
		for (String defProperty : defPropertys) {
			int ii = 0;
			for (ii = 0; ii < propertyNames.length; ++ii) {
				if (defProperty.equals(propertyNames[ii])) {
					criteria.addOrder(Order.asc(defProperty));
					break;
				}
			}
			if (ii == propertyNames.length) {
				exam.excludeProperty(defProperty);
			}
		}
		criteria.add(exam);
		return (List<T>) criteria.list();
	}

	public List<T> findLikeByEntity(T entity, String[] propertyNames) {
		Criteria criteria = this.createCriteria();
		for (String property : propertyNames) {
			try {
				Object value = PropertyUtils.getProperty(entity, property);
				if (value instanceof String) {
					criteria.add(Restrictions.like(property, (String) value, MatchMode.ANYWHERE));
					criteria.addOrder(Order.asc(property));
				} else {
					criteria.add(Restrictions.eq(property, value));
					criteria.addOrder(Order.asc(property));
				}
			} catch (Exception ex) {
			}
		}
		return (List<T>) criteria.list();
	}

	public Integer getRowCount(DetachedCriteria criteria) {
		criteria.setProjection(Projections.rowCount());
		List list = this.findByCriteria(criteria, 0, 1);
		return (Integer) list.get(0);
	}

	public Object getStatValue(DetachedCriteria criteria, String propertyName, String StatName) {
		if (StatName.toLowerCase().equals("max"))
			criteria.setProjection(Projections.max(propertyName));
		else if (StatName.toLowerCase().equals("min"))
			criteria.setProjection(Projections.min(propertyName));
		else if (StatName.toLowerCase().equals("avg"))
			criteria.setProjection(Projections.avg(propertyName));
		else if (StatName.toLowerCase().equals("sum"))
			criteria.setProjection(Projections.sum(propertyName));
		else
			return null;
		List list = this.findByCriteria(criteria, 0, 1);
		return list.get(0);
	}

	public void lock(T entity, LockMode lock) {
		getHibernateTemplate().lock(entity, lock);
	}

	public void initialize(Object proxy) {
		getHibernateTemplate().initialize(proxy);
	}

	public void flush() {
		getHibernateTemplate().flush();
	}

	/**
	 * 
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @param paras
	 * @return
	 */
	public List<T> loadByPagenation(String hql, int pageNo, int pageSize, Object[] paras) {
		if (pageSize <= 0)
			pageSize = 10;
		if (pageNo <= 0) {
			pageNo = 1;
		}
		int start = (pageNo - 1) * pageSize;
		Query query = createQuery(hql, paras);
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	/**
	 * 
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @param paras
	 * @return
	 */
	protected Iterator<?> loadByPagenationIte(String hql, int pageNo, int pageSize, Object[] paras) {
		if (pageSize <= 0)
			pageSize = 10;
		if (pageNo <= 0) {
			pageNo = 1;
		}
		int start = (pageNo - 1) * pageSize;
		Query query = createQuery(hql, paras);
		Iterator<T> iter = query.setFirstResult(start).setMaxResults(pageSize).iterate();
		return iter;
	}

	/**
	 * 
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @param paras
	 * @return
	 */
	public List<T> loadByPagenationf(String hql, int pageNo, int pageSize, Object[] paras) {
		if (pageNo == -999) {
			pageNo = 1;
			pageSize = 1000;
		} else {
			if (pageSize <= 0)
				pageSize = 10;
			if (pageNo <= 0) {
				pageNo = 1;
			}
		}
		int start = (pageNo - 1) * pageSize;
		Query query = createQuery(hql, paras);
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	/**
	 * 
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @param paras
	 * @return
	 */
	public Iterator<?> loadByPagenationfIte(String hql, int pageNo, int pageSize, Object[] paras) {
		if (pageNo == -999) {
			pageNo = 1;
			pageSize = 1000;

		} else {
			if (pageSize <= 0)
				pageSize = 10;
			if (pageNo <= 0) {
				pageNo = 1;
			}
		}
		int start = (pageNo - 1) * pageSize;
		Query query = createQuery(hql, paras);
		Iterator<T> iter = query.setFirstResult(start).setMaxResults(pageSize).iterate();
		return iter;
	}

	/**
	 * this method is suit for the special hql which return Object[] and others.
	 * 
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @param paras
	 * @return
	 */
	protected List<?> loadByPage(String hql, int pageNo, int pageSize, Object... paras) {
		if (pageSize <= 0)
			pageSize = 10;
		if (pageNo <= 0) {
			pageNo = 1;
		}
		int start = (pageNo - 1) * pageSize;
		Query query = createQuery(hql, paras);
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	/**
	 * get top records
	 * 
	 * @param hql
	 * @param limitNum
	 * @param paras
	 * @return
	 */
	protected List<T> loadTopRows(String hql, int limitNum, Object... paras) {
		Query query = createQuery(hql, paras);
		return query.setFirstResult(0).setMaxResults(limitNum).list();
	}

	private Query createQuery(String hql, Object... values) {
		Query query = this.getSession().createQuery(hql);
		if (values != null && values.length > 0) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

	public int addBacth(List<T> list) {
		Session session = this.getSession();
		for (int i = 0; i < list.size(); i++) {
			session.save(list.get(i));
			if (i % 20 == 0) {
				// 20，与JDBC批量设置相同
				// 将本批插入的对象立即写入数据库并释放内存
				session.flush();
				session.clear();
			}
		}
		return 0;
	}
	
	public int updateBacth(List<T> list) {
		Session session = this.getSession();
		for (int i = 0; i < list.size(); i++) {
			session.update(list.get(i));
			if (i % 20 == 0) {
				// 20，与JDBC批量设置相同
				// 将本批插入的对象立即写入数据库并释放内存
				session.flush();
				session.clear();
			}
		}
		return 0;
	}

	@Override
	public Iterator<?> sqlQuery(String sql, Object[] value, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		Object obj = null;
		Session session = this.getSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		try {
			if (value != null && value.length > 0) {
				for (int i = 0; i < value.length; i++) {
					obj = value[i];
					if (obj instanceof java.lang.Integer) {
						sqlQuery.setInteger(i, (java.lang.Integer) obj);
					}
					if (obj instanceof java.lang.String) {
						sqlQuery.setString(i, (java.lang.String) obj);
					}
					if (obj instanceof java.lang.Float) {
						sqlQuery.setFloat(i, (java.lang.Float) obj);
					}
					if (obj instanceof java.lang.Double) {
						sqlQuery.setDouble(i, (java.lang.Double) obj);
					}
					if (obj instanceof java.lang.Boolean) {
						sqlQuery.setBoolean(i, (java.lang.Boolean) obj);
					}
					if (obj instanceof java.lang.Byte) {
						sqlQuery.setByte(i, (java.lang.Byte) obj);
					}
					if (obj instanceof java.lang.Long) {
						sqlQuery.setLong(i, (Long) obj);
					}
					if (obj instanceof java.sql.Date) {
						sqlQuery.setDate(i, (java.sql.Date) obj);
					}
					if (obj instanceof java.sql.Timestamp) {
						sqlQuery.setTimestamp(i, (java.sql.Timestamp) obj);
					}
				}
			}
			if (pageNum > 0 && pageSize > 0) {
				sqlQuery.setFirstResult((pageNum - 1) * pageSize);
				sqlQuery.setMaxResults(pageNum * pageSize);
			} else {
				sqlQuery.setFirstResult(0);
				sqlQuery.setMaxResults(16);
			}
			return sqlQuery.list().iterator();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				this.releaseSession(session);
			}
		}
		return null;
	}
	
	@Override
	public Iterator<?> sqlQuery(String sql, Object[] value) {
		// TODO Auto-generated method stub
		Object obj = null;
		Session session = this.getSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		try {
			if (value != null && value.length > 0) {
				for (int i = 0; i < value.length; i++) {
					obj = value[i];
					if (obj instanceof java.lang.Integer) {
						sqlQuery.setInteger(i, (java.lang.Integer) obj);
					}
					if (obj instanceof java.lang.String) {
						sqlQuery.setString(i, (java.lang.String) obj);
					}
					if (obj instanceof java.lang.Float) {
						sqlQuery.setFloat(i, (java.lang.Float) obj);
					}
					if (obj instanceof java.lang.Double) {
						sqlQuery.setDouble(i, (java.lang.Double) obj);
					}
					if (obj instanceof java.lang.Boolean) {
						sqlQuery.setBoolean(i, (java.lang.Boolean) obj);
					}
					if (obj instanceof java.lang.Byte) {
						sqlQuery.setByte(i, (java.lang.Byte) obj);
					}
					if (obj instanceof java.lang.Long) {
						sqlQuery.setLong(i, (Long) obj);
					}
					if (obj instanceof java.sql.Date) {
						sqlQuery.setDate(i, (java.sql.Date) obj);
					}
					if (obj instanceof java.sql.Timestamp) {
						sqlQuery.setTimestamp(i, (java.sql.Timestamp) obj);
					}
				}
			}
			return sqlQuery.list().iterator();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(session != null) {
				this.releaseSession(session);
			}
		}
		return null;
	}

	@Override
	public Iterator<?> sqlQuery(SQLQuery sqlQuery, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		if (pageNum > 0 && pageSize > 0) {
			sqlQuery.setFirstResult((pageNum - 1) * pageSize);
			sqlQuery.setMaxResults(pageNum * pageSize);
		} else {
			sqlQuery.setFirstResult(0);
			sqlQuery.setMaxResults(16);
		}
		return sqlQuery.list().iterator();
	}
	
	@Override
	public Iterator<?> sqlQuery(SQLQuery sqlQuery) {
		// TODO Auto-generated method stub
		return sqlQuery.list().iterator();
	}

	@Override
	public T save(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public void deleteByKey(PK id) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(this.load(id));
	}

	/**
	 * @function 分页显示符合所有的记录数，将查询结果封装为Pager
	 * @param pageNo
	 *            当前页数
	 * @param pageSize
	 *            每页显示的条数
	 * @param instance
	 *            将查询条件封装为专家Bean
	 * @return 查询结果Pager
	 */
	public List<?> findPageByQuery(int pageNo, int pageSize, String hql, Map<String, Object> map)
	{
		List<Object> result = null;
		try
		{
			Query query = this.getSession().createQuery(hql);
			Iterator it = map.keySet().iterator();
			while (it.hasNext())
			{
				Object key = it.next();
				query.setParameter(key.toString(), map.get(key));
			}
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
			result = query.list();
		} catch (RuntimeException re)
		{
			throw re;
		}
		return result;
	}
	
	/**
	 * @function 根据查询条件查询记录数的个数
	 * @param hql
	 *            hql查询语句
	 * @param map
	 *            用map封装查询条件
	 * @return 数据库中满足查询条件的数据的条数
	 */
	public long getTotalCount(String hql, Map<String, Object> map)
	{
		try
		{
			Query query = this.getSession().createQuery(hql);
			Iterator it = map.keySet().iterator();
			while (it.hasNext())
			{
				Object key = it.next();
				query.setParameter(key.toString(), map.get(key));
			}

			Long i = (Long) query.list().get(0);
			return i;
		} catch (RuntimeException re)
		{
			throw re;
		}
	}
	
	public long getTotalCount(String hql)
	{
		try
		{
			Query query = this.getSession().createQuery(hql);
			Long i = (Long) query.list().get(0);
			return i;
		} catch (RuntimeException re)
		{
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.wanggz.core.domain.dao.BaseDao#getTotalCount(java.lang.String, java.util.Map)
	 */
	public long getTotalCount(Query query)
	{
		try
		{
			Long i = (Long) query.list().get(0);
			return i;
		} catch (RuntimeException re)
		{
			throw re;
		}
	}
	
	/**
	 * @function 根据查询条件查询记录数的个数
	 * @param hql
	 *            hql查询语句
	 * @param map
	 *            用map封装查询条件
	 * @return 数据库中满足查询条件的数据的条数
	 */
	public long getTotalCount(String hql, Object[] values)
	{
		try
		{
			Query query = this.getSession().createQuery(hql);
			for(int i=0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
			Long i = (Long) query.list().get(0);
			return i;
		} catch (RuntimeException re)
		{
			throw re;
		}
	}
	
	@Override
	public PageInfo<T> findPageInfoByQuery(int pageNo, int pageSize, String hql, String hqlCount, Map<String, Object> map) {
		// TODO Auto-generated method stub
		try{
			List<T> resutlList = (List<T>)this.findPageByQuery(pageNo, pageSize, hql, map);
			long rowCount = this.getTotalCount(hqlCount, map);
			PageInfo<T> pager = new PageInfo<T>(resutlList, rowCount, new Long(pageNo), new Long(pageSize));
			return pager;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @function 分页显示符合所有的记录数，将查询结果封装为Pager
	 * @param pageNo
	 *            当前页数
	 * @param pageSize
	 *            每页显示的条数
	 * @param criterions
	 *            不定参数Criterion
	 * @return 查询结果Pager
	 */
	public PageInfo<T> findPageByCriteria(int pageNo, int pageSize, Criterion[] criterions)
	{
		PageInfo<T> pager = null;
		try
		{
			Criteria criteria = this.getSession().createCriteria(entityClass);
			if (criterions != null)
			{
				for (Criterion criterion : criterions)
				{
					if (criterion != null)
					{
						criteria.add(criterion);
					}
				}
			}
			// 获取根据条件分页查询的总行数
			int rowCount = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
			criteria.setProjection(null);
			criteria.setFirstResult((pageNo - 1) * pageSize);
			criteria.setMaxResults(pageSize);
			List<T> result = criteria.list();
			pager = new PageInfo<T>(result, new Long(rowCount), new Long(pageNo), new Long(pageSize));
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			throw re;
		} 
		return pager;
	}

	@Override
	public List<?> findPageByQuery(int pageNo, int pageSize, String hql, Object[] values) {
		// TODO Auto-generated method stub
		List<Object> result = null;
		try
		{
			Query query = this.getSession().createQuery(hql);
			for(int i=0; i<values.length; i++)
			{
				query.setParameter(i, values[i]);
			}
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
			result = query.list();
		} catch (RuntimeException re)
		{
			throw re;
		}
		return result;
	}

	@Override
	public PageInfo<T> findPageInfoByQuery(int pageNo, int pageSize, String hql, String hqlCount, Object[] values) {
		// TODO Auto-generated method stub
		try{
			List<T> resutlList = (List<T>)this.findPageByQuery(pageNo, pageSize, hql, values);
			long rowCount = this.getTotalCount(hqlCount, values);
			PageInfo<T> pager = new PageInfo<T>(resutlList, rowCount, new Long(pageNo), new Long(pageSize));
			return pager;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<T> findPageByQuery(int pageNo, int pageSize, Query query) {
		// TODO Auto-generated method stub
		try{
			if (pageSize <= 0)
				pageSize = 10;
			if (pageNo <= 0) {
				pageNo = 1;
			}
			int start = (pageNo - 1) * pageSize;
			return query.setFirstResult(start).setMaxResults(pageSize).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageInfo<T> findPageInfoByQuery(int pageNo, int pageSize, Query query, String hqlCount) {
		// TODO Auto-generated method stub
		try{
			if (pageSize <= 0)
				pageSize = 10;
			if (pageNo <= 0) {
				pageNo = 1;
			}
			int start = (pageNo - 1) * pageSize;
			List<T> resutlList = query.setFirstResult(start).setMaxResults(pageSize).list();
			long rowCount = this.getTotalCount(hqlCount);
			PageInfo<T> pager = new PageInfo<T>(resutlList, rowCount, new Long(pageNo), new Long(pageSize));
			return pager;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<?> findObjectListByQuery(String hql, Map<String, Object> map) {
		// TODO Auto-generated method stub
		try{
			Query query = this.getSession().createQuery(hql);
			Iterator it = map.keySet().iterator();
			while (it.hasNext()) {
				Object key = it.next();
				query.setParameter(key.toString(), map.get(key));
			}
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
