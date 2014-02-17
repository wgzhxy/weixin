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
import com.weixin.datacore.domain.busi.dao.BusiMemberInfoDao;
import com.weixin.datacore.domain.busi.model.BusiMemberInfo;
import com.weixin.datacore.service.busi.BusiMemberInfoSrv;

@Service("busiMemberInfoSrv")
public class BusiMemberInfoSrvImpl extends ServiceSrvImpl implements BusiMemberInfoSrv {

	@Override
	public BusiMemberInfo addBusiMemberInfo(BusiMemberInfo busiMemberInfo) {
		// TODO Auto-generated method stub
		return (BusiMemberInfo)busiMemberInfoDao.save(busiMemberInfo);
	}

	@Override
	public void deleBusiMemberInfo(BusiMemberInfo busiMemberInfo) {
		// TODO Auto-generated method stub
		busiMemberInfoDao.delete(busiMemberInfo);
	}

	@Override
	public void deleBusiMemberInfo(Long id) {
		// TODO Auto-generated method stub
		busiMemberInfoDao.deleteByKey(id);
	}

	@Override
	public void updateBusiMemberInfo(BusiMemberInfo busiMemberInfo) {
		// TODO Auto-generated method stub
		busiMemberInfoDao.saveOrUpdate(busiMemberInfo);
	}
	
	@Override
	public void saveBatchBusiMemberInfo(List<BusiMemberInfo> busiMemberInfoLs) {
		// TODO Auto-generated method stub
		busiMemberInfoDao.addBacth(busiMemberInfoLs);
	}
	
	public PageInfo<BusiMemberInfo> findBusiMemberInfoList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<BusiMemberInfo> findBusiMemberInfoList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public BusiMemberInfo getBusiMemberInfo(Long id) {
		return busiMemberInfoDao.get(id);
	}
	
	@Resource(name="busiMemberInfoDao")
	private BusiMemberInfoDao busiMemberInfoDao;
}
