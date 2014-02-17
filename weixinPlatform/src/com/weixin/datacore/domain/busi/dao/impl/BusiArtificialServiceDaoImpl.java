/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.busi.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.busi.dao.BusiArtificialServiceDao;
import com.weixin.datacore.domain.busi.model.BusiArtificialService;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("busiArtificialServiceDao")
public class BusiArtificialServiceDaoImpl extends HibernateDAOImpl<BusiArtificialService, Serializable, Long> implements
		BusiArtificialServiceDao {

}
