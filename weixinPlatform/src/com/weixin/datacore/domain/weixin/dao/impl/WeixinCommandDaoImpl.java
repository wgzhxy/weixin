/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.weixin.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.weixin.dao.WeixinCommandDao;
import com.weixin.datacore.domain.weixin.model.WeixinCommand;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("weixinCommandDao")
public class WeixinCommandDaoImpl extends HibernateDAOImpl<WeixinCommand, Serializable, Long> implements
		WeixinCommandDao {

}
