package com.sybercare.hospital.common.jobs;

import com.sybercare.hospital.common.jobs.BloodPressureVo;

import java.util.List;

public class Patdata {

	private String personcard;
	private String personName;
	private String personSex;
	private String personBirthday;
	private String cardType;
	private String cardNumber;
	private String measureTime;
	private String measureSourceId;
	private String measureLocation;
	private String measureOrgId;
	private String measureMode;
	private String deviceId;
	private String deviceType;
	private String doctorId;
	private String doctorName;
	private List<BloodPressureVo> dataBpList;
	private List<BloodGlucoseVo> dataList;
	public String getPersoncard() {
		return personcard;
	}

	public void setPersoncard(String personcard) {
		this.personcard = personcard;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonSex() {
		return personSex;
	}

	public void setPersonSex(String personSex) {
		this.personSex = personSex;
	}

	public String getPersonBirthday() {
		return personSex;
	}

	public void setPersonBirthday(String personBirthday) {
		this.personBirthday = personBirthday;
	}

	public String getCardType(){
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}



	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getMeasureTime() {
		return measureTime;
	}

	public void setMeasureTime(String measureTime) {
		this.measureTime = measureTime;
	}

	public String getMeasureSourceId() {
		return measureSourceId;
	}

	public void setMeasureSourceId(String measureSourceId) {
		this.measureSourceId = measureSourceId;
	}

	public String getMeasureLocation() {
		return measureLocation;
	}

	public void setMeasureLocation(String measureLocation) {
		this.measureLocation = measureLocation;
	}

	public String getMeasureOrgId() {
		return measureOrgId;
	}

	public void setMeasureOrgId(String measureOrgId) {
		this.measureOrgId = measureOrgId;
	}

	public String getMeasureMode() {
		return measureMode;
	}

	public void setMeasureMode(String measureMode) {
		this.measureMode = measureMode;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
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


	public List<BloodPressureVo> getDataBpList() {
		return dataBpList;
	}

	public void setDataBpList(List<BloodPressureVo> dataBpList) {
		this.dataBpList = dataBpList;
	}

	public List<BloodGlucoseVo> getDataList() {
		return dataList;
	}

	public void setDataList(List<BloodGlucoseVo> dataList) {
		this.dataList = dataList;
	}
}
