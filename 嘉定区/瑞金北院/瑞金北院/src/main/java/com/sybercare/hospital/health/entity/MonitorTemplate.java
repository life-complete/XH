package com.sybercare.hospital.health.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monitor_template")
public class MonitorTemplate implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String monitoreTemplateName;
	private String monitorSchemeContent;
	private String fpgFrequencyStatus="0";
	private String afterBreakfastFrequencyStatus="0";
	private String beforeLunchFrequencyStatus="0";
	private String afterLunchFrequencyStatus="0";
	private String beforeDinnerFrequencyStatus="0";
	private String afterDinnerFrequencyStatus="0";
	private String beforeSleepFrequencyStatus="0";
	private String duringNightFrequencyStatus="0";
	private String dawnFrequencyStatus="0";
	private String comCode;
	
	private String monitorTemplateType;	 //	模板类型  0：长期模板 1：临时模板
	private  Integer measureType;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "monitor_template_name")
	public String getMonitoreTemplateName() {
		return monitoreTemplateName;
	}
	public void setMonitoreTemplateName(String monitoreTemplateName) {
		this.monitoreTemplateName = monitoreTemplateName;
	}
	

	
	@Column(name = "monitor_scheme_content")
	public String getMonitorSchemeContent() {
		return monitorSchemeContent;
	}
	public void setMonitorSchemeContent(String monitorSchemeContent) {
		this.monitorSchemeContent = monitorSchemeContent;
	}
	@Column(name = "fpg_frequency_status")
	public String getFpgFrequencyStatus() {
		return fpgFrequencyStatus;
	}
	public void setFpgFrequencyStatus(String fpgFrequencyStatus) {
		this.fpgFrequencyStatus = fpgFrequencyStatus;
	}
	
	@Column(name = "after_breakfast_frequency_status")
	public String getAfterBreakfastFrequencyStatus() {
		return afterBreakfastFrequencyStatus;
	}
	public void setAfterBreakfastFrequencyStatus(
			String afterBreakfastFrequencyStatus) {
		this.afterBreakfastFrequencyStatus = afterBreakfastFrequencyStatus;
	}
	
	@Column(name = "before_lunch_frequency_status")
	public String getBeforeLunchFrequencyStatus() {
		return beforeLunchFrequencyStatus;
	}
	public void setBeforeLunchFrequencyStatus(String beforeLunchFrequencyStatus) {
		this.beforeLunchFrequencyStatus = beforeLunchFrequencyStatus;
	}
	
	@Column(name = "after_lunch_frequency_status")
	public String getAfterLunchFrequencyStatus() {
		return afterLunchFrequencyStatus;
	}
	public void setAfterLunchFrequencyStatus(String afterLunchFrequencyStatus) {
		this.afterLunchFrequencyStatus = afterLunchFrequencyStatus;
	}
	
	@Column(name = "before_dinner_frequency_status")
	public String getBeforeDinnerFrequencyStatus() {
		return beforeDinnerFrequencyStatus;
	}
	public void setBeforeDinnerFrequencyStatus(String beforeDinnerFrequencyStatus) {
		this.beforeDinnerFrequencyStatus = beforeDinnerFrequencyStatus;
	}
	
	@Column(name = "after_dinner_frequency_status")
	public String getAfterDinnerFrequencyStatus() {
		return afterDinnerFrequencyStatus;
	}
	public void setAfterDinnerFrequencyStatus(String afterDinnerFrequencyStatus) {
		this.afterDinnerFrequencyStatus = afterDinnerFrequencyStatus;
	}
	
	@Column(name = "before_sleep_frequency_status")
	public String getBeforeSleepFrequencyStatus() {
		return beforeSleepFrequencyStatus;
	}
	public void setBeforeSleepFrequencyStatus(String beforeSleepFrequencyStatus) {
		this.beforeSleepFrequencyStatus = beforeSleepFrequencyStatus;
	}
	
	@Column(name = "during_night_frequency_status")
	public String getDuringNightFrequencyStatus() {
		return duringNightFrequencyStatus;
	}
	public void setDuringNightFrequencyStatus(String duringNightFrequencyStatus) {
		this.duringNightFrequencyStatus = duringNightFrequencyStatus;
	}
	
	@Column(name = "comcode")
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	
	@Column(name = "monitor_template_type")
	public String getMonitorTemplateType() {
		return monitorTemplateType;
	}
	public void setMonitorTemplateType(String monitorTemplateType) {
		this.monitorTemplateType = monitorTemplateType;
	}
	
	@Column(name = "measure_type")
	public Integer getMeasureType() {
		return measureType;
	}
	public void setMeasureType(Integer measureType) {
		this.measureType = measureType;
	}
	
	@Column(name = "dawn_frequency_status")
	public String getDawnFrequencyStatus() {
		return dawnFrequencyStatus;
	}
	public void setDawnFrequencyStatus(String dawnFrequencyStatus) {
		this.dawnFrequencyStatus = dawnFrequencyStatus;
	}
}
