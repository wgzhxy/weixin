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
import com.weixin.datacore.domain.weixin.dao.WeixinPageClassDao;
import com.weixin.datacore.domain.weixin.model.WeixinPageClass;
import com.weixin.datacore.service.weixin.WeixinPageClassSrv;

@Service("weixinPageClassSrv")
public class WeixinPageClassSrvImpl extends ServiceSrvImpl implements WeixinPageClassSrv {

	@Override
	public WeixinPageClass addWeixinPageClass(WeixinPageClass weixinPageClass) {
		// TODO Auto-generated method stub
		return (WeixinPageClass)weixinPageClassDao.save(weixinPageClass);
	}

	@Override
	public void deleWeixinPageClass(WeixinPageClass weixinPageClass) {
		// TODO Auto-generated method stub
		weixinPageClassDao.delete(weixinPageClass);
	}

	@Override
	public void deleWeixinPageClass(Long id) {
		// TODO Auto-generated method stub
		weixinPageClassDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinPageClass(WeixinPageClass weixinPageClass) {
		// TODO Auto-generated method stub
		weixinPageClassDao.saveOrUpdate(weixinPageClass);
	}
	
	@Override
	public void saveBatchWeixinPageClass(List<WeixinPageClass> weixinPageClassLs) {
		// TODO Auto-generated method stub
		weixinPageClassDao.addBacth(weixinPageClassLs);
	}
	
	public PageInfo<WeixinPageClass> findWeixinPageClassList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<WeixinPageClass> findWeixinPageClassList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public WeixinPageClass getWeixinPageClass(Long id) {
		return weixinPageClassDao.get(id);
	}
	
	@Resource(name="weixinPageClassDao")
	private WeixinPageClassDao weixinPageClassDao;
}
