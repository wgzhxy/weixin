/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;
import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinFormHumanServices;

public interface WeixinFormHumanServicesSrv extends ServiceSrv {

	public WeixinFormHumanServices addWeixinFormHumanServices(WeixinFormHumanServices weixinFormHumanServices);
	
	public void deleWeixinFormHumanServices(WeixinFormHumanServices weixinFormHumanServices);
	
	public void deleWeixinFormHumanServices(Long id);
	
	public void updateWeixinFormHumanServices(WeixinFormHumanServices weixinFormHumanServices);
	
	public void saveBatchWeixinFormHumanServices(List<WeixinFormHumanServices> weixinFormHumanServicesLs);
	
	public PageInfo<WeixinFormHumanServices> findWeixinFormHumanServicesList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<WeixinFormHumanServices> findWeixinFormHumanServicesList(Object[] params, int pageNo, int pageSize);
	
	public WeixinFormHumanServices getWeixinFormHumanServices(Long id);
	
	public WeixinFormHumanServices getWeixinFormHumanServices(Map<String,Object> params);
}
