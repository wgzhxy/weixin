package com.weixin.datacore.domain.weixin.vo;

import java.util.Date;

public class WeixinPageInfoVo {

	private String id;
	private String pageName;
	private String pageClass;
	private String pageClassName;
	private String pageTitle;
	private String pageSubtitle;
	private String content;
	private String associateLinks;
	private Integer displayNum;
	private String platformTag;
	private String operator;
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageClass() {
		return pageClass;
	}

	public void setPageClass(String pageClass) {
		this.pageClass = pageClass;
	}

	public String getPageClassName() {
		return pageClassName;
	}

	public void setPageClassName(String pageClassName) {
		this.pageClassName = pageClassName;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageSubtitle() {
		return pageSubtitle;
	}

	public void setPageSubtitle(String pageSubtitle) {
		this.pageSubtitle = pageSubtitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAssociateLinks() {
		return associateLinks;
	}

	public void setAssociateLinks(String associateLinks) {
		this.associateLinks = associateLinks;
	}

	public Integer getDisplayNum() {
		return displayNum;
	}

	public void setDisplayNum(Integer displayNum) {
		this.displayNum = displayNum;
	}

	public String getPlatformTag() {
		return platformTag;
	}

	public void setPlatformTag(String platformTag) {
		this.platformTag = platformTag;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
