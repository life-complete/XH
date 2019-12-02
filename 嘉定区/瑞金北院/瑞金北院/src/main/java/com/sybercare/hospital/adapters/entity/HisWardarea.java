package com.sybercare.hospital.adapters.entity;

import java.io.Serializable;

/**
 * 功能：病区信息表
 * 
 * @author 任梁荣
 * */
public class HisWardarea implements Serializable {

	private static final long serialVersionUID = -6893132815408255627L;
	/** 科室id */
	private Long id;
	/** 病区代码 */
	private String wardareaCode;
	/** 病区名称 */
	private String wardareaName;
	/** 所属科室(所属科室代码) */
	private String departmentCode;
	/** 排序号(病区排序) */
	private Long order;
	/** 作废标示(0：作废；1：有效) */
	private Integer validFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWardareaCode() {
		return wardareaCode;
	}

	public void setWardareaCode(String wardareaCode) {
		this.wardareaCode = wardareaCode;
	}

	public String getWardareaName() {
		return wardareaName;
	}

	public void setWardareaName(String wardareaName) {
		this.wardareaName = wardareaName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

	public Integer getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}
}
