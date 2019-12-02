package com.sybercare.hospital.adapters.worker.push.hospital;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.adapters.entity.HisDepartment;
import com.sybercare.hospital.adapters.entity.HisPatient;
import com.sybercare.hospital.adapters.entity.HisPrescriptionOther;
import com.sybercare.hospital.adapters.entity.HisStaff;
import com.sybercare.hospital.adapters.entity.HisWardarea;
import com.sybercare.hospital.adapters.worker.data.HisDataEvents;
import com.sybercare.hospital.adapters.worker.push.HisBasePushOnWorker;
import com.sybercare.hospital.common.utils.Constants;
import com.sybercare.hospital.health.worker.SybWorkEvents;

//import oracle.sql.DATE;

public class HisPushEEDuoSiZXYiYuanOnWorker extends HisBasePushOnWorker {
	protected static final Logger LOGGER = LoggerFactory.getLogger(HisPushEEDuoSiZXYiYuanOnWorker.class);

	@Override
	public String versionName() {
		return String.valueOf("鄂尔多斯中心医院对接");
	}

	@Override
	public HisDataEvents dataSources() {
		return HisDataEvents.ORACLE;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setBasicDataOnWorker(this);
		super.update(o, arg);
	}

	@Override
	public Object analysis(Object obList, Object params, Object woker) {
		JSONArray destJson = new JSONArray();
		if (woker != null && obList != null) {
			if (woker != null && woker instanceof SybWorkEvents) {
				SybWorkEvents events = (SybWorkEvents) woker;
				switch (events) {
				case SYBSTAFF:
					destJson = this.staffParse(obList, params);// 科室员工
					break;
				case SYBPATIENT:
					destJson = this.patientParse(obList, params);// 科室患者
					break;
				case SYBPOTHER:
					destJson = this.potherParse(obList, params);// 患者医嘱
					break;
				case SYBDEPARTMENT:
					destJson = this.departemtParse(obList, params);// 二级部门
					break;
				case SYBWARDAREA:
					destJson = this.wardareaParse(obList);// 一级部门
					break;
				default:
					break;
				}
			}
		}
		return destJson;
	}

