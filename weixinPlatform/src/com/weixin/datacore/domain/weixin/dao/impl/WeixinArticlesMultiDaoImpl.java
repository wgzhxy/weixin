/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.weixin.dao.WeixinArticlesMultiDao;
import com.weixin.datacore.domain.weixin.model.WeixinArticlesMulti;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("weixinArticlesMultiDao")
public class WeixinArticlesMultiDaoImpl extends HibernateDAOImpl<WeixinArticlesMulti, Serializable, Long> implements
		WeixinArticlesMultiDao {

}
