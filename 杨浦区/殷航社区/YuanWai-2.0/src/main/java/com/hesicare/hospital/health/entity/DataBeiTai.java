package com.hesicare.hospital.health.entity;

import java.util.Date;

public class DataBeiTai {
	private String userId;
	private String idcard;// 身份证号
	private String phone;// 手机号
	private String type;
	private String dtype;// 设备类型
	private String did;// 设备编码
	private DataBeiTaiDetail data;
	private String name;
	private Date birth;
	private String gender;
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public DataBeiTaiDetail getData() {
		return data;
	}

	public void setData(DataBeiTaiDetail data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "DataBmi [idcard=" + idcard + ", phone=" + phone + ", type=" + type + ", dtype=" + dtype + ", did=" + did
				+ ", data=" + data + "]";
	}

}
