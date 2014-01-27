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
import com.weixin.datacore.domain.sys.dao.SysUserPrivilegeDao;
import com.weixin.datacore.domain.sys.model.SysUserPrivilege;
import com.weixin.datacore.service.sys.SysUserPrivilegeSrv;
import com.weixin.comm.PageInfo;

@Service("sysUserPrivilegeSrv")
public class SysUserPrivilegeSrvImpl extends ServiceSrvImpl implements SysUserPrivilegeSrv {

	@Override
	public SysUserPrivilege addSysUserPrivilege(SysUserPrivilege sysUserPrivilege) {
		// TODO Auto-generated method stub
		return (SysUserPrivilege)sysUserPrivilegeDao.save(sysUserPrivilege);
	}

	@Override
	public void deleSysUserPrivilege(SysUserPrivilege sysUserPrivilege) {
		// TODO Auto-generated method stub
		sysUserPrivilegeDao.delete(sysUserPrivilege);
	}

	@Override
	public void deleSysUserPrivilege(Long id) {
		// TODO Auto-generated method stub
		sysUserPrivilegeDao.deleteByKey(id);
	}

	@Override
	public void updateSysUserPrivilege(SysUserPrivilege sysUserPrivilege) {
		// TODO Auto-generated method stub
		sysUserPrivilegeDao.saveOrUpdate(sysUserPrivilege);
	}
	
	@Override
	public void saveBatchSysUserPrivilege(List<SysUserPrivilege> sysUserPrivilegeLs) {
		// TODO Auto-generated method stub
		sysUserPrivilegeDao.addBacth(sysUserPrivilegeLs);
	}
	
	public PageInfo<SysUserPrivilege> findSysUserPrivilegeList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<SysUserPrivilege> findSysUserPrivilegeList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public SysUserPrivilege getSysUserPrivilege(Long id) {
		return sysUserPrivilegeDao.get(id);
	}
	
	@Resource(name="sysUserPrivilegeDao")
	private SysUserPrivilegeDao sysUserPrivilegeDao;
}
