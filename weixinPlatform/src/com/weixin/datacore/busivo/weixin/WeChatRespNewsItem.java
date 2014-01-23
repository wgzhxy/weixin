package com.weixin.datacore.busivo.weixin;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "item")
public class WeChatRespNewsItem {
	
	private String Title;
	private String Description;
	private String PicUrl;
	private String Url;

	public WeChatRespNewsItem(String Title, String Description, String PicUrl, String Url) {
		this.Title = Title;
		this.Description = Description;
		this.PicUrl = PicUrl;
		this.Url = Url;
	}

	public WeChatRespNewsItem() {
	}

	public String getTitle() {
		return Title;
	}

	@XmlElement(name = "Title")
	@XmlJavaTypeAdapter(value = CDATAdapter.class)
	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	@XmlElement(name = "Description")
	@XmlJavaTypeAdapter(value = CDATAdapter.class)
	public void setDescription(String description) {
		Description = description;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	@XmlElement(name = "PicUrl")
	@XmlJavaTypeAdapter(value = CDATAdapter.class)
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
		return Url;
	}

	@XmlElement(name = "Url")
	@XmlJavaTypeAdapter(value = CDATAdapter.class)
	public void setUrl(String url) {
		Url = url;
	}
}