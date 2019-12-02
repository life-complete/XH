package com.sybercare.hospital.health.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * 功能：权限定义表
 * 
 * @author 任梁荣
 * */
@Entity
@Table(name = "saa_task")
public class SaaTask implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String taskCode;
	private String parentCode;
	private String taskCName;
	private String taskTName;
	private String taskEName;
	private String creatorCode;
	private Date createTime;
	private String updaterCode;
	private Date updateTime;
	private String validStatus;
	private List<SaaGradeTask> saaGradeTasks = new ArrayList<SaaGradeTask>(0);
	private List<SaaAuthTask> saaAuthTasks = new ArrayList<SaaAuthTask>(0);

	public SaaTask() {
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

	@Column(name = "TaskCode")
	public String getTaskCode() {
		return this.taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	@Column(name = "ParentCode")
	public String getParentCode() {
		return this.parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	@Column(name = "TaskCName")
	public String getTaskCName() {
		return this.taskCName;
	}

	public void setTaskCName(String taskCName) {
		this.taskCName = taskCName;
	}

	@Column(name = "TaskTName")
	public String getTaskTName() {
		return this.taskTName;
	}

	public void setTaskTName(String taskTName) {
		this.taskTName = taskTName;
	}

	@Column(name = "TaskEName")
	public String getTaskEName() {
		return this.taskEName;
	}

	public void setTaskEName(String taskEName) {
		this.taskEName = taskEName;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saaTask")
	public List<SaaGradeTask> getSaaGradeTasks() {
		return this.saaGradeTasks;
	}

	public void setSaaGradeTasks(List<SaaGradeTask> saaGradeTasks) {
		this.saaGradeTasks = saaGradeTasks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saaTask")
	public List<SaaAuthTask> getSaaAuthTasks() {
		return this.saaAuthTasks;
	}

	public void setSaaAuthTasks(List<SaaAuthTask> saaAuthTasks) {
		this.saaAuthTasks = saaAuthTasks;
	}

	public boolean equals(Object o) {
		SaaTask s = (SaaTask) o;
		if (o == null) {
			return false;
		}
		if (this.getTaskCode().equals(s.getTaskCode())) {
			return true;
		} else {
			return false;
		}
	}

}
