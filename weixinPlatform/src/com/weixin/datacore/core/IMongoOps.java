/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/

package com.weixin.datacore.core;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.weixin.comm.Pagination;

/**
 * Mongo 其用接口类
 * 
 * @author Wang.g.z
 * @category 短信调度
 * 
 */
public interface IMongoOps<T> extends MongoOperations {
	public Pagination<T> findByPage(int pageNo, int pageSize, Query query, Class<?> entityClass);
}
