/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.sys.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.sys.dao.SysUserPrivilegeDao;
import com.weixin.datacore.domain.sys.model.SysUserPrivilege;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("sysUserPrivilegeDao")
public class SysUserPrivilegeDaoImpl extends HibernateDAOImpl<SysUserPrivilege, Serializable, Long> implements
		SysUserPrivilegeDao {

}
