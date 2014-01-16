package com.weixin.datacore.domain.weixin.model;

import java.io.Serializable;

public class MerchantInfoForMobileVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1579995072958241978L;
	// company
	private Long id;
	private String companyName;
	private Double mapX;
	private Double mapY;
	private Integer state;
	private String address;
	private String linkTel;
	private String serviceTel;
	private Long areaId;
	private String remarks;
	// brand
	private Integer smsFlag;
	private Integer couFlag;
	private String signCode;
	private String mobileContent;
	private String summary;
	private Integer recommend;
	private Integer smsRecommend;
	private String appLogo;
	private String printAdd;
	private String rebate;
	private Integer praise;
	// other
	private String room;
	private Integer card;
	private String park;
	private String bus;
	private String wifi;
	//
	private double distance;
	private double standardx;
	private double standardy;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Double getMapX() {
		return mapX;
	}
	public void setMapX(Double mapX) {
		this.mapX = mapX;
	}
	public Double getMapY() {
		return mapY;
	}
	public void setMapY(Double mapY) {
		this.mapY = mapY;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLinkTel() {
		return linkTel;
	}
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
	public String getServiceTel() {
		return serviceTel;
	}
	public void setServiceTel(String serviceTel) {
		this.serviceTel = serviceTel;
	}
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getSmsFlag() {
		return smsFlag;
	}
	public void setSmsFlag(Integer smsFlag) {
		this.smsFlag = smsFlag;
	}
	public Integer getCouFlag() {
		return couFlag;
	}
	public void setCouFlag(Integer couFlag) {
		this.couFlag = couFlag;
	}
	public String getSignCode() {
		return signCode;
	}
	public void setSignCode(String signCode) {
		this.signCode = signCode;
	}
	public String getMobileContent() {
		return mobileContent;
	}
	public void setMobileContent(String mobileContent) {
		this.mobileContent = mobileContent;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Integer getRecommend() {
		return recommend;
	}
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	public Integer getSmsRecommend() {
		return smsRecommend;
	}
	public void setSmsRecommend(Integer smsRecommend) {
		this.smsRecommend = smsRecommend;
	}
	public String getAppLogo() {
		return appLogo;
	}
	public void setAppLogo(String appLogo) {
		this.appLogo = appLogo;
	}
	public String getPrintAdd() {
		return printAdd;
	}
	public void setPrintAdd(String printAdd) {
		this.printAdd = printAdd;
	}
	public String getRebate() {
		return rebate;
	}
	public void setRebate(String rebate) {
		this.rebate = rebate;
	}
	public Integer getPraise() {
		return praise;
	}
	public void setPraise(Integer praise) {
		this.praise = praise;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public Integer getCard() {
		return card;
	}
	public void setCard(Integer card) {
		this.card = card;
	}
	public String getPark() {
		return park;
	}
	public void setPark(String park) {
		this.park = park;
	}
	public String getBus() {
		return bus;
	}
	public void setBus(String bus) {
		this.bus = bus;
	}
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getStandardx() {
		return standardx;
	}
	public void setStandardx(double standardx) {
		this.standardx = standardx;
	}
	public double getStandardy() {
		return standardy;
	}
	public void setStandardy(double standardy) {
		this.standardy = standardy;
	}
	
	
}