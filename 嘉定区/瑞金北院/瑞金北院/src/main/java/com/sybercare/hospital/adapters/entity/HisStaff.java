package com.sybercare.hospital.adapters.entity;

import java.io.Serializable;

/**
 * 功能：员工信息(医院人员信息视图)
 * 
 * @author wangzhi
 */
public class HisStaff implements Serializable {

	private static final long serialVersionUID = -6190280942138745260L;
	/** 工号ID */
	private String staffId;
	/** 员工工号 */
	private String usercode;
	/** 姓名 */
	private String personname;
	/** 性别 (1：男，2：女) */
	private String sex;
	/** 科室(科室编码，如果有多个共享科室需要选择主科室) */
	private String department;
	/** 病区(病区编码) */
	private String wardArea;
	/** 职务(行政职位信息编码) */
	private String title;
	/** 手机号 */
	private String mobile;
	/** 医生资质等级(有资质等级表示医生，否者护士) */
	private String doctorLevel;

	private String ext1;

	private String ext2;

	private String ext3;

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getPersonname() {
		return personname;
	}

	public void setPersonname(String personname) {
		this.personname = personname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDoctorLevel() {
		return doctorLevel;
	}

	public void setDoctorLevel(String doctorLevel) {
		this.doctorLevel = doctorLevel;
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

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}