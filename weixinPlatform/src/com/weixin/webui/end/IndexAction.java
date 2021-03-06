package com.weixin.webui.end;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;

import com.weixin.comm.ConvertJson;
import com.weixin.comm.PageInfo;
import com.weixin.comm.logs.LogUtil;
import com.weixin.datacore.domain.sys.model.SysMenu;
import com.weixin.datacore.domain.sys.model.SysUser;
import com.weixin.datacore.domain.sys.vo.SysUserVo;
import com.weixin.datacore.domain.sys.vo.TreeNode;
import com.weixin.datacore.service.sys.SysMenuSrv;
import com.weixin.datacore.service.sys.SysUserSrv;
import com.weixin.webui.core.BaseAction;

@SuppressWarnings("serial")
public class IndexAction extends BaseAction {
	
	public String Login() {
		if(sysUserVo != null) {
			LogUtil.info(sysUserVo.getUserName());
			LogUtil.info(sysUserVo.getPassword());
			SysUser user = new SysUser();
			user.setUserName(sysUserVo.getUserName());
			user.setPassword(sysUserVo.getPassword());
			tips = sysUserSrv.checkSysUser(user);
			if(StringUtils.equals("ok", tips)) {
				List<SysMenu> menuParent = sysMenuSrv.getParentMenu();
				
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("menuParent", "bc7f1c015f86430982efa65028d5eedc");
				PageInfo<SysMenu> initChild = sysMenuSrv.findSysMenuList(params, 1, 50);
				if(initChild != null) {
					this.setRequestAttribute("initChildMenu", initChild.getResultlist());
				}
				this.setRequestAttribute("menuParent", menuParent);
				
				return "index";
			}
		}
		return "login";
	}
	
	public String LoginOut() {
		
		return "loginOut";
	}
	
	public String Page() {
		return "index";
	}
	
	public String ListParentMenu() {
		JSONObject obj = null;
		JSONArray jsonArray = new JSONArray();
		List<SysMenu> menuParent = sysMenuSrv.getParentMenu();
		if(menuParent != null) {
			for(SysMenu menu : menuParent) {
				obj = new JSONObject();
				obj.put("id", menu.getId());
				obj.put("menuName", menu.getMenuName());
				jsonArray.add(obj);
			}
		}
		this.writeResult(jsonArray.toString());
		return null;
	}

	public String ListSecondMenu() {
		TreeNode treeNode = null;
		List<TreeNode> menuList = new ArrayList<TreeNode>();
		String parentId = this.getRequestParameter("parentId");
		if(StringUtils.isNotEmpty(parentId)) {
			List<SysMenu> ls = sysMenuSrv.getChildMenu(parentId);
			if(ls != null) {
				for(SysMenu obj : ls) {
					treeNode = new TreeNode();
					treeNode.setId(obj.getId());
					treeNode.setText(obj.getMenuName());
					treeNode.setUrl(obj.getMenuUrl());
					treeNode.setIconCls(obj.getExtend1());
					menuList.add(treeNode);
				}
			}
		}
		this.writeResult(ConvertJson.list2json(menuList));
		return null;
	}
	
	@Resource(name="sysMenuSrv")
	private SysMenuSrv sysMenuSrv;
	
	@Resource(name="sysUserSrv")
	private SysUserSrv sysUserSrv;
	
	private SysUserVo sysUserVo;

	public SysUserVo getSysUserVo() {
		return sysUserVo;
	}

	public void setSysUserVo(SysUserVo sysUserVo) {
		this.sysUserVo = sysUserVo;
	}
}
