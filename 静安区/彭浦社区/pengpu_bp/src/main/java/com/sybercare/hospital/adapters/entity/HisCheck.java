package com.sybercare.hospital.adapters.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 功能：院内检查信息视图
 * 
 * @author 任梁荣
 * */
public class HisCheck implements Serializable {

	private static final long serialVersionUID = -4188677335655214656L;
	/** 序号ID */
	private BigDecimal id;
	/** 病人ID */
	private BigDecimal patientId;
	/** 住院号 */
	private String cardNumber;
	/** 检查项ID */
	private String checkId;
	/** 样本ID */
	private String sampleNo;
	/** 检查项目英文名 */
	private String englishHab;
	/** 检查项目中文名 */
	private String chineseHab;
	/** 检查结果值 */
	private Double checkResult;
	/** 结果标示(偏高或偏低) */
	private String resultFlag;
	/** 单位 */
	private String unit;
	/** 取样类型 */
	private String sampleType;
	/** 参考低限 */
	private String refLo;
	/** 参考高限 */
	private String refHi;
	/** 检查项测量时间 */
	private Timestamp measureTime;
	/** 监测时间 */
	private Timestamp checkTime;
	/** 操作人 */
	private String operator;
	/** 检查备注 */
	private String operatorNotes;
	/** 备注 */
	private String remark;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getPatientId() {
		return patientId;
	}

	public void setPatientId(BigDecimal patientId) {
		this.patientId = patientId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public Timestamp getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}

	public String getEnglishHab() {
		return englishHab;
	}

	public void setEnglishHab(String englishHab) {
		this.englishHab = englishHab;
	}

	public String getChineseHab() {
		return chineseHab;
	}

	public void setChineseHab(String chineseHab) {
		this.chineseHab = chineseHab;
	}

	public Double getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(Double checkResult) {
		this.checkResult = checkResult;
	}

	public String getResultFlag() {
		return resultFlag;
	}

	public void setResultFlag(String resultFlag) {
		this.resultFlag = resultFlag;
	}

	public String getSampleNo() {
		return sampleNo;
	}

	public void setSampleNo(String sampleNo) {
		this.sampleNo = sampleNo;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSampleType() {
		return sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}

	public String getRefLo() {
		return refLo;
	}

	public void setRefLo(String refLo) {
		this.refLo = refLo;
	}

	public String getRefHi() {
		return refHi;
	}

	public void setRefHi(String refHi) {
		this.refHi = refHi;
	}

	public Timestamp getMeasureTime() {
		return measureTime;
	}

	public void setMeasureTime(Timestamp measureTime) {
		this.measureTime = measureTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperatorNotes() {
		return operatorNotes;
	}

	public void setOperatorNotes(String operatorNotes) {
		this.operatorNotes = operatorNotes;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
