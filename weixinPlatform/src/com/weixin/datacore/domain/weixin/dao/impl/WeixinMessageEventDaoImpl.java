/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.weixin.dao.WeixinMessageEventDao;
import com.weixin.datacore.domain.weixin.model.WeixinMessageEvent;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("weixinMessageEventDao")
public class WeixinMessageEventDaoImpl extends HibernateDAOImpl<WeixinMessageEvent, Serializable, Long> implements
		WeixinMessageEventDao {

}
