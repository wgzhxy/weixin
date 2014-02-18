package com.weixin.webui.form;
public class WeixinFormHumanServicesForm implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3811899937459447517L;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getReplyContents() {
		return replyContents;
	}

	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}

	public String getQuestionContents() {
		return questionContents;
	}

	public void setQuestionContents(String questionContents) {
		this.questionContents = questionContents;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	public String getPlatformTag() {
		return platformTag;
	}

	public void setPlatformTag(String platformTag) {
		this.platformTag = platformTag;
	}
	private String id;
	private String userName;
	private String email;
	private String mobile;
	private String openId;
	private String replyContents;
	private String questionContents;
	private String questionType;
	private String state;
	private String updateTime;
	private String createTime;
	private String extend1;
	private String extend2;
	private String platformTag;

	public WeixinFormHumanServicesForm() {
	}
}