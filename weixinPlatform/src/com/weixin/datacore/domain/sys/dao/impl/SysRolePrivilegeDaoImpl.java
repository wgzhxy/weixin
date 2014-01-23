/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.sys.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.sys.dao.SysRolePrivilegeDao;
import com.weixin.datacore.domain.sys.model.SysRolePrivilege;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("sysRolePrivilegeDao")
public class SysRolePrivilegeDaoImpl extends HibernateDAOImpl<SysRolePrivilege, Serializable, Long> implements
		SysRolePrivilegeDao {

}
