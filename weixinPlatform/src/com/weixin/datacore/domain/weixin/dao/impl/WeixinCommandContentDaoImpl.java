/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.weixin.dao.WeixinCommandContentDao;
import com.weixin.datacore.domain.weixin.model.WeixinCommandContent;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("weixinCommandContentDao")
public class WeixinCommandContentDaoImpl extends HibernateDAOImpl<WeixinCommandContent, Serializable, Long> implements
		WeixinCommandContentDao {

}
