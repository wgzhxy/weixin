package com.weixin.datacore.domain.weixin.model;
/**
 * EcdArticle entity. @author MyEclipse Persistence Tools
 */
public class EcdArticle implements java.io.Serializable {
	public EcdArticle(){}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getCouponid() {
		return couponid;
	}
	public void setCouponid(String couponid) {
		this.couponid = couponid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getCompanyid() {
		return companyid;
	}
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	// Fields
	private static final long serialVersionUID = 1L;
	private String id;
	private String contents;
	private String couponid;
	private String title;
	private String photo;
	private String companyid;
}