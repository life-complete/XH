package com.sybercare.hospital.health.worker.recv;

import java.util.Date;
import java.util.Observable;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.adapters.entity.HisPrescriptionOther;
import com.sybercare.hospital.common.utils.BaseObserver;
import com.sybercare.hospital.common.utils.Constants;
import com.sybercare.hospital.common.utils.WorkAutowired;
import com.sybercare.hospital.health.service.IPatientService;
import com.sybercare.hospital.health.service.IPrescriptionOtherService;

/**
 * 功能：接收处理监测医嘱信息
 * 
 * @author 任梁荣
 * */
public class SybRecvPrescriptionOtherOnWorker implements BaseObserver {

	@WorkAutowired
	private IPrescriptionOtherService prescriptionOtherService;

	@WorkAutowired
	private IPatientService patientService;

	@Override
	public void update(Observable o, Object arg) {
		Object[] args = (Object[]) arg;
		if (args != null && args.length > 0) {
			JSONArray json = (JSONArray) args[0];
			if (json != null) {
				json.forEach(other -> {
					HisPrescriptionOther $other = JSONObject.parseObject(other.toString(), HisPrescriptionOther.class);
					this.prescriptionOtherService.doPOther($other);
					//System.out.println(other.toString());
				});
				System.out.println(Constants.convert((new Date()), Constants.format2) + " 医嘱同步完成");
			}
		}
	}

}
