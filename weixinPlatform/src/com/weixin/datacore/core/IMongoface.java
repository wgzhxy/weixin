/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/

package com.weixin.datacore.core;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;
import com.weixin.comm.PageInfo;

/**
 * Mongo dao公用接口类
 * 
 * @author Wang.g.z
 * @category 短信调度
 * 
 */
@SuppressWarnings("hiding")
public interface IMongoface<T> {

	public long count(Query query, Class<?> entityClass);

	public long count(Query query, String collectionName);

	public <T> List<T> find(Query query, Class<T> entityClass);

	public <T> List<T> find(Query query, Class<T> entityClass, String collectionName);

	public <T> T findAndModify(Query query, Update update, Class<T> entityClass);

	public <T> T findAndModify(Query query, Update update, Class<T> entityClass, String collectionName);

	public <T> T findAndRemove(Query query, Class<T> entityClass);

	public <T> T findAndRemove(Query query, Class<T> entityClass, String collectionName);

	public <T> T findById(Object id, Class<T> entityClass);

	public <T> T findById(Object id, Class<T> entityClass, String collectionName);

	public <T> T findOne(Query query, Class<T> entityClass);

	public void insert(Object objectToSave);

	public void insert(Object objectToSave, String collectionName);

	public void insert(Collection<? extends Object> batchToSave, Class<?> entityClass);

	public void insert(Collection<? extends Object> batchToSave, String collectionName);

	public void insertAll(Collection<? extends Object> objectsToSave);

	public void remove(Object arg0);

	public void remove(Query query, String collectionName);

	public <T> void remove(Query query, Class<T> entityClass);

	public void save(Object objectToSave);

	public void save(Object objectToSave, String collectionName);

	public WriteResult updateMulti(Query query, Update update, Class<?> entityClass);

	public WriteResult updateFirst(Query query, Update update, Class<?> entityClass);

	public WriteResult updateMulti(Query query, Update update, String collectionName);

	public WriteResult updateFirst(Query query, Update update, String collectionName);

	public WriteResult upsert(Query query, Update update, Class<?> entityClass);

	public WriteResult upsert(Query query, Update update, String collectionName);

	public <T> boolean collectionExists(Class<T> entityClass);

	public boolean collectionExists(String collectionName);
	
	public PageInfo<T> findByPage(int pageNo, int pageSize, Query query, Class<?> entityClass);
}
