/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.weixin.dao.WeixinPageInfoDao;
import com.weixin.datacore.domain.weixin.model.WeixinPageInfo;
import com.weixin.datacore.service.weixin.WeixinPageInfoSrv;

@Service("weixinPageInfoSrv")
public class WeixinPageInfoSrvImpl extends ServiceSrvImpl implements WeixinPageInfoSrv {

	@Override
	public WeixinPageInfo addWeixinPageInfo(WeixinPageInfo weixinPageInfo) {
		// TODO Auto-generated method stub
		return (WeixinPageInfo)weixinPageInfoDao.save(weixinPageInfo);
	}

	@Override
	public void deleWeixinPageInfo(WeixinPageInfo weixinPageInfo) {
		// TODO Auto-generated method stub
		weixinPageInfoDao.delete(weixinPageInfo);
	}

	@Override
	public void deleWeixinPageInfo(Long id) {
		// TODO Auto-generated method stub
		weixinPageInfoDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinPageInfo(WeixinPageInfo weixinPageInfo) {
		// TODO Auto-generated method stub
		weixinPageInfoDao.saveOrUpdate(weixinPageInfo);
	}
	
	@Override
	public void saveBatchWeixinPageInfo(List<WeixinPageInfo> weixinPageInfoLs) {
		// TODO Auto-generated method stub
		weixinPageInfoDao.addBacth(weixinPageInfoLs);
	}
	
	public PageInfo<WeixinPageInfo> findWeixinPageInfoList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<WeixinPageInfo> findWeixinPageInfoList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public WeixinPageInfo getWeixinPageInfo(Long id) {
		return weixinPageInfoDao.get(id);
	}
	
	@Resource(name="weixinPageInfoDao")
	private WeixinPageInfoDao weixinPageInfoDao;
}
