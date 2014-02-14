/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.busi.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.busi.dao.BusiCouponReceiveDao;
import com.weixin.datacore.domain.busi.model.BusiCouponReceive;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("busiCouponReceiveDao")
public class BusiCouponReceiveDaoImpl extends HibernateDAOImpl<BusiCouponReceive, Serializable, Long> implements
		BusiCouponReceiveDao {

}
