package com.sybercare.hospital.health.service;
import com.sybercare.hospital.common.utils.annotation.DateUtils;
import com.sybercare.hospital.health.entity.SysPatient;
import com.sybercare.hospital.health.entity.SysPatientBmi;
import com.sybercare.hospital.health.mappering.TripartiteDeviceMapper;
import com.sybercare.hospital.health.entity.DataBeiTai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TripartiteDeviceServiceImpl implements ITripartiteDeviceService {
	@Autowired
	private TripartiteDeviceMapper deviceMapper;

	@Override
	public void uploadBmi(DataBeiTai dataBmi) {
		SysPatient patient = deviceMapper.selectPatientByPhoneAndIdCard(dataBmi.getPhone(), dataBmi.getIdcard());
		if (patient == null) {
			patient = new SysPatient();
			if(dataBmi.getDid().equals("2019082419072633005004")){
				patient.setDeptId(Long.valueOf(350));
			}
			else{
				patient.setDeptId(Long.valueOf(352));
			}
			patient.setMobile(dataBmi.getPhone());
			patient.setIdCard(dataBmi.getIdcard());
			patient.setWeight(dataBmi.getData().getWeight());
			patient.setHigh(dataBmi.getData().getHeight());
			patient.setPatientName(dataBmi.getName());
			patient.setBmi(Double.parseDouble(dataBmi.getData().getBmi()));
			patient.setStatus("0");
			patient.setUserType("other");
			patient.setCreateTime(new Date());
			patient.setCreateBy(dataBmi.getDtype());
			patient.setSex(dataBmi.getGender());
			patient.setBirth(dataBmi.getBirth());
			deviceMapper.insertPatient(patient);
			patient = deviceMapper.selectPatientByPhoneAndIdCard(dataBmi.getPhone(), dataBmi.getIdcard());
		} else {
			if (dataBmi.getPhone() != null) {
				patient.setMobile(dataBmi.getPhone());
			}
			if (dataBmi.getIdcard() != null) {
				patient.setIdCard(dataBmi.getIdcard());
				patient.setSex(dataBmi.getGender());
				patient.setBirth(dataBmi.getBirth());
			}
			patient.setHigh(dataBmi.getData().getHeight());
			patient.setWeight(dataBmi.getData().getWeight());
			patient.setBmi(Double.parseDouble(dataBmi.getData().getBmi()));
			patient.setUpdateTime(new Date());
			patient.setUpdateBy(dataBmi.getDtype());
			
			deviceMapper.updatePatient(patient);
		}
		SysPatientBmi patientBmi = new SysPatientBmi();
		patientBmi.setBmi(dataBmi.getData().getBmi());
		patientBmi.setHigh(dataBmi.getData().getHeight());
		patientBmi.setWeight(dataBmi.getData().getWeight());
		patientBmi.setCreateTime(new Date());
		patientBmi.setCreateBy(dataBmi.getDtype());
		patientBmi.setPatientId(patient.getPatientId());
		//patientBmi.setMeasureTime(DateUtils.dateTime("yyyy-MM-dd hh:mm:ss", dataBmi.getData().getTime()));
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(0);
		Date currentTime_2 = formatter.parse(dateString, pos);
		patientBmi.setMeasureTime(currentTime_2);
		String bmiResult = null;
		double bmi = Double.parseDouble(dataBmi.getData().getBmi());
		if (bmi <= 18.4) {
			bmiResult = "偏瘦";
		} else if (bmi < 24) {
			bmiResult = "正常";
		} else if (bmi < 28) {
			bmiResult = "过重";
		} else {
			bmiResult = "肥胖";
		}
		patientBmi.setBmiResult(bmiResult);
		deviceMapper.insertPatientBmi(patientBmi);
	}

}
