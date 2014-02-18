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
import com.weixin.datacore.domain.weixin.model.WeixinFormHumanServices;
import com.weixin.datacore.service.weixin.WeixinFormHumanServicesSrv;
import com.weixin.webui.core.BaseAction;
import com.weixin.webui.form.WeixinFormHumanServicesForm;
/**
 * 人工服务表单处理
 * @author JINLONE
 *
 */
public class WeixinFormHumanServicesAction extends BaseAction {
	private String jump;
	private WeixinFormHumanServicesForm weixinFormHumanServicesForm;
	private String id;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4949448238447282481L;

	/**
	 * 取得列表数据进行展示使用
	 * 
	 * @return
	 */
	public String humanList(){
		if(weixinFormHumanServicesForm!=null){
			Map<String, Object> params = new HashMap<String, Object>();
			
			if(StringUtils.isNotEmpty(weixinFormHumanServicesForm.getUserName())){
				params.put("userName", weixinFormHumanServicesForm.getUserName());
			}
			
			if(StringUtils.isNotEmpty(weixinFormHumanServicesForm.getState())){
				params.put("state", weixinFormHumanServicesForm.getState());
			}
			
			Long total = 0L;
			Map<String, Object> map = new HashMap<String, Object>();
			PageInfo<WeixinFormHumanServices> pageInfo = weixinFormHumanServicesSrv.findWeixinFormHumanServicesList(params,
					this.page, this.rows);
			List<WeixinFormHumanServicesForm> reservationLs = new ArrayList<WeixinFormHumanServicesForm>();
			if (pageInfo != null) {
				for (WeixinFormHumanServices obj : pageInfo.getResultlist()) {
					WeixinFormHumanServicesForm e=new WeixinFormHumanServicesForm();
					e.setId(String.valueOf(obj.getId()));
					e.setUserName(obj.getUserName());
					e.setOpenId(obj.getOpenId());
					e.setMobile(obj.getMobile());
					e.setEmail(obj.getEmail());
					e.setQuestionContents(obj.getQuestionContents());
					e.setReplyContents(obj.getReplyContents());
					e.setUpdateTime(String.valueOf(obj.getUpdateTime()));
					e.setCreateTime(String.valueOf(obj.getCreateTime()));
					int state=obj.getState();
					if(state==0){
						e.setState("未处理");
					}else{
						e.setState("已处理");
					}
					int questionType=obj.getQuestionType();
					if(questionType==1){
						e.setQuestionType("销售相关");
					}else if(questionType==2){
						e.setQuestionType("物业问题");
					}else{
						e.setQuestionType("其他问题");
					}
					reservationLs.add(e);
				}
				total = pageInfo.getTotalrecond();
			}
			map.put("total", total);
			map.put("rows", reservationLs);
			String jsonStr = ConvertJson.map2json(map);
			LogUtil.info(jsonStr);
			this.writeResult(jsonStr);
			return null;
		}
		return SUCCESS;
	}
	/**
	 * 已经处理
	 * @return
	 */
	public String humanRemove() {
		try{
			if(StringUtils.isNotEmpty(weixinFormHumanServicesForm.getId())){
				WeixinFormHumanServices weixinFormHumanServices=weixinFormHumanServicesSrv.getWeixinFormHumanServices(Long.valueOf(weixinFormHumanServicesForm.getId()));
				if(weixinFormHumanServices!=null){
					weixinFormHumanServices.setState(Integer.parseInt(weixinFormHumanServicesForm.getId()));
					weixinFormHumanServices.setUpdateTime(DateUtil.getNow());
					weixinFormHumanServices.setReplyContents(weixinFormHumanServicesForm.getReplyContents());
					weixinFormHumanServicesSrv.updateWeixinFormHumanServices(weixinFormHumanServices);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			this.writeResult("e");
			return null;
		}
		this.writeResult("0");
		return null;
	}
	
	/**
	 * 新增处理
	 * @return
	 */
	public String humanAdd() {
		if(weixinFormHumanServicesForm==null){
			this.writeResult("e");//成功添加数据了
			return null;
		}
		try{
			WeixinFormHumanServices weixinFormHumanServices=new WeixinFormHumanServices();
			weixinFormHumanServicesSrv.addWeixinFormHumanServices(weixinFormHumanServices);
			this.writeResult("0");//成功添加数据了
			return null;
		}catch(Exception e){
			e.printStackTrace();
			this.writeResult("e");//系统异常的处理
			return null;
		}
	}
	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String humanBase() {
		if(StringUtils.isNotEmpty(jump)){
			return jump;
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
	
	public WeixinFormHumanServicesForm getWeixinFormHumanServicesForm() {
		return weixinFormHumanServicesForm;
	}
	public void setWeixinFormHumanServicesForm(
			WeixinFormHumanServicesForm weixinFormHumanServicesForm) {
		this.weixinFormHumanServicesForm = weixinFormHumanServicesForm;
	}

	@Resource(name = "weixinFormHumanServicesSrv")
	private WeixinFormHumanServicesSrv weixinFormHumanServicesSrv;
}