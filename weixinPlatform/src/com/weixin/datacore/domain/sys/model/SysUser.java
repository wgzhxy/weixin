package com.weixin.datacore.domain.sys.model;
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
 * SysUser generated by hbm2java
 */
@Entity
@Table(name = "sys_user")
public class SysUser implements java.io.Serializable {

	private String id;
	private String userName;
	private String password;
	private String mobile;
	private String email;
	private String qq;
	private String msn;
	private String orgId;
	private String orgName;
	private String operatorId;
	private String operatorName;
	private Date updateTime;
	private Date createTime;
	private String extend1;
	private String extend2;
	private String platformTag;

	public SysUser() {
	}

	public SysUser(String id) {
		this.id = id;
	}

	public SysUser(String id, String userName, String password, String mobile,
			String email, String qq, String msn, String orgId, String orgName,
			String operatorId, String operatorName, Date updateTime,
			Date createTime, String extend1, String extend2, String platformTag) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
		this.qq = qq;
		this.msn = msn;
		this.orgId = orgId;
		this.orgName = orgName;
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

	@Column(name = "user_name", length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "mobile", length = 11)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "qq", length = 20)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "msn", length = 20)
	public String getMsn() {
		return this.msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	@Column(name = "org_id", length = 50)
	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	@Column(name = "org_name", length = 128)
	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
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
