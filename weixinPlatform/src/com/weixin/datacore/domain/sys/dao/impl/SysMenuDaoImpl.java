/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.sys.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.sys.dao.SysMenuDao;
import com.weixin.datacore.domain.sys.model.SysMenu;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("sysMenuDao")
public class SysMenuDaoImpl extends HibernateDAOImpl<SysMenu, Serializable, Long> implements
		SysMenuDao {

}
