/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.sys;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.sys.model.SysUserRole;

public interface SysUserRoleSrv extends ServiceSrv {

	public SysUserRole addSysUserRole(SysUserRole sysUserRole);
	
	public void deleSysUserRole(SysUserRole sysUserRole);
	
	public void deleSysUserRole(Long id);
	
	public void updateSysUserRole(SysUserRole sysUserRole);
	
	public void saveBatchSysUserRole(List<SysUserRole> sysUserRoleLs);
	
	public PageInfo<SysUserRole> findSysUserRoleList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<SysUserRole> findSysUserRoleList(Object[] params, int pageNo, int pageSize);
	
	public SysUserRole getSysUserRole(Long id);
}
