/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinArticlesMulti;

public interface WeixinArticlesMultiSrv extends ServiceSrv {

	public WeixinArticlesMulti addWeixinArticlesMulti(WeixinArticlesMulti weixinArticlesMulti);
	
	public void deleWeixinArticlesMulti(WeixinArticlesMulti weixinArticlesMulti);
	
	public void deleWeixinArticlesMulti(Long id);
	
	public void deleWeixinArticlesMultiList(List<WeixinArticlesMulti> weixinArticlesMultiLs);
	
	public void updateWeixinArticlesMulti(WeixinArticlesMulti weixinArticlesMulti);
	
	public void saveBatchWeixinArticlesMulti(List<WeixinArticlesMulti> weixinArticlesMultiLs);
	
	public PageInfo<WeixinArticlesMulti> findWeixinArticlesMultiList(Map<String, Object> params, int pageNo, int pageSize);
	
	public List<WeixinArticlesMulti> findWeixinArticlesMultiList(Map<String, Object> params);
	
	public WeixinArticlesMulti getWeixinArticlesMulti(Long id);
}
