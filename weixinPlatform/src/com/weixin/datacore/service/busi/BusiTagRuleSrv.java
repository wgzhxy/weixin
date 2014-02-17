/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.busi;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.busi.model.BusiTagRule;

public interface BusiTagRuleSrv extends ServiceSrv {

	public BusiTagRule addBusiTagRule(BusiTagRule busiTagRule);
	
	public void deleBusiTagRule(BusiTagRule busiTagRule);
	
	public void deleBusiTagRule(Long id);
	
	public void updateBusiTagRule(BusiTagRule busiTagRule);
	
	public void saveBatchBusiTagRule(List<BusiTagRule> busiTagRuleLs);
	
	public PageInfo<BusiTagRule> findBusiTagRuleList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<BusiTagRule> findBusiTagRuleList(Object[] params, int pageNo, int pageSize);
	
	public BusiTagRule getBusiTagRule(Long id);
}
