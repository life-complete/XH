package com.sybercare.hospital.adapters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sybercare.hospital.adapters.entity.HisPatient;
import com.sybercare.hospital.adapters.entity.HisPrescriptionOther;
import com.sybercare.hospital.adapters.entity.HisStaff;

@Repository
public class CacheDBDAO {

	public Object readStaff(Connection connection, Object params) {
		List<HisStaff> list = new ArrayList<>();

		String sql = "SELECT * FROM his_staff";
		
		int scroll = ResultSet.TYPE_SCROLL_SENSITIVE;
		// int update=ResultSet.CONCUR_UPDATABLE;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql, scroll);
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
//			int colnum = rsmd.getColumnCount();
			while (rs.next()) {
				HisStaff staff = new HisStaff();
				staff.setStaffId(rs.getString("staff_id"));
				staff.setUsercode(rs.getString("usercode"));
				staff.setPersonname(rs.getString("personname"));
				if ("".equalsIgnoreCase(rs.getString("sex"))) {
					staff.setSex("9");
				}else{
					staff.setSex(rs.getString("sex"));
				}
				staff.setDepartment(rs.getString("department"));
				
				staff.setWardArea(rs.getString("ward_area"));
				if ("".equalsIgnoreCase(rs.getString("ward_area"))) {
					staff.setWardArea(null);
				}
				if ("医生".equalsIgnoreCase(rs.getString("title"))) {
					staff.setTitle("0");
					staff.setDoctorLevel("0");
				}else{
					staff.setTitle("1");
					staff.setDoctorLevel(null);
				}
				staff.setMobile(rs.getString("mobile"));
				if ("".equalsIgnoreCase(rs.getString("mobile"))) {
					staff.setMobile(null);
				}
				
				staff.setExt1(rs.getString("ext1"));
				staff.setExt2(rs.getString("ext2"));
				staff.setExt3(rs.getString("ext3"));
				list.add(staff);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public Object readPatient(Connection connection, Object params) {
		List<HisPatient> list = new ArrayList<>();

		String sql = "SELECT * FROM his_patient";
		int scroll = ResultSet.TYPE_SCROLL_SENSITIVE;
		// int update=ResultSet.CONCUR_UPDATABLE;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql, scroll);
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
//			int colnum = rsmd.getColumnCount();
			while (rs.next()) {
				HisPatient patient = new HisPatient();
				patient.setPatientId(rs.getString("patient_id"));
				patient.setCardNumber(rs.getString("card_number"));
				
				if ("".equalsIgnoreCase(rs.getString("hospital_times"))) {
					patient.setHospitalTimes(null);
				}else{
					patient.setHospitalTimes(rs.getString("hospital_times"));
				}
				
				patient.setPhone(rs.getString("phone"));
				patient.setName(rs.getString("name"));
				patient.setIdentifyCard(rs.getString("identify_card"));
				if ("0".equals(rs.getString("gender"))) {
					patient.setGender("0");
				}else if ("1".equals(rs.getString("gender"))) {
					patient.setGender("1");
				}else{
					patient.setGender("9");
				}
				
				patient.setBirth(rs.getDate("birth"));
				patient.setAddress(rs.getString("address"));
				patient.setHospitalDate(rs.getDate("hospital_date"));
				
				patient.setHospitalState(rs.getString("hospital_state"));
				if ("0".equalsIgnoreCase(rs.getString("hospital_state"))) {
					patient.setDischargeDate(null);
				}else if ("1".equalsIgnoreCase(rs.getString("hospital_state"))) {
					patient.setDischargeDate(rs.getDate("discharge_date"));
				}
				patient.setGlucoseDiseaseType(rs.getString("glucose_disease_type"));
				patient.setFirstGlucoseDate(rs.getString("first_glucose_date"));
				patient.setDoctorId(rs.getString("doctor_id"));
				patient.setDoctorName(rs.getString("doctor_name"));
				patient.setFamilyhistory(rs.getString("familyhistory"));
				patient.setChronicDisease(rs.getString("chronic_disease"));
				patient.setDepartment(rs.getString("department"));
				patient.setWardArea(rs.getString("ward_area"));
				patient.setWardNo(rs.getString("ward_no"));
				patient.setBedNumber(rs.getString("bed_number"));
				patient.setProfession(rs.getString("profession"));
				patient.setWaist(rs.getDouble("waist"));
				patient.setHeight(rs.getDouble("height"));
				patient.setWeight(rs.getDouble("weight"));
				patient.setExt1(rs.getString("ext1"));
				patient.setExt2(rs.getString("ext2"));
				patient.setExt3(rs.getString("ext3"));
				
				list.add(patient);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public Object readPother(Connection connection, Object params) {
		List<HisPrescriptionOther> list = new ArrayList<>();

		String sql = "SELECT * FROM his_prescription_other";
		int scroll = ResultSet.TYPE_SCROLL_SENSITIVE;
		// int update=ResultSet.CONCUR_UPDATABLE;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql, scroll);
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
//			int colnum = rsmd.getColumnCount();
			while (rs.next()) {
				HisPrescriptionOther prescriptionOther = new HisPrescriptionOther();
				if (rs.getString("prescription_id") == null || "".equalsIgnoreCase(rs.getString("prescription_id"))) {
					continue;
				}
				prescriptionOther.setPrescriptionId(rs.getString("prescription_id"));
				if (rs.getString("patient_id") == null || "".equalsIgnoreCase(rs.getString("patient_id"))) {
					continue;
				}
				prescriptionOther.setPatientId(rs.getString("patient_id"));
				prescriptionOther.setCreateDate(rs.getDate("creat_date"));
				prescriptionOther.setCardNumber(rs.getString("card_number"));
				
				if (rs.getString("prescription_name") == null || 
						"".equalsIgnoreCase(rs.getString("prescription_name"))||
						!rs.getString("prescription_name").contains("血糖")) {//过滤医嘱中的非血糖医嘱
					continue;
				}
				/*
				qod 	隔日1次
				qid 	每日4次
				tid 	每日3次
				bid 	每日2次
				qd  	每日1次
				st  	立即
				qn  	每晚1次
				q6h 	6小时1次
				q8h 	8小时1次
				prn 	必要时
				q2h 	2小时1次
				q3h 	3小时1次
				q4h 	4小时1次
				q1h 	1小时1次
				qw  	每周1次
				q12h	12小时1次
				早晚	早晚各1次
				午晚	午晚各1次
				biw 	每周2次
				qm  	每月1次
				qow 	隔周1次
				其他	NULL
				早	每日早1次
				午	每日午1次
				*/
				prescriptionOther.setFrequency("ALWAYS");//用医院的频次
				if (rs.getString("frequency") == null || "".equalsIgnoreCase(rs.getString("frequency"))) {
					prescriptionOther.setPrescriptionName("血糖医嘱");//系统中有一个名称为"血糖医嘱"的长期医嘱
				}else{
					prescriptionOther.setPrescriptionName(rs.getString("frequency"));
				}
				
//				prescriptionOther.setPrescriptionName(rs.getString("prescription_name"));
				
//				prescriptionOther.setFrequency(rs.getString("frequency"));
				prescriptionOther.setPrescriptionNotes(rs.getString("prescription_name"));
				prescriptionOther.setStartTime(rs.getDate("start_time"));
				prescriptionOther.setEndTime(rs.getDate("end_time"));
				prescriptionOther.setDoctorId(rs.getString("doctor_id"));
				prescriptionOther.setDoctorName(rs.getString("doctor_name"));
				prescriptionOther.setPrescriptionNo(rs.getString("prescription_no"));
				if (!"血糖监测".equalsIgnoreCase(rs.getString("prescription_type"))) {
					continue;
				}else{
					prescriptionOther.setPrescriptionType("0");
				}
				
				prescriptionOther.setRemark(rs.getString("remark"));
				prescriptionOther.setPrescriptionStatus(rs.getString("prescription_status"));
				
				prescriptionOther.setExt1(rs.getString("ext1"));
				prescriptionOther.setExt2(rs.getString("ext2"));
				prescriptionOther.setExt3(rs.getString("ext3"));
				
				list.add(prescriptionOther);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
