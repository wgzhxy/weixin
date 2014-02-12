/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinPageClass;

public interface WeixinPageClassSrv extends ServiceSrv {

	public WeixinPageClass addWeixinPageClass(WeixinPageClass weixinPageClass);
	
	public void deleWeixinPageClass(WeixinPageClass weixinPageClass);
	
	public void deleWeixinPageClass(Long id);
	
	public void updateWeixinPageClass(WeixinPageClass weixinPageClass);
	
	public void saveBatchWeixinPageClass(List<WeixinPageClass> weixinPageClassLs);
	
	public PageInfo<WeixinPageClass> findWeixinPageClassList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<WeixinPageClass> findWeixinPageClassList(Object[] params, int pageNo, int pageSize);
	
	public WeixinPageClass getWeixinPageClass(Long id);
	
	public WeixinPageClass getWeixinPageClass(String id);
	
	public void deleWeixinPageClass(String id);
}
