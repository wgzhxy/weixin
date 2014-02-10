/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.weixin.dao.WeixinArticlesDao;
import com.weixin.datacore.domain.weixin.model.WeixinArticles;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("weixinArticlesDao")
public class WeixinArticlesDaoImpl extends HibernateDAOImpl<WeixinArticles, Serializable, Long> implements
		WeixinArticlesDao {

}
