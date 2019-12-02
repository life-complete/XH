package com.hesicare.hospital.health.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "patient_blood_pressure_view")
public class BloodPressure implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private String checkTime;
	private String userid;
	private String idCard;
	private String NAME;
	private String birth;
	private String sex;
	private String systolicPressure;
	private String diastolicPressure;
	private String pluse;
	private Integer datasource;
	private String isAverage;
	private String identifierCode;
	private String hand;
	private String data_status;
	private String cardNumber;
	private String  deviceId;
	private String deptid;
	@GenericGenerator(name = "generator", strategy = "identity")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "measure_time")
	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	@Column(name = "userid")
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Column(name = "identify_card")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "name")
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	@Column(name = "birth")
	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Column(name = "sex")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "systolicPressure")
	public String getSystolicPressure() {
		return systolicPressure;
	}

	public void setSystolicPressure(String systolicPressure) {
		this.systolicPressure = systolicPressure;
	}

	@Column(name = "diastolicPressure")
	public String getDiastolicPressure() {
		return diastolicPressure;
	}

	public void setDiastolicPressure(String diastolicPressure) {
		this.diastolicPressure = diastolicPressure;
	}

	@Column(name = "pluse")
	public String getPluse() {
		return pluse;
	}

	public void setPluse(String pluse) {
		this.pluse = pluse;
	}

	@Column(name = "deviceSn")
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name = "is_average")
	public String getIsAverage() {
		return isAverage;
	}

	public void setIsAverage(String isAverage) {
		this.isAverage = isAverage;
	}	
	
	@Column(name = "parent_id")
	public String getIdentifierCode(){
		return identifierCode;
	}

	public void setidentifierCode(String identifierCode) {
		this.identifierCode = identifierCode;
	}
	
	@Column(name = "hand")
	public String getHand(){
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}
	
	@Column(name = "status")
	public String getData_status() {
		return data_status;
	}

	public void setData_status(String data_status) {
		this.data_status = data_status;
	}
	
	@Column(name = "card_number")
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	@Column(name = "deptid")
	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
}
