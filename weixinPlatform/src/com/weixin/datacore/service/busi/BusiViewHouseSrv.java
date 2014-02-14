/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.busi;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.busi.model.BusiViewHouse;

public interface BusiViewHouseSrv extends ServiceSrv {

	public BusiViewHouse addBusiViewHouse(BusiViewHouse busiViewHouse);
	
	public void deleBusiViewHouse(BusiViewHouse busiViewHouse);
	
	public void deleBusiViewHouse(Long id);
	
	public void updateBusiViewHouse(BusiViewHouse busiViewHouse);
	
	public void saveBatchBusiViewHouse(List<BusiViewHouse> busiViewHouseLs);
	
	public PageInfo<BusiViewHouse> findBusiViewHouseList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<BusiViewHouse> findBusiViewHouseList(Object[] params, int pageNo, int pageSize);
	
	public BusiViewHouse getBusiViewHouse(Long id);
}
