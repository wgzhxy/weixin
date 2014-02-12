package com.weixin.webui.end;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.weixin.comm.ConvertJson;
import com.weixin.comm.PageInfo;
import com.weixin.comm.Uuid;
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
		return "index";
	}

	public String PageAdd() {
		
		return "add";
	}

	public String PageEdit() {
		return "edit";
	}

	public String PageSave() {
		return "save";
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
