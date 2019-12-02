package com.sybercare.hospital.common.jobs;

import java.util.List;

public class Patdata {
	
		private String personcard;
		private String measureTime;
		private String measureSourceId;
		private String measureLocation;
		private String measureOrgId;
		private String measureMode;
		private String deviceId;
		private String deviceType;
		private List<BloodPressureVo> dataList;

		public String getPersoncard() {
			return personcard;
		}

		public void setPersoncard(String personcard) {
			this.personcard = personcard;
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

		public List<BloodPressureVo> getDataList() {
			return dataList;
		}

		public void setDataList(List<BloodPressureVo> dataList) {
			this.dataList = dataList;
		}



}
