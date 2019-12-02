package com.sybercare.hospital.adapters.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.sybercare.hospital.adapters.entity.DataBloodGlucose;
import com.sybercare.hospital.adapters.entity.HisPatient;
import com.sybercare.hospital.adapters.entity.HisPrescriptionOther;
import com.sybercare.hospital.adapters.entity.HisStaff;
import com.sybercare.hospital.common.ds.DynamicDataSourceAutowired;

/**
 * 功能：sqlserver数据库业务实现
 *
 * @author 任梁荣
 * @version 创建时间：Sep 25, 2017 2:38:55 PM
 */
@Repository
public class MssqlDAO {

	protected static final Logger LOGGER = LoggerFactory.getLogger(MssqlDAO.class);

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
		// StringBuffer sql = new StringBuffer().append("Select * from
		// dbo.his_prescription_other where prescription_name like '%血糖%'");
		StringBuffer sql = new StringBuffer().append(
				"Select * from HIS_PRESCRIPTION_OTHER121 where prescription_name like '%血糖%' AND (end_time IS NULL or start_time>=DateAdd(m,-3,getdate())) order by end_time desc ");
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
				Pother.setExt1(rs.getString("ext1"));
				Pother.setExt2(rs.getString("ext2"));
				Pother.setExt3(rs.getString("ext3"));

				return Pother;
			}
		});
		return result;
	}

	@DynamicDataSourceAutowired(name = "his")

	public Object readPatientList() {
		List<HisPatient> result = new ArrayList<HisPatient>();
		StringBuffer sql = new StringBuffer().append("Select * from dbo.his_patient");

		result = this.jdbcTemplate.query(sql.toString(), new RowMapper<HisPatient>() {
			@Override
			public HisPatient mapRow(ResultSet rs, int rowNum) throws SQLException {
				HisPatient Patient = new HisPatient();
				Patient.setPatientId(rs.getString("PATIENT_ID"));
				Patient.setCardNumber(rs.getString("CARD_NUMBER"));
				Patient.setHospitalTimes(rs.getString("hospital_times"));
				Patient.setWist_Band_Code(rs.getString("PATIENT_ID"));
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
				// Patient.setWaist(rs.getDouble("waist"));
				// Patient.setHeight(rs.getDouble("height"));
				// Patient.setWeight(rs.getDouble("weight"));
				if (StringUtils.isNotBlank(rs.getString("waist")) && !rs.getString("waist").equals(""))
					Patient.setWaist(Double.parseDouble(rs.getString("waist")));
				else
					Patient.setWaist(0.0);
				if (StringUtils.isNotBlank(rs.getString("height")) && !rs.getString("height").equals(""))
					Patient.setHeight(Double.parseDouble(rs.getString("height")));
				else
					Patient.setHeight(0.0);
				if (StringUtils.isNotBlank(rs.getString("weight")) && !rs.getString("weight").equals(""))
					Patient.setWeight(Double.parseDouble(rs.getString("weight")));
				else
					Patient.setWeight(0.0);
				// Patient.setExt1(rs.getString("ext1"));
				// Patient.setExt2(rs.getString("ext2"));
				// Patient.setExt3(rs.getString("ext3"));

				return Patient;
			}
		});
		return result;
	}

	@DynamicDataSourceAutowired(name = "his")
	public Object readStaffList() {
		List<HisStaff> result = new ArrayList<HisStaff>();
		StringBuffer sql = new StringBuffer().append("Select * from dbo.his_staff");

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
				staff.setExt1(rs.getString("ext1"));
				staff.setExt2(rs.getString("ext2"));
				staff.setExt3(rs.getString("ext3"));

				return staff;
			}
		});
		return result;
	}

	@DynamicDataSourceAutowired(name = "recv")
	public boolean saveBloodGlucoseList(Object args) {
		if (null != args) {
			// System.out.println("args:"+args);
			try {
				DataBloodGlucose bloodGlucose = JSON.parseObject(args.toString(), DataBloodGlucose.class);
				String id = String.valueOf(bloodGlucose.getId());
				String value = bloodGlucose.getValue();
				String status = bloodGlucose.getStatus();
				Date measureTime = bloodGlucose.getMeasureTime();
				String patientId = bloodGlucose.getPatientId();
				String cardNumber = bloodGlucose.getCardNumber();
				String opratorId = bloodGlucose.getOpratorId();
				if (StringUtils.isNotBlank(opratorId) && opratorId.length() > 10) {
					opratorId = opratorId.substring(0, 10);
				}
				Integer operateState = bloodGlucose.getOpratorState();
				Integer operateType = bloodGlucose.getOpratorType();
				String remark = bloodGlucose.getRemark();
				if (remark == null) {
					remark = "";
				}
				Date lastUpdateTime = bloodGlucose.getLastUpdateTime(); // 回传新增字段
				String ksdm = "1002010102";

				System.out.println("bloodGlucose:" + bloodGlucose.toString());
				// Date entertime = measureTime.getTime()+60000;
				String statuscode = "";
				String statusname = "";
				switch (status) {
				case "0":
					statuscode = "001";
					statusname = "早餐前";
					break;
				case "1":
					statuscode = "004";
					statusname = "早餐后";
					break;
				case "2":
					statuscode = "002";
					statusname = "午餐前";
					break;
				case "3":
					statuscode = "005";
					statusname = "午餐后";
					break;
				case "4":
					statuscode = "003";
					statusname = "晚餐前";
					break;
				case "5":
					statuscode = "006";
					statusname = "晚餐后";
					break;
				case "6":
					statuscode = "006";
					statusname = "晚餐后";
					break;
				case "7":
					statuscode = "006";
					statusname = "晚餐后";
					break;
				case "8":
					statuscode = "006";
					statusname = "晚餐后";
				case "9":
					statuscode = "006";
					statusname = "晚餐后";
					break;
				default:
					break;
				}
				int res1 = 0;
				// int res2 = 0;
				// opratorType = 1;opratorState = 0;

				if (operateType == 1 && operateState == 0) {
					res1 = this.jdbcTemplate.update(
							" insert into dbo.data_blood_glucose( "
									+ "ids, value, status, measure_time, patient_id, card_number, oprator_id, operate_state, operate_type, remark, ksdm) "
									+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
							id, value, status, measureTime, patientId, cardNumber, opratorId, operateState,
							operateType, remark, ksdm);
				} else if (operateType == 2 || operateType == 3 && operateState == 0) {
					res1 = this.jdbcTemplate.update(
							" update dbo.data_blood_glucose set "
									+ " value = ?, status = ?, measure_time = ?, patient_id = ?, card_number = ?, oprator_id = ?, operate_state = ?, operate_type = ?, remark = ?,ksdm = ? where ids = ? ",
							value, status, measureTime, patientId, cardNumber, opratorId, operateState, operateType,
							remark, ksdm, id);
				}
				if (res1 == 0) {
					return false;
				} else {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.debug("saveBloodGlucoseList: " + e);
			}
		}
		return false;
	}
}
