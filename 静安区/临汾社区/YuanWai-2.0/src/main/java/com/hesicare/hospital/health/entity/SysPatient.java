package com.hesicare.hospital.health.entity;


import java.util.Date;

/**
 * 患者表 sys_patient
 * 
 * @author gongzhiwei
 * @date 2019-06-16
 */
public class SysPatient extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键id */
	private Long patientId;
	/** 归属部门 */
	private Long deptId;
	/** 头像地址 */
	private String avatar;
	/** 登录账号 */
	private String loginName;
	/** 用户名 */
	private String patientName;
	/** 手机号 */
	private String mobile;
	/** 密码 */
	private String password;
	/** 出生日期 */
	private Date birth;
	/** 性别(0男 1女 2未知) */
	private String sex;
	/** 住院号 */
	private String hospitalizedNum;
	/** 入院日期 */
	private Date hospitalizedDate;
	/** 入院日期 */
	private Date leaveDate;
	/** 住院状态(1 住院 2 出院) */
	private String hospitalizedType;
	/** 腕带码 */
	private String wristbandCode;
	/** 床号 */
	private String bedNum;
	/** 住院医生编号 */
	private Long doctorId;
	/** 医生姓名 */
	private String doctorName;
	/** 住址 */
	private String address;
	/** 卡类型(1-身份证 2-磁条医保卡号  3-芯片医保卡号 4-就诊卡) */
//	private String cardType;
	/** 身份证号 */
	private String idCard;
	/** 医保卡/就诊卡号 */
