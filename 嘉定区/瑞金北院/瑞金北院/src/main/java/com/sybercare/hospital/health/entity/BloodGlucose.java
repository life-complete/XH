package com.sybercare.hospital.health.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sybercare.hospital.common.utils.DateUtils;

@Entity
@Table(name = "data_blood_glucose_clinic")
public class BloodGlucose implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	//private Long datasn;
	private Double value;
	private Integer status;
	private String measureTime;
	//private String remark;
	//private String userId;
	private String deviceSn;
	private String stampTime=DateUtils.getCurrent(16);
	private String opratorId;
	private String datasource;
	private String gsntime;
	private String createTime;
	//private String lastUpdateTime;
	private Integer evaluation;//评测结果；0：正常；1：偏低；2：偏高
	//private String message;
	//private String optComment;
	private Integer operateType;	//'操作类型1:增加 2:修改 3.删除',
	private Integer operateState; //'操作类型0：未操作 1：已操作',
	//private String bgqcPaperNumber;
	private String name;
	private String cardNumber;
	private String idCard;
	

	
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
	/*@Column(name = "data_sn")
	public Long getDatasn() {
		return datasn;
	}

	public void setDatasn(Long datasn) {
		this.datasn = datasn;
	}*/

	@Column(name = "value")
	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Column(name = "status")
	public Integer  getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/*@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	*/
	
	@Column(name = "measure_time")
	public String getMeasureTime() {
		return measureTime;
	}

	public void setMeasureTime(String measureTime) {
		this.measureTime = measureTime;
	}
	@Column(name = "stamp_time")
	public String getStampTime() {
		return stampTime;
	}

	public void setStampTime(String stampTime) {
		this.stampTime = stampTime;
	}


//	@Column(name = "user_id")
//	public String getUserId() {
//		return this.userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

	@Column(name = "device_sn")
	public String getDeviceSn() {
		return this.deviceSn;
	}

	public void setDeviceSn(String deviceSn) {
		this.deviceSn = deviceSn;
	}
	@Column(name = "operatorId")
	public String getOpratorId() {
		return opratorId;
	}

	public void setOpratorId(String opratorId) {
		this.opratorId = opratorId;
	}
	
	@Column(name = "data_source")
	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	/*@Column(name = "gsn_time")
	public String getGsntime() {
		return gsntime;
	}

	public void setGsntime(String gsntime) {
		this.gsntime = gsntime;
	}*/
	
	@Column(name = "create_time")
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/*@Column(name = "lastUpdateTime")
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}*/
	
	@Column(name = "evaluation")
	public Integer getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}
	
	/*@Column(name = "message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}*/
	
	
	@Column(name = "operate_type")
	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}

	@Column(name = "operate_state")
	public Integer getOperateState() {
		return operateState;
	}

	public void setOperateState(Integer operateState) {
		this.operateState = operateState;
	}
	/*@Column(name = "bgqc_paper_number")
	public String getBgqcPaperNumber() {
		return bgqcPaperNumber;
	}

	public void setBgqcPaperNumber(String bgqcPaperNumber) {
		this.bgqcPaperNumber = bgqcPaperNumber;
	}*/
	
	@Column(name = "card_number")
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "identify_card")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

}
