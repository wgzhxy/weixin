/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.weixin.dao.WeixinUserGroupDao;
import com.weixin.datacore.domain.weixin.model.WeixinUserGroup;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("weixinUserGroupDao")
public class WeixinUserGroupDaoImpl extends HibernateDAOImpl<WeixinUserGroup, Serializable, Long> implements
		WeixinUserGroupDao {

}
