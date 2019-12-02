package com.sybercare.hospital.adapters.entity;

import java.io.Serializable;

/**
 * 功能：科室信息表
 * 
 * @author 任梁荣
 * */
public class HisDepartment implements Serializable {

	private static final long serialVersionUID = -8201745874747680789L;
	/** 科室id */
	private Long id;
	/** 科室代码 */
	private String departmentCode;
	/** 科室名称 */
	private String departmentName;
	/** 作废标示(是 0：作废；1：有效) */
	private Integer validFlag;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}

}
