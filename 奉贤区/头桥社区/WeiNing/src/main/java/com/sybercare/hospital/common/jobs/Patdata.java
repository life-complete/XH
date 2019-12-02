package com.sybercare.hospital.common.jobs;

import com.sybercare.hospital.common.jobs.BloodPressureVo;

import java.util.List;

public class Patdata {

	private String idcard;
	private String measureTime;
	private String measureAppId;
	private String measureLocation;
	private String measureOrgId;
	private String measureMode;
	private String hospitalcadno;
	private String hospitalcadtype;
	private String timestamp;
	private String sign;
	private List<BloodPressureVo> dataBpList;
	private List<BloodGlucoseVo> dataList;

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getMeasureTime() {
		return measureTime;
	}

	public void setMeasureTime(String measureTime) {
		this.measureTime = measureTime;
	}

	public String getMeasureAppId() {
		return measureAppId;
	}

	public void setMeasureAppId(String measureAppId) {
		this.measureAppId = measureAppId;
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

	public String getHospitalcadno() {
		return hospitalcadno;
	}

	public void setHospitalcadno(String hospitalcadno) {
		this.hospitalcadno = hospitalcadno;
	}

	public String getHospitalcadtype() {
		return hospitalcadtype;
	}

	public void setHospitalcadtype(String hospitalcadtype) {
		this.hospitalcadtype = hospitalcadtype;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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
