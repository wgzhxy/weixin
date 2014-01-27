/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinMenuItem;
import com.weixin.comm.PageInfo;

public interface WeixinMenuItemSrv extends ServiceSrv {

	public WeixinMenuItem addWeixinMenuItem(WeixinMenuItem weixinMenuItem);
	
	public void deleWeixinMenuItem(WeixinMenuItem weixinMenuItem);
	
	public void deleWeixinMenuItem(Long id);
	
	public void updateWeixinMenuItem(WeixinMenuItem weixinMenuItem);
	
	public void saveBatchWeixinMenuItem(List<WeixinMenuItem> weixinMenuItemLs);
	
	public PageInfo<WeixinMenuItem> findWeixinMenuItemList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<WeixinMenuItem> findWeixinMenuItemList(Object[] params, int pageNo, int pageSize);
	
	public WeixinMenuItem getWeixinMenuItem(Long id);
}
