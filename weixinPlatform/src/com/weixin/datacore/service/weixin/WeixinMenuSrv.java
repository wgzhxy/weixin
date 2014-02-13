/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinMenu;
import com.weixin.datacore.domain.weixin.vo.WeixinMenuTreeNode;
import com.weixin.comm.PageInfo;

public interface WeixinMenuSrv extends ServiceSrv {

	public WeixinMenu addWeixinMenu(WeixinMenu WeixinMenu);
	
	public void deleWeixinMenu(WeixinMenu WeixinMenu);
	
	public void deleWeixinMenu(Long id);
	
	public void updateWeixinMenu(WeixinMenu WeixinMenu);
	
	public void saveBatchWeixinMenu(List<WeixinMenu> WeixinMenuLs);
	
	public PageInfo<WeixinMenu> findWeixinMenuList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<WeixinMenu> findWeixinMenuList(Object[] params, int pageNo, int pageSize);
	
	public WeixinMenu getWeixinMenu(Long id);
	
	/**
	 * 构建一个菜单的树形数据格式
	 */
	public List<WeixinMenuTreeNode> weixinMenuTreeNodeList();
	/**听过ID过去树
	 * @param id
	 * @return
	 */
	public WeixinMenuTreeNode weixinMenuTreeNode(long id);
	/**
	 * 单独取对象集合
	 * @param params
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<WeixinMenu> findWeixinMenuListForMap(Map<String, Object> params, int pageNo, int pageSize);
	
	/**
	 * 查找对象
	 * @param params
	 * @return
	 */
	public WeixinMenu getWeixinMenu(Map<String, Object> params);
}
