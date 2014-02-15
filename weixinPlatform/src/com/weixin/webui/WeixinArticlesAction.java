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
import com.weixin.datacore.domain.weixin.model.WeixinArticles;
import com.weixin.datacore.domain.weixin.model.WeixinArticlesMulti;
import com.weixin.datacore.service.weixin.WeixinArticlesMultiSrv;
import com.weixin.datacore.service.weixin.WeixinArticlesSrv;
import com.weixin.webui.form.WeixinArticlesForm;
import com.weixin.webui.core.BaseAction;
/**
 * 图文管理action
 * 
 * @author JINLONE
 * 
 */
public class WeixinArticlesAction extends BaseAction {
	private String jump;
	private WeixinArticlesForm weixinArticlesForm;
	private String id;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4949448238447282481L;

	public String articlesList() {
		if (weixinArticlesForm != null) {
			Map<String, Object> params = new HashMap<String, Object>();

			if (StringUtils.isNotEmpty(weixinArticlesForm.getTitle())) {
				params.put("title", weixinArticlesForm.getTitle());
			}

			if (StringUtils.isNotEmpty(weixinArticlesForm.getPicType())) {
				params.put("picType", weixinArticlesForm.getPicType());
			}

			Long total = 0L;
			Map<String, Object> map = new HashMap<String, Object>();
			PageInfo<WeixinArticles> pageInfo = weixinArticlesSrv
					.findWeixinArticlesList(params, this.page, this.rows);
			List<WeixinArticlesForm> pictureLs = new ArrayList<WeixinArticlesForm>();
			if (pageInfo != null) {
				for (WeixinArticles obj : pageInfo.getResultlist()) {
					WeixinArticlesForm e = new WeixinArticlesForm();
					e.setCreateTime(String.valueOf(obj.getCreateTime()));
					e.setDescription(obj.getDescription());
					e.setTitle(obj.getTitle());
					e.setId(String.valueOf(obj.getId()));
					int picType = obj.getPicType();
					if (picType == 1) {
						e.setPicType("单图文");
					} else {
						e.setPicType("多图文");
					}
					int status = obj.getStatus();
					if (status == 1) {
						e.setStatus("有效");
					} else {
						e.setStatus("无效");
					}
					e.setUpdateTime(String.valueOf(obj.getUpdateTime()));
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
	public String articlesRemove() {
		if (StringUtils.isNotEmpty(id)) {
			WeixinArticles weixinArticles = weixinArticlesSrv
					.getWeixinArticles(Long.valueOf(id));
			if (weixinArticles != null) {
				weixinArticles.setStatus(0);
				weixinArticlesSrv.updateWeixinArticles(weixinArticles);
				WeixinArticlesForm e = new WeixinArticlesForm();
				e.setCreateTime(String.valueOf(weixinArticles.getCreateTime()));
				e.setDescription(weixinArticles.getDescription());
				e.setTitle(weixinArticles.getTitle());
				e.setId(String.valueOf(weixinArticles.getId()));
				int picType = weixinArticles.getPicType();
				if (picType == 1) {
					e.setPicType("单图文");
				} else {
					e.setPicType("多图文");
				}
				int status = weixinArticles.getStatus();
				if (status == 1) {
					e.setStatus("有效");
				} else {
					e.setStatus("无效");
				}
				e.setUpdateTime(String.valueOf(weixinArticles.getUpdateTime()));
				String jsonStr = ConvertJson.bean2json(e);
				LogUtil.info(jsonStr);
				this.writeResult(jsonStr);
				return null;
			}
		}
		return SUCCESS;
	}
	/**
	 * 修改
	 * 
	 * @return
	 */
	public String articlesEdit() throws Exception{
	  try{
			if (weixinArticlesForm != null) {
				String title=weixinArticlesForm.getTitle();
				WeixinArticles weixinArticles=null;
				if(getRequestParameter("isEdit").equals("1")){
					Map<String,Object> params=new HashMap<String,Object>();
					params.put("title", title);
					weixinArticles=weixinArticlesSrv.getWeixinArticles(params);
					if(weixinArticles!=null){
						this.writeResult("3");
						return null;
					}
				}
				
				weixinArticles = weixinArticlesSrv.getWeixinArticles(Long.valueOf(weixinArticlesForm.getId()));
				if(weixinArticles==null){
					this.writeResult("2");//数据异常了
					return null;
				}
				
				weixinArticles.setTitle(weixinArticlesForm.getTitle());
				weixinArticles.setDescription(weixinArticlesForm.getDescription());
				weixinArticles.setUpdateTime(DateUtil.getNow());
				weixinArticles.setPicUrl(weixinArticlesForm.getPicUrl());
				weixinArticles.setUrl(weixinArticlesForm.getUrl());
				weixinArticlesSrv.updateWeixinArticles(weixinArticles);
				
				String picType=weixinArticlesForm.getPicType();
				if(picType.equals("2")){
					long articlesId=Long.valueOf(weixinArticlesForm.getId());
					Map<String,Object> params=new HashMap<String,Object>();
					params.put("articlesId",articlesId);
					List<WeixinArticlesMulti> weixinArticlesMultiLs=weixinArticlesMultiSrv.findWeixinArticlesMultiList(params);
					if(weixinArticlesMultiLs!=null){
						weixinArticlesMultiSrv.deleWeixinArticlesMultiList(weixinArticlesMultiLs);//清理现有数据
					}
					articlesMulti(articlesId);//重新添加数据
				}
				
				this.writeResult("0");//数据修改成功
				return null;
			}
		  }catch(Exception e){
				e.printStackTrace();
				this.writeResult("e");//系统异常
				return null;
		  }
		  return SUCCESS;
	}
	/**
	 * 新增
	 * 
	 * @return
	 */
	public String articlesAdd() {
		String picType=weixinArticlesForm.getPicType();//取得提交的图文类型
		try{
			if (StringUtils.isEmpty(weixinArticlesForm.getTitle())) {
				this.writeResult("2");//参数为空,理论上前台是需要验证
				return null;
			}
			
			Map<String,Object> params=new HashMap<String,Object>();
			params.put("title", weixinArticlesForm.getTitle());
			WeixinArticles weixinArticles = weixinArticlesSrv.getWeixinArticles(params);
			if(weixinArticles!=null){
				this.writeResult("3");//添加的标题出现重复
				return null;
			}
			
			weixinArticles=new WeixinArticles();
			weixinArticles.setCreateTime(DateUtil.getNow());
			weixinArticles.setUrl(weixinArticlesForm.getUrl());
			weixinArticles.setTitle(weixinArticlesForm.getTitle());
			weixinArticles.setStatus(1);
			weixinArticles.setPicUrl(weixinArticlesForm.getPicUrl());
			weixinArticles.setPicType(Integer.parseInt(picType));
			
			if(picType.equals("1")){//单图文提交
				weixinArticles.setDescription(weixinArticlesForm.getDescription());//单图文多了一个备注
				weixinArticlesSrv.addWeixinArticles(weixinArticles);
				this.writeResult("0");//成功添加数据了
				return null;
			}
			if(picType.equals("2")){//多图文提交方式
				weixinArticlesSrv.addWeixinArticles(weixinArticles);
				long articles_id=weixinArticles.getId();
				articlesMulti(articles_id);//增加多图文下面的子项
				this.writeResult("0");//成功添加数据了
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			this.writeResult("e");//系统异常的处理
			return null;
		}
		return SUCCESS;
	}
	
	
	private void articlesMulti(long articles_id){
		List<WeixinArticlesMulti> list=new ArrayList<WeixinArticlesMulti>();
		String items_str=this.getRequestParameter("items_array");
		String[] items_array=items_str.split(",");
		for(int i=0;i<items_array.length;i++){
			String str=items_array[i];
			if(StringUtils.isNotEmpty(str)){
				WeixinArticlesMulti weixinArticlesMulti=new WeixinArticlesMulti();
				weixinArticlesMulti.setArticlesId(articles_id);
				weixinArticlesMulti.setTitle(this.getRequestParameter("title"+str));
				weixinArticlesMulti.setUrl(this.getRequestParameter("url"+str));
				weixinArticlesMulti.setPicUrl(this.getRequestParameter("picUrl"+str));
				list.add(weixinArticlesMulti);
			}
		}
		if(list.size()>0){
			weixinArticlesMultiSrv.saveBatchWeixinArticlesMulti(list);
		}
	}

	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String articlesBase() {
		if (jump.equals("single")) {
			return "single";
		}else if (jump.equals("multi")) {
			return "multi";
		}else if (jump.equals("edit")) {
			if (weixinArticlesForm != null){
				String picType=weixinArticlesForm.getPicType();
				long id=Long.valueOf(weixinArticlesForm.getId());
				WeixinArticles weixinArticles = weixinArticlesSrv.getWeixinArticles(id);
				if (weixinArticles != null) {
					this.getRequest().setAttribute("weixinArticles",weixinArticles);
					if(picType.equals("1")){
						return "edit-single";
					}else if(picType.equals("2")){
						Map<String,Object> params=new HashMap<String,Object>();
						params.put("articlesId",id);
						List<WeixinArticlesMulti> weixinArticlesMultiLs=weixinArticlesMultiSrv.findWeixinArticlesMultiList(params);
						this.getRequest().setAttribute("weixinArticlesMulti",weixinArticlesMultiLs);
						return "edit_multi";
					}
				}
			}
		}
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJump() {
		return jump;
	}

	public void setJump(String jump) {
		this.jump = jump;
	}

	public WeixinArticlesForm getWeixinArticlesForm() {
		return weixinArticlesForm;
	}

	public void setWeixinArticlesForm(WeixinArticlesForm weixinArticlesForm) {
		this.weixinArticlesForm = weixinArticlesForm;
	}

	@Resource(name = "weixinArticlesSrv")
	private WeixinArticlesSrv weixinArticlesSrv;
	
	@Resource(name = "weixinArticlesMultiSrv")
	private WeixinArticlesMultiSrv weixinArticlesMultiSrv;
}