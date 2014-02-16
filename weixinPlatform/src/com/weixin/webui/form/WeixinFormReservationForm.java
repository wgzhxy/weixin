package com.weixin.webui.form;
public class WeixinFormReservationForm implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3811899937459447517L;
	private String id;
	private String userName;
	private String nick;
	private String mobile;
	private String city;
	private String state;
	private String reservationStartTime;
	private String reservationEndTime;
	private String updateTime;
	private String createTime;
	private String extend1;
	private String extend2;
	private String platformTag;
	private String sex;
	private String isInitiative;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIsInitiative() {
		return isInitiative;
	}

	public void setIsInitiative(String isInitiative) {
		this.isInitiative = isInitiative;
	}

	public WeixinFormReservationForm() {
	}

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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReservationStartTime() {
		return reservationStartTime;
	}

	public void setReservationStartTime(String reservationStartTime) {
		this.reservationStartTime = reservationStartTime;
	}

	public String getReservationEndTime() {
		return reservationEndTime;
	}

	public void setReservationEndTime(String reservationEndTime) {
		this.reservationEndTime = reservationEndTime;
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
}