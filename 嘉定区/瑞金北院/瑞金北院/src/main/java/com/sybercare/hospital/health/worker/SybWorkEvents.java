package com.sybercare.hospital.health.worker;

/**
 * 功能：工作事件名称
 * 
 * @author 任梁荣
 * */
public enum SybWorkEvents {
	
	SYBSTAFF("SybStaff"),//科室员工
	SYBPATIENT("SybPatient"),//科室患者
	SYBPOTHER("SybPrescriptionOther"),//监测医嘱
	SYBDEPARTMENT("SybDepartment"),//科室信息
	SYBWARDAREA("SybWardarea"),//病区信息
	SYBPUSHXUETANG("SybPushXueTang");//血糖数据
	
	private String values;

	private SybWorkEvents(String values) {
		this.values = values;
	}

	public static SybWorkEvents nvalueOf(String value) {
		for (SybWorkEvents names : SybWorkEvents.values()) {
			if (names.values.equals(value)) {
				return names;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return this.values;
	}
}
