/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.sys.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.sys.dao.SysUserDao;
import com.weixin.datacore.domain.sys.model.SysUser;
import com.weixin.datacore.service.sys.SysUserSrv;
import com.weixin.comm.PageInfo;

@Service("sysUserSrv")
public class SysUserSrvImpl extends ServiceSrvImpl implements SysUserSrv {

	@Override
	public SysUser addSysUser(SysUser sysUser) {
		// TODO Auto-generated method stub
		return (SysUser)sysUserDao.save(sysUser);
	}

	@Override
	public void deleSysUser(SysUser sysUser) {
		// TODO Auto-generated method stub
		sysUserDao.delete(sysUser);
	}

	@Override
	public void deleSysUser(Long id) {
		// TODO Auto-generated method stub
		sysUserDao.deleteByKey(id);
	}

	@Override
	public void updateSysUser(SysUser sysUser) {
		// TODO Auto-generated method stub
		sysUserDao.saveOrUpdate(sysUser);
	}
	
	@Override
	public void saveBatchSysUser(List<SysUser> sysUserLs) {
		// TODO Auto-generated method stub
		sysUserDao.addBacth(sysUserLs);
	}
	
	public PageInfo<SysUser> findSysUserList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<SysUser> findSysUserList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public SysUser getSysUser(Long id) {
		return sysUserDao.get(id);
	}
	
	@Resource(name="sysUserDao")
	private SysUserDao sysUserDao;
}
