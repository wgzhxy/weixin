/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.weixin.dao.WeixinMenuItemDao;
import com.weixin.datacore.domain.weixin.model.WeixinMenuItem;
import com.weixin.datacore.service.weixin.WeixinMenuItemSrv;
import com.weixin.comm.PageInfo;

@Service("weixinMenuItemSrv")
public class WeixinMenuItemSrvImpl extends ServiceSrvImpl implements WeixinMenuItemSrv {

	@Override
	public WeixinMenuItem addWeixinMenuItem(WeixinMenuItem weixinMenuItem) {
		// TODO Auto-generated method stub
		return (WeixinMenuItem)weixinMenuItemDao.save(weixinMenuItem);
	}

	@Override
	public void deleWeixinMenuItem(WeixinMenuItem weixinMenuItem) {
		// TODO Auto-generated method stub
		weixinMenuItemDao.delete(weixinMenuItem);
	}

	@Override
	public void deleWeixinMenuItem(Long id) {
		// TODO Auto-generated method stub
		weixinMenuItemDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinMenuItem(WeixinMenuItem weixinMenuItem) {
		// TODO Auto-generated method stub
		weixinMenuItemDao.saveOrUpdate(weixinMenuItem);
	}
	
	@Override
	public void saveBatchWeixinMenuItem(List<WeixinMenuItem> weixinMenuItemLs) {
		// TODO Auto-generated method stub
		weixinMenuItemDao.addBacth(weixinMenuItemLs);
	}
	
	public PageInfo<WeixinMenuItem> findWeixinMenuItemList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<WeixinMenuItem> findWeixinMenuItemList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public WeixinMenuItem getWeixinMenuItem(Long id) {
		return weixinMenuItemDao.get(id);
	}
	
	@Resource(name="weixinMenuItemDao")
	private WeixinMenuItemDao weixinMenuItemDao;
}