	/**
	 * 功能：解析科室员工信息
	 * 
	 * @param params
	 */
	private JSONArray staffParse(Object obList, Object params) {
		List<HisStaff> staffList = new ArrayList<HisStaff>();
		try {
			if (obList instanceof ArrayList) {
				@SuppressWarnings("unchecked")
				ArrayList<HisStaff> $list = (ArrayList<HisStaff>) obList;
				for (HisStaff staff : $list) {
					String userID = staff.getStaffId();// 员工Id
					String userCode = staff.getUsercode();// 员工工号
					String userName = staff.getPersonname();// 姓名
					String userSex = staff.getSex();// 性别
					String depCode = staff.getDepartment();// 科室编码
					String wardCode = staff.getWardArea();// 病区编码
					String title = staff.getTitle();// 职务
					String doctorLevel = staff.getDoctorLevel();// 医护级别描述（不是职务）
					String phoneNo = staff.getMobile();// 电话;无此信息
					String ext1 = staff.getExt1();
					String ext2 = staff.getExt2();
					String ext3 = staff.getExt3();

					// String internalType =
					// json.getString("InternalType");//DOCTOR:医生;NURSE:护士;Technician:技师;Pharmacist:药师
					// String validFlag =
					// json.getString("ValidFlag");//可用标志；0：作废；1：有效

					HisStaff $stafflist = new HisStaff();
					$stafflist.setStaffId(userID);
					$stafflist.setUsercode(userCode);
					$stafflist.setPersonname(userName);
				    $stafflist.setSex(userSex);
					$stafflist.setDepartment(depCode);
					if (StringUtils.isNotBlank(title) && title.equals("医生"))
						$stafflist.setTitle(String.valueOf(0));
					else
						$stafflist.setTitle(String.valueOf(1));
					$stafflist.setMobile(phoneNo);
					$stafflist.setWardArea(wardCode);
					$stafflist.setDoctorLevel(doctorLevel);
					$stafflist.setExt1(ext1);
					$stafflist.setExt2(ext2);
					$stafflist.setExt3(ext3);
					staffList.add($stafflist);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (JSONArray) JSONArray.toJSON(staffList);
	}

	/**
	 * 功能：解析科室患者
	 */
	private JSONArray patientParse(Object obList, Object params) {
		List<String> patientParams = new ArrayList<String>();
		List<HisPatient> patientList = new ArrayList<HisPatient>();
		try {
			if (obList instanceof ArrayList) {
				@SuppressWarnings("unchecked")
				ArrayList<HisPatient> $list = (ArrayList<HisPatient>) obList;
				for (HisPatient patient : $list) {
					String patientID = patient.getPatientId();// 病人Id
					String cardNo = patient.getCardNumber();// 病人就诊卡号
					String inPatTimes = patient.getHospitalTimes();// 住院次数
					String phone = patient.getPhone();// 手机号码
					String patientName = patient.getName();// 病人姓名
					String iDCardNo = patient.getIdentifyCard();// 身份证号码
					String gender = patient.getGender();// 性别；男、女、不确定
					Date birth = patient.getBirth();// 出生日期；格式：1840-01-01
					String address = patient.getAddress();// 住址
					Date admDate = patient.getHospitalDate();// 入院日期；格式：1840-01-01
					Date dischargeDate = patient.getDischargeDate();// 出院日期；格式：1840-01-01
					String dischargeFlag = patient.getHospitalState();// 出院标志；0：在院1：出院
					String depCode = patient.getDepartment();// 患者住院所属科室编码
					String wardCode = patient.getWardArea();// 患者住院所属病
					String roomDesc = patient.getWardNo();// 病房名称；
					String bedCode = patient.getBedNumber();// 床号名称
					String doctorID = patient.getDoctorId();// 医生ID
					String doctorName = patient.getDoctorName();// 医生姓名
					String diabetesType = patient.getGlucoseDiseaseType();// 糖尿病类型;
					String diaDefDate = patient.getFirstGlucoseDate();// 糖尿病确诊日期;
					String familyHistory = patient.getFamilyhistory();// 家族病史；
					String anamnesis = patient.getChronicDisease(); // 既往病史；
					double waist = patient.getWaist();// 腰围
					double height = patient.getHeight();// 身高
					double weight = patient.getWeight();// 体重
					String ext1 = patient.getExt1();
					String ext2 = patient.getExt2();
					String ext3 = patient.getExt3();					

					HisPatient $patientList = new HisPatient();
					
					$patientList.setPatientId(patientID);
					$patientList.setCardNumber(cardNo);
					$patientList.setHospitalTimes(inPatTimes);
					$patientList.setPhone(phone);
					$patientList.setName(patientName);
					$patientList.setIdentifyCard(iDCardNo);
					$patientList.setGender(String.valueOf(9));
					if (StringUtils.isNotBlank(gender) && gender.equals("男")) {
						$patientList.setGender(String.valueOf(0));
					} else if (StringUtils.isNotBlank(gender) && gender.equals("女")) {
						$patientList.setGender(String.valueOf(1));
					}
					$patientList.setBirth(birth);
					$patientList.setAddress(address);
					$patientList.setHospitalDate(admDate);
					$patientList.setDischargeDate(dischargeDate);
					$patientList.setHospitalState(dischargeFlag);				
					$patientList.setGlucoseDiseaseType(diabetesType);
					$patientList.setFirstGlucoseDate(diaDefDate);
					$patientList.setDoctorId(doctorID);
					$patientList.setDoctorName(doctorName);
					$patientList.setFamilyhistory(familyHistory);
					$patientList.setChronicDisease(anamnesis);
					$patientList.setDepartment(depCode);
					$patientList.setWardArea(wardCode);
					$patientList.setWardNo(roomDesc);
					$patientList.setBedNumber(bedCode);
					$patientList.setWaist(Double.valueOf(waist));
					$patientList.setHeight(Double.valueOf(height));
					$patientList.setWeight(Double.valueOf(weight));
					$patientList.setExt1(ext1);
					$patientList.setExt2(ext2);
					$patientList.setExt3(ext3);
					patientList.add($patientList);
					patientParams.add(cardNo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Constants.params.put(SybWorkEvents.SYBPOTHER, patientParams);
		return (JSONArray) JSONArray.toJSON(patientList);
	}

	/**
	 * 功能：患者医嘱数据
	 */
	private JSONArray potherParse(Object obList, Object params) {

		List<HisPrescriptionOther> potherList = new ArrayList<HisPrescriptionOther>();

		try {
			if (obList instanceof ArrayList) {
				@SuppressWarnings("unchecked")
				ArrayList<HisPrescriptionOther> $list = (ArrayList<HisPrescriptionOther>) obList;
				for (HisPrescriptionOther pother : $list) {
					
					String orderID = pother.getPrescriptionId();// 医嘱ID
					String patientID = pother.getPatientId();// 病人ID，病人唯一标识。
					String cardNo = pother.getCardNumber();// 住院号
					Date createDate = pother.getCreateDate();// 创建日期
					String prescriptionName = pother.getPrescriptionName(); // 医嘱名称
					String frequency = pother.getFrequency();// 频次
					String prescriptionNotes = pother.getPrescriptionNotes();// 医嘱编码
					Date starttime = pother.getStartTime();
					Date endtime = pother.getEndTime();
					String doctorId = pother.getDoctorId();
					String doctorName = pother.getDoctorName();
					String prescriptionNo = pother.getPrescriptionNo();
					String prescriptionType = pother.getPrescriptionType();
					String remark = pother.getRemark();
					String prescriptionStatus = pother.getPrescriptionStatus();
					String ext1 = pother.getExt1();
					String ext2 = pother.getExt2();
					String ext3 = pother.getExt3();
					
					if (orderID == null || "".equalsIgnoreCase(orderID)) {
						continue;
					}
					
					if (patientID == null || "".equalsIgnoreCase(patientID)) {
						continue;
					}
					
					HisPrescriptionOther $potherList = new HisPrescriptionOther();
					
					$potherList.setPrescriptionId(orderID);
					$potherList.setPatientId(patientID);
					$potherList.setCardNumber(cardNo);
					$potherList.setCreateDate(createDate);
					$potherList.setPrescriptionName(prescriptionName);
					$potherList.setFrequency(frequency);
					if(StringUtils.isNotBlank(prescriptionNotes)){
						$potherList.setPrescriptionNotes(prescriptionNotes);}
					else {
					$potherList.setPrescriptionNotes(prescriptionName);}
					$potherList.setStartTime(starttime);
					$potherList.setEndTime(endtime);
					$potherList.setDoctorId(doctorId);
					$potherList.setDoctorName(doctorName);
					$potherList.setPrescriptionNo(prescriptionNo);
					$potherList.setPrescriptionType(String.valueOf(0));
					$potherList.setRemark(remark);
					$potherList.setPrescriptionStatus(prescriptionStatus);
					$potherList.setExt1(ext1);
					$potherList.setExt2(ext2);
					$potherList.setExt3(ext3);
					potherList.add($potherList);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (JSONArray) JSONArray.toJSON(potherList);
	}

	/**
	 * 功能：解析一级部门
	 */
	private JSONArray wardareaParse(Object obList) {
		JSONObject srcJson = JSONObject.parseObject(obList.toString());
		List<HisWardarea> wardsList = new ArrayList<HisWardarea>();
		try {
			if (srcJson != null && srcJson.size() > 0) {
				String resultCode = srcJson.getString("ResultCode");
				JSONArray records = new JSONArray();
				if (srcJson.get("Records") instanceof JSONArray) {
					records = srcJson.getJSONArray("Records");
				} else {
					JSONObject $ = srcJson.getJSONObject("Records");
					records.add($);
				}
				if (resultCode.equals(String.valueOf(0)) && records != null && records.size() > 0) {
					for (Object o : records) {
						JSONObject json = (JSONObject) o;

						Long wardID = json.getLong("WardID");// 病区ID
						String wardCode = json.getString("WardCode");// 病区代码
						String wardDesc = json.getString("WardDesc");// 病区名称
						String depCode = json.getString("DepCode");// 所属科室
						String validFlag = json.getString("ValidFlag");// 可用标志；0：作废；1：有效

						HisWardarea wards = new HisWardarea();
						wards.setId(wardID);
						wards.setWardareaCode(wardCode);
						wards.setWardareaName(wardDesc);
						wards.setDepartmentCode(depCode);
						wards.setOrder(Long.valueOf(0));
						wards.setValidFlag(Integer.valueOf(validFlag));
						wardsList.add(wards);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (JSONArray) JSONArray.toJSON(wardsList);
	}

	/**
	 * 功能：解析二级部门
	 */
	private JSONArray departemtParse(Object obList, Object params) {
		JSONObject srcJson = JSONObject.parseObject(obList.toString());
		List<String> deptParams = new ArrayList<String>();// 寄存科室Id参数
		List<HisDepartment> deptList = new ArrayList<HisDepartment>();
		try {
			if (srcJson != null && srcJson.size() > 0) {
				String resultCode = srcJson.getString("ResultCode");
				if (srcJson.get("Records") != null && resultCode.equals(String.valueOf(0))) {
					if (srcJson.get("Records") instanceof JSONArray) {
						JSONArray records = srcJson.getJSONArray("Records");
						if (records.size() > 0) {
							for (Object o : records) {
								JSONObject json = (JSONObject) o;
								Long depId = json.getLong("DepID");// 科室ID
								String depCode = json.getString("DepCode");// 科室代码
								String depDesc = json.getString("DepDesc");// 科室名称
								Integer validFlag = json.getInteger("ValidFlag");// 可用标志；0：作废；1：有效
								HisDepartment depts = new HisDepartment();
								depts.setId(depId);
								depts.setDepartmentName(depDesc);
								depts.setDepartmentCode(depCode);
								depts.setValidFlag(validFlag);
								deptList.add(depts);
								String value = depId.toString();
								if (!deptParams.contains(value)) {
									deptParams.add(value);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Constants.params.put(SybWorkEvents.SYBSTAFF, deptParams);
		Constants.params.put(SybWorkEvents.SYBPATIENT, deptParams);
		return (JSONArray) JSONArray.toJSON(deptList);
	}
}
