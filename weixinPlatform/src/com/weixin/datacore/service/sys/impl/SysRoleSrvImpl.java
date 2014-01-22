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
import com.weixin.datacore.domain.sys.dao.SysRoleDao;
import com.weixin.datacore.domain.sys.model.SysRole;
import com.weixin.datacore.service.sys.SysRoleSrv;
import com.weixin.comm.PageInfo;

@Service("sysRoleSrv")
public class SysRoleSrvImpl extends ServiceSrvImpl implements SysRoleSrv {

	@Override
	public SysRole addSysRole(SysRole sysRole) {
		// TODO Auto-generated method stub
		return (SysRole)sysRoleDao.save(sysRole);
	}

	@Override
	public void deleSysRole(SysRole sysRole) {
		// TODO Auto-generated method stub
		sysRoleDao.delete(sysRole);
	}

	@Override
	public void deleSysRole(Long id) {
		// TODO Auto-generated method stub
		sysRoleDao.deleteByKey(id);
	}

	@Override
	public void updateSysRole(SysRole sysRole) {
		// TODO Auto-generated method stub
		sysRoleDao.saveOrUpdate(sysRole);
	}
	
	@Override
	public void saveBatchSysRole(List<SysRole> sysRoleLs) {
		// TODO Auto-generated method stub
		sysRoleDao.addBacth(sysRoleLs);
	}
	
	public PageInfo<SysRole> findSysRoleList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<SysRole> findSysRoleList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public SysRole getSysRole(Long id) {
		return sysRoleDao.get(id);
	}
	
	@Resource(name="sysRoleDao")
	private SysRoleDao sysRoleDao;
}
