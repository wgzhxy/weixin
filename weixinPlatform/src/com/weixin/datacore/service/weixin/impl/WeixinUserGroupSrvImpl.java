/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.weixin.dao.WeixinUserGroupDao;
import com.weixin.datacore.domain.weixin.model.WeixinUserGroup;
import com.weixin.datacore.service.weixin.WeixinUserGroupSrv;
import com.weixin.comm.PageInfo;

@Service("weixinUserGroupSrv")
public class WeixinUserGroupSrvImpl extends ServiceSrvImpl implements WeixinUserGroupSrv {

	@Override
	public WeixinUserGroup addWeixinUserGroup(WeixinUserGroup weixinUserGroup) {
		// TODO Auto-generated method stub
		return (WeixinUserGroup)weixinUserGroupDao.save(weixinUserGroup);
	}

	@Override
	public void deleWeixinUserGroup(WeixinUserGroup weixinUserGroup) {
		// TODO Auto-generated method stub
		weixinUserGroupDao.delete(weixinUserGroup);
	}

	@Override
	public void deleWeixinUserGroup(Long id) {
		// TODO Auto-generated method stub
		weixinUserGroupDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinUserGroup(WeixinUserGroup weixinUserGroup) {
		// TODO Auto-generated method stub
		weixinUserGroupDao.saveOrUpdate(weixinUserGroup);
	}
	
	@Override
	public void saveBatchWeixinUserGroup(List<WeixinUserGroup> weixinUserGroupLs) {
		// TODO Auto-generated method stub
		weixinUserGroupDao.addBacth(weixinUserGroupLs);
	}
	
	public PageInfo<WeixinUserGroup> findWeixinUserGroupList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<WeixinUserGroup> findWeixinUserGroupList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public WeixinUserGroup getWeixinUserGroup(Long id) {
		return weixinUserGroupDao.get(id);
	}
	
	@Resource(name="weixinUserGroupDao")
	private WeixinUserGroupDao weixinUserGroupDao;
}
