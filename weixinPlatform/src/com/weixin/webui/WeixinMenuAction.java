package com.weixin.webui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import com.weixin.comm.ConvertJson;
import com.weixin.comm.date.DateUtil;
import com.weixin.comm.logs.LogUtil;
import com.weixin.datacore.domain.weixin.model.WeixinMenu;
import com.weixin.datacore.domain.weixin.vo.WeixinMenuTreeNode;
import com.weixin.datacore.service.weixin.WeixinMenuSrv;
import com.weixin.webui.core.BaseAction;
import com.weixin.webui.form.WeixinMenuForm;

/**
 * 菜单管理action
 * 
 * @author JINLONE
 * 
 */
public class WeixinMenuAction extends BaseAction {

	private String jump;
	private WeixinMenuForm weixinMenuForm;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4949448238447282481L;

	/**
	 * 取得菜单的列表数据进行展示使用
	 * 
	 * @return
	 */
	public String menuTreeGrid() {
		List<WeixinMenuTreeNode> list = weixinMenuSrv.weixinMenuTreeNodeList();
		String jsonStr = ConvertJson.list2json(list);
		LogUtil.info(jsonStr);
		this.writeResult(jsonStr);
		return null;
	}

	public String menuList() {
		if (weixinMenuForm != null) {
			Map<String, Object> params = new HashMap<String, Object>();
			if (StringUtils.isNotEmpty(weixinMenuForm.getParentId())) {
				params.put("parentId", weixinMenuForm.getParentId());
			}

			if (StringUtils.isNotEmpty(weixinMenuForm.getState())) {
				params.put("state", weixinMenuForm.getState());
			}

			if (StringUtils.isNotEmpty(weixinMenuForm.getMenuName())) {
				params.put("menuName", weixinMenuForm.getMenuName());
			}

			List<WeixinMenu> list = weixinMenuSrv.findWeixinMenuListForMap(
					params, this.page,this.rows);
			String jsonStr = ConvertJson.list2json(list);
			LogUtil.info(jsonStr);
			this.writeResult(jsonStr);
			return null;
		}
		return SUCCESS;
	}
	/**
	 * 修改
	 * 
	 * @return
	 */
	public String menuEdit() {
		if(weixinMenuForm!=null){
				String menuName=weixinMenuForm.getMenuName();
				WeixinMenu weixinMenu=null;
				if(this.getRequestParameter("falg").equals("2")){
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("menuName", menuName);
					weixinMenu=weixinMenuSrv.getWeixinMenu(params);
					if(weixinMenu!=null){
						this.writeResult("100");
						return null;
					}
				}
				weixinMenu=weixinMenuSrv.getWeixinMenu(Long.valueOf(weixinMenuForm.getId()));
				if(weixinMenu!=null){
					weixinMenu.setUpdateTime(DateUtil.getNow());
					weixinMenu.setMenuKey(weixinMenuForm.getMenuKey());
					weixinMenu.setState(Integer.parseInt(weixinMenuForm.getState()));
					weixinMenu.setMenuName(menuName);
					weixinMenu.setType(weixinMenuForm.getType());
					weixinMenu.setUrl(weixinMenuForm.getUrl());
					
					String button=weixinMenuForm.getButton();
					if(button.equals("button")){
						weixinMenu.setButton(button);
						weixinMenu.setParentId(0);
					}else{
						weixinMenu.setSubButton(button);
						weixinMenu.setParentId(Long.valueOf(weixinMenuForm.getParentId()));
					}
					weixinMenuSrv.updateWeixinMenu(weixinMenu);
				}
				this.writeResult("000");
				return null;
		}
		return SUCCESS;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String menuRemove() {
		return SUCCESS;
	}

	/**
	 * 新增
	 * 
	 * @return
	 */
	public String menuAdd() {
		try{
		if(weixinMenuForm!=null){
			String name=weixinMenuForm.getMenuName();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("menuName", name);
			WeixinMenu weixinMenu=weixinMenuSrv.getWeixinMenu(params);
			if(weixinMenu!=null){
				this.writeResult("100");
				return null;
			}
			
			weixinMenu=new WeixinMenu();
			weixinMenu.setCreateTime(DateUtil.getNow());
			weixinMenu.setMenuKey(weixinMenuForm.getMenuKey());
			weixinMenu.setState(1);
			weixinMenu.setMenuName(name);
			weixinMenu.setType(weixinMenuForm.getType());
			weixinMenu.setUrl(weixinMenuForm.getUrl());
			
			String button=weixinMenuForm.getButton();
			if(button.equals("button")){
				weixinMenu.setButton(button);
				weixinMenu.setParentId(0);
			}else{
				weixinMenu.setSubButton(button);
				weixinMenu.setParentId(Long.valueOf(weixinMenuForm.getParentId()));
			}
			weixinMenuSrv.addWeixinMenu(weixinMenu);
			
//			weixinMenuForm.setId(String.valueOf(weixinMenu.getId()));
//			weixinMenuForm.setStatus("有效");
//			
//			String jsonStr = ConvertJson.bean2json(weixinMenuForm);
//			LogUtil.info(jsonStr);
			this.writeResult("000");
			return null;
		}
		}catch(Exception e){e.printStackTrace();}
		return SUCCESS;
	}

	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String menuBase() {
		if (jump.equals("add")) {
			return "add";
		}
		if (jump.equals("edit")) {
			String id=this.getRequestParameter("id");
			if(id!=null){
				WeixinMenu weixinMenu=weixinMenuSrv.getWeixinMenu(Long.valueOf(id));
				this.getRequest().setAttribute("weixinMenu", weixinMenu);
			}else{
				return SUCCESS;
			}
			return "edit";
		}
		return SUCCESS;
	}

	public String getJump() {
		return jump;
	}

	public void setJump(String jump) {
		this.jump = jump;
	}

	public WeixinMenuForm getWeixinMenuForm() {
		return weixinMenuForm;
	}

	public void setWeixinMenuForm(WeixinMenuForm weixinMenuForm) {
		this.weixinMenuForm = weixinMenuForm;
	}
	
	@Resource(name = "weixinMenuSrv")
	private WeixinMenuSrv weixinMenuSrv;
}