package com.sybercare.hospital.health.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_blood_pressure_view")
public class BloodPressure implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private String checkTime;
	private String userUid;
	private String idCard;
	private String NAME;
	private String mobile;
	private String birth;
	private String sex;
	private String companycode;
	private String companyname;
	private String systolicPressure;
	private String diastolicPressure;
	private String pluse;
	private Integer datasource;
	//private String data_status;
	//private String synchro_time;
	private String  deviceId;
	private String hand;
	// Property accessors
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

	@Column(name = "checkTime")
	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	@Column(name = "userUid")
	public String getUserUid() {
		return userUid;
	}

	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}

	@Column(name = "idCard")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "NAME")
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	@Column(name = "companycode")
	public String getCompanycode() {
		return companycode;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	@Column(name = "companyname")
	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
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

	@Column(name = "datasource")
	public Integer getDatasource() {
		return datasource;
	}

	public void setDatasource(Integer datasource) {
		this.datasource = datasource;
	}
	
	@Column(name = "deviceSn")
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	@Column(name = "hand")
	public String getHand(){
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

//	@Column(name = "data_status")
//	public String getData_status() {
//		return data_status;
//	}
//
//	public void setData_status(String data_status) {
//		this.data_status = data_status;
//	}
//
//	@Column(name = "synchro_time")
//	public String getSynchro_time() {
//		return synchro_time;
//	}
//
//	public void setSynchro_time(String synchro_time) {
//		this.synchro_time = synchro_time;
//	}

}
