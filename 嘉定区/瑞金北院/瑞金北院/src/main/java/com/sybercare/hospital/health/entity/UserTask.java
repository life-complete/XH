package com.sybercare.hospital.health.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "user_task")
public class UserTask implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String userId;
	private String createDate;  // 任务创建时间	
	private String status;      // 任务状态  0-未完成   1-已完成
	private String taskDescription;  // 任务描述
	
	private String taskTimeCode;  // 任务时段编号
	
	private Integer monitorSchemeId; //监测方案Id
	
	private String monitorName;   //监测方案名称
	
	private Integer monitorType;  //监测方案类型
	
	private Integer measureType; //测量类型  0--血糖   1--血压   2--体温
	
	@GenericGenerator(name = "generator", strategy = "identity")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "user_id")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name = "create_date")
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "task_description")
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	@Column(name = "task_time_code")
	public String getTaskTimeCode() {
		return taskTimeCode;
	}
	public void setTaskTimeCode(String taskTimeCode) {
		this.taskTimeCode = taskTimeCode;
	}
	
	@Column(name = "monitor_scheme_id")
	public Integer getMonitorSchemeId() {
		return monitorSchemeId;
	}
	public void setMonitorSchemeId(Integer monitorSchemeId) {
		this.monitorSchemeId = monitorSchemeId;
	}
	
	@Column(name = "monitor_name")
	public String getMonitorName() {
		return monitorName;
	}
	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}
	
	@Column(name = "monitor_type")
	public Integer getMonitorType() {
		return monitorType;
	}
	public void setMonitorType(Integer monitorType) {
		this.monitorType = monitorType;
	}
	
	@Column(name = "measure_type")
	public Integer getMeasureType() {
		return measureType;
	}
	public void setMeasureType(Integer measureType) {
		this.measureType = measureType;
	}
	
}
