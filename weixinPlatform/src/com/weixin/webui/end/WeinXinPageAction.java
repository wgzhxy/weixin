package com.weixin.webui.end;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;

import com.weixin.comm.ConvertJson;
import com.weixin.comm.PageInfo;
import com.weixin.comm.Uuid;
import com.weixin.comm.date.DateUtil;
import com.weixin.comm.logs.LogUtil;
import com.weixin.datacore.domain.weixin.model.WeixinPageClass;
import com.weixin.datacore.domain.weixin.model.WeixinPageInfo;
import com.weixin.datacore.domain.weixin.vo.WeixinPageClassVo;
import com.weixin.datacore.domain.weixin.vo.WeixinPageInfoVo;
import com.weixin.datacore.service.weixin.WeixinPageClassSrv;
import com.weixin.datacore.service.weixin.WeixinPageInfoSrv;
import com.weixin.webui.core.BaseAction;

/**
 * 微信页面管理
 * 
 * @author wang.g.z
 * 
 */
@SuppressWarnings("serial")
public class WeinXinPageAction extends BaseAction {

	public String PageList() {
		if (weixinPageInfoVo != null) {
			Map<String, Object> params = new HashMap<String, Object>();
			PageInfo<WeixinPageInfo> pageInfo = weixinPageInfoSrv.findWeixinPageInfoList(params, this.page, this.rows);
			
			params.clear();
			if (pageInfo != null) {
				String operator = "";
				List<WeixinPageInfoVo> resultList = new ArrayList<WeixinPageInfoVo>();
				for(WeixinPageInfo obj : pageInfo.getResultlist()) {
					WeixinPageInfoVo vo = new WeixinPageInfoVo();
					vo.setId(obj.getId());
					vo.setPageTitle(obj.getPageTitle());
					vo.setContent(obj.getContent());
					vo.setCreateTime(obj.getCreateTime());
					operator = "<a href='#' onclick='editPage(\""+obj.getId()+"\");' id='memo' data-type='text' data-placement='right'>编辑</a> " + 
							   " | <a href='#' onclick='deletePage(\""+obj.getId()+"\");'>删出</a> | <a href='#' onclick='viewPage(\""+obj.getId()+"\");'>查看链接</a>";
					vo.setOperator(operator);
					resultList.add(vo);
				}
				params.put("total", pageInfo.getTotalrecond());
				params.put("rows", resultList);
			} else {
				params.put("total", 0);
				params.put("rows", null);
			}
			String jsonStr = ConvertJson.map2json(params);
			LogUtil.info(jsonStr);
			this.writeResult(jsonStr);
			return null;
		}
		return "index";
	}
	
	public String PageDelete() {
		LogUtil.info("PageClassDelete!");
		if(weixinPageInfoVo != null && StringUtils.isNotEmpty(weixinPageInfoVo.getId())) {
			if (StringUtils.isNotEmpty(weixinPageInfoVo.getId())) {
				weixinPageInfoSrv.deleWeixinPageInfo(weixinPageInfoVo.getId());
			}
		}
		return "redirect";
	}

