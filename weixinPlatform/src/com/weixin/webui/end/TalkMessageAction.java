package com.weixin.webui.end;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import com.weixin.comm.ConvertJson;
import com.weixin.comm.PageInfo;
import com.weixin.comm.logs.LogUtil;
import com.weixin.datacore.domain.weixin.model.WeixinMessageLog;
import com.weixin.datacore.domain.weixin.vo.WeixinMessageLogVo;
import com.weixin.datacore.service.weixin.WeixinMessageLogSrv;
import com.weixin.webui.core.BaseAction;

/**
 * 微信消息管理
 * @author wang.g.z
 *
 */
@SuppressWarnings("serial")
public class TalkMessageAction extends BaseAction {
	
	public String ManagerIndex() {
		if(weixinMessageLogVo != null) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("msgClass", new Integer(0));
			PageInfo<WeixinMessageLog> messageLs = weixinMessageLogSrv.findWeixinMessageLogList(params, this.page, this.rows);
			
			params.clear();
			if(messageLs != null) {
				params.put("total", messageLs.getTotalrecond());
				params.put("rows", messageLs.getResultlist());
			} else {
				params.put("total", 0);
				params.put("rows", null);
			}
			String jsonStr = ConvertJson.map2json(params);
			LogUtil.info(jsonStr);
			this.writeResult(jsonStr);
			return null;
		}
		return "input";
	}
	
	public String TalkInfo() {
		if(weixinMessageLogVo != null 
				&& StringUtils.isNotEmpty(weixinMessageLogVo.getFromUserName())
				&& StringUtils.isNotEmpty(weixinMessageLogVo.getMsgClass())) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("msgClass", new Integer(0));
			params.put("fromUserName", weixinMessageLogVo.getFromUserName());
			PageInfo<WeixinMessageLog> messageLs = weixinMessageLogSrv.findWeixinMessageLogList(params, this.page, this.rows);
			
			params.clear();
			if(messageLs != null) {
				params.put("total", messageLs.getTotalrecond());
				params.put("rows", messageLs.getResultlist());
			} else {
				params.put("total", 0);
				params.put("rows", null);
			}
			String jsonStr = ConvertJson.map2json(params);
			LogUtil.info(jsonStr);
			this.writeResult(jsonStr);
			return null;
		}
		return "talk";
	}
	
	public String AddRemark() {
		
		return "remark";
	}

	public String AddStar() {
		
		return null;
	}
	
	/**
	 * 发送文字及图文消息
	 * @return
	 */
	public String SendMessage() {
		
		return "send";
	}
	
	@Resource(name="weixinMessageLogSrv")
	private WeixinMessageLogSrv weixinMessageLogSrv;
	
	private WeixinMessageLogVo weixinMessageLogVo;

	public WeixinMessageLogSrv getWeixinMessageLogSrv() {
		return weixinMessageLogSrv;
	}

	public void setWeixinMessageLogSrv(WeixinMessageLogSrv weixinMessageLogSrv) {
		this.weixinMessageLogSrv = weixinMessageLogSrv;
	}

	public WeixinMessageLogVo getWeixinMessageLogVo() {
		return weixinMessageLogVo;
	}

	public void setWeixinMessageLogVo(WeixinMessageLogVo weixinMessageLogVo) {
		this.weixinMessageLogVo = weixinMessageLogVo;
	}
}
