/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.sys.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.sys.dao.SysUserRoleDao;
import com.weixin.datacore.domain.sys.model.SysUserRole;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("sysUserRoleDao")
public class SysUserRoleDaoImpl extends HibernateDAOImpl<SysUserRole, Serializable, Long> implements
		SysUserRoleDao {

}
