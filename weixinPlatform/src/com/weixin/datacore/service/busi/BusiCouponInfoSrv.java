/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.busi;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.busi.model.BusiCouponInfo;

public interface BusiCouponInfoSrv extends ServiceSrv {

	public BusiCouponInfo addBusiCouponInfo(BusiCouponInfo busiCouponInfo);
	
	public void deleBusiCouponInfo(BusiCouponInfo busiCouponInfo);
	
	public void deleBusiCouponInfo(Long id);
	
	public void updateBusiCouponInfo(BusiCouponInfo busiCouponInfo);
	
	public void saveBatchBusiCouponInfo(List<BusiCouponInfo> busiCouponInfoLs);
	
	public PageInfo<BusiCouponInfo> findBusiCouponInfoList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<BusiCouponInfo> findBusiCouponInfoList(Object[] params, int pageNo, int pageSize);
	
	public BusiCouponInfo getBusiCouponInfo(Long id);
}
