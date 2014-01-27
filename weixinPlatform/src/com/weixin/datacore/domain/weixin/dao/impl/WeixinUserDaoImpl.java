/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.weixin.dao.WeixinUserDao;
import com.weixin.datacore.domain.weixin.model.WeixinUser;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("weixinUserDao")
public class WeixinUserDaoImpl extends HibernateDAOImpl<WeixinUser, Serializable, Long> implements
		WeixinUserDao {

}
