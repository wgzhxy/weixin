package com.weixin.datacore.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 * Generic DAO interface, define general database access methods
 * 
 * @author Liang Dong
 */
@SuppressWarnings("rawtypes")
public interface HibernateDAO {

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
	public String formatGetEntitiesByIdsQuery(String entityByName, String idPropertyName, List ids);

	/**
	 * add a new entity into database
	 */
	public void save(Object entity);

	/**
	 * delete a entity from database
	 */
	public void delete(Object entity);

	/**
	 * delete a entity by ID
	 */
	public void deleteById(Class entityClass, Serializable id);

	/**
	 * add or update a entity
	 */
	public void saveorupdate(Object entity);

	/**
	 * find all entities for a given entity class. Note. this will create huge
	 * performance impact when target entity class has large number of records.
	 * Suggest use only for static tables with small and fixed records
	 * 
	 * @param entityClass
	 *            the entity class
	 */
	public List findAll(Class entityClass);

	/**
	 * get an entity by PK
	 * 
	 * @param entityClass
	 *            the entity class
	 * @param id
	 *            entity id
	 */
	public Object findById(Class entityClass, Serializable id);

	/**
	 * list result of given hql
	 * 
	 * @param hql
	 *            the hql query
	 * @param params
	 *            paramaters to replace "?" in hql template
	 */
	public List findByHql(String hql, Object[] params);

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
	public List findByHql(String hql, Object[] params, int start, int max);

	/**
	 * use criteria to query database. details see DetachedCriteria class
	 * 
	 * @param ca
	 *            criteria
	 */
	public List findByCriteria(DetachedCriteria ca);

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
	public List findByCriteria(DetachedCriteria ca, int start, int max);

	/**
	 * Find the total record count of given entity
	 * 
	 * @param entityClass
	 *            the entity class
	 */
	public long getTotalCount(Class entityClass);

	/**
	 * get current managed session
	 */
	public Session getManagedSession();

	/**
	 * open a new session. musted be closed before exit
	 */
	public Session openSession();
	
	/**
	 * execute HQL. Design for update, delete and insert statements.
	 * @createDate 2013-8-7
	 */
	public int executeUpdate(String hql, Object[] params) throws Exception;
	
	public void addAll(List entities);
	
	public void delAll(List entities);
	
	public void updateAll(List entities);
}