/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.weixin.dao.WeixinMenuDao;
import com.weixin.datacore.domain.weixin.model.WeixinMenu;
import com.weixin.datacore.domain.weixin.vo.WeixinMenuTreeNode;
import com.weixin.datacore.service.weixin.WeixinMenuSrv;
import com.weixin.comm.PageInfo;

@Service("weixinMenuSrv")
public class WeixinMenuSrvImpl extends ServiceSrvImpl implements WeixinMenuSrv {

	@Override
	public WeixinMenu addWeixinMenu(WeixinMenu WeixinMenu) {
		// TODO Auto-generated method stub
		return (WeixinMenu)weixinMenuDao.save(WeixinMenu);
	}

	@Override
	public void deleWeixinMenu(WeixinMenu WeixinMenu) {
		// TODO Auto-generated method stub
		weixinMenuDao.delete(WeixinMenu);
	}

	@Override
	public void deleWeixinMenu(Long id) {
		// TODO Auto-generated method stub
		weixinMenuDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinMenu(WeixinMenu WeixinMenu) {
		// TODO Auto-generated method stub
		weixinMenuDao.saveOrUpdate(WeixinMenu);
	}
	
	@Override
	public void saveBatchWeixinMenu(List<WeixinMenu> WeixinMenuLs) {
		// TODO Auto-generated method stub
		weixinMenuDao.addBacth(WeixinMenuLs);
	}
	
	public PageInfo<WeixinMenu> findWeixinMenuList(Map<String, Object> params, int pageNo, int pageSize) {
		String hql = "from WeixinMenu c where 1=1 ";
		String hqlCount = "select count(c.id) from WeixinMenu c where 1=1 ";
		StringBuffer where = new StringBuffer();
		String orderBy = " order by c.id desc ";
		List<Object> values = new ArrayList<Object>();
		for(Map.Entry<String, Object> enity : params.entrySet()) {
			if("name".equals(enity.getKey())) {
				where.append(" and c.menuName like ?");
				values.add("%" + enity.getValue() + "%");
			}
			
			if("status".equals(enity.getKey())) {
				where.append(" and c.state=?");
				values.add(Integer.parseInt(enity.getValue().toString()));
			}
			
			if("parendId".equals(enity.getKey())) {
				where.append(" and c.parentId=?");
				values.add(Long.parseLong(enity.getValue().toString()));
			}
		}
		return weixinMenuDao.findPageInfoByQuery(pageNo, pageSize, hql + where.toString() + orderBy, hqlCount + where.toString(), values.toArray());
	}
	
	public List<WeixinMenu> findWeixinMenuListForMap(Map<String, Object> params, int pageNo, int pageSize){
		String hql = "from WeixinMenu c where 1=1 ";
		StringBuffer where = new StringBuffer();
		String orderBy = " order by c.id desc ";
		List<Object> values = new ArrayList<Object>();
		for(Map.Entry<String, Object> enity : params.entrySet()) {
			if("menuName".equals(enity.getKey())) {
				where.append(" and c.menuName like ?");
				values.add("%" + enity.getValue() + "%");
			}
			
			if("state".equals(enity.getKey())) {
				where.append(" and c.state=?");
				values.add(Integer.parseInt(enity.getValue().toString()));
			}
			
			if("parentId".equals(enity.getKey())) {
				where.append(" and c.parentId=?");
				values.add(Long.parseLong(enity.getValue().toString()));
			}
		}
		return weixinMenuDao.loadByPagenation(hql+where.toString()+orderBy,pageNo, pageSize, values.toArray());
	}
	
	
	public WeixinMenu getWeixinMenu(Map<String, Object> params){
		String hql = "from WeixinMenu c where 1=1 ";
		StringBuffer where = new StringBuffer();
		String orderBy = " order by c.id desc ";
		List<Object> values = new ArrayList<Object>();
		for(Map.Entry<String, Object> enity : params.entrySet()) {
			if("menuName".equals(enity.getKey())) {
				where.append(" and c.menuName=?");
				values.add(enity.getValue());
			}
		}
		List<WeixinMenu> list=weixinMenuDao.loadByPagenation(hql+where.toString()+orderBy,1,1, values.toArray());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public PageInfo<WeixinMenu> findWeixinMenuList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public WeixinMenu getWeixinMenu(Long id) {
		return weixinMenuDao.get(id);
	}
	
	public List<WeixinMenuTreeNode> weixinMenuTreeNodeList(){
		String hql = "from WeixinMenu c where parentId=?";//先取最高一级
		Object[] params = new Object[]{0L};
		List<WeixinMenu> topMenu = weixinMenuDao.findByHql(hql, params);//取得父级菜单
		
		List<WeixinMenuTreeNode> parentLs = new ArrayList<WeixinMenuTreeNode>();
		for (WeixinMenu obj : topMenu) {
			parentLs.add(weixinMenuTreeNode(obj.getId()));
		}
		return parentLs;
	}

	@Override
	public WeixinMenuTreeNode weixinMenuTreeNode(long id) {
		WeixinMenuTreeNode weixinMenuTreeNode = null;
		// 根据cid获取节点对象
		String hql = "from WeixinMenu c where 1=1 and c.id =?";
		Object[] params = new Object[] {id};
		WeixinMenu parent_menu = weixinMenuDao.get(id);//取得父级菜单对象
		if (parent_menu!=null) {
			weixinMenuTreeNode = new WeixinMenuTreeNode();
			weixinMenuTreeNode.setId(parent_menu.getId());
			weixinMenuTreeNode.setButton(parent_menu.getButton());
			weixinMenuTreeNode.setMenuKey(parent_menu.getMenuKey());
			weixinMenuTreeNode.setUrl(parent_menu.getUrl());
			weixinMenuTreeNode.setSubButton(parent_menu.getSubButton());
			weixinMenuTreeNode.setMenuName(parent_menu.getMenuName());
			weixinMenuTreeNode.setType(parent_menu.getType());
			
			long parentId=parent_menu.getParentId();
			if (parentId==0) {
				weixinMenuTreeNode.setParentId("");
			} else {
				weixinMenuTreeNode.setParentId(String.valueOf(parentId));
			}
			
			int state=parent_menu.getState();
			if (state==1) {
				weixinMenuTreeNode.setState("启用");
			} else {
				weixinMenuTreeNode.setState("停用");
			}
		}
		// 查询cid下的所有子节点
		hql = "from WeixinMenu c where 1=1 and c.parentId=?";
		params = new Object[] {id};
		List<WeixinMenu> childMenu = weixinMenuDao.findByHql(hql, params);
		// 遍历子节点
		for (WeixinMenu child:childMenu) {
			WeixinMenuTreeNode tmp= weixinMenuTreeNode(child.getId()); //递归
			weixinMenuTreeNode.getChildren().add(tmp);
		}
		return weixinMenuTreeNode;
	}
	
	@Resource(name="weixinMenuDao")
	private WeixinMenuDao weixinMenuDao;
}
