package com.sybercare.hospital.health.worker.recv;

import java.util.Date;
import java.util.Observable;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.adapters.entity.HisPatient;
import com.sybercare.hospital.common.utils.BaseObserver;
import com.sybercare.hospital.common.utils.Constants;
import com.sybercare.hospital.common.utils.WorkAutowired;
import com.sybercare.hospital.health.service.IPatientService;

/**
 * 功能：接收处理患者信息
 * 
 * @author 任梁荣
 * */
public class SybRecvPatientOnWorker implements BaseObserver {

	@WorkAutowired
	private IPatientService patientService;

	@Override
	public void update(Observable o, Object arg) {
		Object[] args = (Object[]) arg;
		if (args != null && args.length > 0) {
			JSONArray json = (JSONArray) args[0];
			if (json != null) {
				json.forEach(patient -> {
					//System.out.println(patient.toString());
					HisPatient $patient = JSONObject.parseObject(patient.toString(), HisPatient.class);
					this.patientService.doPatient($patient);
				});
				System.out.println(Constants.convert((new Date()), Constants.format2) + " 患者同步完成");
			}
		}
	}
}
