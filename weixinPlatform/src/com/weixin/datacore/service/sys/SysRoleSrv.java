/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.sys;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.sys.model.SysRole;

public interface SysRoleSrv extends ServiceSrv {

	public SysRole addSysRole(SysRole sysRole);
	
	public void deleSysRole(SysRole sysRole);
	
	public void deleSysRole(Long id);
	
	public void updateSysRole(SysRole sysRole);
	
	public void saveBatchSysRole(List<SysRole> sysRoleLs);
	
	public PageInfo<SysRole> findSysRoleList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<SysRole> findSysRoleList(Object[] params, int pageNo, int pageSize);
	
	public SysRole getSysRole(Long id);
}
