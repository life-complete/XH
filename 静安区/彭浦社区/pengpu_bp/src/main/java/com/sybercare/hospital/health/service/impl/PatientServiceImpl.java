package com.sybercare.hospital.health.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.adapters.entity.HisPatient;
import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.health.dao.DepartmentDAO;
import com.sybercare.hospital.health.dao.PatientDAO;
import com.sybercare.hospital.health.dao.StaffDAO;
import com.sybercare.hospital.health.entity.LogInHospital;
import com.sybercare.hospital.health.entity.PrpScompany;
import com.sybercare.hospital.health.entity.PrpSstaff;
import com.sybercare.hospital.health.entity.User;
import com.sybercare.hospital.health.entity.UserPatient;
import com.sybercare.hospital.health.service.IPatientService;

/**
 * 功能：患者信息数据处理
 *
 * @author 任梁荣
 * @version 创建时间：Sep 22, 2017 6:10:32 PM
 */
@Service
public class PatientServiceImpl implements IPatientService {

	protected static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);

	@Value("${custom.hospital.default.comcode}")
	private String comcode;
	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private StaffDAO staffDAO;
	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	public boolean doPatient(HisPatient patient) {
		if (!this.checkPatientIdValid(patient)) {
			return false;
		}
		User user = null;
		UserPatient userPatient = null;
		LogInHospital logInHospital = new LogInHospital();
		try {
			user = patientDAO.readUserByPatientId(patient.getPatientId());
			if (null == user) {
				if ("1".equals(String.valueOf(patient.getHospitalState()))) {
					return false;
				}
				user = new User();
				userPatient = new UserPatient();
				this.setUser(patient, user);
				patientDAO.saveUser(user);
				this.setUserPatient(patient, user, userPatient);
				patientDAO.saveUserPatient(userPatient);
				this.setLogInHospital(patient, user, logInHospital);
				patientDAO.saveLogInHospital(logInHospital);
			} else {
				userPatient = patientDAO.readUserPatientByPatientId(patient.getPatientId());
				if (null == userPatient) {
					if ("1".equals(String.valueOf(patient.getHospitalState()))) {
						return true;
					}
					userPatient = new UserPatient();
					this.setUserPatient(patient, user, userPatient);
					patientDAO.saveUserPatient(userPatient);
					setLogInHospital(patient, user, logInHospital);
					patientDAO.saveLogInHospital(logInHospital);
				} else {
					if (null != patient.getHospitalState() && null != userPatient.getInHospitalStatus()) {
						if (!userPatient.getInHospitalStatus().equals(String.valueOf(patient.getHospitalState()))) {
							setLogInHospital(patient, user, logInHospital);
							patientDAO.saveLogInHospital(logInHospital);
						}
					}
					this.setUserPatient(patient, user, userPatient);
					patientDAO.updateUserPatientByCardNumber(userPatient);
				}
				setUser(patient, user);
				patientDAO.updateUserByUserId(user);
			}
			return true;
		} catch (Exception e) {
			LOGGER.debug("doPatient: " + e);
		}
		return false;

	}

	private void setLogInHospital(HisPatient patient, User user, LogInHospital logInHospital) {
		logInHospital.setUserId(user.getUserId());
		if (null != patient.getHospitalDate()) {
			logInHospital.setHospitalDate(Timestamp.valueOf(DateUtils.fmtDate(patient.getHospitalDate(), 16)));
		}
		if (null != patient.getDischargeDate()) {
			logInHospital.setDischargeDate(Timestamp.valueOf(DateUtils.fmtDate(patient.getDischargeDate(), 16)));
		}
		logInHospital.setHospitalizationNumber(patient.getCardNumber());
		logInHospital.setDoctorName(patient.getDoctorName());
	}

	private void setUserPatient(HisPatient patient, User user, UserPatient userPatient) {
		userPatient.setUserId(user.getUserId());
		userPatient.setInHospitalId(patient.getPatientId());
		userPatient.setCardNumber(patient.getCardNumber());
		userPatient.setHospitalTimes(patient.getHospitalTimes());
		if (null != patient.getHospitalDate()) {
			userPatient.setHospitalDate(DateUtils.fmtDate(patient.getHospitalDate(), 16));
		}
		if (null != patient.getDischargeDate()) {
			userPatient.setDischargeDate(DateUtils.fmtDate(patient.getDischargeDate(), 16));
		}
		userPatient.setInHospitalStatus(patient.getHospitalState());
		
		boolean isDepExist=false;
		// 科室
		if (StringUtils.isNotBlank(patient.getDepartment())) {
			List<PrpScompany> prpScompanys = departmentDAO.readPrpScompanyByHisCode(patient.getDepartment());
			if (null != prpScompanys && prpScompanys.size() > 0) {
				for (PrpScompany prpScompany : prpScompanys) {
					String departmentCode = prpScompany.getComCode();
					if (StringUtils.isNotBlank(departmentCode) && departmentCode.length() == 12) {
						String code = departmentCode.substring(0, 8);
						if (comcode.equals(code)) {
							isDepExist=true;
							userPatient.setDepartment(departmentCode);
							break;
						}
					}
				}
			}
		}
		
		boolean isWardExist=false;
		// 病区
		if (StringUtils.isNotBlank(patient.getWardArea())) {
			List<PrpScompany> prpScompanys = departmentDAO.readPrpScompanyByHisCode(patient.getWardArea());
			if (null != prpScompanys && prpScompanys.size() > 0) {
				for (PrpScompany prpScompany : prpScompanys) {
					String wardAreaCode = prpScompany.getComCode();
					if (StringUtils.isNotBlank(wardAreaCode) && wardAreaCode.length() == 16) {
						String code = wardAreaCode.substring(0, 8);
						if (comcode.equals(code)) {
							isWardExist=true;
							userPatient.setWardArea(wardAreaCode);
							break;
						}
					}
				}
			}
		}
		
		if(!isWardExist && !isDepExist){//如果没有归属科室则，归属于医院
			String dep = userPatient.getDepartment();
			if(dep != null && dep.length()==12){
				String newDep = dep.substring(0, 8);
				userPatient.setDepartment(newDep);
				userPatient.setWardArea(null);
			}
		}
		// 病房
		if (StringUtils.isNotBlank(patient.getWardNo())) {
			List<PrpScompany> prpScompanys = departmentDAO.readPrpScompanyByHisCode(patient.getWardNo());
			if (null != prpScompanys && prpScompanys.size() > 0) {
				for (PrpScompany prpScompany : prpScompanys) {
					String wardNoCode = prpScompany.getComCode();
					if (StringUtils.isNotBlank(wardNoCode) && wardNoCode.length() == 20) {
						String code = wardNoCode.substring(0, 8);
						if (comcode.equals(code)) {
							userPatient.setWardNo(wardNoCode);
							break;
						}
					}
				}
			}
		}
		userPatient.setBedNumber(patient.getBedNumber());
	}

	private void setUser(HisPatient patient, User user) {
		user.setName(patient.getName());
		user.setInHospitalId(patient.getPatientId());
		user.setPhone(patient.getPhone());
		user.setIdentifyCard(patient.getIdentifyCard());
		if (null != patient.getGender()) {
			user.setGender(Integer.parseInt(patient.getGender()));
		}
		if (null != patient.getBirth()) {
			user.setBirth(patient.getBirth());
			user.setAge(getAge(DateUtils.fmtDate(patient.getBirth(), 13)));
		}
		user.setAddress(patient.getAddress());
		user.setGlucoseDiseaseType(patient.getGlucoseDiseaseType());
		if (StringUtils.isNotBlank(patient.getDoctorId())) {
			PrpSstaff prpSstaff = staffDAO.readPrpSstaffByUserCode(patient.getDoctorId());
			if (null != prpSstaff) {
				user.setServicePersonId(prpSstaff.getPersonID());
				user.setDoctorName(prpSstaff.getPersonName());
			}
		}
		user.setFamilyHistory(patient.getFamilyhistory());
		user.setChronicDisease(patient.getChronicDisease());
		user.setProfession(patient.getProfession());
		user.setWaist(patient.getWaist());
		user.setHeight(patient.getHeight());
		user.setWeight(patient.getWeight());
		user.setStatus(1);
		user.setCreateTime(new Date());
		user.setUpdateTime(patient.getHospitalDate());
		user.setSourceComcode(comcode);
		user.setWrist_Band_Code(patient.getWist_Band_Code());
	}

	public int getAge(String string) {
		if (string == null)
			throw new RuntimeException("出生日期不能为null");
		int age = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birthDate = sdf.parse(string);
			Date now = new Date();
			SimpleDateFormat format_y = new SimpleDateFormat("yyyy");
			SimpleDateFormat format_M = new SimpleDateFormat("MM");
			SimpleDateFormat format_D = new SimpleDateFormat("dd");

			String birth_year = format_y.format(birthDate);
			String this_year = format_y.format(now);

			String birth_month = format_M.format(birthDate);
			String this_month = format_M.format(now);

			// 初步，估算
			age = Integer.parseInt(this_year) - Integer.parseInt(birth_year);
			// 如果未到出生月份，则age - 1
			if (this_month.compareTo(birth_month) < 0) {
				age -= 1;
			} else if (this_month.compareTo(birth_month) == 0) {
				String birth_day = format_D.format(birthDate);
				String this_day = format_D.format(now);
				if (this_day.compareTo(birth_day) < 0) {
					age -= 1;
				}
			}

			if (age < 0)
				age = 0;
		} catch (ParseException e) {
			LOGGER.debug("getAge: " + e);
		}
		return age;
	}

	@Override
	public List<UserPatient> getUserPatientByInHospitalState(String state) {
		List<UserPatient> userPatientList = patientDAO.getUserPatientByInHospitalState(state);
		return userPatientList;
	}

	protected boolean checkPatientIdValid(HisPatient hisPatient) {
		if (null == hisPatient || null == hisPatient.getPatientId()) {
			return false;
		}
		return true;
	};

}
