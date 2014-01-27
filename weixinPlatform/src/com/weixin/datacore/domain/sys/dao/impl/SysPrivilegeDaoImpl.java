/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.sys.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.sys.dao.SysPrivilegeDao;
import com.weixin.datacore.domain.sys.model.SysPrivilege;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("sysPrivilegeDao")
public class SysPrivilegeDaoImpl extends HibernateDAOImpl<SysPrivilege, Serializable, Long> implements
		SysPrivilegeDao {

}
