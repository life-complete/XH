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

/**
 * 功能：岗位表
 * 
 * @author 任梁荣
 */
@Entity
@Table(name = "saa_grade")
public class SaaGrade implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String gradeCName;
	private String gradeTName;
	private String gradeEName;
	private String commonGrade;
	private String comCode;
	private String creatorCode;
	private Date createTime;
	private String updaterCode;
	private Date updateTime;
	private String validStatus;
	private String systemTypeName;

	private String gradeCode;

	public SaaGrade() {
	}

	@Id
	@Column(name = "Id")
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "identity")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "GradeCName")
	public String getGradeCName() {
		return this.gradeCName;
	}

	public void setGradeCName(String gradeCName) {
		this.gradeCName = gradeCName;
	}

	@Column(name = "GradeTName")
	public String getGradeTName() {
		return this.gradeTName;
	}

	public void setGradeTName(String gradeTName) {
		this.gradeTName = gradeTName;
	}

	@Column(name = "GradeEName")
	public String getGradeEName() {
		return this.gradeEName;
	}

	public void setGradeEName(String gradeEName) {
		this.gradeEName = gradeEName;
	}

	@Column(name = "CommonGrade")
	public String getCommonGrade() {
		return this.commonGrade;
	}

	public void setCommonGrade(String commonGrade) {
		this.commonGrade = commonGrade;
	}

	@Column(name = "ComCode")
	public String getComCode() {
		return this.comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
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

	@Column(name = "SystemTypeName")
	public String getSystemTypeName() {
		return systemTypeName;
	}

	public void setSystemTypeName(String systemTypeName) {
		this.systemTypeName = systemTypeName;
	}

	@Column(name = "GradeCode")
	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
}
