/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.weixin.dao.WeixinMessageLogDao;
import com.weixin.datacore.domain.weixin.model.WeixinMessageLog;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("weixinMessageLogDao")
public class WeixinMessageLogDaoImpl extends HibernateDAOImpl<WeixinMessageLog, Serializable, Long> implements
		WeixinMessageLogDao {

}
