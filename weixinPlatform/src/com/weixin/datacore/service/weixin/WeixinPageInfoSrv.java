/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinPageInfo;
import com.weixin.datacore.domain.weixin.vo.WeixinPageInfoVo;

public interface WeixinPageInfoSrv extends ServiceSrv {

	public WeixinPageInfo addWeixinPageInfo(WeixinPageInfo weixinPageInfo);
	
	public void deleWeixinPageInfo(WeixinPageInfo weixinPageInfo);
	
	public void deleWeixinPageInfo(Long id);
	
	public void deleWeixinPageInfo(String id);
	
	public void updateWeixinPageInfo(WeixinPageInfo weixinPageInfo);
	
	public WeixinPageInfo updateWeixinPageInfo(WeixinPageInfoVo weixinPageInfoVo);
	
	public void saveBatchWeixinPageInfo(List<WeixinPageInfo> weixinPageInfoLs);
	
	public PageInfo<WeixinPageInfo> findWeixinPageInfoList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<WeixinPageInfo> findWeixinPageInfoList(Object[] params, int pageNo, int pageSize);
	
	public WeixinPageInfo getWeixinPageInfo(Long id);
	
	public WeixinPageInfo getWeixinPageInfo(String id);
}
