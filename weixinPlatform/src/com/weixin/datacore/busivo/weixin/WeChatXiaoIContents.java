package com.weixin.datacore.busivo.weixin;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class WeChatXiaoIContents implements Serializable {

	private static final long serialVersionUID = 1L;
	private WeChatRespNewsItems items;
	private String type;

	public WeChatRespNewsItems getItems() {
		return items;
	}

	@XmlElement(name = "Articles")
	public void setItems(WeChatRespNewsItems items) {
		this.items = items;
	}

	public String getType() {
		return type;
	}

	@XmlAttribute
	public void setType(String type) {
		this.type = type;
	}
}
