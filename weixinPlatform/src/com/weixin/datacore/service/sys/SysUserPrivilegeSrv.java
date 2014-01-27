/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.sys;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.sys.model.SysUserPrivilege;

public interface SysUserPrivilegeSrv extends ServiceSrv {

	public SysUserPrivilege addSysUserPrivilege(SysUserPrivilege sysUserPrivilege);
	
	public void deleSysUserPrivilege(SysUserPrivilege sysUserPrivilege);
	
	public void deleSysUserPrivilege(Long id);
	
	public void updateSysUserPrivilege(SysUserPrivilege sysUserPrivilege);
	
	public void saveBatchSysUserPrivilege(List<SysUserPrivilege> sysUserPrivilegeLs);
	
	public PageInfo<SysUserPrivilege> findSysUserPrivilegeList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<SysUserPrivilege> findSysUserPrivilegeList(Object[] params, int pageNo, int pageSize);
	
	public SysUserPrivilege getSysUserPrivilege(Long id);
}
