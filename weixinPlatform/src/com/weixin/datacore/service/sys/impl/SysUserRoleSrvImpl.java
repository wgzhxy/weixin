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
import com.weixin.datacore.domain.sys.dao.SysUserRoleDao;
import com.weixin.datacore.domain.sys.model.SysUserRole;
import com.weixin.datacore.service.sys.SysUserRoleSrv;
import com.weixin.comm.PageInfo;

@Service("sysUserRoleSrv")
public class SysUserRoleSrvImpl extends ServiceSrvImpl implements SysUserRoleSrv {

	@Override
	public SysUserRole addSysUserRole(SysUserRole sysUserRole) {
		// TODO Auto-generated method stub
		return (SysUserRole)sysUserRoleDao.save(sysUserRole);
	}

	@Override
	public void deleSysUserRole(SysUserRole sysUserRole) {
		// TODO Auto-generated method stub
		sysUserRoleDao.delete(sysUserRole);
	}

	@Override
	public void deleSysUserRole(Long id) {
		// TODO Auto-generated method stub
		sysUserRoleDao.deleteByKey(id);
	}

	@Override
	public void updateSysUserRole(SysUserRole sysUserRole) {
		// TODO Auto-generated method stub
		sysUserRoleDao.saveOrUpdate(sysUserRole);
	}
	
	@Override
	public void saveBatchSysUserRole(List<SysUserRole> sysUserRoleLs) {
		// TODO Auto-generated method stub
		sysUserRoleDao.addBacth(sysUserRoleLs);
	}
	
	public PageInfo<SysUserRole> findSysUserRoleList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<SysUserRole> findSysUserRoleList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public SysUserRole getSysUserRole(Long id) {
		return sysUserRoleDao.get(id);
	}
	
	@Resource(name="sysUserRoleDao")
	private SysUserRoleDao sysUserRoleDao;
}
