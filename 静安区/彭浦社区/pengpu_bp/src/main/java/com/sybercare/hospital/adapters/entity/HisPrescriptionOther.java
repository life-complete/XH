package com.sybercare.hospital.adapters.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 功能：监测医嘱信息(血糖血压等监测医嘱视图)
 * 
 * @author wangzhi
 */
public class HisPrescriptionOther implements Serializable {

	private static final long serialVersionUID = 7566446130951999478L;
	/** 医嘱ID */
	private String prescriptionId;
	/** 病人ID */
	private String patientId;
	/** 医嘱创建时间 */
	private Date createDate;
	/** 住院号 (不填为NULL，下同) */
	private String cardNumber;
	/** 医嘱名称 */
	private String prescriptionName;
	/** 使用频次 (ALWAYS:长期医嘱,ONCE:临时医嘱) */
	private String frequency;
	/** 医嘱说明 */
	private String prescriptionNotes;
	/** 医嘱开始日期 */
	private Date startTime;
	/** 医嘱结束日期 */
	private Date endTime;
	/** 医嘱医生ID */
	private String doctorId;
	/** 医嘱医生姓名 */
	private String doctorName;
	/** 医嘱项目代码 */
	private String prescriptionNo;
	/** 医嘱类型 (0：血糖检测，1：血压监测) */
	private String prescriptionType;
	/** 备注 */
	private String remark;
	/** 医嘱状态(0：可用，1：不可用) */
	private String prescriptionStatus;

	private String ext1;

	private String ext2;

	private String ext3;

	public String getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

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

	public String getPrescriptionName() {
		return prescriptionName;
	}

	public void setPrescriptionName(String prescriptionName) {
		this.prescriptionName = prescriptionName;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getPrescriptionNotes() {
		return prescriptionNotes;
	}

	public void setPrescriptionNotes(String prescriptionNotes) {
		this.prescriptionNotes = prescriptionNotes;
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

	public String getPrescriptionNo() {
		return prescriptionNo;
	}

	public void setPrescriptionNo(String prescriptionNo) {
		this.prescriptionNo = prescriptionNo;
	}

	public String getPrescriptionType() {
		return prescriptionType;
	}

	public void setPrescriptionType(String prescriptionType) {
		this.prescriptionType = prescriptionType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPrescriptionStatus() {
		return prescriptionStatus;
	}

	public void setPrescriptionStatus(String prescriptionStatus) {
		this.prescriptionStatus = prescriptionStatus;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}