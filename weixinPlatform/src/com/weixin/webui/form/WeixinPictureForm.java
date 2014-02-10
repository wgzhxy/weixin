package com.weixin.webui.form;


public class WeixinPictureForm {
		private String id;
		private String pictureName;
		private String state;
		private String createTime;
		private String modifyTime;
		
		public WeixinPictureForm(){}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPictureName() {
			return pictureName;
		}


		public void setPictureName(String pictureName) {
			this.pictureName = pictureName;
		}


		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}


		public String getCreateTime() {
			return createTime;
		}


		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}


		public String getModifyTime() {
			return modifyTime;
		}

		public void setModifyTime(String modifyTime) {
			this.modifyTime = modifyTime;
		}
}