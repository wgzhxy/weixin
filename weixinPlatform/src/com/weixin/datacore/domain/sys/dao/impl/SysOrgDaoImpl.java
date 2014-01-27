/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.sys.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.sys.dao.SysOrgDao;
import com.weixin.datacore.domain.sys.model.SysOrg;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("sysOrgDao")
public class SysOrgDaoImpl extends HibernateDAOImpl<SysOrg, Serializable, Long> implements
		SysOrgDao {

}
