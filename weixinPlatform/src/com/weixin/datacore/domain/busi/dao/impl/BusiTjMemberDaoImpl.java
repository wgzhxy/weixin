/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.busi.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.busi.dao.BusiTjMemberDao;
import com.weixin.datacore.domain.busi.model.BusiTjMember;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("busiTjMemberDao")
public class BusiTjMemberDaoImpl extends HibernateDAOImpl<BusiTjMember, Serializable, Long> implements
		BusiTjMemberDao {

}
