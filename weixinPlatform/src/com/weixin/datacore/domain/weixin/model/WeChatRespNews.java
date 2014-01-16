package com.weixin.datacore.domain.weixin.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "xml")
public class WeChatRespNews implements Serializable {
	
	private static final long serialVersionUID = 2687201723161197284L;
	private String toUserName;
	private String fromUserName;
	private Long createTime;
	private String msgType;
	private Integer articleCount;
	private WeChatRespNewsItems items;

	public WeChatRespNewsItems getItems() {
		return items;
	}

	@XmlElement(name = "Articles")
	public void setItems(WeChatRespNewsItems items) {
		this.items = items;
	}

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

	public Integer getArticleCount() {
		return articleCount;
	}

	@XmlElement(name = "ArticleCount")
	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}

	@Override
	public String toString() {
		return "WeChatRespNews [articleCount=" + articleCount + ", createTime="
				+ createTime + ", fromUserName=" + fromUserName + ", items="
				+ items + ", msgType=" + msgType + ", toUserName=" + toUserName
				+ "]";
	}
}