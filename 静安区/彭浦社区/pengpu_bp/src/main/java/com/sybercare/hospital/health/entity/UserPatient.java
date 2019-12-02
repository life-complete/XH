package com.sybercare.hospital.health.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.sybercare.hospital.common.utils.DateUtils;

@Entity
@Table(name = "user_patient")
public class UserPatient implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String userId;
	private String inHospitalStatus;
	private String wardArea;//病区
	private String cardNumber;//住院号
	private String bedNumber;//床号
	private String isHealthInsurance;
	private String healthInsuranceNumber;
	private String qrCode;
	private String wardNo;//病房
	private String medicationType;
	private String healthCareType;
	private String hospitalTimes;
	private String department;
	
	private String createTime =DateUtils.getCurrent(16);//创建时间
	
	
	
	private String hospitalDate; //入院时间
	
	private String dischargeDate;  //出院时间
	
	private String inHospitalId;
	
	
	@GenericGenerator(name = "generator", strategy = "identity")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "user_id")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name = "in_hospital_status")
	public String getInHospitalStatus() {
		return inHospitalStatus;
	}
	public void setInHospitalStatus(String inHospitalStatus) {
		this.inHospitalStatus = inHospitalStatus;
	}
	
	@Column(name = "ward_area")
	public String getWardArea() {
		return wardArea;
	}
	public void setWardArea(String wardArea) {
		this.wardArea = wardArea;
	}
	
	
	@Column(name = "bed_number")
	public String getBedNumber() {
		return bedNumber;
	}
	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}
	
	@Column(name = "is_health_insurance")
	public String getIsHealthInsurance() {
		return isHealthInsurance;
	}
	public void setIsHealthInsurance(String isHealthInsurance) {
		this.isHealthInsurance = isHealthInsurance;
	}
	
	@Column(name = "health_insurance_number")
	public String getHealthInsuranceNumber() {
		return healthInsuranceNumber;
	}
	public void setHealthInsuranceNumber(String healthInsuranceNumber) {
		this.healthInsuranceNumber = healthInsuranceNumber;
	}
	
	@Column(name = "qr_code")
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	
	@Column(name = "ward_no")
	public String getWardNo() {
		return wardNo;
	}
	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}
	
	@Column(name = "medication_type")
	public String getMedicationType() {
		return medicationType;
	}
	public void setMedicationType(String medicationType) {
		this.medicationType = medicationType;
	}
	
	@Column(name = "health_care_type")
	public String getHealthCareType() {
		return healthCareType;
	}
	public void setHealthCareType(String healthCareType) {
		this.healthCareType = healthCareType;
	}
	
	@Column(name = "hospital_times")
	public String getHospitalTimes() {
		return hospitalTimes;
	}
	public void setHospitalTimes(String hospitalTimes) {
		this.hospitalTimes = hospitalTimes;
	}
	
	@Column(name = "department")
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	@Column(name = "create_time")
	public String getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "card_number")
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
	@Column(name = "hospital_date")
	public String getHospitalDate() {
		return hospitalDate;
	}
	public void setHospitalDate(String hospitalDate) {
		this.hospitalDate = hospitalDate;
	}
	
	@Column(name = "discharge_date")
	public String getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	@Column(name = "in_hospital_id")
	public String getInHospitalId() {
		return inHospitalId;
	}
	public void setInHospitalId(String inHospitalId) {
		this.inHospitalId = inHospitalId;
	}


	
	
}
