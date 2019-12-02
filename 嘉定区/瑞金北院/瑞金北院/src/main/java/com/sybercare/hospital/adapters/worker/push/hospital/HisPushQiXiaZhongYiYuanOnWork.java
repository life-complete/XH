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
import com.sybercare.hospital.health.worker.SybWorkEvents;

public class HisPushQiXiaZhongYiYuanOnWork extends HisBasePushOnWorker{
protected static final Logger LOGGER = LoggerFactory.getLogger(HisPushQiXiaZhongYiYuanOnWork.class);
	
	@Override
	public String versionName(){
		 return String.valueOf("栖霞中医院对接");
	}
	
	@Override
	public HisDataEvents dataSources(){
		return HisDataEvents.MSSQL;
	}
	
	@Override
	public void update(Observable o,Object arg){
		this.setBasicDataOnWorker(this);
		super.update(o, arg);
	}
	
	@Override
	public Object analysis(Object obList,Object params,Object woker){
		JSONArray destJson = new JSONArray();
		if(woker != null && obList != null){
			if(woker != null && woker instanceof SybWorkEvents){
				SybWorkEvents events = (SybWorkEvents)woker;
				switch(events) {
				case SYBSTAFF:
					destJson = this.staffParse(obList,params);	//员工
					break;
				case SYBPATIENT:
					destJson = this.patientParse(obList,params);//患者
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
	 * 功能：解析一级部门
	 */
	private JSONArray wardareaParse(Object obList) {
		JSONObject srcJson = JSONObject.parseObject(obList.toString());
		List<HisWardarea> wardsList = new ArrayList<HisWardarea>();
		try{
			if(srcJson != null && srcJson.size() > 0){
				String resultCode = srcJson.getString("ResultCode");
				JSONArray records = new JSONArray();
				if(srcJson.get("Records") instanceof JSONArray){
					records = srcJson.getJSONArray("Records");
				} else {
					JSONObject $ = srcJson.getJSONObject("Records");
					records.add($);
				}
				if(resultCode.equals(String.valueOf(0)) && records != null && records.size()>0){
					for(Object o : records) {
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
		} catch (Exception e){
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
		//Constants.params.put(SybWorkEvents.SYBSTAFF, deptParams);
		//Constants.params.put(SybWorkEvents.SYBPATIENT, deptParams);
		return (JSONArray) JSONArray.toJSON(deptList);
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
					String frequency1 = pother.getFrequency();// 频次
					String frequency = null;
					Date endtime = pother.getEndTime();
					if(frequency1 != null && frequency1.equals("st")) {
						frequency="ONCE";
						//临时医嘱则结束时间为空
						endtime=null;
					}
					if(frequency1 != null && frequency1.equals("cxx")){
						frequency="ALWAYS";
					}
			//		System.out.println("________"+frequency1+"__"+frequency);
					String prescriptionNotes = pother.getPrescriptionNotes();// 医嘱编码
					Date starttime = pother.getStartTime();
	
					String doctorId = pother.getDoctorId();
					String doctorName = pother.getDoctorName();
					String prescriptionNo = pother.getPrescriptionNo();
					String prescriptionType = pother.getPrescriptionType();
					String remark = pother.getRemark();
					String prescriptionStatus = pother.getPrescriptionStatus();
					String ext1 = pother.getExt1();
					String ext2 = pother.getExt2();
					String ext3 = pother.getExt3();
												
					HisPrescriptionOther $potherList = new HisPrescriptionOther();
					
					$potherList.setPrescriptionId(orderID);
					$potherList.setPatientId(patientID);
					$potherList.setCardNumber(cardNo);
					$potherList.setCreateDate(createDate);
					$potherList.setFrequency(frequency);
//					if(StringUtils.isNotBlank(frequency) && frequency.equals("ALWAYS")){
//						$potherList.setPrescriptionName("葡萄糖测定(床旁血糖仪检测)");
//					} else {
//						$potherList.setPrescriptionName(prescriptionName);
//					}
//					if(StringUtils.isNotBlank(prescriptionNotes) && !prescriptionNotes.equals("")){
//						$potherList.setPrescriptionNotes(prescriptionName+"/"+prescriptionNotes);
//					}
//					else {
//						$potherList.setPrescriptionNotes(prescriptionName);
//					}
					$potherList.setPrescriptionName(prescriptionName);
					$potherList.setPrescriptionNotes(prescriptionName);
					$potherList.setStartTime(starttime);
					$potherList.setEndTime(endtime);
					$potherList.setDoctorId(doctorId);
					$potherList.setDoctorName(doctorName);
					$potherList.setPrescriptionNo(prescriptionNo);
					$potherList.setPrescriptionType(String.valueOf(0));
					//$potherList.setPrescriptionType(prescriptionType);
					$potherList.setRemark(remark);
					if(StringUtils.isNotBlank(prescriptionStatus) && prescriptionStatus.equals("0"))
						$potherList.setPrescriptionStatus(String.valueOf(0));
					else
						$potherList.setPrescriptionNotes(String.valueOf(1));
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

	private JSONArray patientParse(Object obList, Object params) {
		List<HisPatient> patientList = new ArrayList<HisPatient>();
		try {
			if(obList instanceof ArrayList){
				@SuppressWarnings("unchecked")
				ArrayList<HisPatient> $list = (ArrayList<HisPatient>) obList;
				for(HisPatient patient : $list){
					String patientID = patient.getPatientId();//病人ID
					String cardNo = patient.getCardNumber();//病人就诊卡号
					String wistBandCode = patient.getWist_Band_Code();//腕带码
					String inPatTimes = patient.getHospitalTimes();//住院次数
					String phone = patient.getPhone();//手机号码
					String patientName = patient.getName();//病人姓名
					String iDCardNo = patient.getIdentifyCard();//身份证号码
					String gender = patient.getGender();//性别；0：男；1：女；9：不详
					Date birth = patient.getBirth();//出生日期
					String address = patient.getAddress();//住址
					Date admDate = patient.getHospitalDate();//入院日期
					Date dischargeDate = patient.getDischargeDate();//出院日期
					String dischargeFlag = patient.getHospitalState();//出院标识；0：在院；1：出院
					String depCode = patient.getDepartment();//患者所属科室
					String wardArea = patient.getWardArea();//患者所属病区
					String wardNo = patient.getWardNo();//病区代码
					String bedCode = patient.getBedNumber();//床号
					String doctorID = patient.getDoctorId();//患者所属医生ID
					String doctorName = patient.getDoctorName();//患者所属医生姓名
					String diabetesType = patient.getGlucoseDiseaseType();//糖尿病类型
					String diaDefDate = patient.getFirstGlucoseDate();//糖尿病确诊日期
					String familyHistory = patient.getFamilyhistory();//家族病史
					String anamnesis = patient.getChronicDisease();//以往病史
					double waist = patient.getWaist();//腰围
					double height = patient.getHeight();//身高
					double weight = patient.getWeight();//体重
					String ext1 = patient.getExt1();
					String ext2 = patient.getExt2();
					String ext3 = patient.getExt3();
					
					HisPatient $patientList = new HisPatient();
					
					$patientList.setPatientId(patientID);
					$patientList.setCardNumber(cardNo);
					$patientList.setWist_Band_Code(wistBandCode);
					$patientList.setHospitalTimes(inPatTimes);
					$patientList.setPhone(phone);
					$patientList.setName(patientName);
					$patientList.setIdentifyCard(iDCardNo);
					if(StringUtils.isNotBlank(gender) && gender.equals("0")){
						$patientList.setGender(String.valueOf(0));
					} else if(StringUtils.isNotBlank(gender) && gender.equals("1")){
						$patientList.setGender(String.valueOf(1));
					} else {
						$patientList.setGender(String.valueOf(9));
					}
					$patientList.setBirth(birth);
					$patientList.setAddress(address);
					$patientList.setHospitalDate(admDate);
					$patientList.setDischargeDate(dischargeDate);
					if(StringUtils.isNotBlank(dischargeFlag) && dischargeFlag.equals("0")){
						$patientList.setHospitalState(String.valueOf(0));
					} else {
						$patientList.setHospitalState(String.valueOf(1));
					}
					$patientList.setGlucoseDiseaseType(diabetesType);
					$patientList.setFirstGlucoseDate(diaDefDate);
					$patientList.setDoctorId(doctorID);
					$patientList.setDoctorName(doctorName);
					$patientList.setFamilyhistory(familyHistory);
					$patientList.setChronicDisease(anamnesis);
					$patientList.setDepartment(depCode);
					$patientList.setWardArea(wardArea);
					$patientList.setWardNo(wardNo);
					$patientList.setBedNumber(bedCode);
					$patientList.setWaist(Double.valueOf(waist));
					$patientList.setHeight(Double.valueOf(height));
					$patientList.setWeight(Double.valueOf(weight));
					$patientList.setExt1(ext1);
					$patientList.setExt2(ext2);
					$patientList.setExt3(ext3);
					patientList.add($patientList);
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return (JSONArray)JSONArray.toJSON(patientList);
	}

	/**
	 * 功能:解析科室员工信息
	 * 
	 * @param params
	 */
	private JSONArray staffParse(Object obList, Object params) {
		List<HisStaff> staffList = new ArrayList<HisStaff>();
		try{
			if(obList instanceof ArrayList)	{
				@SuppressWarnings("unchecked")
				ArrayList<HisStaff> $list = (ArrayList<HisStaff>) obList;
				for(HisStaff staff : $list) {
					String userID = staff.getStaffId();//员工ID
					String userCode = staff.getUsercode();//员工工号
					String userName = staff.getPersonname();//姓名
					String userSex = staff.getSex();//性别
					String depCode = staff.getDepartment();//科室编码
					String wardCode = staff.getWardArea();//病区编码
					String title = staff.getTitle();//职务
					if(title!=null&&title.equals("9")) {
						continue;
					}
					String doctorLevel = staff.getDoctorLevel();//职务描述
					String phoneNo = staff.getMobile();//电话
					String ext1 = staff.getExt1();
					String ext2 = staff.getExt2();
					String ext3 = staff.getExt3();
					
					HisStaff $staffList = new HisStaff();
					$staffList.setStaffId(userID);
					$staffList.setUsercode(userCode);
					$staffList.setPersonname(userName);
				
					if(StringUtils.isNotBlank(userSex) && userSex.equals("0")){
						$staffList.setSex(String.valueOf(0));
					} else if(StringUtils.isNotBlank(userSex) && userSex.equals("1")){
						$staffList.setSex(String.valueOf(1));
					} else {
						$staffList.setSex(String.valueOf(9));
					}
					$staffList.setDepartment(depCode);
					$staffList.setWardArea(depCode);	
					//分辨是医生还是护士
					if(StringUtils.isNotBlank(title) && title.equals("0")){
						$staffList.setTitle(String.valueOf(0));
					} else if(StringUtils.isNotBlank(title) && title.equals("1")){
						$staffList.setTitle(String.valueOf(1));
					}else {
						$staffList.setTitle("9");
					}
					$staffList.setDoctorLevel(doctorLevel);
					$staffList.setMobile(phoneNo);
					$staffList.setExt1(ext1);
					$staffList.setExt2(ext2);
					$staffList.setExt3(ext3);
					staffList.add($staffList);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return (JSONArray) JSONArray.toJSON(staffList);
	}
}
