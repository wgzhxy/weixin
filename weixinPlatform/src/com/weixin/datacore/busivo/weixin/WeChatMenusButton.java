package com.weixin.datacore.busivo.weixin;

import java.io.Serializable;
import java.util.List;

public class WeChatMenusButton implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3809408244664841652L;
	
	private List<WeChatMenusSubButton> button;
	
	public List<WeChatMenusSubButton> getButton() {
		return button;
	}

	public void setButton(List<WeChatMenusSubButton> subbuttons) {
		this.button = subbuttons;
	}
	
	public WeChatMenusButton(){}
	
}