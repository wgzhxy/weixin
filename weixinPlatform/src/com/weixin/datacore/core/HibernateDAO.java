package com.weixin.datacore.core;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.weixin.comm.PageInfo;

/**
 * Generic DAO interface, define general database access methods
 * 
 * @author wang.g.z
 */
public interface HibernateDAO<T extends Serializable, K extends Serializable, PK extends Serializable> {

	/**
	 * HQL format which lists entities of given id array and ordered as the
	 * array specified
	 */
	public static String GET_ENTITIIES_BY_IDS_TEMPLATE = "from %s where %s in (%s) order by case %s end";

	/**
	 * get a HQL string which lists entities of given id array and ordered as
	 * the array specified
	 * 
	 * @param entityByName
	 *            entity class to query
	 * @param idPropertyName
	 *            id property name
	 * @param ids
	 *            the id array
	 */
	public String formatGetEntitiesByIdsQuery(String entityByName, String idPropertyName, List<PK> ids);

	/**
	 * delete a entity from database
	 */
	public void delete(T entity);

	/**
	 * delete a entity by ID
	 */
	public void deleteById(Class<T> entityClass, PK id);

	/**
	 * add or update a entity
	 */
	public void saveorupdate(T entity);

	/**
	 * use a hql to add/update/delete entities
	 * 
	 * @param hql
	 *            the hql
	 * @param params
	 *            paramaters to replace "?" in hql template
	 */
	public void update(final String hql, final Object[] params);

	/**
	 * find all entities for a given entity class. Note. this will create huge
	 * performance impact when target entity class has large number of records.
	 * Suggest use only for static tables with small and fixed records
	 * 
	 * @param entityClass
	 *            the entity class
	 */
	public List<T> findAll(Class entityClass);

	/**
	 * get an entity by PK
	 * 
	 * @param entityClass
	 *            the entity class
	 * @param id
	 *            entity id
	 */
	public T findById(Class<T> entityClass, PK id);

	/**
	 * list result of given hql
	 * 
	 * @param hql
	 *            the hql query
	 * @param params
	 *            paramaters to replace "?" in hql template
	 */
	public List<T> findByHql(String hql, Object[] params);

	/**
	 * list result of given hql with pagenation params
	 * 
	 * @param hql
	 *            hql the hql query
	 * @param params
	 *            paramaters to replace "?" in hql template
	 * @param start
	 *            start number of results
	 * @param max
	 *            max records in result list
	 */
	public List<T> findByHql(String hql, Object[] params, int start, int max);

	/**
	 * use criteria to query database. details see DetachedCriteria class
	 * 
	 * @param ca
	 *            criteria
	 */
	public List<T> findByCriteria(DetachedCriteria ca);

	/**
	 * use criteria to query database with pagenation params
	 * 
	 * @param ca
	 *            criteria
	 * @param startNo
	 *            start number of results
	 * @param maxNo
	 *            max records in result list
	 */
	public List<T> findByCriteria(DetachedCriteria ca, int start, int max);

	/**
	 * Find the total record count of given entity
	 * 
	 * @param entityClass
	 *            the entity class
	 */
	public int getTotalCount(Class entityClass);

	/**
	 * return hibernateTemplate used by this DAO This method provides access to
	 * lower level hibernate API
	 */
	public HibernateTemplate getHibernateTemplate();

	/**
	 * get current managed session
	 */
	public Session getManagedSession();

	/**
	 * open a new session. musted be closed before exit
	 */
	public Session openSession();

	/**
	 * remove all entities in an array
	 * 
	 * @param entities
	 *            the entity array
	 */
	public void deleteAll(List<T> entities);
	
	public T get(PK id);

	public T load(PK id);

	public List<T> loadAll();

	public void update(T entity);

	public T merge(T entity);

	public Serializable save(T entity);

	public void saveOrUpdate(T entity);

	public void saveOrUpdateAll(Collection<T> entities);

	public void deleteByKey(PK id);

	public void deleteAll(Collection<T> entities);

	public List<T> loadByPagenationf(String hql, int pageNo, int pageSize, Object[] paras);
	
	public Iterator<?> loadByPagenationfIte(String hql, int pageNo, int pageSize, Object[] paras);

	public int addBacth(List<T> list);
	
	/**
	 * 纯SQL语句查询
	 * @param sql      纯sql语句
	 * @param value    变量名称
	 * @param pageNum  当前页
	 * @param pageSize 分页大小
	 * @return Iterator对象
	 */
	public Iterator<?> sqlQuery(String sql, Object[] value, int pageNum, int pageSize);
	
	/**
	 * 纯SQL语句查询
	 * @param sql      纯sql语句
	 * @param value    变量名称
	 * @return Iterator对象
	 */
	public Iterator<?> sqlQuery(String sql, Object[] value);
	
	/**
	 * 纯SQL语句查询
	 * @param sqlQuery
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Iterator<?> sqlQuery(SQLQuery sqlQuery, int pageNum, int pageSize);
	
	/**
	 * 纯SQL语句查询
	 * @param sqlQuery
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Iterator<?> sqlQuery(SQLQuery sqlQuery);
	
	public Object getStatValue(DetachedCriteria criteria, String propertyName, String StatName);
			
	public List<T> loadByPagenation(String hql, int pageNo, int pageSize, Object[] paras);
	
	public List<?> findPageByQuery(int pageNo, int pageSize, String hql,  Map<String, Object> map);
	
	public PageInfo<T> findPageInfoByQuery(int pageNo, int pageSize, String hql, String hqlCount, Map<String, Object> map);
	
	public List<?> findPageByQuery(int pageNo, int pageSize, String hql, Object[] values);
	
	public PageInfo<T> findPageInfoByQuery(int pageNo, int pageSize, String hql, String hqlCount, Object[] values);
	
	public List<T> findPageByQuery(int pageNo, int pageSize, Query query);
	
	public PageInfo<T> findPageInfoByQuery(int pageNo, int pageSize, Query query, String hqlCount);
	
	public long getTotalCount(String hql, Object[] values);
	
	public long getTotalCount(String hql, Map<String, Object> map);
	
	public List<?> findObjectListByQuery(String hql, Map<String, Object> map);
	
	public int updateBacth(List<T> list);
	
	public void delete(String hql, Object[] params);
}