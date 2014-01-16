package com.weixin.datacore.domain.weixin.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Command")
public class WeChatXiaoICommand implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Arg;

	public String getArg() {
		return Arg;
	}

	@XmlElement(name = "Arg")
	public void setArg(String arg) {
		Arg = arg;
	}
}
