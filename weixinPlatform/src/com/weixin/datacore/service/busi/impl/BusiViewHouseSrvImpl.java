/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.busi.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.busi.dao.BusiViewHouseDao;
import com.weixin.datacore.domain.busi.model.BusiViewHouse;
import com.weixin.datacore.service.busi.BusiViewHouseSrv;

@Service("busiViewHouseSrv")
public class BusiViewHouseSrvImpl extends ServiceSrvImpl implements BusiViewHouseSrv {

	@Override
	public BusiViewHouse addBusiViewHouse(BusiViewHouse busiViewHouse) {
		// TODO Auto-generated method stub
		return (BusiViewHouse)busiViewHouseDao.save(busiViewHouse);
	}

	@Override
	public void deleBusiViewHouse(BusiViewHouse busiViewHouse) {
		// TODO Auto-generated method stub
		busiViewHouseDao.delete(busiViewHouse);
	}

	@Override
	public void deleBusiViewHouse(Long id) {
		// TODO Auto-generated method stub
		busiViewHouseDao.deleteByKey(id);
	}

	@Override
	public void updateBusiViewHouse(BusiViewHouse busiViewHouse) {
		// TODO Auto-generated method stub
		busiViewHouseDao.saveOrUpdate(busiViewHouse);
	}
	
	@Override
	public void saveBatchBusiViewHouse(List<BusiViewHouse> busiViewHouseLs) {
		// TODO Auto-generated method stub
		busiViewHouseDao.addBacth(busiViewHouseLs);
	}
	
	public PageInfo<BusiViewHouse> findBusiViewHouseList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<BusiViewHouse> findBusiViewHouseList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public BusiViewHouse getBusiViewHouse(Long id) {
		return busiViewHouseDao.get(id);
	}
	
	@Resource(name="busiViewHouseDao")
	private BusiViewHouseDao busiViewHouseDao;
}
