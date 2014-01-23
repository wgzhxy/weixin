/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.sys;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.sys.model.SysRolePrivilege;

public interface SysRolePrivilegeSrv extends ServiceSrv {

	public SysRolePrivilege addSysRolePrivilege(SysRolePrivilege sysRolePrivilege);
	
	public void deleSysRolePrivilege(SysRolePrivilege sysRolePrivilege);
	
	public void deleSysRolePrivilege(Long id);
	
	public void updateSysRolePrivilege(SysRolePrivilege sysRolePrivilege);
	
	public void saveBatchSysRolePrivilege(List<SysRolePrivilege> sysRolePrivilegeLs);
	
	public PageInfo<SysRolePrivilege> findSysRolePrivilegeList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<SysRolePrivilege> findSysRolePrivilegeList(Object[] params, int pageNo, int pageSize);
	
	public SysRolePrivilege getSysRolePrivilege(Long id);
}
