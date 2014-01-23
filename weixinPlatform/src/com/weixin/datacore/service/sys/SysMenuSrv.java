/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.sys;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.sys.model.SysMenu;

public interface SysMenuSrv extends ServiceSrv {

	public SysMenu addSysMenu(SysMenu sysMenu);
	
	public void deleSysMenu(SysMenu sysMenu);
	
	public void deleSysMenu(Long id);
	
	public void updateSysMenu(SysMenu sysMenu);
	
	public void saveBatchSysMenu(List<SysMenu> sysMenuLs);
	
	public PageInfo<SysMenu> findSysMenuList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<SysMenu> findSysMenuList(Object[] params, int pageNo, int pageSize);
	
	public SysMenu getSysMenu(Long id);
}
