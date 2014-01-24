package com.weixin.webui.end;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.envers.Audited;

import com.weixin.comm.ConvertJson;
import com.weixin.comm.logs.LogUtil;
import com.weixin.datacore.domain.sys.model.SysMenu;
import com.weixin.datacore.domain.sys.vo.SysUserVo;
import com.weixin.datacore.domain.sys.vo.TreeNode;
import com.weixin.datacore.service.sys.SysMenuSrv;
import com.weixin.webui.core.BaseAction;

@SuppressWarnings("serial")
public class IndexAction extends BaseAction {
	
	public String Login() {
		if(sysUserVo != null) {
			LogUtil.info(sysUserVo.getUserName());
			LogUtil.info(sysUserVo.getPassword());
			List<SysMenu> menuParent = sysMenuSrv.getParentMenu();
			this.setRequestAttribute("menuParent", menuParent);
			return "index";
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
	
	private SysUserVo sysUserVo;

	public SysUserVo getSysUserVo() {
		return sysUserVo;
	}

	public void setSysUserVo(SysUserVo sysUserVo) {
		this.sysUserVo = sysUserVo;
	}
}
