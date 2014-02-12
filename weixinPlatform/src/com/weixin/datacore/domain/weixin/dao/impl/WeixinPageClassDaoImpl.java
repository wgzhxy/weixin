/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.weixin.dao.WeixinPageClassDao;
import com.weixin.datacore.domain.weixin.model.WeixinPageClass;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("weixinPageClassDao")
public class WeixinPageClassDaoImpl extends HibernateDAOImpl<WeixinPageClass, Serializable, Long> implements
		WeixinPageClassDao {

}
