package com.weixin.datacore.domain.weixin.model;

import java.io.Serializable;
import java.util.List;

public class WeChatMenusSubButton implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4004761058949883738L;
	
	public WeChatMenusSubButton(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<WeChatMenusItem> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<WeChatMenusItem> subButton) {
		sub_button = subButton;
	}
	private String name;
	private List<WeChatMenusItem> sub_button;
}
