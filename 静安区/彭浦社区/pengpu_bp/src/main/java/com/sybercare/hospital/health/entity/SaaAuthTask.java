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


@Entity
@Table(name = "saa_authtask")
public class SaaAuthTask implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private SaaTask saaTask;
	private String userCode;

	public SaaAuthTask() {
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

	@Column(name = "UserCode")
	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
