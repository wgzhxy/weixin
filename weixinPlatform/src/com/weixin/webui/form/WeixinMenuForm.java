package com.weixin.webui.form;

public class WeixinMenuForm implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuKey() {
		return menuKey;
	}

	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}

	public String getSubButton() {
		return subButton;
	}

	public void setSubButton(String subButton) {
		this.subButton = subButton;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String state;
	private String parentId;
	private String id;
	private String button;
	private String subButton;
	private String type;
	private String menuName;
	private String menuKey;
	private String url;

	public WeixinMenuForm() {
	}
}