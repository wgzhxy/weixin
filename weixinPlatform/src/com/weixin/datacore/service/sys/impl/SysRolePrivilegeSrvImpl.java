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
import com.weixin.datacore.domain.sys.dao.SysRolePrivilegeDao;
import com.weixin.datacore.domain.sys.model.SysRolePrivilege;
import com.weixin.datacore.service.sys.SysRolePrivilegeSrv;
import com.weixin.comm.PageInfo;

@Service("sysRolePrivilegeSrv")
public class SysRolePrivilegeSrvImpl extends ServiceSrvImpl implements SysRolePrivilegeSrv {

	@Override
	public SysRolePrivilege addSysRolePrivilege(SysRolePrivilege sysRolePrivilege) {
		// TODO Auto-generated method stub
		return (SysRolePrivilege)sysRolePrivilegeDao.save(sysRolePrivilege);
	}

	@Override
	public void deleSysRolePrivilege(SysRolePrivilege sysRolePrivilege) {
		// TODO Auto-generated method stub
		sysRolePrivilegeDao.delete(sysRolePrivilege);
	}

	@Override
	public void deleSysRolePrivilege(Long id) {
		// TODO Auto-generated method stub
		sysRolePrivilegeDao.deleteByKey(id);
	}

	@Override
	public void updateSysRolePrivilege(SysRolePrivilege sysRolePrivilege) {
		// TODO Auto-generated method stub
		sysRolePrivilegeDao.saveOrUpdate(sysRolePrivilege);
	}
	
	@Override
	public void saveBatchSysRolePrivilege(List<SysRolePrivilege> sysRolePrivilegeLs) {
		// TODO Auto-generated method stub
		sysRolePrivilegeDao.addBacth(sysRolePrivilegeLs);
	}
	
	public PageInfo<SysRolePrivilege> findSysRolePrivilegeList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<SysRolePrivilege> findSysRolePrivilegeList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public SysRolePrivilege getSysRolePrivilege(Long id) {
		return sysRolePrivilegeDao.get(id);
	}
	
	@Resource(name="sysRolePrivilegeDao")
	private SysRolePrivilegeDao sysRolePrivilegeDao;
}
