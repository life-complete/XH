package com.sybercare.hospital.health.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 功能：机构表
 * 
 * @author 任梁荣
 * */
@Entity
@Table(name = "PRPSCOMPANY")
public class PrpScompany implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 机构代码 */
	private String comCode;
	/** HIS代码 */
	private String hisCode;
	/** 机构名称 */
	private String comCName;
	/** 机构名称 */
	private String comEName;
	/** 地址中文名称 */
	private String addressCName;
	/** 地址英文名称 */
	private String addressEName;
	/** 国家 */
	private String country;
	/** 省 */
	private String province;
	/** 市 */
	private String city;
	/** 邮编 */
	private String postCode;
	/** 电话 */
	private String phone;
	/** 手机 */
	private String tel;
	/** 传真 */
	private String fax;
	/** 负责人 */
	private String leader;
	/** 开始日期 */
	private Date createDate;
	/** 上级机构代码 */
	private String upperComcode;
	/** 机构类型 */
	private String comType;
	/** 机构等级 */
	private String comLevel;
	/** 许可证机构编号 */
	private String licenceComCode;
	/** 营业执照注册号 */
	private String commerinstrnmentNo;
	/** 组织机构编码 */
	private String organizationNo;
	/** 税务登记证号 */
	private String taxregistNo;
	/**  */
	private String permitNo;
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
	/** 备注 */
	private String remark;
	/** 效力状态(0失效/1有效) */
	private String validStatus;
	/** 核算单位标志 */
	private String centerFlag;
	/** 预留标志 */
	private String flag;
	/** 申请类型 */
	private String applyType;
	/** 审核状态 */
	private String verifyStatus;
	/** 审核人 */
	private String verifyCode;
	/** 审核时间 */
	private Date verifyDate;
	/** 审核意见 */
	private String reviews;
	private Date updatedate;
	private String updatecode;
	/** 总公司logo */
	private String logo;
	private Short isChronicDisease;
	private String treatType;
	private Integer comcodeMode;
	private String comcodeUrl;
	/** 机构擅长领域 */
	private String goodAtArea;

	private String sort;

	public PrpScompany() {
	}

	@Column(name = "comcode_mode")
	public Integer getComcodeMode() {
		return comcodeMode;
	}

	public void setComcodeMode(Integer comcodeMode) {
		this.comcodeMode = comcodeMode;
	}

	@Column(name = "is_chronic_disease")
	public Short getIsChronicDisease() {
		return isChronicDisease;
	}

	public void setIsChronicDisease(Short isChronicDisease) {
		this.isChronicDisease = isChronicDisease;
	}

	@Column(name = "treat_type")
	public String getTreatType() {
		return treatType;
	}

	public void setTreatType(String treatType) {
		this.treatType = treatType;
	}

	/** 短信归属机构 */
	@Id
	@Column(name = "COMCODE")
	public String getComCode() {
		return this.comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	/** 授权机构名称 */
	@Column(name = "COMCNAME")
	public String getComCName() {
		return this.comCName;
	}

	public void setComCName(String comCName) {
		this.comCName = comCName;
	}

	@Column(name = "COMENAME")
	public String getComEName() {
		return this.comEName;
	}

	public void setComEName(String comEName) {
		this.comEName = comEName;
	}

	/** 地址中文名称 */
	@Column(name = "ADDRESSCNAME")
	public String getAddressCName() {
		return this.addressCName;
	}

	public void setAddressCName(String addressCName) {
		this.addressCName = addressCName;
	}

	/** 地址英文名称 */
	@Column(name = "ADDRESSENAME")
	public String getAddressEName() {
		return this.addressEName;
	}

	public void setAddressEName(String addressEName) {
		this.addressEName = addressEName;
	}

	/** 邮编 */
	@Column(name = "POSTCODE")
	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Column(name = "PHONE")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "FAX")
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "UPPERCOMCODE")
	public String getUpperComcode() {
		return this.upperComcode;
	}

	public void setUpperComcode(String upperComcode) {
		this.upperComcode = upperComcode;
	}

	@Column(name = "COMTYPE")
	public String getComType() {
		return this.comType;
	}

	public void setComType(String comType) {
		this.comType = comType;
	}

	@Column(name = "COMLEVEL")
	public String getComLevel() {
		return this.comLevel;
	}

	public void setComLevel(String comLevel) {
		this.comLevel = comLevel;
	}

	/** 备注 */
	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/** 效力状态(0失效/1有效) */
	@Column(name = "VALIDSTATUS")
	public String getValidStatus() {
		return this.validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	@Column(name = "CENTERFLAG")
	public String getCenterFlag() {
		return this.centerFlag;
	}

	public void setCenterFlag(String centerFlag) {
		this.centerFlag = centerFlag;
	}

	/** 预留标志 */
	@Column(name = "FLAG")
	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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

	@Column(name = "PERMITNO")
	public String getPermitNo() {
		return this.permitNo;
	}

	public void setPermitNo(String permitNo) {
		this.permitNo = permitNo;
	}

	@Column(name = "LICENCECOMCODE")
	public String getLicenceComCode() {
		return licenceComCode;
	}

	public void setLicenceComCode(String licenceComCode) {
		this.licenceComCode = licenceComCode;
	}

	@Column(name = "COMMERINSTRUMENTNO")
	public String getCommerinstrnmentNo() {
		return commerinstrnmentNo;
	}

	public void setCommerinstrnmentNo(String commerinstrnmentNo) {
		this.commerinstrnmentNo = commerinstrnmentNo;
	}

	@Column(name = "ORGANIZATIONNO")
	public String getOrganizationNo() {
		return organizationNo;
	}

	public void setOrganizationNo(String organizationNo) {
		this.organizationNo = organizationNo;
	}

	@Column(name = "TAXREGISTNO")
	public String getTaxregistNo() {
		return taxregistNo;
	}

	public void setTaxregistNo(String taxregistNo) {
		this.taxregistNo = taxregistNo;
	}

	@Column(name = "CREATEDATE")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "LEADER")
	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	@Column(name = "APPLYTYPE")
	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	@Column(name = "PROVINCE")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "VERIFYSTATUS")
	public String getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	@Column(name = "VERIFYCODE")
	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VERIFYDATE")
	public Date getVerifyDate() {
		return verifyDate;
	}

	public void setVerifyDate(Date verifyDate) {
		this.verifyDate = verifyDate;
	}

	@Column(name = "reviews")
	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "tel")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "e_mail")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	@Column(name = "updatedate")
	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	@Column(name = "updatecode")
	public String getUpdatecode() {
		return updatecode;
	}

	public void setUpdatecode(String updatecode) {
		this.updatecode = updatecode;
	}

	@Column(name = "logo")
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Column(name = "comcode_url")
	public String getComcodeUrl() {
		return comcodeUrl;
	}

	public void setComcodeUrl(String comcodeUrl) {
		this.comcodeUrl = comcodeUrl;
	}

	@Column(name = "good_at_area")
	public String getGoodAtArea() {
		return goodAtArea;
	}

	public void setGoodAtArea(String goodAtArea) {
		this.goodAtArea = goodAtArea;
	}

	@Column(name = "hiscode")
	public String getHisCode() {
		return hisCode;
	}

	public void setHisCode(String hisCode) {
		this.hisCode = hisCode;
	}

	@Column(name = "sort")
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}
