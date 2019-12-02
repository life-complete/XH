package com.sybercare.hospital.adapters.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class HisPrescriptionDiet {

	private BigDecimal prescriptionId;

	private Timestamp createDate;

	private String doctorId;

	private String doctorName;

	private String drugName;

	private BigDecimal patientId;

	private String drugDoseUnit;

	private String doseUnit;

	private String medicationFrequency;

	private String prescriptionNotes;

	private String supplyName;

	private String orderCode;

	private String drugNo;

	private String drugProductName;

	private String drugSpec;

	private Timestamp startTime;

	private Timestamp endTime;

	private BigDecimal orderFlag;

	private BigDecimal parentNo;

	private BigDecimal groupNo;

	private String parentName;

	private String remark;

	public BigDecimal getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(BigDecimal prescriptionId) {
		this.prescriptionId = prescriptionId;
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

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public BigDecimal getPatientId() {
		return patientId;
	}

	public void setPatientId(BigDecimal patientId) {
		this.patientId = patientId;
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

	public String getMedicationFrequency() {
		return medicationFrequency;
	}

	public void setMedicationFrequency(String medicationFrequency) {
		this.medicationFrequency = medicationFrequency;
	}

	public String getPrescriptionNotes() {
		return prescriptionNotes;
	}

	public void setPrescriptionNotes(String prescriptionNotes) {
		this.prescriptionNotes = prescriptionNotes;
	}

	public String getSupplyName() {
		return supplyName;
	}

	public void setSupplyName(String supplyName) {
		this.supplyName = supplyName;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getDrugNo() {
		return drugNo;
	}

	public void setDrugNo(String drugNo) {
		this.drugNo = drugNo;
	}

	public String getDrugProductName() {
		return drugProductName;
	}

	public void setDrugProductName(String drugProductName) {
		this.drugProductName = drugProductName;
	}

	public String getDrugSpec() {
		return drugSpec;
	}

	public void setDrugSpec(String drugSpec) {
		this.drugSpec = drugSpec;
	}

	public BigDecimal getOrderFlag() {
		return orderFlag;
	}

	public void setOrderFlag(BigDecimal orderFlag) {
		this.orderFlag = orderFlag;
	}

	public BigDecimal getParentNo() {
		return parentNo;
	}

	public void setParentNo(BigDecimal parentNo) {
		this.parentNo = parentNo;
	}

	public BigDecimal getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(BigDecimal groupNo) {
		this.groupNo = groupNo;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
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

}