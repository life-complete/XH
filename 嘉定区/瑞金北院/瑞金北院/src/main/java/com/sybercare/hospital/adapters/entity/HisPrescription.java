package com.sybercare.hospital.adapters.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 功能：用药医嘱信息视图
 * 
 * @author wangzhi
 */
public class HisPrescription implements Serializable {

	private static final long serialVersionUID = 1952749471575005055L;
	/** 医嘱ID */
	private BigDecimal prescriptionId;
	/** 病人ID */
	private BigDecimal patientId;
	/** 住院号 */
	private String cardNumber;
	/** 创建时间 */
	private Timestamp createDate;
	/** 药品名称 */
	private String drugName;
	/** 药品规格 */
	private String drugSpec;
	/** 商品名称 */
	private String drugProductName;
	/** 服用剂量 */
	private String drugDoseUnit;
	/** 剂量单位 */
	private String doseUnit;
	/** 给药方式 */
	private String supplyName;
	/** 服药频次 */
	private String frequency;
	/** 服药备注 */
	private String prescriptionNotes;
	/** 医嘱开始日期 */
	private Timestamp startTime;
	/** 医嘱结束日期 */
	private Timestamp endTime;
	/** 医嘱医生ID */
	private String doctorId;
	/** 医嘱医生姓名 */
	private String doctorName;
	/** 药品序号 */
	private String drugNo;
	/** 服药时段 */
	private String drugTimeSchedule;
	/** 医嘱项目代码 */
	private BigDecimal prescriptionNo;
	/** 医嘱类型 */
	private String prescriptionType;
	/** 备注 */
	private String remark;

	public BigDecimal getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(BigDecimal prescriptionId) {
		this.prescriptionId = prescriptionId;
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

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getDrugSpec() {
		return drugSpec;
	}

	public void setDrugSpec(String drugSpec) {
		this.drugSpec = drugSpec;
	}

	public String getDrugProductName() {
		return drugProductName;
	}

	public void setDrugProductName(String drugProductName) {
		this.drugProductName = drugProductName;
	}

	public String getDrugDoseUnit() {
		return drugDoseUnit;
	}

	public void setDrugDoseUnit(String drugDoseUnit) {
		this.drugDoseUnit = drugDoseUnit;
	}

	public String getDoseUnit() {
		return doseUnit;
	}

	public void setDoseUnit(String doseUnit) {
		this.doseUnit = doseUnit;
	}

	public String getSupplyName() {
		return supplyName;
	}

	public void setSupplyName(String supplyName) {
		this.supplyName = supplyName;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getPrescriptionNotes() {
		return prescriptionNotes;
	}

	public void setPrescriptionNotes(String prescriptionNotes) {
		this.prescriptionNotes = prescriptionNotes;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDrugNo() {
		return drugNo;
	}

	public void setDrugNo(String drugNo) {
		this.drugNo = drugNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDrugTimeSchedule() {
		return drugTimeSchedule;
	}

	public void setDrugTimeSchedule(String drugTimeSchedule) {
		this.drugTimeSchedule = drugTimeSchedule;
	}

	public BigDecimal getPrescriptionNo() {
		return prescriptionNo;
	}

	public void setPrescriptionNo(BigDecimal prescriptionNo) {
		this.prescriptionNo = prescriptionNo;
	}

	public String getPrescriptionType() {
		return prescriptionType;
	}

	public void setPrescriptionType(String prescriptionType) {
		this.prescriptionType = prescriptionType;
	}

}