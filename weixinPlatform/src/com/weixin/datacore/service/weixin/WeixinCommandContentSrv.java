/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinCommandContent;
import com.weixin.comm.PageInfo;

public interface WeixinCommandContentSrv extends ServiceSrv {

	public WeixinCommandContent addWeixinCommandContent(WeixinCommandContent weixinCommandContent);
	
	public void deleWeixinCommandContent(WeixinCommandContent weixinCommandContent);
	
	public void deleWeixinCommandContent(Long id);
	
	public void updateWeixinCommandContent(WeixinCommandContent weixinCommandContent);
	
	public void saveBatchWeixinCommandContent(List<WeixinCommandContent> weixinCommandContentLs);
	
	public PageInfo<WeixinCommandContent> findWeixinCommandContentList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<WeixinCommandContent> findWeixinCommandContentList(Object[] params, int pageNo, int pageSize);
	
	public WeixinCommandContent getWeixinCommandContent(Long id);
}
