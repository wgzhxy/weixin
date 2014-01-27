/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinUser;

public interface WeixinUserSrv extends ServiceSrv {

	public WeixinUser addWeixinUser(WeixinUser weixinUser);
	
	public void deleWeixinUser(WeixinUser weixinUser);
	
	public void deleWeixinUser(Long id);
	
	public void updateWeixinUser(WeixinUser weixinUser);
	
	public void saveBatchWeixinUser(List<WeixinUser> weixinUserLs);
	
	public PageInfo<WeixinUser> findWeixinUserList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<WeixinUser> findWeixinUserList(Object[] params, int pageNo, int pageSize);
	
	public WeixinUser getWeixinUser(Long id);
}
