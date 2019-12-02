package com.sybercare.hospital.health.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sybercare.hospital.health.entity.BloodGlucose;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.adapters.entity.DataBloodGlucose;
import com.sybercare.hospital.common.utils.Constants;
import com.sybercare.hospital.health.dao.BloodGlucoseDAO;
import com.sybercare.hospital.health.dao.PatientDAO;
import com.sybercare.hospital.health.dao.StaffDAO;
import com.sybercare.hospital.health.entity.PrpSstaff;
import com.sybercare.hospital.health.service.IBloodGlucoseService;

@Service
public class BloodGlucoseServiceImpl implements IBloodGlucoseService {

	@Autowired
	private BloodGlucoseDAO bloodGlucoseDAO;
	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private StaffDAO staffDAO;

	@Override
	public List<Object> getBloodGlucoseByOperateState(Integer operateState) {
		List<BloodGlucose> bloodGlucoses = bloodGlucoseDAO.getBloodGlucoseByOperateState(operateState);
		List<Object> objList = new ArrayList<Object>();
		if (null != bloodGlucoses && bloodGlucoses.size() > 0) {
			for (BloodGlucose bloodGlucose : bloodGlucoses) {
				DataBloodGlucose bg = new DataBloodGlucose();
				bg.setId(bloodGlucose.getId());
				if(null != bloodGlucose.getValue()){
					bg.setValue(String.valueOf(bloodGlucose.getValue()));
				}
				if(null != bloodGlucose.getMeasureTime()){
					bg.setMeasureTime(Constants.convert(bloodGlucose.getMeasureTime(), Constants.format2));
				}
//				if (StringUtils.isNotBlank(bloodGlucose.getUserId())) {
//					UserPatient userPatient = patientDAO.readUserPatientByUserId(bloodGlucose.getUserId());
//					if (null != userPatient) {
//						bg.setPatientId(userPatient.getInHospitalId());
//						bg.setCardNumber(userPatient.getCardNumber());
//						bg.setDepartment(userPatient.getDepartment());
//					}
//				}
				if (StringUtils.isNotBlank(bloodGlucose.getOpratorId())) {
					PrpSstaff prpSstaff = staffDAO.readPrpSstaffByPersonID(bloodGlucose.getOpratorId());
					if (null != prpSstaff) {
						bg.setOpratorId(prpSstaff.getUserCode());
					}
				}
				if(null != bloodGlucose.getStatus()){
					bg.setStatus(String.valueOf(bloodGlucose.getStatus()));
				}
				bg.setOpratorType(bloodGlucose.getOperateType());
				bg.setOpratorState(bloodGlucose.getOperateState());
				//bg.setRemark(bloodGlucose.getRemark());
				bg.setRemark("1");
				/*if(null != bloodGlucose.getLastUpdateTime()){
					bg.setLastUpdateTime((Constants.convert(bloodGlucose.getLastUpdateTime(), Constants.format2)));
				}*/
				objList.add(bg);
			}
		}
		return objList;
	}

	@Override
	public void modifyOperateState(List<JSONObject> result) {
		if (null != result && result.size() > 0) {
			for (int i = 0; i < result.size(); i++) {
				Long id = null;
				JSONObject job = result.get(i);
				if(null != job.get("Id")){
					id = Long.valueOf(job.get("Id").toString());
				}
				if(null != job.get("PushResult") && Boolean.parseBoolean(job.get("PushResult").toString()) == true){
					bloodGlucoseDAO.updateBloodGlucoseOperateState(id, (short)1);
				}
			}
		}
	}

}
