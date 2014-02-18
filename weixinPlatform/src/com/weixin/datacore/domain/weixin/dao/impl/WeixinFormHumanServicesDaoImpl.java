/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.core.impl.HibernateDAOImpl;
import com.weixin.datacore.domain.weixin.dao.WeixinFormHumanServicesDao;
import com.weixin.datacore.domain.weixin.model.WeixinFormHumanServices;

@Repository("weixinFormHumanServicesDao")
public class WeixinFormHumanServicesDaoImpl extends HibernateDAOImpl<WeixinFormHumanServices, Serializable, Long> implements
WeixinFormHumanServicesDao {
}
