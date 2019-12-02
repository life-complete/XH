package com.sybercare.hospital.health.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "prescription_other")
public class PrescriptionOther implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String prescriptionId;
	private String drugClass;
	private String drugName;
	private String drugProductName;
	private String drugDoseUnit;
	private String unit;
	private String drugTimeSchedule;
	private String medicationFrequency;
	private String remark;
	private Date createDate;
	//private String patientId;
	private String userId;//用户ID
	private String cardNumber;
	private Date endTime;
	private String doctorId;
	private String doctorName;
	private String supplyName;
	private String orderCode;
	private String drugNo;
	private Date startTime;
	private Integer orderFlag;
	private String parentNo;
	private String groupNo;
	private String parentName;
	
	@GenericGenerator(name = "generator", strategy = "identity")
	@Id
	@GeneratedValue(generator = "generator")
	
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "prescription_id")
	public String getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	
	@Column(name = "drug_class")
	public String getDrugClass() {
		return drugClass;
	}
	public void setDrugClass(String drugClass) {
		this.drugClass = drugClass;
	}
	
	@Column(name = "drug_name")
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	@Column(name = "drug_product_name")
	public String getDrugProductName() {
		return drugProductName;
	}
	

	public void setDrugProductName(String drugProductName) {
		this.drugProductName = drugProductName;
	}
	
	@Column(name = "drug_dose_unit")
	public String getDrugDoseUnit() {
		return drugDoseUnit;
	}
	public void setDrugDoseUnit(String drugDoseUnit) {
		this.drugDoseUnit = drugDoseUnit;
	}
	
	@Column(name = "dose_unit")
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	@Column(name = "drug_time_schedule")
	public String getDrugTimeSchedule() {
		return drugTimeSchedule;
	}
	public void setDrugTimeSchedule(String drugTimeSchedule) {
		this.drugTimeSchedule = drugTimeSchedule;
	}
	
	@Column(name = "medication_frequency")
	public String getMedicationFrequency() {
		return medicationFrequency;
	}
	
	public void setMedicationFrequency(String medicationFrequency) {
		this.medicationFrequency = medicationFrequency;
	}
	
	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	@Column(name = "create_date")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
	@Column(name = "card_number")
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Column(name = "end_time")
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@Column(name = "doctor_id")
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	
	@Column(name = "doctor_name")
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	@Column(name = "supply_name")
	public String getSupplyName() {
		return supplyName;
	}
	public void setSupplyName(String supplyName) {
		this.supplyName = supplyName;
	}
	
	@Column(name = "order_code")
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	
	@Column(name = "drug_no")
	public String getDrugNo() {
		return drugNo;
	}
	public void setDrugNo(String drugNo) {
		this.drugNo = drugNo;
	}
	
	@Column(name = "start_time")
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@Column(name = "order_flag")
	public Integer getOrderFlag() {
		return orderFlag;
	}
	public void setOrderFlag(Integer orderFlag) {
		this.orderFlag = orderFlag;
	}
	
	
	@Column(name = "parent_no")
	public String getParentNo() {
		return parentNo;
	}
	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}
	
	@Column(name = "group_no")
	public String getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	
	
	@Column(name = "parent_name")
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	@Column(name = "user_id")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
