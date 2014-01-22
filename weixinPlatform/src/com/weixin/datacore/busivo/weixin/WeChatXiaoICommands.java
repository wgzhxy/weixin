package com.weixin.datacore.busivo.weixin;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Commands")
public class WeChatXiaoICommands implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<WeChatXiaoICommand> command;
	private String name;
	private String state;

	public List<WeChatXiaoICommand> getCommand() {
		return command;
	}

	public void setCommand(List<WeChatXiaoICommand> command) {
		this.command = command;
	}

	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	@XmlAttribute
	public void setState(String state) {
		this.state = state;
	}
}
