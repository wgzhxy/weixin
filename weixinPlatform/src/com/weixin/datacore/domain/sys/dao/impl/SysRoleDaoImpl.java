/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.sys.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.sys.dao.SysRoleDao;
import com.weixin.datacore.domain.sys.model.SysRole;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("sysRoleDao")
public class SysRoleDaoImpl extends HibernateDAOImpl<SysRole, Serializable, Long> implements
		SysRoleDao {

}