	public String PageAdd() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<WeixinPageClass> ls = weixinPageClassSrv.findWeixinPageClassList(params);
		this.getRequest().setAttribute("pageClass", ls);
		return "add";
	}

	public String PageEdit() {
		WeixinPageInfo obj = null;
		if(weixinPageInfoVo != null && StringUtils.isNotEmpty(weixinPageInfoVo.getId())) {
			 obj = weixinPageInfoSrv.getWeixinPageInfo(weixinPageInfoVo.getId());
		}
		//微页面分类加载
		Map<String, Object> params = new HashMap<String, Object>();
		List<WeixinPageClass> ls = weixinPageClassSrv.findWeixinPageClassList(params);
		
		this.getRequest().setAttribute("weixinPageClass", ls);
		this.getRequest().setAttribute("weixinPageInfo", obj);
		return "edit";
	}

	public String PageSave() {
		JSONObject json = new JSONObject();
		try{
			if(weixinPageInfoVo != null && StringUtils.isEmpty(weixinPageInfoVo.getId())) {
				WeixinPageInfo weixinPageInfo = new WeixinPageInfo();
				weixinPageInfo.setId(Uuid.getPrimaryKey());
				weixinPageInfo.setCreateTime(DateUtil.getNow());
				weixinPageInfo.setUpdateTime(DateUtil.getNow());
				weixinPageInfo.setContent(weixinPageInfoVo.getContent());
				weixinPageInfo.setAssociateLinks(weixinPageInfoVo.getAssociateLinks());
				weixinPageInfo.setDisplayNum(weixinPageInfoVo.getDisplayNum());
				weixinPageInfo.setPageClass(weixinPageInfoVo.getPageClass());
				weixinPageInfo.setPageName(weixinPageInfoVo.getPageName());
				weixinPageInfo.setPageTitle(weixinPageInfoVo.getPageTitle());
				weixinPageInfo.setPageSubtitle(weixinPageInfoVo.getPageSubtitle());
				weixinPageInfoSrv.addWeixinPageInfo(weixinPageInfo);
			} else {
				weixinPageInfoSrv.updateWeixinPageInfo(weixinPageInfoVo);
			}
			json.put("result", "ok");
		} catch(Exception e) {
			e.printStackTrace();
			json.put("result", "error");
		}
		this.writeResult(json.toString());
		return null;
	}

	public String PageClassList() {
		if (weixinPageClassVo != null) {
			Map<String, Object> params = new HashMap<String, Object>();
			PageInfo<WeixinPageClass> pageInfo = weixinPageClassSrv.findWeixinPageClassList(params, this.page, this.rows);

			params.clear();
			if (pageInfo != null) {
				params.put("total", pageInfo.getTotalrecond());
				params.put("rows", pageInfo.getResultlist());
			} else {
				params.put("total", 0);
				params.put("rows", null);
			}
			String jsonStr = ConvertJson.map2json(params);
			LogUtil.info(jsonStr);
			this.writeResult(jsonStr);
			return null;
		}
		return "list";
	}

	public String PageClassDelete() {
		LogUtil.info("PageClassDelete!");
		String sysId = this.getRequestParameter("id");
		if (StringUtils.isNotEmpty(sysId)) {
			weixinPageClassSrv.deleWeixinPageClass(sysId);
		}
		return null;
	}

	@SuppressWarnings("unused")
	public String PageClassSave() {
		WeixinPageClass obj = null;
		String className = this.getRequestParameter("className");
		String type = this.getRequestParameter("type");
		String classDesc = this.getRequestParameter("classDesc");
		String id = this.getRequestParameter("id");
		String isNewRecord = this.getRequestParameter("isNewRecord");
		if (!StringUtils.equals("true", isNewRecord)) {
			LogUtil.info("PageClassSave!");
			if (StringUtils.isNotEmpty(id)) {
				obj = weixinPageClassSrv.getWeixinPageClass(id);
				if (obj != null) {
					obj.setClassDesc(classDesc);
					obj.setClassName(className);
					obj.setType(type);
					obj.setUpdateTime(new Date());
					weixinPageClassSrv.updateWeixinPageClass(obj);
				}
			}
		} else {
			LogUtil.info("PageClassSave!");
			obj = new WeixinPageClass();
			obj.setClassDesc(classDesc);
			obj.setClassName(className);
			obj.setType(type);
			obj.setCreateTime(new Date());
			obj.setUpdateTime(new Date());
			obj.setId(Uuid.getPrimaryKey());
			weixinPageClassSrv.addWeixinPageClass(obj);
		}
		this.writeResult(ConvertJson.bean2json(obj));
		return null;
	}

	@Resource(name = "weixinPageClassSrv")
	private WeixinPageClassSrv weixinPageClassSrv;
	
	@Resource(name = "weixinPageInfoSrv")
	private WeixinPageInfoSrv weixinPageInfoSrv;

	private WeixinPageClassVo weixinPageClassVo;
	private WeixinPageInfoVo weixinPageInfoVo;

	public WeixinPageClassVo getWeixinPageClassVo() {
		return weixinPageClassVo;
	}

	public void setWeixinPageClassVo(WeixinPageClassVo weixinPageClassVo) {
		this.weixinPageClassVo = weixinPageClassVo;
	}

	public WeixinPageInfoVo getWeixinPageInfoVo() {
		return weixinPageInfoVo;
	}

	public void setWeixinPageInfoVo(WeixinPageInfoVo weixinPageInfoVo) {
		this.weixinPageInfoVo = weixinPageInfoVo;
	}

}
