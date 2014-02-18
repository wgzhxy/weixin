package com.weixin.datacore.domain.weixin.model;
// default package
// Generated 2014-1-22 16:24:37 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * WeixinCommand generated by hbm2java
 */
@Entity
@Table(name = "weixin_command")
public class WeixinCommand implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7676454102643938414L;
	private String id;
	private String cmd;
	private String contents;
	private String defaultContents;
	private String cmdType;
	private String createTimeStr;
	private String remark;
	private String operatorId;
	private String operatorName;
	private Date updateTime;
	private Date createTime;
	private String extend1;
	private String extend2;
	private String platformTag;

	public WeixinCommand() {
	}

	public WeixinCommand(String id) {
		this.id = id;
	}

	public WeixinCommand(String id, String cmd, String contents,
			String defaultContents, String cmdType, String createTimeStr,
			String remark, String operatorId, String operatorName,
			Date updateTime, Date createTime, String extend1, String extend2,
			String platformTag) {
		this.id = id;
		this.cmd = cmd;
		this.contents = contents;
		this.defaultContents = defaultContents;
		this.cmdType = cmdType;
		this.createTimeStr = createTimeStr;
		this.remark = remark;
		this.operatorId = operatorId;
		this.operatorName = operatorName;
		this.updateTime = updateTime;
		this.createTime = createTime;
		this.extend1 = extend1;
		this.extend2 = extend2;
		this.platformTag = platformTag;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "cmd", length = 50)
	public String getCmd() {
		return this.cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	@Column(name = "contents", length = 2000)
	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Column(name = "default_contents", length = 2000)
	public String getDefaultContents() {
		return this.defaultContents;
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	@Column(name = "cmd_type", length = 50)
	public String getCmdType() {
		return this.cmdType;
	}

	public void setCmdType(String cmdType) {
		this.cmdType = cmdType;
	}

	@Column(name = "create_time_str", length = 50)
	public String getCreateTimeStr() {
		return this.createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "operator_id", length = 50)
	public String getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	@Column(name = "operator_name", length = 128)
	public String getOperatorName() {
		return this.operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time", length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "extend1", length = 128)
	public String getExtend1() {
		return this.extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	@Column(name = "extend2", length = 128)
	public String getExtend2() {
		return this.extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	@Column(name = "platform_tag", length = 50)
	public String getPlatformTag() {
		return this.platformTag;
	}

	public void setPlatformTag(String platformTag) {
		this.platformTag = platformTag;
	}

}
