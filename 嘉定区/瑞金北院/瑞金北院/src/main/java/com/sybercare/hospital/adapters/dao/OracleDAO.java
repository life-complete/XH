package com.sybercare.hospital.adapters.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sybercare.hospital.adapters.entity.HisPatient;
import com.sybercare.hospital.adapters.entity.HisPrescriptionOther;
import com.sybercare.hospital.adapters.entity.HisStaff;
import com.sybercare.hospital.adapters.entity.Tuser;
import com.sybercare.hospital.common.ds.DynamicDataSourceAutowired;

/**
 * 功能：oracle数据库业务实现
 *
 * @author 任梁荣
 * @version 创建时间：Sep 25, 2017 2:39:22 PM
 */
@Repository
public class OracleDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@DynamicDataSourceAutowired(name = "his")
	public Object readWardareaList() {

		return null;
	}

	@DynamicDataSourceAutowired(name = "his")
	public Object readDepartmentList() {

		return null;
	}

	@DynamicDataSourceAutowired(name = "his")
	public Object readPotherList() {
		List<HisPrescriptionOther> result = new ArrayList<HisPrescriptionOther>();
		StringBuffer sql = new StringBuffer().append("Select * from HIS_PRESCRIPTION_OTHER");

		result = this.jdbcTemplate.query(sql.toString(), new RowMapper<HisPrescriptionOther>() {
			@Override
			public HisPrescriptionOther mapRow(ResultSet rs, int rowNum) throws SQLException {
				HisPrescriptionOther Pother = new HisPrescriptionOther();
				Pother.setPrescriptionId(rs.getString("PRESCRIPTION_ID"));
				Pother.setPatientId(rs.getString("PATIENT_ID"));
				Pother.setCreateDate(rs.getDate("CREAT_DATE"));
				Pother.setCardNumber(rs.getString("CARD_NUMBER"));
				Pother.setPrescriptionName(rs.getString("PRESCRIPTION_NAME"));
				Pother.setFrequency(rs.getString("FREQUENCY"));
				Pother.setPrescriptionNotes(rs.getString("PRESCRIPTION_NOTES"));
				Pother.setStartTime(rs.getDate("START_TIME"));
				Pother.setEndTime(rs.getDate("END_TIME"));
				Pother.setDoctorId(rs.getString("DOCTOR_ID"));
				Pother.setDoctorName(rs.getString("DOCTOR_NAME"));
				Pother.setPrescriptionNo(rs.getString("PRESCRIPTION_NO"));
				Pother.setPrescriptionType(rs.getString("PRESCRIPTION_TYPE"));
				Pother.setRemark(rs.getString("REMARK"));
				Pother.setPrescriptionStatus(rs.getString("PRESCRIPTION_STATUS"));
				Pother.setExt1(rs.getString("EXT1"));
				Pother.setExt2(rs.getString("EXT2"));
				Pother.setExt3(rs.getString("EXT3"));
				
				return Pother;
			}
		});
		return result;
	}

	@DynamicDataSourceAutowired(name = "his")

	public Object readPatientList() {
		List<HisPatient> result = new ArrayList<HisPatient>();
		StringBuffer sql = new StringBuffer().append("Select * from HIS_PATIENT");

		result = this.jdbcTemplate.query(sql.toString(), new RowMapper<HisPatient>() {
			@Override
			public HisPatient mapRow(ResultSet rs, int rowNum) throws SQLException {
				HisPatient Patient = new HisPatient();
				Patient.setPatientId(rs.getString("PATIENT_ID"));
				Patient.setCardNumber(rs.getString("CARD_NUMBER"));
				Patient.setHospitalTimes(rs.getString("HOSPITAL_TIMES"));
				Patient.setPhone(rs.getString("phone"));
				Patient.setName(rs.getString("name"));
				Patient.setIdentifyCard(rs.getString("identify_card"));
				Patient.setGender(rs.getString("gender"));
				Patient.setBirth(rs.getDate("birth"));
				Patient.setAddress(rs.getString("address"));
				Patient.setHospitalDate(rs.getDate("hospital_date"));
				Patient.setDischargeDate(rs.getDate("discharge_date"));
				Patient.setHospitalState(rs.getString("hospital_state"));
				Patient.setGlucoseDiseaseType(rs.getString("glucose_disease_type"));
				Patient.setFirstGlucoseDate(rs.getString("first_glucose_date"));
				Patient.setDoctorId(rs.getString("doctor_id"));
				Patient.setDoctorName(rs.getString("doctor_name"));
				Patient.setFamilyhistory(rs.getString("familyhistory"));
				Patient.setChronicDisease(rs.getString("chronic_disease"));
				Patient.setDepartment(rs.getString("department"));
				Patient.setWardArea(rs.getString("ward_area"));
				Patient.setWardNo(rs.getString("ward_no"));
				Patient.setBedNumber(rs.getString("bed_number"));
				Patient.setProfession(rs.getString("profession"));
				Patient.setWaist(rs.getDouble("waist"));
				Patient.setHeight(rs.getDouble("height"));
				Patient.setWeight(rs.getDouble("weight"));
				Patient.setExt1(rs.getString("ext1"));
				Patient.setExt2(rs.getString("ext2"));
				Patient.setExt3(rs.getString("ext3"));

				return Patient;
			}
		});
		return result;
	}

	@DynamicDataSourceAutowired(name = "his")
	public Object readStaffList() {
		List<HisStaff> result = new ArrayList<HisStaff>();
		StringBuffer sql = new StringBuffer().append("Select * from HIS_STAFF");

		result = this.jdbcTemplate.query(sql.toString(), new RowMapper<HisStaff>() {
			@Override
			public HisStaff mapRow(ResultSet rs, int rowNum) throws SQLException {
				HisStaff staff = new HisStaff();
				staff.setStaffId(rs.getString("STAFF_ID"));
				staff.setUsercode(rs.getString("USERCODE"));
				staff.setPersonname(rs.getString("PERSONNAME"));
				staff.setSex(rs.getString("SEX"));
				staff.setDepartment(rs.getString("DEPARTMENT"));
				staff.setWardArea(rs.getString("WARD_AREA"));
				staff.setTitle(rs.getString("TITLE"));
				staff.setMobile(rs.getString("MOBILE"));
				staff.setDoctorLevel(rs.getString("DOCTOR_LEVEL"));
				staff.setExt1(rs.getString("EXT1"));
				staff.setExt1(rs.getString("EXT2"));
				staff.setExt1(rs.getString("EXT3"));
				return staff;
			}
		});
		return result;
	}

	@DynamicDataSourceAutowired(name = "his")
	public boolean saveBloodGlucoseList() {
		 
		return false;
	}
}
