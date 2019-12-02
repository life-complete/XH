package com.sybercare.hospital.adapters.worker.push.hospital;

import java.util.List;
import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.sybercare.hospital.adapters.entity.HisStaff;
import com.sybercare.hospital.adapters.worker.data.HisDataEvents;
import com.sybercare.hospital.adapters.worker.push.HisBasePushOnWorker;
import com.sybercare.hospital.health.worker.SybWorkEvents;

public class HisPushMianYangSanYuanOnWorker extends HisBasePushOnWorker {
	protected static final Logger LOGGER = LoggerFactory.getLogger(HisPushMianYangSanYuanOnWorker.class);
	
	@Override
	public String versionName() {
		return String.valueOf("绵阳第三医院血糖仪对接");
	}

	@Override
	public HisDataEvents dataSources() {
		return HisDataEvents.MIANYANGSANYUAN;
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
					destJson = this.staffParse(obList, params);//科室员工
					break;
				case SYBPATIENT:
					destJson = this.patientParse(obList, params);//科室患者
					break;
				case SYBPOTHER:
					destJson = this.potherParse(obList, params);//患者医嘱
					break;
				case SYBDEPARTMENT:
					destJson = this.departemtParse(obList, params);//科室信息
					break;
				case SYBWARDAREA:
					destJson = this.wardareaParse(obList);//病区信息
					break;
				default:
					break;
				}
			}
		}
		return destJson;
	}

	private JSONArray wardareaParse(Object obList) {
		return null;
	}

	private JSONArray departemtParse(Object obList, Object params) {
		return null;
	}

	private JSONArray potherParse(Object obList, Object params) {
		return (JSONArray) JSONArray.toJSON(obList);
	}

	private JSONArray patientParse(Object obList, Object params) {
		return (JSONArray) JSONArray.toJSON(obList);
	}

	private JSONArray staffParse(Object obList, Object params) {
//		if (obList != null) {
//			List<HisStaff> staffs = (List<HisStaff>)obList;
//			for (HisStaff hisStaff : staffs) {
//				System.out.println("staff id "+hisStaff.getStaffId() + " "+hisStaff.getSex()+"  "+hisStaff.getTitle());
//			}
//		}
		
		return (JSONArray) JSONArray.toJSON(obList);
	}
}
