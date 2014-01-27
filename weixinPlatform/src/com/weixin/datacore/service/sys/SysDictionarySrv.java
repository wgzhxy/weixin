/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.sys;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.sys.model.SysDictionary;

public interface SysDictionarySrv extends ServiceSrv {

	public SysDictionary addSysDictionary(SysDictionary sysDictionary);
	
	public void deleSysDictionary(SysDictionary sysDictionary);
	
	public void deleSysDictionary(Long id);
	
	public void updateSysDictionary(SysDictionary sysDictionary);
	
	public void saveBatchSysDictionary(List<SysDictionary> sysDictionaryLs);
	
	public PageInfo<SysDictionary> findSysDictionaryList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<SysDictionary> findSysDictionaryList(Object[] params, int pageNo, int pageSize);
	
	public SysDictionary getSysDictionary(Long id);
}
