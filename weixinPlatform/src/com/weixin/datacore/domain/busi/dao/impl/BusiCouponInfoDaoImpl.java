/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.busi.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.busi.dao.BusiCouponInfoDao;
import com.weixin.datacore.domain.busi.model.BusiCouponInfo;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("busiCouponInfoDao")
public class BusiCouponInfoDaoImpl extends HibernateDAOImpl<BusiCouponInfo, Serializable, Long> implements
		BusiCouponInfoDao {

}
