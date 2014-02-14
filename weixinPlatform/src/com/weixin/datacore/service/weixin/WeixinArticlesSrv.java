/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinArticles;

public interface WeixinArticlesSrv extends ServiceSrv {

	public WeixinArticles addWeixinArticles(WeixinArticles weixinArticles);
	
	public void deleWeixinArticles(WeixinArticles weixinArticles);
	
	public void deleWeixinArticles(Long id);
	
	public void updateWeixinArticles(WeixinArticles weixinArticles);
	
	public void saveBatchWeixinArticles(List<WeixinArticles> weixinArticlesLs);
	
	public PageInfo<WeixinArticles> findWeixinArticlesList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<WeixinArticles> findWeixinArticlesList(Object[] params, int pageNo, int pageSize);
	
	public WeixinArticles getWeixinArticles(Long id);
	
	public WeixinArticles getWeixinArticles(Map<String,Object> params);
}
