/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinUserGroup;
import com.weixin.comm.PageInfo;

public interface WeixinUserGroupSrv extends ServiceSrv {

	public WeixinUserGroup addWeixinUserGroup(WeixinUserGroup weixinUserGroup);
	
	public void deleWeixinUserGroup(WeixinUserGroup weixinUserGroup);
	
	public void deleWeixinUserGroup(Long id);
	
	public void updateWeixinUserGroup(WeixinUserGroup weixinUserGroup);
	
	public void saveBatchWeixinUserGroup(List<WeixinUserGroup> weixinUserGroupLs);
	
	public PageInfo<WeixinUserGroup> findWeixinUserGroupList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<WeixinUserGroup> findWeixinUserGroupList(Object[] params, int pageNo, int pageSize);
	
	public WeixinUserGroup getWeixinUserGroup(Long id);
}
