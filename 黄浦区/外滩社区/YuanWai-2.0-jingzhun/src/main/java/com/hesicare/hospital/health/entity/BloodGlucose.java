package com.hesicare.hospital.health.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hesicare.hospital.common.utils.DateUtils;
import org.hibernate.annotations.GenericGenerator;


@Entity
//@Table(name = "data_blood_glucose_clinic")
@Table(name = "patient_blood_glucose_view")
public class BloodGlucose implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;/**/
	private Double value;/**/
	private String status;/**/
	private String measureTime;/**/
	private String deviceSn;/**/
	private Integer evaluation;//评测结果；0：正常；1：偏低；2：偏高/**/
	//private Integer operateType;	//'操作类型1:增加 2:修改 3.删除',
	//private Integer operateState; //'操作类型0：未操作 1：已操作',
	private String idCard;/**/
    private String data_status;
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

	@Column(name = "meature_value")
	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Column(name = "status")
	public String  getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "measure_time")
	public String getMeasureTime() {
		return measureTime;
	}
	public void setMeasureTime(String measureTime) {
		this.measureTime = measureTime;
	}
	@Column(name = "devicesn")
	public String getDeviceSn() {
		return this.deviceSn;
	}

	public void setDeviceSn(String deviceSn) {
		this.deviceSn = deviceSn;
	}
	@Column(name = "evaluation")
	public Integer getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}
	@Column(name = "identify_card")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	@Column(name = "data_status")
	public String getData_status() {
		return data_status;
	}

	public void setData_status(String data_status) {
		this.data_status = data_status;
	}
	@Column(name = "deptid")
	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
}
