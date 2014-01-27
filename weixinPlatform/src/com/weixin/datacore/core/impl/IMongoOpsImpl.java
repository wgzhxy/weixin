/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/

package com.weixin.datacore.core.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.DocumentCallbackHandler;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.IndexOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.geo.GeoResults;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.CommandResult;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.weixin.comm.Pagination;
import com.weixin.datacore.core.IMongoOps;

/**
 * Mongo 其用接口类实现
 * 
 * @author Wang.g.z
 * @category 短信调度
 * 
 */
//@Repository("iMongoOps")
public class IMongoOpsImpl<T> implements IMongoOps<T> {
	
	//@Resource(name = "mongoTemplate")
	private MongoTemplate mongoTemplate;

	
	public <T> boolean collectionExists(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.collectionExists(entityClass);
	}

	
	public boolean collectionExists(String collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.collectionExists(collectionName);
	}

	
	public long count(Query query, Class<?> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.count(query, entityClass);
	}

	
	public long count(Query query, String collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.count(query, collectionName);
	}

	
	public <T> DBCollection createCollection(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.createCollection(entityClass);
	}

	
	public DBCollection createCollection(String collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.createCollection(collectionName);
	}

	
	public <T> DBCollection createCollection(Class<T> entityClass,
			CollectionOptions collectionOptions) {
		// TODO Auto-generated method stub
		return mongoTemplate.createCollection(entityClass, collectionOptions);
	}

	
	public DBCollection createCollection(String collectionName, CollectionOptions collectionOptions) {
		// TODO Auto-generated method stub
		return mongoTemplate.createCollection(collectionName, collectionOptions);
	}

	
	public <T> void dropCollection(Class<T> entityClass) {
		// TODO Auto-generated method stub
		mongoTemplate.dropCollection(entityClass);
	}

	
	public void dropCollection(String collectionName) {
		// TODO Auto-generated method stub
		mongoTemplate.dropCollection(collectionName);
	}

	
	public <T> T execute(DbCallback<T> arg0) {
		// TODO Auto-generated method stub
		return mongoTemplate.execute(arg0);
	}

	
	public <T> T execute(Class<?> arg0, CollectionCallback<T> arg1) {
		// TODO Auto-generated method stub
		return mongoTemplate.execute(arg0, arg1);
	}

	
	public <T> T execute(String arg0, CollectionCallback<T> arg1) {
		// TODO Auto-generated method stub
		return mongoTemplate.execute(arg0, arg1);
	}

	
	public CommandResult executeCommand(String jsonCommand) {
		// TODO Auto-generated method stub
		return mongoTemplate.executeCommand(jsonCommand);
	}

	
	public CommandResult executeCommand(DBObject command) {
		// TODO Auto-generated method stub
		return mongoTemplate.executeCommand(command);
	}

	
	public CommandResult executeCommand(DBObject command, int options) {
		// TODO Auto-generated method stub
		return mongoTemplate.executeCommand(command, options);
	}

	
	public <T> T executeInSession(DbCallback<T> action) {
		// TODO Auto-generated method stub
		return mongoTemplate.executeInSession(action);
	}

	
	public void executeQuery(Query query, String collectionName, DocumentCallbackHandler dch) {
		// TODO Auto-generated method stub
		mongoTemplate.executeQuery(query, collectionName, dch);
	}

	
	public <T> List<T> find(Query query, Class<T> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.find(query, entityClass);
	}

	
	public <T> List<T> find(Query query, Class<T> entityClass, String collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.find(query, entityClass, collectionName);
	}

	
	public <T> List<T> findAll(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(entityClass);
	}

	
	public <T> List<T> findAll(Class<T> entityClass, String collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(entityClass, collectionName);
	}

	
	public <T> T findAndModify(Query query, Update update, Class<T> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.findAndModify(query, update, entityClass);
	}

	
	public <T> T findAndModify(Query query, Update update, Class<T> entityClass,
			String collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.findAndModify(query, update, entityClass, collectionName);
	}

	
	public <T> T findAndModify(Query query, Update update, FindAndModifyOptions options, 
			Class<T> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.findAndModify(query, update, options, entityClass);
	}

	
	public <T> T findAndModify(Query query, Update update,
			FindAndModifyOptions options, Class<T> entityClass, String collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.findAndModify(query, update, options, entityClass, collectionName);
	}

	
	public <T> T findAndRemove(Query query, Class<T> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.findAndRemove(query, entityClass);
	}

	
	public <T> T findAndRemove(Query query, Class<T> entityClass, String collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.findAndRemove(query, entityClass, collectionName);
	}

	
	public <T> T findById(Object id, Class<T> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.findById(id, entityClass);
	}

	
	public <T> T findById(Object id, Class<T> entityClass, String collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.findById(id, entityClass, collectionName);
	}

	
	public <T> T findOne(Query query, Class<T> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.findOne(query, entityClass);
	}

	
	public <T> T findOne(Query arg0, Class<T> arg1, String arg2) {
		// TODO Auto-generated method stub
		return mongoTemplate.findOne(arg0, arg1, arg2);
	}

	
	public <T> GeoResults<T> geoNear(NearQuery near, Class<T> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.geoNear(near, entityClass);
	}

	
	public <T> GeoResults<T> geoNear(NearQuery arg0, Class<T> arg1, String arg2) {
		// TODO Auto-generated method stub
		return mongoTemplate.geoNear(arg0, arg1, arg2);
	}

	
	public DBCollection getCollection(String collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.getCollection(collectionName);
	}

	
	public String getCollectionName(Class<?> collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.getCollectionName(collectionName);
	}

	
	public Set<String> getCollectionNames() {
		// TODO Auto-generated method stub
		return mongoTemplate.getCollectionNames();
	}

	
	public MongoConverter getConverter() {
		// TODO Auto-generated method stub
		return mongoTemplate.getConverter();
	}

	
	public <T> GroupByResults<T> group(String inputCollectionName, GroupBy groupBy, Class<T> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.group(inputCollectionName, groupBy, entityClass);
	}

	
	public <T> GroupByResults<T> group(Criteria arg0, String arg1,
			GroupBy arg2, Class<T> arg3) {
		// TODO Auto-generated method stub
		return mongoTemplate.group(arg0, arg1, arg2, arg3);
	}

	
	public IndexOperations indexOps(String collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.indexOps(collectionName);
	}

	
	public IndexOperations indexOps(Class<?> collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.indexOps(collectionName);
	}

	
	public void insert(Object objectToSave) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(objectToSave);
	}

	
	public void insert(Object objectToSave, String collectionName) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(objectToSave, collectionName);
	}

	
	public void insert(Collection<? extends Object> batchToSave, Class<?> entityClass) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(batchToSave, entityClass);
	}

	
	public void insert(Collection<? extends Object> batchToSave, String collectionName) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(batchToSave, collectionName);
	}

	
	public void insertAll(Collection<? extends Object> objectsToSave) {
		// TODO Auto-generated method stub
		mongoTemplate.insertAll(objectsToSave);
	}

	
	public <T> MapReduceResults<T> mapReduce(String inputCollectionName, String mapFunction,
			String reduceFunction, Class<T> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.mapReduce(inputCollectionName, mapFunction, reduceFunction, entityClass);
	}

	
	public <T> MapReduceResults<T> mapReduce(String inputCollectionName, String mapFunction,
			String reduceFunction, MapReduceOptions mapReduceOptions, Class<T> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.mapReduce(inputCollectionName, mapFunction, reduceFunction, mapReduceOptions, entityClass);
	}

	
	public <T> MapReduceResults<T> mapReduce(Query query, String inputCollectionName,
			String mapFunction, String reduceFunction, Class<T> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.mapReduce(query, inputCollectionName, mapFunction, reduceFunction, entityClass);
	}

	
	public <T> MapReduceResults<T> mapReduce(Query arg0, String arg1,
			String arg2, String arg3, MapReduceOptions arg4, Class<T> arg5) {
		// TODO Auto-generated method stub
		return mongoTemplate.mapReduce(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	
	public void remove(Object arg0) {
		// TODO Auto-generated method stub
		mongoTemplate.remove(arg0);
	}

	
	public void remove(Object object, String collection) {
		// TODO Auto-generated method stub
		mongoTemplate.remove(object, collection);
	}

	
	public <T> void remove(Query query, Class<T> entityClass) {
		// TODO Auto-generated method stub
		mongoTemplate.remove(query, entityClass);
	}

	
	public void remove(Query query, String collectionName) {
		// TODO Auto-generated method stub
		mongoTemplate.remove(query, collectionName);
	}

	
	public void save(Object objectToSave) {
		// TODO Auto-generated method stub
		mongoTemplate.save(objectToSave);
	}

	
	public void save(Object objectToSave, String collectionName) {
		// TODO Auto-generated method stub
		mongoTemplate.save(objectToSave, collectionName);
	}

	
	public WriteResult updateFirst(Query query, Update update, Class<?> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.updateFirst(query, update, entityClass);
	}

	
	public WriteResult updateFirst(Query query, Update update, String collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.updateFirst(query, update, collectionName);
	}

	
	public WriteResult updateMulti(Query query, Update update, Class<?> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.updateMulti(query, update, entityClass);
	}

	
	public WriteResult updateMulti(Query query, Update update, String collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.updateMulti(query, update, collectionName);
	}

	
	public WriteResult upsert(Query query, Update update, Class<?> entityClass) {
		// TODO Auto-generated method stub
		return mongoTemplate.upsert(query, update, entityClass);
	}

	
	public WriteResult upsert(Query query, Update update, String collectionName) {
		// TODO Auto-generated method stub
		return mongoTemplate.upsert(query, update, collectionName);
	}
	
	/**
	 * 通过条件查询,查询分页结果
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param query
	 * @return
	 */
	public Pagination<T> findByPage(int pageNo, int pageSize, Query query, Class<?> entityClass) {
		long totalCount = mongoTemplate.count(query, entityClass);
		Pagination<T> page = new Pagination<T>(pageNo, pageSize, totalCount);
		//skip相当于从那条记录开始
		query.skip(page.getFirstResult());
		//从skip开始,取多少条记录
		query.limit(pageSize);
		List<T> datas = (List<T>)mongoTemplate.find(query, entityClass);
		page.setDatas(datas);
		return page;
	}
}
