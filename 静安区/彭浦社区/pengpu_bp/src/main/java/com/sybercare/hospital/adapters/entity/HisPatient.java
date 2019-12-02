package com.sybercare.hospital.adapters.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 功能：患者信息视图
 * 
 * @author wangzhi
 */
public class HisPatient implements Serializable {

	private static final long serialVersionUID = -1842669521741747910L;

	/** 病人ID */
	private String patientId;
	/** 住院号 */
	private String cardNumber;
	/** 手机号码 */
	private String phone;
	/** 姓名 */
	private String name;
	/** 身份证号码 */
	private String identifyCard;
	/** 性别 */
	private String gender;
	/** 生日，格式2016-01-01 */
	private Date birth;
	/** 入院时间，格式2016-01-01 10:20:21 */
	private Date hospitalDate;
	/** 出院时间 */
	private Date dischargeDate;
	/** 在院状态，0：在院1：出院 */
	private String hospitalState;
	/** 住院医师ID */
	private String doctorId;
	/** 住院医师姓名 */
	private String doctorName;
	/** 科室(编码) */
	private String department;
	/** 病区(编码) */
	private String wardArea;
	/** 病房名称 */
	private String wardNo;
	/** 床号名称 */
	private String bedNumber;
	/** 住院次数 */
	private String hospitalTimes;
	/** 家庭住址 */
	private String address;
	/** 职业 */
	private String profession;
	/** 腰围 */
	private Double waist;
	/** 身高 */
	private Double height;
	/** 体重 */
	private Double weight;
	/** 糖尿病类型 */
	private String glucoseDiseaseType;
	/** 糖尿病初诊日期 */
	private String firstGlucoseDate;
	/** 家族史 */
	private String familyhistory;
	/** 疾病史 */
	private String chronicDisease;
	/**腕带码打印*/
	private String wist_Band_Code;

	

	public String getWist_Band_Code() {
		return wist_Band_Code;
	}

	public void setWist_Band_Code(String wist_Band_Code) {
		this.wist_Band_Code = wist_Band_Code;
	}

	private String ext1;

	private String ext2;

	private String ext3;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentifyCard() {
		return identifyCard;
	}

	public void setIdentifyCard(String identifyCard) {
		this.identifyCard = identifyCard;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHospitalDate() {
		return hospitalDate;
	}

	public void setHospitalDate(Date hospitalDate) {
		this.hospitalDate = hospitalDate;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getWardArea() {
		return wardArea;
	}

	public void setWardArea(String wardArea) {
		this.wardArea = wardArea;
	}

	public String getWardNo() {
		return wardNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Double getWaist() {
		return waist;
	}

	public void setWaist(Double waist) {
		this.waist = waist;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getGlucoseDiseaseType() {
		return glucoseDiseaseType;
	}

	public void setGlucoseDiseaseType(String glucoseDiseaseType) {
		this.glucoseDiseaseType = glucoseDiseaseType;
	}

	public String getFirstGlucoseDate() {
		return firstGlucoseDate;
	}

	public void setFirstGlucoseDate(String firstGlucoseDate) {
		this.firstGlucoseDate = firstGlucoseDate;
	}

	public String getFamilyhistory() {
		return familyhistory;
	}

	public void setFamilyhistory(String familyhistory) {
		this.familyhistory = familyhistory;
	}

	public String getChronicDisease() {
		return chronicDisease;
	}

	public void setChronicDisease(String chronicDisease) {
		this.chronicDisease = chronicDisease;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getHospitalState() {
		return hospitalState;
	}

	public void setHospitalState(String hospitalState) {
		this.hospitalState = hospitalState;
	}

	public String getHospitalTimes() {
		return hospitalTimes;
	}

	public void setHospitalTimes(String hospitalTimes) {
		this.hospitalTimes = hospitalTimes;
	}

}