package com.sybercare.hospital.health.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 体重BMI数据表 sys_patient_bmi
 * 
 * @author hesicare
 * @date 2019-08-19
 */
public class SysPatientBmi extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键id */
	private Long id;
	/** 患者id */
	private Long patientId;
	/** 身高(m) */
	private String high;
	/** 体重(kg) */
	private String weight;
	/** bmi */
	private String bmi;
	/** 身体状况 偏瘦 正常 过重 肥胖 */
	private String bmiResult;
	
	private Date startDate;
	private Date endDate;
	
	private String patientName;
	private String loginName;
	private Date measureTime;

	public Date getMeasureTime() {
		return measureTime;
	}

	public void setMeasureTime(Date measureTime) {
		this.measureTime = measureTime;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setPatientId(Long patientId) 
	{
		this.patientId = patientId;
	}

	public Long getPatientId() 
	{
		return patientId;
	}
	public void setHigh(String high) 
	{
		this.high = high;
	}

	public String getHigh() 
	{
		return high;
	}
	public void setWeight(String weight) 
	{
		this.weight = weight;
	}

	public String getWeight() 
	{
		return weight;
	}
	public void setBmi(String bmi) 
	{
		this.bmi = bmi;
	}

	public String getBmi() 
	{
		return bmi;
	}
	public void setBmiResult(String bmiResult) 
	{
		this.bmiResult = bmiResult;
	}

	public String getBmiResult() 
	{
		return bmiResult;
	}

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("patientId", getPatientId())
            .append("high", getHigh())
            .append("weight", getWeight())
            .append("bmi", getBmi())
            .append("bmiResult", getBmiResult())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
