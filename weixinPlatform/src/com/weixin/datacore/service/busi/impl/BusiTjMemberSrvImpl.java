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
import com.weixin.datacore.domain.busi.dao.BusiTjMemberDao;
import com.weixin.datacore.domain.busi.model.BusiTjMember;
import com.weixin.datacore.service.busi.BusiTjMemberSrv;

@Service("busiTjMemberSrv")
public class BusiTjMemberSrvImpl extends ServiceSrvImpl implements BusiTjMemberSrv {

	@Override
	public BusiTjMember addBusiTjMember(BusiTjMember busiTjMember) {
		// TODO Auto-generated method stub
		return (BusiTjMember)busiTjMemberDao.save(busiTjMember);
	}

	@Override
	public void deleBusiTjMember(BusiTjMember busiTjMember) {
		// TODO Auto-generated method stub
		busiTjMemberDao.delete(busiTjMember);
	}

	@Override
	public void deleBusiTjMember(Long id) {
		// TODO Auto-generated method stub
		busiTjMemberDao.deleteByKey(id);
	}

	@Override
	public void updateBusiTjMember(BusiTjMember busiTjMember) {
		// TODO Auto-generated method stub
		busiTjMemberDao.saveOrUpdate(busiTjMember);
	}
	
	@Override
	public void saveBatchBusiTjMember(List<BusiTjMember> busiTjMemberLs) {
		// TODO Auto-generated method stub
		busiTjMemberDao.addBacth(busiTjMemberLs);
	}
	
	public PageInfo<BusiTjMember> findBusiTjMemberList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<BusiTjMember> findBusiTjMemberList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public BusiTjMember getBusiTjMember(Long id) {
		return busiTjMemberDao.get(id);
	}
	
	@Resource(name="busiTjMemberDao")
	private BusiTjMemberDao busiTjMemberDao;
}
