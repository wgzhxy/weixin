/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.domain.busi.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.weixin.datacore.domain.busi.dao.BusiTagRuleDao;
import com.weixin.datacore.domain.busi.model.BusiTagRule;
import com.weixin.datacore.core.impl.HibernateDAOImpl;

@Repository("busiTagRuleDao")
public class BusiTagRuleDaoImpl extends HibernateDAOImpl<BusiTagRule, Serializable, Long> implements
		BusiTagRuleDao {

}
