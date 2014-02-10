package com.weixin.webui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.weixin.comm.ConvertJson;
import com.weixin.comm.PageInfo;
import com.weixin.comm.date.DateUtil;
import com.weixin.comm.logs.LogUtil;
import com.weixin.datacore.domain.weixin.model.WeixinPicture;
import com.weixin.datacore.service.weixin.WeixinPictureSrv;
import com.weixin.webui.form.WeixinPictureForm;
import com.weixin.webui.core.BaseAction;

/**
 * 图片管理action
 * 
 * @author JINLONE
 * 
 */
public class WeixinPictureAction extends BaseAction {
	private String jump;
	private WeixinPictureForm weixinPictureForm;
	private String id;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4949448238447282481L;

	/**
	 * 取得菜单的列表数据进行展示使用
	 * 
	 * @return
	 */
	public String pictureList(){
		if(weixinPictureForm!=null){
			Map<String, Object> params = new HashMap<String, Object>();
			
			if(StringUtils.isNotEmpty(weixinPictureForm.getPictureName())){
				params.put("pictureName", weixinPictureForm.getPictureName());
			}
			
			if(StringUtils.isNotEmpty(weixinPictureForm.getState())){
				params.put("status", weixinPictureForm.getState());
			}
			
			Long total = 0L;
			Map<String, Object> map = new HashMap<String, Object>();
			PageInfo<WeixinPicture> pageInfo = weixinPictureSrv.findWeixinPictureList(params,
					this.page, this.rows);
			List<WeixinPictureForm> pictureLs = new ArrayList<WeixinPictureForm>();
			if (pageInfo != null) {
				for (WeixinPicture obj : pageInfo.getResultlist()) {
					WeixinPictureForm e=new WeixinPictureForm();
					e.setCreateTime(String.valueOf(obj.getCreateTime()));
					e.setPictureName(obj.getPictureName());
					e.setId(String.valueOf(obj.getId()));
					e.setPictureUrl(obj.getPictureUrl());
					e.setModifyTime(String.valueOf(obj.getUpdateTime()));
					int status=obj.getStatus();
					if(status==0){
						e.setState("无效");
					}else{
						e.setState("有效");
					}
					pictureLs.add(e);
				}
				total = pageInfo.getTotalrecond();
			}
			map.put("total", total);
			map.put("rows", pictureLs);
			String jsonStr = ConvertJson.map2json(map);
			LogUtil.info(jsonStr);
			this.writeResult(jsonStr);
			return null;
		}
		return SUCCESS;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String pictureRemove() {
		if(StringUtils.isNotEmpty(id)){
			WeixinPicture weixinPicture=weixinPictureSrv.getWeixinPicture(Long.valueOf(id));
			if(weixinPicture!=null){
				weixinPicture.setStatus(0);
				weixinPictureSrv.updateWeixinPicture(weixinPicture);
			}
		}
		return SUCCESS;
	}

	/**
	 * 新增
	 * 
	 * @return
	 */
	public String pictureAdd() {
		WeixinPicture weixinPicture=new WeixinPicture();
		if(weixinPictureForm!=null){
			weixinPicture.setCreateTime(DateUtil.getNow());
			weixinPicture.setStatus(1);
			weixinPicture.setPictureUrl(weixinPictureForm.getPictureUrl());
			weixinPicture.setPictureName(weixinPictureForm.getPictureName());
			weixinPicture.setPlatformTag(weixinPictureForm.getPlatformTag());
			try{
				weixinPicture=weixinPictureSrv.addWeixinPicture(weixinPicture);
			}catch(Exception e){
				e.printStackTrace();
			}
			weixinPictureForm.setId(String.valueOf(weixinPicture.getId()));
			weixinPictureForm.setState("有效");
			String jsonStr = ConvertJson.bean2json(weixinPictureForm);
			LogUtil.info(jsonStr);
			this.writeResult(jsonStr);
			return null;
		}
		return SUCCESS;
	}

	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String pictureBase() {
		if (jump.equals("add")) {
			return "add";
		}
		return SUCCESS;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public WeixinPictureForm getWeixinPictureForm() {
		return weixinPictureForm;
	}

	public void setWeixinPictureForm(WeixinPictureForm weixinPictureForm) {
		this.weixinPictureForm = weixinPictureForm;
	}

	public String getJump() {
		return jump;
	}

	public void setJump(String jump) {
		this.jump = jump;
	}

	@Resource(name = "weixinPictureSrv")
	private WeixinPictureSrv weixinPictureSrv;
}