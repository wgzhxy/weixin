/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.sys.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.sys.dao.SysDictionaryDao;
import com.weixin.datacore.domain.sys.model.SysDictionary;
import com.weixin.datacore.service.sys.SysDictionarySrv;

@Service("sysDictionarySrv")
public class SysDictionarySrvImpl extends ServiceSrvImpl implements SysDictionarySrv {

	@Override
	public SysDictionary addSysDictionary(SysDictionary sysDictionary) {
		// TODO Auto-generated method stub
		return (SysDictionary)sysDictionaryDao.save(sysDictionary);
	}

	@Override
	public void deleSysDictionary(SysDictionary sysDictionary) {
		// TODO Auto-generated method stub
		sysDictionaryDao.delete(sysDictionary);
	}

	@Override
	public void deleSysDictionary(Long id) {
		// TODO Auto-generated method stub
		sysDictionaryDao.deleteByKey(id);
	}

	@Override
	public void updateSysDictionary(SysDictionary sysDictionary) {
		// TODO Auto-generated method stub
		sysDictionaryDao.saveOrUpdate(sysDictionary);
	}
	
	@Override
	public void saveBatchSysDictionary(List<SysDictionary> sysDictionaryLs) {
		// TODO Auto-generated method stub
		sysDictionaryDao.addBacth(sysDictionaryLs);
	}
	
	public PageInfo<SysDictionary> findSysDictionaryList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<SysDictionary> findSysDictionaryList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public SysDictionary getSysDictionary(Long id) {
		return sysDictionaryDao.get(id);
	}
	
	@Resource(name="sysDictionaryDao")
	private SysDictionaryDao sysDictionaryDao;
}
