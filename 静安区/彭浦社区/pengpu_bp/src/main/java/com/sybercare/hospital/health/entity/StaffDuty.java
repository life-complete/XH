package com.sybercare.hospital.health.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 功能：员工职责表
 * 
 * @author 任梁荣
 * */
@Entity
@Table(name = "staff_duty")
public class StaffDuty implements java.io.Serializable {

	private static final long serialVersionUID = 3619836065166773932L;

	private Integer staffDutyId;
	private String personid;
	private Integer jobDutyId;
	private Short status;
	private Timestamp createTime;

	public StaffDuty() {
	}

	public StaffDuty(String personid, Integer jobDutyId, Timestamp createTime) {
		this.personid = personid;
		this.jobDutyId = jobDutyId;
		this.createTime = createTime;
	}

	public StaffDuty(String personid, Integer jobDutyId, Short status, Timestamp createTime) {
		this.personid = personid;
		this.jobDutyId = jobDutyId;
		this.status = status;
		this.createTime = createTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "staff_duty_id", unique = true, nullable = false)
	public Integer getStaffDutyId() {
		return this.staffDutyId;
	}

	public void setStaffDutyId(Integer staffDutyId) {
		this.staffDutyId = staffDutyId;
	}

	@Column(name = "personid")
	public String getPersonid() {
		return this.personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	@Column(name = "job_duty_id")
	public Integer getJobDutyId() {
		return this.jobDutyId;
	}

	public void setJobDutyId(Integer jobDutyId) {
		this.jobDutyId = jobDutyId;
	}

	@Column(name = "STATUS")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "create_time")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
