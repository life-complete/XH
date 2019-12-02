package com.sybercare.hospital.adapters.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 功能：血糖数据表
 * 
 * @author 任梁荣
 */
public class DataBloodGlucose implements Serializable {

	private static final long serialVersionUID = 3402730842423989220L;
	/** 序号id */
	private Long id;
	/** 测量值 */
	private String value;
	/** 测量时段 */
	private String status;
	/** 测量时间 */
	private Date measureTime;
	/** 病人ID */
	private String patientId;
	/** 卡号 */
	private String cardNumber;
	/** 测量人ID */
	private String opratorId;

	/** 备注 */
	private String remark;

	/** 最后跟新时间 */
	private Date lastUpdateTime;
	/** 操作状态 (0：未操作 1：已操作) */
	private Integer opratorState;
	/** 操作类型 (1：增加 2：修改 3：删除) */
	private Integer opratorType;

	private String department;

	public Integer getOpratorState() {
		return opratorState;
	}

	public void setOpratorState(Integer opratorState) {
		this.opratorState = opratorState;
	}

	public Integer getOpratorType() {
		return opratorType;
	}

	public void setOpratorType(Integer opratorType) {
		this.opratorType = opratorType;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getOpratorId() {
		return opratorId;
	}

	public void setOpratorId(String opratorId) {
		this.opratorId = opratorId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getMeasureTime() {
		return measureTime;
	}

	public void setMeasureTime(Date measureTime) {
		this.measureTime = measureTime;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "id：" + id + "\n value:" + value + "\n status:" + status + "\n measureTime:" + measureTime
				+ "\n patienId:" + patientId + "\n cardNumber:" + cardNumber + "\n opratorId:" + opratorId
				+ "\n opratorType:" + opratorType + "\n opratorState:" + opratorState + "\n lastUpdateTime:"
				+ lastUpdateTime + "\n remark:" + remark;
	}
}
