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
import com.weixin.datacore.domain.busi.dao.BusiCouponReceiveDao;
import com.weixin.datacore.domain.busi.model.BusiCouponReceive;
import com.weixin.datacore.service.busi.BusiCouponReceiveSrv;

@Service("busiCouponReceiveSrv")
public class BusiCouponReceiveSrvImpl extends ServiceSrvImpl implements BusiCouponReceiveSrv {

	@Override
	public BusiCouponReceive addBusiCouponReceive(BusiCouponReceive busiCouponReceive) {
		// TODO Auto-generated method stub
		return (BusiCouponReceive)busiCouponReceiveDao.save(busiCouponReceive);
	}

	@Override
	public void deleBusiCouponReceive(BusiCouponReceive busiCouponReceive) {
		// TODO Auto-generated method stub
		busiCouponReceiveDao.delete(busiCouponReceive);
	}

	@Override
	public void deleBusiCouponReceive(Long id) {
		// TODO Auto-generated method stub
		busiCouponReceiveDao.deleteByKey(id);
	}

	@Override
	public void updateBusiCouponReceive(BusiCouponReceive busiCouponReceive) {
		// TODO Auto-generated method stub
		busiCouponReceiveDao.saveOrUpdate(busiCouponReceive);
	}
	
	@Override
	public void saveBatchBusiCouponReceive(List<BusiCouponReceive> busiCouponReceiveLs) {
		// TODO Auto-generated method stub
		busiCouponReceiveDao.addBacth(busiCouponReceiveLs);
	}
	
	public PageInfo<BusiCouponReceive> findBusiCouponReceiveList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<BusiCouponReceive> findBusiCouponReceiveList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public BusiCouponReceive getBusiCouponReceive(Long id) {
		return busiCouponReceiveDao.get(id);
	}
	
	@Resource(name="busiCouponReceiveDao")
	private BusiCouponReceiveDao busiCouponReceiveDao;
}
