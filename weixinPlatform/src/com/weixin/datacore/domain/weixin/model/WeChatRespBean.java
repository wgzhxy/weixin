package com.weixin.datacore.domain.weixin.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "xml")
public class WeChatRespBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String toUserName;
	
	private String fromUserName;
	
	private Long createTime;
	
	private String msgType;
	
	private String content;
	
	private Integer funcFlag = 0;

	public String getToUserName() {
		return toUserName;
	}
	
	@XmlElement(name = "ToUserName")
	@XmlJavaTypeAdapter(value = CDATAdapter.class)
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	@XmlElement(name = "FromUserName")
	@XmlJavaTypeAdapter(value = CDATAdapter.class)
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	@XmlElement(name = "CreateTime")
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	@XmlElement(name = "MsgType")
	@XmlJavaTypeAdapter(value = CDATAdapter.class)
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return content;
	}

	@XmlElement(name = "Content")
	@XmlJavaTypeAdapter(value = CDATAdapter.class)
	public void setContent(String content) {
		this.content = content;
	}

	public Integer getFuncFlag() {
		return funcFlag;
	}

	@XmlElement(name = "FuncFlag")
	public void setFuncFlag(Integer funcFlag) {
		this.funcFlag = funcFlag;
	}
}