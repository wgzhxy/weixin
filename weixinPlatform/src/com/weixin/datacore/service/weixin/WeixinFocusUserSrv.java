/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinFocusUser;
import com.weixin.comm.PageInfo;

public interface WeixinFocusUserSrv extends ServiceSrv {

	public WeixinFocusUser addWeixinFocusUser(WeixinFocusUser weixinFocusUser);
	
	public void deleWeixinFocusUser(WeixinFocusUser weixinFocusUser);
	
	public void deleWeixinFocusUser(Long id);
	
	public void updateWeixinFocusUser(WeixinFocusUser weixinFocusUser);
	
	public void saveBatchWeixinFocusUser(List<WeixinFocusUser> weixinFocusUserLs);
	
	public PageInfo<WeixinFocusUser> findWeixinFocusUserList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<WeixinFocusUser> findWeixinFocusUserList(Object[] params, int pageNo, int pageSize);
	
	public WeixinFocusUser getWeixinFocusUser(Long id);
}
