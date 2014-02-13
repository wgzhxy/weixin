package com.weixin.datacore.domain.weixin.vo;

import java.util.ArrayList;
import java.util.List;

public class WeixinMenuTreeNode {
	
	private long id;
	private String button;
	private String subButton;
	private String type;
	private String menuName;
	private String menuKey;
	private String url;
	private String state;
	private String parentId;
	private List<WeixinMenuTreeNode> children=new ArrayList<WeixinMenuTreeNode>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public List<WeixinMenuTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<WeixinMenuTreeNode> children) {
		this.children = children;
	}
}