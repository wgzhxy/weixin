/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.busi;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.busi.model.BusiCouponReceive;

public interface BusiCouponReceiveSrv extends ServiceSrv {

	public BusiCouponReceive addBusiCouponReceive(BusiCouponReceive busiCouponReceive);
	
	public void deleBusiCouponReceive(BusiCouponReceive busiCouponReceive);
	
	public void deleBusiCouponReceive(Long id);
	
	public void updateBusiCouponReceive(BusiCouponReceive busiCouponReceive);
	
	public void saveBatchBusiCouponReceive(List<BusiCouponReceive> busiCouponReceiveLs);
	
	public PageInfo<BusiCouponReceive> findBusiCouponReceiveList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<BusiCouponReceive> findBusiCouponReceiveList(Object[] params, int pageNo, int pageSize);
	
	public BusiCouponReceive getBusiCouponReceive(Long id);
}
