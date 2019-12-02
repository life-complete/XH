package com.sybercare.hospital.health.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "saa_usergrade")
public class SaaUserGrade implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	// private SaaGrade saaGrade;
	private Integer gradeid;
	private String userCode;
	private Date invalidDate;
	private String creatorCode;
	private Date createTime;
	private String updaterCode;
	private Date updateTime;
	private String validStatus;

	public SaaUserGrade() {
	}

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "identity")
	@Column(name = "id")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "GradeId", nullable = false)
	// public SaaGrade getSaaGrade() {
	// return this.saaGrade;
	// }
	//
	// public void setSaaGrade(SaaGrade saaGrade) {
	// this.saaGrade = saaGrade;
	// }
	@Column(name = "gradeid")
	public Integer getGradeid() {
		return gradeid;
	}

	public void setGradeid(Integer gradeid) {
		this.gradeid = gradeid;
	}

	@Column(name = "UserCode")
	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "InvalidDate")
	public Date getInvalidDate() {
		return this.invalidDate;
	}

	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}

	@Column(name = "CreatorCode")
	public String getCreatorCode() {
		return this.creatorCode;
	}

	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CreateTime")
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "UpdaterCode")
	public String getUpdaterCode() {
		return this.updaterCode;
	}

	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UpdateTime")
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "ValidStatus")
	public String getValidStatus() {
		return this.validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

}
