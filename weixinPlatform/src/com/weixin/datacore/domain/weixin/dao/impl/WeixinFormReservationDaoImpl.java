/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.weixin.dao.WeixinFormReservationDao;
import com.weixin.datacore.domain.weixin.model.WeixinFormReservation;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("weixinFormReservationDao")
public class WeixinFormReservationDaoImpl extends HibernateDAOImpl<WeixinFormReservation, Serializable, Long> implements
WeixinFormReservationDao {
}
