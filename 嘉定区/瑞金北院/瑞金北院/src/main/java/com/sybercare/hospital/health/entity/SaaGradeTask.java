package com.sybercare.hospital.health.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 功能：岗位权限表
 * 
 * @author 任梁荣
 * */
@Entity
@Table(name = "saa_gradetask")
public class SaaGradeTask implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private SaaTask saaTask;
	private SaaGrade saaGrade;
	private String intranetValue;
	private String internetValue;

	public SaaGradeTask() {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TaskID", nullable = false)
	public SaaTask getSaaTask() {
		return this.saaTask;
	}

	public void setSaaTask(SaaTask saaTask) {
		this.saaTask = saaTask;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GradeID", nullable = false)
	public SaaGrade getSaaGrade() {
		return this.saaGrade;
	}

	public void setSaaGrade(SaaGrade saaGrade) {
		this.saaGrade = saaGrade;
	}

	@Column(name = "IntranetValue")
	public String getIntranetValue() {
		return this.intranetValue;
	}

	public void setIntranetValue(String intranetValue) {
		this.intranetValue = intranetValue;
	}

	@Column(name = "InternetValue")
	public String getInternetValue() {
		return this.internetValue;
	}

	public void setInternetValue(String internetValue) {
		this.internetValue = internetValue;
	}

}
