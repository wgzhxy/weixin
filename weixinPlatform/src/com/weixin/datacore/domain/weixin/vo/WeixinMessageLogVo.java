package com.weixin.datacore.domain.weixin.vo;

import java.util.Date;

public class WeixinMessageLogVo {

	private long msgId;
	private String toUserName;
	private String fromUserName;
	private Date createTime;
	private Integer msgType;
	private String content;
	private String picUrl;
	private String mediaId;
	private String format;
	private String thumbMediaId;
	private Float locationX;
	private Float locationY;
	private Float scale;
	private String label;
	private String title;
	private String description;
	private String url;
	private String msgClass;
	private String platformTag;

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public Float getLocationX() {
		return locationX;
	}

	public void setLocationX(Float locationX) {
		this.locationX = locationX;
	}

	public Float getLocationY() {
		return locationY;
	}

	public void setLocationY(Float locationY) {
		this.locationY = locationY;
	}

	public Float getScale() {
		return scale;
	}

	public void setScale(Float scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMsgClass() {
		return msgClass;
	}

	public void setMsgClass(String msgClass) {
		this.msgClass = msgClass;
	}

	public String getPlatformTag() {
		return platformTag;
	}

	public void setPlatformTag(String platformTag) {
		this.platformTag = platformTag;
	}

}
