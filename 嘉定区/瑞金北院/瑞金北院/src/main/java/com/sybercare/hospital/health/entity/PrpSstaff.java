package com.sybercare.hospital.health.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sybercare.hospital.common.utils.Constants;

/**
 * 功能：医院员工作信息表
 * 
 * @author 任梁荣 
 * */
@Entity
@Table(name = "prpsstaff")
public class PrpSstaff implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 人员ID */
	private String personID;
	/** 员工姓名 */
	private String personName;
	/** 归属机构 */
	private String comCode;
	/** 入司时间 */
	private Date partInTime;
	/** 效力状态(0失效/1有效) */
	private String validStatus;
	/** 操作时间 */
	private Date operTime;
	/** 操作人 */
	private String operCode;
	/** 性别 */
	private String sex;
	/** 身份证号码 */
	private String identifyNumber;
	/** 民族 */
	private String nationality;
	/** 出生年月 */
	private Date birthday;
	/** 电话 */
	private String homePhone;
	/** 手机 */
	private String mobile;
	/** 开户银行 */
	private String bank;
	/** 帐号 */
	private String account;
	/** E_mail信箱 */
	private String email;
	/** 微博 */
	private String microblog;
	/** 微信 */
	private String wechat;
	/** 地址 */
	private String homeAddress;
	/** 婚姻状况 */
	private String maritalStatus;
	/** 教育程度 */
	private String qualifiCations;
	/** '毕业院校 */
	private String schools;
	/** 毕业时间 */
	private Date graduationDate;
	/** 专业名称 */
	private String professional;
	/** 专业执照 */
	private String certifiCate;
	/** 执照起始日期 */
	private Date certificateStartDate;
	/** 执照结束日期 */
	private Date certificateEndDate;
	/** 备注 */
	private String remark;
	/** 密码 */
	private String password;
	/** 密码设置日期 */
	private Date passwdSetDate;
	/** 密码过期日期 */
	private Date passwordExpireDate;
	private Date validDate;
	/** 操作类型1-新增2-修改 */
	private String applytype;
	/** 审核人 */
	private String verifyCode;
	/** 审核时间 */
	private Date verifyDate;
	/** 审核状态 */
	private String verifyStatus;
	/** 审核评语 */
	private String reviews;
	private Integer operateTimes;
	/** 工号 */
	private String userCode;
	private String avatar;
	/** 岗位 */
	private String role;
	/** 验证码 */
	private String verifyMsg;
	private String verifyTime;
	private String hospital;
	private Integer isdoctor;
	private String personalpassport;
	private String tiitleCertificate;
	private String tiitleCertificateNo;
	private String vocationalcertificate;
	private String vocationalcertificateNo;
	private String department;
	private String admintitle;
	private String teachtitle;
	private String adept;
	private String therapeuticrange;
	/** 首次登陆 0-未登陆过 1-已登陆过 */
	private Short isLogin;
	/** 首次登陆时间 */
	private Date firstLoginTime;
	private String stampTime = Constants.convert(new Date(), Constants.format2);
	/** APP登录次数 */
	private Integer appLoginTimes;

	public PrpSstaff() {
	}

	@Column(name = "is_login")
	public Short getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(Short isLogin) {
		this.isLogin = isLogin;
	}

	@Column(name = "first_login_time")
	public Date getFirstLoginTime() {
		return firstLoginTime;
	}

	public void setFirstLoginTime(Date firstLoginTime) {
		this.firstLoginTime = firstLoginTime;
	}

	@Column(name = "role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "verifymsg")
	public String getVerifyMsg() {
		return verifyMsg;
	}

	public void setVerifyMsg(String verifyMsg) {
		this.verifyMsg = verifyMsg;
	}

	@Column(name = "avatar")
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name = "userCode")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name = "microblog")
	public String getMicroblog() {
		return microblog;
	}

	public void setMicroblog(String microblog) {
		this.microblog = microblog;
	}

	@Column(name = "wechat")
	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "certificateStartDate")
	public Date getCertificateStartDate() {
		return certificateStartDate;
	}

	public void setCertificateStartDate(Date certificateStartDate) {
		this.certificateStartDate = certificateStartDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "certificateEndDate")
	public Date getCertificateEndDate() {
		return certificateEndDate;
	}

	public void setCertificateEndDate(Date certificateEndDate) {
		this.certificateEndDate = certificateEndDate;
	}

	/** 人员ID */
	@Id
	@Column(name = "PERSONID")
	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	/** 短信归属机构 */
	@Column(name = "COMCODE")
	public String getComCode() {
		return this.comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PARTINTIME")
	public Date getPartInTime() {
		return partInTime;
	}

	public void setPartInTime(Date partInTime) {
		this.partInTime = partInTime;
	}

	/** 效力状态(0失效/1有效) */
	@Column(name = "VALIDSTATUS")
	public String getValidStatus() {
		return this.validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OPERTIME")
	public Date getOperTime() {
		return operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

	@Column(name = "OPERCODE")
	public String getOperCode() {
		return operCode;
	}

	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}

	/** 身份证号码 */
	@Column(name = "IDENTIFYNUMBER")
	public String getIdentifyNumber() {
		return this.identifyNumber;
	}

	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY")
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "MARITALSTATUS")
	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Column(name = "QUALIFICATIONS")
	public String getQualifiCations() {
		return qualifiCations;
	}

	public void setQualifiCations(String qualifiCations) {
		this.qualifiCations = qualifiCations;
	}

	@Column(name = "SCHOOLS")
	public String getSchools() {
		return this.schools;
	}

	public void setSchools(String schools) {
		this.schools = schools;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "GRADUATIONDATE")
	public Date getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	@Column(name = "PROFESSIONAL")
	public String getProfessional() {
		return this.professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	/** 手机 */
	@Column(name = "MOBILE")
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "HOMEPHONE")
	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/** E_mail信箱 */
	@Column(name = "E_MAIL")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/** 性别 */
	@Column(name = "SEX")
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	/** 开户银行 */
	@Column(name = "BANK")
	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	/** 帐号 */
	@Column(name = "ACCOUNT")
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "CERTIFICATE")
	public String getCertifiCate() {
		return certifiCate;
	}

	public void setCertifiCate(String certifiCate) {
		this.certifiCate = certifiCate;
	}

	/** 备注 */
	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "NATIONALITY")
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Column(name = "PERSONNAME")
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PASSWDSETDATE")
	public Date getPasswdSetDate() {
		return passwdSetDate;
	}

	public void setPasswdSetDate(Date passwdSetDate) {
		this.passwdSetDate = passwdSetDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PASSWORDEXPIREDATE")
	public Date getPasswordExpireDate() {
		return passwordExpireDate;
	}

	public void setPasswordExpireDate(Date passwordExpireDate) {
		this.passwordExpireDate = passwordExpireDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "validdate")
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Column(name = "verifycode")
	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	@Column(name = "verifydate")
	public Date getVerifyDate() {
		return verifyDate;
	}

	public void setVerifyDate(Date verifyDate) {
		this.verifyDate = verifyDate;
	}

	@Column(name = "verifystatus")
	public String getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	@Column(name = "reviews")
	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	@Column(name = "applytype")
	public String getApplytype() {
		return applytype;
	}

	public void setApplytype(String applytype) {
		this.applytype = applytype;
	}

	@Column(name = "homeaddress")
	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	@Column(name = "operatetimes")
	public Integer getOperateTimes() {
		return operateTimes;
	}

	public void setOperateTimes(Integer operateTimes) {
		this.operateTimes = operateTimes;
	}

	@Column(name = "stamp_time")
	public String getStampTime() {
		return stampTime;
	}

	public void setStampTime(String stampTime) {
		this.stampTime = stampTime;
	}

	@Column(name = "verifytime")
	public String getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(String verifyTime) {
		this.verifyTime = verifyTime;
	}

	@Column(name = "hospital")
	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	@Column(name = "isdoctor")
	public Integer getIsdoctor() {
		return isdoctor;
	}

	public void setIsdoctor(Integer isdoctor) {
		this.isdoctor = isdoctor;
	}

	@Column(name = "personalpassport")
	public String getPersonalpassport() {
		return personalpassport;
	}

	public void setPersonalpassport(String personalpassport) {
		this.personalpassport = personalpassport;
	}

	@Column(name = "tiitleCertificate")
	public String getTiitleCertificate() {
		return tiitleCertificate;
	}

	public void setTiitleCertificate(String tiitleCertificate) {
		this.tiitleCertificate = tiitleCertificate;
	}

	@Column(name = "tiitleCertificateNo")
	public String getTiitleCertificateNo() {
		return tiitleCertificateNo;
	}

	public void setTiitleCertificateNo(String tiitleCertificateNo) {
		this.tiitleCertificateNo = tiitleCertificateNo;
	}

	@Column(name = "vocationalcertificate")
	public String getVocationalcertificate() {
		return vocationalcertificate;
	}

	public void setVocationalcertificate(String vocationalcertificate) {
		this.vocationalcertificate = vocationalcertificate;
	}

	@Column(name = "vocationalcertificateNo")
	public String getVocationalcertificateNo() {
		return vocationalcertificateNo;
	}

	public void setVocationalcertificateNo(String vocationalcertificateNo) {
		this.vocationalcertificateNo = vocationalcertificateNo;
	}

	@Column(name = "department")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "admintitle")
	public String getAdmintitle() {
		return admintitle;
	}

	public void setAdmintitle(String admintitle) {
		this.admintitle = admintitle;
	}

	@Column(name = "teachtitle")
	public String getTeachtitle() {
		return teachtitle;
	}

	public void setTeachtitle(String teachtitle) {
		this.teachtitle = teachtitle;
	}

	@Column(name = "adept")
	public String getAdept() {
		return adept;
	}

	public void setAdept(String adept) {
		this.adept = adept;
	}

	@Column(name = "therapeuticrange")
	public String getTherapeuticrange() {
		return therapeuticrange;
	}

	public void setTherapeuticrange(String therapeuticrange) {
		this.therapeuticrange = therapeuticrange;
	}

	@Column(name = "applogintimes")
	public Integer getAppLoginTimes() {
		return appLoginTimes;
	}

	public void setAppLoginTimes(Integer appLoginTimes) {
		this.appLoginTimes = appLoginTimes;
	}

}
