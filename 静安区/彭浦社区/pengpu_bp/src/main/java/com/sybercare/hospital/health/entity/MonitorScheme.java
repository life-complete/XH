package com.sybercare.hospital.health.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sybercare.hospital.common.utils.DateUtils;

/**
 * MonitorScheme entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "monitor_scheme")
public class MonitorScheme implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long monitorSchemeId;
	private String monitorSchemeName;
	private String monitorSchemeContent;
	private String userId;
	private String personId;
	private String doctorId;
	private Date recordDate;
	private String stampTime=DateUtils.getCurrent(16);////时间戳;
	private Short monitorSchemeType;
	private Short status;
	private Date startDate;
	private Date endDate;
	private String Monday;
	private String Tuesday;
	private String Wednesday;
	private String Thursday;
	private String Friday;
	private String Saturday;
	private String Sunday;
	private String comcode;
	private String ext1;
	private String ext2;
	private String ext3;
	private Long monitorModelId;
	
	private String monitorSchemeRemark;   //医嘱备注
	
	private Integer measureType;   // 测量类型  0--血糖   1--血压

	/** default constructor */
	public MonitorScheme() {
	}

	/** full constructor */
	public MonitorScheme(String monitorSchemeName, String monitorSchemeContent,
			String userId, String personId, String doctorId, Date recordDate,
			String stampTime, Short monitorSchemeType, Short status,
			Date startDate, Date endDate, String Monday, String Tuesday, 
			String Wednesday, String Thursday, String Friday, String Saturday,
			String Sunday, String comcode, String ext1, String ext2, String ext3,
			Long monitorModelId) {
		this.monitorSchemeName = monitorSchemeName;
		this.monitorSchemeContent = monitorSchemeContent;
		this.userId = userId;
		this.personId = personId;
		this.doctorId = doctorId;
		this.recordDate = recordDate;
		this.stampTime = stampTime;
		this.monitorSchemeType = monitorSchemeType;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.Monday = Monday;
		this.Tuesday = Tuesday;
		this.Wednesday = Wednesday;
		this.Thursday = Thursday;
		this.Friday = Friday;
		this.Saturday = Saturday;
		this.Sunday = Sunday;
		this.comcode = comcode;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.monitorModelId = monitorModelId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "monitor_scheme_id", unique = true, nullable = false)
	public Long getMonitorSchemeId() {
		return this.monitorSchemeId;
	}

	public void setMonitorSchemeId(Long monitorSchemeId) {
		this.monitorSchemeId = monitorSchemeId;
	}

	@Column(name = "monitor_model_id")
	public Long getMonitorModelId() {
		return monitorModelId;
	}

	public void setMonitorModelId(Long monitorModelId) {
		this.monitorModelId = monitorModelId;
	}

	@Column(name = "monitor_scheme_name")
	public String getMonitorSchemeName() {
		return this.monitorSchemeName;
	}

	public void setMonitorSchemeName(String monitorSchemeName) {
		this.monitorSchemeName = monitorSchemeName;
	}

	@Column(name = "monitor_scheme_content")
	public String getMonitorSchemeContent() {
		return this.monitorSchemeContent;
	}

	public void setMonitorSchemeContent(String monitorSchemeContent) {
		this.monitorSchemeContent = monitorSchemeContent;
	}

	@Column(name = "user_id")
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "person_id")
	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	@Column(name = "doctor_id")
	public String getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "record_date")
	public Date getRecordDate() {
		return this.recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	@Column(name = "stamp_time")
	public String getStampTime() {
		return this.stampTime;
	}

	public void setStampTime(String stampTime) {
		this.stampTime = stampTime;
	}

	@Column(name = "monitor_scheme_type")
	public Short getMonitorSchemeType() {
		return this.monitorSchemeType;
	}

	public void setMonitorSchemeType(Short monitorSchemeType) {
		this.monitorSchemeType = monitorSchemeType;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	//@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	//@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "Monday")
	public String getMonday() {
		return Monday;
	}

	public void setMonday(String monday) {
		Monday = monday;
	}

	@Column(name = "Tuesday")
	public String getTuesday() {
		return Tuesday;
	}

	public void setTuesday(String tuesday) {
		Tuesday = tuesday;
	}

	@Column(name = "Wednesday")
	public String getWednesday() {
		return Wednesday;
	}

	public void setWednesday(String wednesday) {
		Wednesday = wednesday;
	}

	@Column(name = "Thursday")
	public String getThursday() {
		return Thursday;
	}

	public void setThursday(String thursday) {
		Thursday = thursday;
	}

	@Column(name = "Friday")
	public String getFriday() {
		return Friday;
	}

	public void setFriday(String friday) {
		Friday = friday;
	}

	@Column(name = "Saturday")
	public String getSaturday() {
		return Saturday;
	}

	public void setSaturday(String saturday) {
		Saturday = saturday;
	}

	@Column(name = "Sunday")
	public String getSunday() {
		return Sunday;
	}

	public void setSunday(String sunday) {
		Sunday = sunday;
	}

	@Column(name = "comcode")
	public String getComcode() {
		return this.comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	@Column(name = "ext1")
	public String getExt1() {
		return this.ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	@Column(name = "ext2")
	public String getExt2() {
		return this.ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	@Column(name = "ext3")
	public String getExt3() {
		return this.ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	@Column(name = "monitor_scheme_remark")
	public String getMonitorSchemeRemark() {
		return monitorSchemeRemark;
	}

	public void setMonitorSchemeRemark(String monitorSchemeRemark) {
		this.monitorSchemeRemark = monitorSchemeRemark;
	}

	@Column(name = "measure_type")
	public Integer getMeasureType() {
		return measureType;
	}

	public void setMeasureType(Integer measureType) {
		this.measureType = measureType;
	}

}
