/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.sys.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.sys.dao.SysDictionaryDao;
import com.weixin.datacore.domain.sys.model.SysDictionary;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("sysDictionaryDao")
public class SysDictionaryDaoImpl extends HibernateDAOImpl<SysDictionary, Serializable, Long> implements
		SysDictionaryDao {

}
