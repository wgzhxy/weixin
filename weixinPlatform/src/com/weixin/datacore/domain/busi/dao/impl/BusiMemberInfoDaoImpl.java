/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.busi.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.busi.dao.BusiMemberInfoDao;
import com.weixin.datacore.domain.busi.model.BusiMemberInfo;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("busiMemberInfoDao")
public class BusiMemberInfoDaoImpl extends HibernateDAOImpl<BusiMemberInfo, Serializable, Long> implements
		BusiMemberInfoDao {

}
