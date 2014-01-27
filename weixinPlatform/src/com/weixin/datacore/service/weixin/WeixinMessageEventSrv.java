/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinMessageEvent;
import com.weixin.comm.PageInfo;

public interface WeixinMessageEventSrv extends ServiceSrv {

	public WeixinMessageEvent addWeixinMessageEvent(WeixinMessageEvent weixinMessageEvent);
	
	public void deleWeixinMessageEvent(WeixinMessageEvent weixinMessageEvent);
	
	public void deleWeixinMessageEvent(Long id);
	
	public void updateWeixinMessageEvent(WeixinMessageEvent weixinMessageEvent);
	
	public void saveBatchWeixinMessageEvent(List<WeixinMessageEvent> weixinMessageEventLs);
	
	public PageInfo<WeixinMessageEvent> findWeixinMessageEventList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<WeixinMessageEvent> findWeixinMessageEventList(Object[] params, int pageNo, int pageSize);
	
	public WeixinMessageEvent getWeixinMessageEvent(Long id);
}
