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
import com.weixin.datacore.domain.busi.dao.BusiCouponInfoDao;
import com.weixin.datacore.domain.busi.model.BusiCouponInfo;
import com.weixin.datacore.service.busi.BusiCouponInfoSrv;

@Service("busiCouponInfoSrv")
public class BusiCouponInfoSrvImpl extends ServiceSrvImpl implements BusiCouponInfoSrv {

	@Override
	public BusiCouponInfo addBusiCouponInfo(BusiCouponInfo busiCouponInfo) {
		// TODO Auto-generated method stub
		return (BusiCouponInfo)busiCouponInfoDao.save(busiCouponInfo);
	}

	@Override
	public void deleBusiCouponInfo(BusiCouponInfo busiCouponInfo) {
		// TODO Auto-generated method stub
		busiCouponInfoDao.delete(busiCouponInfo);
	}

	@Override
	public void deleBusiCouponInfo(Long id) {
		// TODO Auto-generated method stub
		busiCouponInfoDao.deleteByKey(id);
	}

	@Override
	public void updateBusiCouponInfo(BusiCouponInfo busiCouponInfo) {
		// TODO Auto-generated method stub
		busiCouponInfoDao.saveOrUpdate(busiCouponInfo);
	}
	
	@Override
	public void saveBatchBusiCouponInfo(List<BusiCouponInfo> busiCouponInfoLs) {
		// TODO Auto-generated method stub
		busiCouponInfoDao.addBacth(busiCouponInfoLs);
	}
	
	public PageInfo<BusiCouponInfo> findBusiCouponInfoList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<BusiCouponInfo> findBusiCouponInfoList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public BusiCouponInfo getBusiCouponInfo(Long id) {
		return busiCouponInfoDao.get(id);
	}
	
	@Resource(name="busiCouponInfoDao")
	private BusiCouponInfoDao busiCouponInfoDao;
}