//	private String cardNum;
	/** 状态(0-正常 1-禁用) */
	private String status;
	/** 最后登陆IP */
	private String loginIp;
	/** 最后登陆时间 */
	private Date loginDate;

	/** 用户类型 bloodPressure高血压 bloodGlucos糖尿病 heart心血管疾病 other其他 */
	private String userType;
	/** 身高(m) */
	private String high;
	/** 体重(kg) */
	private String weight;
	/** 腰围(cm) */
	private String waist;
	/** 臀围(cm) */
	private String hip;
	/** 紧急联系人 */
	private String contactsName;
	/** 联系人手机 */
	private String contactsPhone;
	/** 用户等级 normal 普通 vip vvip */
	private String userLevel;
	/** 血压级别 0正常血压 4正常高值 1 1级高血压 2 2级高血压 3 3级高血压 */
	private String pressureLevel;
	/** 血压危险等级 0待评估 1低危 2 中危 3高危 4 很高危 */
	private String pressureDangerLevel;
	/** 血糖危险等级 1低危 2 中危 3高危 */
	private String glucoseDangerLevel;
	  // 年龄
    private Integer age;
    private String deptName;
    /**扫描枪扫出来条形码或二维码的ID  */
    private String codeId; 
    /** 员工卡号*/
	private String employeeCard; 
    private SysPatientOtherInfo sysPatientOtherInfo;
    /** 左右手标识，决定本次测量左手or右手（“left”、“right”、“both”：3个选1个必填）     */
    private String hand;

	/** 磁条医保卡号 */
	private String magneticCard;
	/** 芯片医保卡号 */
	private String chipCard;

	private Double bmi;

	/** CDSS全部异常判断，不入库 */
	private String allNormal;

	public String getAllNormal() {
		return allNormal;
	}

	public void setAllNormal(String allNormal) {
		this.allNormal = allNormal;
	}

	public Double getBmi() {
		return bmi;
	}

	public void setBmi(Double bmi) {
		this.bmi = bmi;
	}

	public String getMagneticCard() {
		return magneticCard;
	}

	public void setMagneticCard(String magneticCard) {
		this.magneticCard = magneticCard;
	}

	public String getChipCard() {
		return chipCard;
	}

	public void setChipCard(String chipCard) {
		this.chipCard = chipCard;
	}

	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getEmployeeCard() {
		return employeeCard;
	}

	public void setEmployeeCard(String employeeCard) {
		this.employeeCard = employeeCard;
	}

	public SysPatientOtherInfo getSysPatientOtherInfo() {
		return sysPatientOtherInfo;
	}

	public void setSysPatientOtherInfo(SysPatientOtherInfo sysPatientOtherInfo) {
		this.sysPatientOtherInfo = sysPatientOtherInfo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWaist() {
		return waist;
	}

	public void setWaist(String waist) {
		this.waist = waist;
	}

	public String getHip() {
		return hip;
	}

	public void setHip(String hip) {
		this.hip = hip;
	}

	public String getContactsName() {
		return contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public String getContactsPhone() {
		return contactsPhone;
	}

	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getPressureLevel() {
		return pressureLevel;
	}

	public void setPressureLevel(String pressureLevel) {
		this.pressureLevel = pressureLevel;
	}

	public String getPressureDangerLevel() {
		return pressureDangerLevel;
	}

	public void setPressureDangerLevel(String pressureDangerLevel) {
		this.pressureDangerLevel = pressureDangerLevel;
	}

	public String getGlucoseDangerLevel() {
		return glucoseDangerLevel;
	}

	public void setGlucoseDangerLevel(String glucoseDangerLevel) {
		this.glucoseDangerLevel = glucoseDangerLevel;
	}

	public void setPatientId(Long patientId) 
	{
		this.patientId = patientId;
	}

	public Long getPatientId() 
	{
		return patientId;
	}
	
	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public void setAvatar(String avatar) 
	{
		this.avatar = avatar;
	}

	public String getAvatar() 
	{
		return avatar;
	}
	public void setLoginName(String loginName) 
	{
		this.loginName = loginName;
	}

	public String getLoginName() 
	{
		return loginName;
	}
	public void setPatientName(String patientName) 
	{
		this.patientName = patientName;
	}

	public String getPatientName() 
	{
		return patientName;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}

	public String getMobile() 
	{
		return mobile;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}
	public void setBirth(Date birth) 
	{
		this.birth = birth;
	}

	public Date getBirth() 
	{
		return birth;
	}
	public void setSex(String sex) 
	{
		this.sex = sex;
	}

	public String getSex() 
	{
		return sex;
	}
	public void setHospitalizedNum(String hospitalizedNum) 
	{
		this.hospitalizedNum = hospitalizedNum;
	}

	public String getHospitalizedNum() 
	{
		return hospitalizedNum;
	}
	public void setHospitalizedDate(Date hospitalizedDate) 
	{
		this.hospitalizedDate = hospitalizedDate;
	}

	public Date getHospitalizedDate() 
	{
		return hospitalizedDate;
	}
	public void setLeaveDate(Date leaveDate) 
	{
		this.leaveDate = leaveDate;
	}

	public Date getLeaveDate() 
	{
		return leaveDate;
	}
	public void setHospitalizedType(String hospitalizedType)
	{
		this.hospitalizedType = hospitalizedType;
	}

	public String getHospitalizedType()
	{
		return hospitalizedType;
	}
	public void setWristbandCode(String wristbandCode) 
	{
		this.wristbandCode = wristbandCode;
	}

	public String getWristbandCode() 
	{
		return wristbandCode;
	}
	public void setBedNum(String bedNum) 
	{
		this.bedNum = bedNum;
	}

	public String getBedNum() 
	{
		return bedNum;
	}
	public void setDoctorId(Long doctorId) 
	{
		this.doctorId = doctorId;
	}

	public Long getDoctorId() 
	{
		return doctorId;
	}
	public void setDoctorName(String doctorName) 
	{
		this.doctorName = doctorName;
	}

	public String getDoctorName() 
	{
		return doctorName;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setIdCard(String idCard) 
	{
		this.idCard = idCard;
	}

	public String getIdCard() 
	{
		return idCard;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setLoginIp(String loginIp) 
	{
		this.loginIp = loginIp;
	}

	public String getLoginIp() 
	{
		return loginIp;
	}
	public void setLoginDate(Date loginDate) 
	{
		this.loginDate = loginDate;
	}

	public Date getLoginDate() 
	{
		return loginDate;
	}

}
