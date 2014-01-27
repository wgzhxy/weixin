/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.weixin.dao.WeixinFocusUserDao;
import com.weixin.datacore.domain.weixin.model.WeixinFocusUser;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("weixinFocusUserDao")
public class WeixinFocusUserDaoImpl extends HibernateDAOImpl<WeixinFocusUser, Serializable, Long> implements
		WeixinFocusUserDao {

}
