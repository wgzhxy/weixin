/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.sys;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.sys.model.SysOrg;

public interface SysOrgSrv extends ServiceSrv {

	public SysOrg addSysOrg(SysOrg sysOrg);
	
	public void deleSysOrg(SysOrg sysOrg);
	
	public void deleSysOrg(Long id);
	
	public void updateSysOrg(SysOrg sysOrg);
	
	public void saveBatchSysOrg(List<SysOrg> sysOrgLs);
	
	public PageInfo<SysOrg> findSysOrgList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<SysOrg> findSysOrgList(Object[] params, int pageNo, int pageSize);
	
	public SysOrg getSysOrg(Long id);
}
