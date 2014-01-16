package com.weixin.datacore.domain.weixin.model;

public class EcdCoupon {
	private Long id;
	private String title;
	private String appphoto;
	private String printyxdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAppphoto() {
		return appphoto;
	}

	public void setAppphoto(String appphoto) {
		this.appphoto = appphoto;
	}

	public String getPrintyxdate() {
		return printyxdate;
	}

	public void setPrintyxdate(String printyxdate) {
		this.printyxdate = printyxdate;
	}
}