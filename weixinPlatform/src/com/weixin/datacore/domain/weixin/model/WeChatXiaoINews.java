package com.weixin.datacore.domain.weixin.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Response")
public class WeChatXiaoINews implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String Type;
	private String Similarity;
	private String Words;

	private WeChatXiaoIContents contents;
	private WeChatXiaoICommands commands;

	public String getType() {
		return Type;
	}

	@XmlElement(name = "Type")
	public void setType(String type) {
		Type = type;
	}

	public String getSimilarity() {
		return Similarity;
	}

	@XmlElement(name = "Similarity")
	public void setSimilarity(String similarity) {
		Similarity = similarity;
	}

	public String getWords() {
		return Words;
	}

	@XmlElement(name = "Words")
	public void setWords(String words) {
		Words = words;
	}

	@XmlElement(name = "Content")
	public WeChatXiaoIContents getContents() {
		return contents;
	}

	public void setContents(WeChatXiaoIContents contents) {
		this.contents = contents;
	}

	public WeChatXiaoICommands getCommands() {
		return commands;
	}

	@XmlElement(name = "Commands")
	public void setCommands(WeChatXiaoICommands commands) {
		this.commands = commands;
	}
}