package com.weixin.webui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.weixin.comm.ConvertJson;
import com.weixin.comm.PageInfo;
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
public class WeixinPrictureAction extends BaseAction {
	private String jump;
	private WeixinPictureForm weixinPictureForm;
	
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
		return SUCCESS;
	}

	/**
	 * 新增
	 * 
	 * @return
	 */
	public String pictureAdd() {
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

	@Resource(name = "weixinPictureSrv")
	private WeixinPictureSrv weixinPictureSrv;

}