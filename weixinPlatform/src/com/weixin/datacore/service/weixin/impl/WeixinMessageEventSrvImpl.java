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
import com.weixin.datacore.domain.weixin.dao.WeixinMessageEventDao;
import com.weixin.datacore.domain.weixin.model.WeixinMessageEvent;
import com.weixin.datacore.service.weixin.WeixinMessageEventSrv;
import com.weixin.comm.PageInfo;

@Service("weixinMessageEventSrv")
public class WeixinMessageEventSrvImpl extends ServiceSrvImpl implements WeixinMessageEventSrv {

	@Override
	public WeixinMessageEvent addWeixinMessageEvent(WeixinMessageEvent weixinMessageEvent) {
		// TODO Auto-generated method stub
		return (WeixinMessageEvent)weixinMessageEventDao.save(weixinMessageEvent);
	}

	@Override
	public void deleWeixinMessageEvent(WeixinMessageEvent weixinMessageEvent) {
		// TODO Auto-generated method stub
		weixinMessageEventDao.delete(weixinMessageEvent);
	}

	@Override
	public void deleWeixinMessageEvent(Long id) {
		// TODO Auto-generated method stub
		weixinMessageEventDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinMessageEvent(WeixinMessageEvent weixinMessageEvent) {
		// TODO Auto-generated method stub
		weixinMessageEventDao.saveOrUpdate(weixinMessageEvent);
	}
	
	@Override
	public void saveBatchWeixinMessageEvent(List<WeixinMessageEvent> weixinMessageEventLs) {
		// TODO Auto-generated method stub
		weixinMessageEventDao.addBacth(weixinMessageEventLs);
	}
	
	public PageInfo<WeixinMessageEvent> findWeixinMessageEventList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<WeixinMessageEvent> findWeixinMessageEventList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public WeixinMessageEvent getWeixinMessageEvent(Long id) {
		return weixinMessageEventDao.get(id);
	}
	
	@Resource(name="weixinMessageEventDao")
	private WeixinMessageEventDao weixinMessageEventDao;
}
