/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.weixin.dao.WeixinMenuDao;
import com.weixin.datacore.domain.weixin.model.WeixinMenu;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("weixinMenuDao")
public class WeixinMenuDaoImpl extends HibernateDAOImpl<WeixinMenu, Serializable, Long> implements
WeixinMenuDao {
}
