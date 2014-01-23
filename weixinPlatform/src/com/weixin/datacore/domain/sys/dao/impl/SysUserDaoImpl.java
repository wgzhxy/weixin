/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.sys.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.sys.dao.SysUserDao;
import com.weixin.datacore.domain.sys.model.SysUser;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("sysUserDao")
public class SysUserDaoImpl extends HibernateDAOImpl<SysUser, Serializable, Long> implements
		SysUserDao {

}
