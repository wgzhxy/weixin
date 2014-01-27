/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao;

import java.io.Serializable;
import com.weixin.datacore.domain.weixin.model.WeixinMessageEvent;
import com.weixin.datacore.core.HibernateDAO;

public interface WeixinMessageEventDao extends HibernateDAO<WeixinMessageEvent, Serializable, Long> {

}
