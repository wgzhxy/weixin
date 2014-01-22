/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.sys;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.sys.model.SysPrivilege;

public interface SysPrivilegeSrv extends ServiceSrv {

	public SysPrivilege addSysPrivilege(SysPrivilege sysPrivilege);
	
	public void deleSysPrivilege(SysPrivilege sysPrivilege);
	
	public void deleSysPrivilege(Long id);
	
	public void updateSysPrivilege(SysPrivilege sysPrivilege);
	
	public void saveBatchSysPrivilege(List<SysPrivilege> sysPrivilegeLs);
	
	public PageInfo<SysPrivilege> findSysPrivilegeList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<SysPrivilege> findSysPrivilegeList(Object[] params, int pageNo, int pageSize);
	
	public SysPrivilege getSysPrivilege(Long id);
}
