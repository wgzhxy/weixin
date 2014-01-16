package com.weixin.datacore.domain.weixin.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class WeChatRespNewsItems {
	private List<WeChatRespNewsItem> item =null;
	
	public List<WeChatRespNewsItem> getItem() {
		return item;
	}

	public void setItem(List<WeChatRespNewsItem> item) {
		this.item = item;
	}
}