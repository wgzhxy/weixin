package com.weixin.webui;

import java.sql.Timestamp;
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
import com.weixin.datacore.domain.weixin.model.WeixinFormReservation;
import com.weixin.datacore.service.weixin.WeixinFormReservationSrv;
import com.weixin.webui.core.BaseAction;
import com.weixin.webui.form.WeixinFormReservationForm;
/**
 * 预约看房表单处理
 * @author JINLONE
 *
 */
public class WeixinFormReservationAction extends BaseAction {
	private String jump;
	private WeixinFormReservationForm weixinFormReservationForm;
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
	public String reservationList(){
		if(weixinFormReservationForm!=null){
			Map<String, Object> params = new HashMap<String, Object>();
			
			if(StringUtils.isNotEmpty(weixinFormReservationForm.getUserName())){
				params.put("userName", weixinFormReservationForm.getUserName());
			}
			
			if(StringUtils.isNotEmpty(weixinFormReservationForm.getState())){
				params.put("state", weixinFormReservationForm.getState());
			}
			
			Long total = 0L;
			Map<String, Object> map = new HashMap<String, Object>();
			PageInfo<WeixinFormReservation> pageInfo = weixinFormReservationSrv.findWeixinFormReservationList(params,
					this.page, this.rows);
			List<WeixinFormReservationForm> reservationLs = new ArrayList<WeixinFormReservationForm>();
			if (pageInfo != null) {
				for (WeixinFormReservation obj : pageInfo.getResultlist()) {
					WeixinFormReservationForm e=new WeixinFormReservationForm();
					e.setCreateTime(String.valueOf(obj.getCreateTime()));
					e.setId(String.valueOf(obj.getId()));
					e.setUpdateTime(String.valueOf(obj.getUpdateTime()));
					e.setCity(obj.getCity());
					e.setUserName(obj.getUserName());
					e.setCreateTime(String.valueOf(obj.getCreateTime()));
					e.setMobile(obj.getMobile());
					e.setNick(obj.getNick());
					e.setReservationStartTime(String.valueOf(obj.getReservationStartTime())+"<br>至<br>"+String.valueOf(obj.getReservationEndTime()));
					int state=obj.getState();
					if(state==0){
						e.setState("未处理");
					}else{
						e.setState("已处理");
					}
					int sex=obj.getSex();
					if(sex==0){
						e.setSex("女");
					}else{
						e.setSex("男");
					}
					int isInitiative=obj.getIsInitiative();
					if(isInitiative==0){
						e.setIsInitiative("否");
					}else{
						e.setIsInitiative("是");
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
	public String reservationRemove() {
		if(StringUtils.isNotEmpty(id)){
			WeixinFormReservation weixinFormReservation=weixinFormReservationSrv.getWeixinFormReservation(Long.valueOf(id));
			if(weixinFormReservation!=null){
				weixinFormReservation.setState(1);
				weixinFormReservation.setUpdateTime(DateUtil.getNow());
				weixinFormReservationSrv.updateWeixinFormReservation(weixinFormReservation);
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 新增处理
	 * @return
	 */
	public String reservationAdd() {
		if(weixinFormReservationForm==null){
			this.writeResult("e");//成功添加数据了
			return null;
		}
		try{
			WeixinFormReservation weixinFormReservation=new WeixinFormReservation();
			weixinFormReservation.setCreateTime(DateUtil.getNow());
			weixinFormReservation.setIsInitiative(Integer.parseInt(weixinFormReservationForm.getIsInitiative()));
			weixinFormReservation.setState(0);
			weixinFormReservation.setSex(Integer.parseInt(weixinFormReservationForm.getSex()));
			weixinFormReservation.setNick(weixinFormReservationForm.getNick());
			weixinFormReservation.setUserName(weixinFormReservationForm.getUserName());
			
			String reservationStartTime=weixinFormReservationForm.getReservationEndTime();
			if(reservationStartTime!=null){
				weixinFormReservation.setReservationEndTime(Timestamp.valueOf(reservationStartTime));
			}
			String reservationEndTime=weixinFormReservationForm.getReservationStartTime();
			if(reservationEndTime!=null){
				weixinFormReservation.setReservationEndTime(Timestamp.valueOf(reservationEndTime));
			}
			
			weixinFormReservationSrv.addWeixinFormReservation(weixinFormReservation);
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
	public String reservationBase() {
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
	
	public WeixinFormReservationForm getWeixinFormReservationForm() {
		return weixinFormReservationForm;
	}
	public void setWeixinFormReservationForm(
			WeixinFormReservationForm weixinFormReservationForm) {
		this.weixinFormReservationForm = weixinFormReservationForm;
	}

	@Resource(name = "weixinFormReservationSrv")
	private WeixinFormReservationSrv weixinFormReservationSrv;
}