package com.hesicare.hospital.health.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.hesicare.hospital.common.utils.DateUtils;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	/** 用户ID */
	private String userId;
	/** 用户名 */
	private String userName;
	/** 用户昵称 */
	private String nickname;
	/** 密码 */
	private String password;
	/** 籍贯 */
	private String nation;
	/** 邮箱 */
	private String email;
	/** 手机号 */
	private String phone;
	/** 真实姓名 */
	private String name;
	/** 身份证 */
	private String identifyCard;
	/** 性别 */
	private Integer gender;
	/** 出生日期 */
	private Date birth;
	/** 地址 */
	private String address;
	/** 用户状态 */
	private Integer status;
	/** 注册时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/** 新增字段 年龄 */
	private Integer age;
	/** 新增字段 服务人员id */
	private String servicePersonId;
	private String isMedicalInsurance;
	private String glucoseDiseaseType;
	private String contactPerson;
	private String contactPersonPhone;
	

	// 旧的serviceComcode改成view_comcode
	private String viewComcode;

	/* 用户来源机构 旧的chainComCode改成sourceComcode */
	private String sourceComcode;

	private String familyHistory;
	private Date firstVisitDate;
	private String verifyMsg;
	private String verifyTime;
	private String stampTime = DateUtils.getCurrent(16);

	// 慢病管理新增字段
	private String cardNumber;// 会员卡号
	private String telephone;// 座机号
	private Double waist; // 腰围(默认cm)
	private String profession; // 职业
	private String chronicDisease; // 规则慢性病
	private String chronicDiseaseOther; // 其他慢性病',[一栏是保存有规律的数据，一栏是保存手动输入的数据]
	private String ruleFamilyHistory; // 规则家族史
	private String remark; // 备注

	private String doctorName;// 住院医师名

	private Double height;// 身高

	private Double weight;// 体重

	private String province;// 籍贯

	private String inHospitalId;
	
	private String wrist_Band_Code;
	
	private String hand; //左右手


	public String getWrist_Band_Code() {
		return wrist_Band_Code;
	}

	public void setWrist_Band_Code(String wrist_Band_Code) {
		this.wrist_Band_Code = wrist_Band_Code;
	}

	/** default constructor */
	public User() {
	}

	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "user_id")
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "nickname")
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "nation")
	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "identify_card")
	public String getIdentifyCard() {
		return this.identifyCard;
	}

	public void setIdentifyCard(String identifyCard) {
		this.identifyCard = identifyCard;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "username")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birth")
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Column(name = "gender")
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_time")
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	// @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time")
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "is_Medical_Insurance")
	public String getIsMedicalInsurance() {
		return isMedicalInsurance;
	}

	public void setIsMedicalInsurance(String isMedicalInsurance) {
		this.isMedicalInsurance = isMedicalInsurance;
	}

	@Column(name = "glucose_disease_Type")
	public String getGlucoseDiseaseType() {
		return glucoseDiseaseType;
	}

	public void setGlucoseDiseaseType(String glucoseDiseaseType) {
		this.glucoseDiseaseType = glucoseDiseaseType;
	}

	@Column(name = "contact_Person")
	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Column(name = "contact_person_phone")
	public String getContactPersonPhone() {
		return contactPersonPhone;
	}

	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}

	@Column(name = "view_comcode")
	public String getViewComcode() {
		return viewComcode;
	}

	public void setViewComcode(String serviceComCode) {
		this.viewComcode = serviceComCode;
	}

	@Column(name = "familyhistory")
	public String getFamilyHistory() {
		return familyHistory;
	}

	public void setFamilyHistory(String familyHistory) {
		this.familyHistory = familyHistory;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "first_visit_date")
	public Date getFirstVisitDate() {
		return firstVisitDate;
	}

	public void setFirstVisitDate(Date firstVisitDate) {
		this.firstVisitDate = firstVisitDate;
	}

	@Column(name = "verifyMsg")
	public String getVerifyMsg() {
		return verifyMsg;
	}

	public void setVerifyMsg(String verifyMsg) {
		this.verifyMsg = verifyMsg;
	}

	@Column(name = "verifytime")
	public String getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(String verifyTime) {
		this.verifyTime = verifyTime;
	}

	@Column(name = "source_comcode")
	public String getSourceComcode() {
		return sourceComcode;
	}

	public void setSourceComcode(String sourceComcode) {
		this.sourceComcode = sourceComcode;
	}

	@Column(name = "stamp_time")
	public String getStampTime() {
		return stampTime;
	}

	public void setStampTime(String stampTime) {
		this.stampTime = stampTime;
	}

	// 慢病管理新增字段

	@Column(name = "waist")
	public Double getWaist() {
		return waist;
	}

	public void setWaist(Double waist) {
		this.waist = waist;
	}

	@Column(name = "profession")
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Column(name = "chronic_disease")
	public String getChronicDisease() {
		return chronicDisease;
	}

	public void setChronicDisease(String chronicDisease) {
		this.chronicDisease = chronicDisease;
	}

	@Column(name = "chronic_disease_other")
	public String getChronicDiseaseOther() {
		return chronicDiseaseOther;
	}

	public void setChronicDiseaseOther(String chronicDiseaseOther) {
		this.chronicDiseaseOther = chronicDiseaseOther;
	}

	@Column(name = "rule_family_history")
	public String getRuleFamilyHistory() {
		return ruleFamilyHistory;
	}

	public void setRuleFamilyHistory(String ruleFamilyHistory) {
		this.ruleFamilyHistory = ruleFamilyHistory;
	}

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "card_number")
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Column(name = "telephone")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getServicePersonId() {
		return servicePersonId;
	}

	public void setServicePersonId(String servicePersonId) {
		this.servicePersonId = servicePersonId;
	}

	@Column(name = "doctor_name")
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	@Column(name = "height")
	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Column(name = "weight")
	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Column(name = "province")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "in_hospital_id")
	public String getInHospitalId() {
		return inHospitalId;
	}

	public void setInHospitalId(String inHospitalId) {
		this.inHospitalId = inHospitalId;
	}
	
	@Column(name = "hand")
	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

}
