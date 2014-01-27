/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.weixin.dao.WeixinMenuItemDao;
import com.weixin.datacore.domain.weixin.model.WeixinMenuItem;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("weixinMenuItemDao")
public class WeixinMenuItemDaoImpl extends HibernateDAOImpl<WeixinMenuItem, Serializable, Long> implements
		WeixinMenuItemDao {

}
