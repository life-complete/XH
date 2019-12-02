package com.sybercare.hospital.health.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monitor_model")
public class MonitorModel {
	
	private static final long serialVersionUID = 1L;
	
	private Long monitorModelId;
	
	private String fpgFrequencyStatus;        //血糖表示空腹，血压无
	
	private String fpgFrequency;
	
	private String afterBreakfastFrequencyStatus;   //血糖表示早餐后，血压上午
	
	private String afterBreakfastFrequency;
	
	private String beforeLunchFrequencyStatus;		//血糖表示午餐前，血压无
	
	private String beforeLunchFrequency;
	
	private String afterLunchFrequencyStatus;		//血糖表示午餐后，血压下午
	
	private String afterLunchFrequency;
	
	private String beforeDinnerFrequencyStatus;		//血糖表示晚餐前，血压无
	
	private String beforeDinnerFrequency;
	
	private String afterDinnerFrequencyStatus;		//血糖表示晚餐后，血压晚上
	
	private String afterDinnerFrequency;
	
	private String beforeSleepFrequencyStatus;		//血糖表示睡前，血压睡前
	
	private String beforeSleepFrequency;
	
	private String duringNightFrequencyStatus;		//血糖表示凌晨，血压凌晨
	
	private String duringNightFrequency;
	
	private String dawnFrequencyStatus;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = IDENTITY)
	public Long getMonitorModelId() {
		return monitorModelId;
	}

	public void setMonitorModelId(Long monitorModelId) {
		this.monitorModelId = monitorModelId;
	}

	@Column(name = "fpg_frequency_status")
	public String getFpgFrequencyStatus() {
		return fpgFrequencyStatus;
	}

	public void setFpgFrequencyStatus(String fpgFrequencyStatus) {
		this.fpgFrequencyStatus = fpgFrequencyStatus;
	}

	@Column(name = "fpg_frequency")
	public String getFpgFrequency() {
		return fpgFrequency;
	}

	public void setFpgFrequency(String fpgFrequency) {
		this.fpgFrequency = fpgFrequency;
	}

	@Column(name = "after_breakfast_frequency_status")
	public String getAfterBreakfastFrequencyStatus() {
		return afterBreakfastFrequencyStatus;
	}

	public void setAfterBreakfastFrequencyStatus(
			String afterBreakfastFrequencyStatus) {
		this.afterBreakfastFrequencyStatus = afterBreakfastFrequencyStatus;
	}

	@Column(name = "after_breakfast_frequency")
	public String getAfterBreakfastFrequency() {
		return afterBreakfastFrequency;
	}

	public void setAfterBreakfastFrequency(String afterBreakfastFrequency) {
		this.afterBreakfastFrequency = afterBreakfastFrequency;
	}

	@Column(name = "before_lunch_frequency_status")
	public String getBeforeLunchFrequencyStatus() {
		return beforeLunchFrequencyStatus;
	}

	public void setBeforeLunchFrequencyStatus(String beforeLunchFrequencyStatus) {
		this.beforeLunchFrequencyStatus = beforeLunchFrequencyStatus;
	}

	@Column(name = "before_lunch_frequency")
	public String getBeforeLunchFrequency() {
		return beforeLunchFrequency;
	}

	public void setBeforeLunchFrequency(String beforeLunchFrequency) {
		this.beforeLunchFrequency = beforeLunchFrequency;
	}

	@Column(name = "after_lunch_frequency")
	public String getAfterLunchFrequency() {
		return afterLunchFrequency;
	}

	public void setAfterLunchFrequency(String afterLunchFrequency) {
		this.afterLunchFrequency = afterLunchFrequency;
	}

	@Column(name = "before_dinner_frequency_status")
	public String getBeforeDinnerFrequencyStatus() {
		return beforeDinnerFrequencyStatus;
	}

	public void setBeforeDinnerFrequencyStatus(String beforeDinnerFrequencyStatus) {
		this.beforeDinnerFrequencyStatus = beforeDinnerFrequencyStatus;
	}

	@Column(name = "before_dinner_frequency")
	public String getBeforeDinnerFrequency() {
		return beforeDinnerFrequency;
	}

	public void setBeforeDinnerFrequency(String beforeDinnerFrequency) {
		this.beforeDinnerFrequency = beforeDinnerFrequency;
	}

	@Column(name = "after_dinner_frequency_status")
	public String getAfterDinnerFrequencyStatus() {
		return afterDinnerFrequencyStatus;
	}

	public void setAfterDinnerFrequencyStatus(String afterDinnerFrequencyStatus) {
		this.afterDinnerFrequencyStatus = afterDinnerFrequencyStatus;
	}

	@Column(name = "after_dinner_frequency")
	public String getAfterDinnerFrequency() {
		return afterDinnerFrequency;
	}

	public void setAfterDinnerFrequency(String afterDinnerFrequency) {
		this.afterDinnerFrequency = afterDinnerFrequency;
	}

	@Column(name = "before_sleep_frequency_status")
	public String getBeforeSleepFrequencyStatus() {
		return beforeSleepFrequencyStatus;
	}

	public void setBeforeSleepFrequencyStatus(String beforeSleepFrequencyStatus) {
		this.beforeSleepFrequencyStatus = beforeSleepFrequencyStatus;
	}

	@Column(name = "before_sleep_frequency")
	public String getBeforeSleepFrequency() {
		return beforeSleepFrequency;
	}

	public void setBeforeSleepFrequency(String beforeSleepFrequency) {
		this.beforeSleepFrequency = beforeSleepFrequency;
	}

	@Column(name = "during_night_frequency_status")
	public String getDuringNightFrequencyStatus() {
		return duringNightFrequencyStatus;
	}

	public void setDuringNightFrequencyStatus(String duringNightFrequencyStatus) {
		this.duringNightFrequencyStatus = duringNightFrequencyStatus;
	}

	@Column(name = "during_night_frequency")
	public String getDuringNightFrequency() {
		return duringNightFrequency;
	}

	public void setDuringNightFrequency(String duringNightFrequency) {
		this.duringNightFrequency = duringNightFrequency;
	}

	@Column(name = "after_lunch_frequency_status")
	public String getAfterLunchFrequencyStatus() {
		return afterLunchFrequencyStatus;
	}

	public void setAfterLunchFrequencyStatus(String afterLunchFrequencyStatus) {
		this.afterLunchFrequencyStatus = afterLunchFrequencyStatus;
	}

	@Column(name = "dawn_frequency_status")
	public String getDawnFrequencyStatus() {
		return dawnFrequencyStatus;
	}

	public void setDawnFrequencyStatus(String dawnFrequencyStatus) {
		this.dawnFrequencyStatus = dawnFrequencyStatus;
	}
	
}
