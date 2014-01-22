/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.sys;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.sys.model.SysUser;

public interface SysUserSrv extends ServiceSrv {

	public SysUser addSysUser(SysUser sysUser);
	
	public void deleSysUser(SysUser sysUser);
	
	public void deleSysUser(Long id);
	
	public void updateSysUser(SysUser sysUser);
	
	public void saveBatchSysUser(List<SysUser> sysUserLs);
	
	public PageInfo<SysUser> findSysUserList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<SysUser> findSysUserList(Object[] params, int pageNo, int pageSize);
	
	public SysUser getSysUser(Long id);
}
