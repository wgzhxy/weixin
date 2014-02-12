/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.weixin.dao.WeixinPageInfoDao;
import com.weixin.datacore.domain.weixin.model.WeixinPageInfo;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("weixinPageInfoDao")
public class WeixinPageInfoDaoImpl extends HibernateDAOImpl<WeixinPageInfo, Serializable, Long> implements
		WeixinPageInfoDao {

}
