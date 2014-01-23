package com.weixin.datacore.busivo.weixin;

import java.io.Serializable;

public class WeChatMenusItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8731878340037880979L;
	public WeChatMenusItem(){}
	
	private String type;
	private String name;
	private String key;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}