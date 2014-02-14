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
import com.weixin.datacore.domain.busi.dao.BusiArtificialServiceDao;
import com.weixin.datacore.domain.busi.model.BusiArtificialService;
import com.weixin.datacore.service.busi.BusiArtificialServiceSrv;

@Service("busiArtificialServiceSrv")
public class BusiArtificialServiceSrvImpl extends ServiceSrvImpl implements BusiArtificialServiceSrv {

	@Override
	public BusiArtificialService addBusiArtificialService(BusiArtificialService busiArtificialService) {
		// TODO Auto-generated method stub
		return (BusiArtificialService)busiArtificialServiceDao.save(busiArtificialService);
	}

	@Override
	public void deleBusiArtificialService(BusiArtificialService busiArtificialService) {
		// TODO Auto-generated method stub
		busiArtificialServiceDao.delete(busiArtificialService);
	}

	@Override
	public void deleBusiArtificialService(Long id) {
		// TODO Auto-generated method stub
		busiArtificialServiceDao.deleteByKey(id);
	}

	@Override
	public void updateBusiArtificialService(BusiArtificialService busiArtificialService) {
		// TODO Auto-generated method stub
		busiArtificialServiceDao.saveOrUpdate(busiArtificialService);
	}
	
	@Override
	public void saveBatchBusiArtificialService(List<BusiArtificialService> busiArtificialServiceLs) {
		// TODO Auto-generated method stub
		busiArtificialServiceDao.addBacth(busiArtificialServiceLs);
	}
	
	public PageInfo<BusiArtificialService> findBusiArtificialServiceList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<BusiArtificialService> findBusiArtificialServiceList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public BusiArtificialService getBusiArtificialService(Long id) {
		return busiArtificialServiceDao.get(id);
	}
	
	@Resource(name="busiArtificialServiceDao")
	private BusiArtificialServiceDao busiArtificialServiceDao;
}
