/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.busi.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.busi.dao.BusiTagRuleDao;
import com.weixin.datacore.domain.busi.model.BusiTagRule;
import com.weixin.datacore.service.busi.BusiTagRuleSrv;

@Service("busiTagRuleSrv")
public class BusiTagRuleSrvImpl extends ServiceSrvImpl implements BusiTagRuleSrv {

	@Override
	public BusiTagRule addBusiTagRule(BusiTagRule busiTagRule) {
		// TODO Auto-generated method stub
		return (BusiTagRule)busiTagRuleDao.save(busiTagRule);
	}

	@Override
	public void deleBusiTagRule(BusiTagRule busiTagRule) {
		// TODO Auto-generated method stub
		busiTagRuleDao.delete(busiTagRule);
	}

	@Override
	public void deleBusiTagRule(Long id) {
		// TODO Auto-generated method stub
		busiTagRuleDao.deleteByKey(id);
	}

	@Override
	public void updateBusiTagRule(BusiTagRule busiTagRule) {
		// TODO Auto-generated method stub
		busiTagRuleDao.saveOrUpdate(busiTagRule);
	}
	
	@Override
	public void saveBatchBusiTagRule(List<BusiTagRule> busiTagRuleLs) {
		// TODO Auto-generated method stub
		busiTagRuleDao.addBacth(busiTagRuleLs);
	}
	
	public PageInfo<BusiTagRule> findBusiTagRuleList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<BusiTagRule> findBusiTagRuleList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public BusiTagRule getBusiTagRule(Long id) {
		return busiTagRuleDao.get(id);
	}
	
	@Resource(name="busiTagRuleDao")
	private BusiTagRuleDao busiTagRuleDao;
}
