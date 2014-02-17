/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.busi.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.busi.dao.BusiViewHouseDao;
import com.weixin.datacore.domain.busi.model.BusiViewHouse;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("busiViewHouseDao")
public class BusiViewHouseDaoImpl extends HibernateDAOImpl<BusiViewHouse, Serializable, Long> implements
		BusiViewHouseDao {

}
