package com.weixin.datacore.domain.busi.model;
// default package
// Generated 2014-2-14 14:54:51 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BusiTjMember generated by hbm2java
 */
@Entity
@Table(name = "busi_tj_member")
public class BusiTjMember implements java.io.Serializable {

	private String id;
	private String name;
	private String idCardNo;
	private String mobile;
	private Integer sex;
	private String province;
	private String city;
	private String region;
	private String refereeName;
	private String refereeIdCardNo;
	private String remark;
	private Date upateTime;
	private Date createTime;
	private String extend1;
	private String extend2;
	private String platformTag;

	public BusiTjMember() {
	}

	public BusiTjMember(String id) {
		this.id = id;
	}

	public BusiTjMember(String id, String name, String idCardNo, String mobile,
			Integer sex, String province, String city, String region,
			String refereeName, String refereeIdCardNo, String remark,
			Date upateTime, Date createTime, String extend1, String extend2,
			String platformTag) {
		this.id = id;
		this.name = name;
		this.idCardNo = idCardNo;
		this.mobile = mobile;
		this.sex = sex;
		this.province = province;
		this.city = city;
		this.region = region;
		this.refereeName = refereeName;
		this.refereeIdCardNo = refereeIdCardNo;
		this.remark = remark;
		this.upateTime = upateTime;
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

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "id_cardNo", length = 20)
	public String getIdCardNo() {
		return this.idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	@Column(name = "mobile", length = 20)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "sex")
	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Column(name = "province", length = 50)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 50)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "region", length = 50)
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "referee_name", length = 50)
	public String getRefereeName() {
		return this.refereeName;
	}

	public void setRefereeName(String refereeName) {
		this.refereeName = refereeName;
	}

	@Column(name = "referee_id_cardNo", length = 20)
	public String getRefereeIdCardNo() {
		return this.refereeIdCardNo;
	}

	public void setRefereeIdCardNo(String refereeIdCardNo) {
		this.refereeIdCardNo = refereeIdCardNo;
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "upate_time", length = 19)
	public Date getUpateTime() {
		return this.upateTime;
	}

	public void setUpateTime(Date upateTime) {
		this.upateTime = upateTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "extend1", length = 50)
	public String getExtend1() {
		return this.extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	@Column(name = "extend2", length = 50)
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
