package com.sybercare.hospital.adapters.worker.data;

import java.util.ArrayList;

import com.sybercare.hospital.adapters.service.IDataOracleService;
import com.sybercare.hospital.adapters.service.ITuserService;
import com.sybercare.hospital.common.utils.IDataOnWorker;
import com.sybercare.hospital.common.utils.WorkAutowired;
import com.sybercare.hospital.health.worker.SybWorkEvents;

/**
 * 功能：HIS对接业务实现,ORACLE版
 * 
 * @author 任梁荣
 * */
public class HisDataOracleOnWorker implements IDataOnWorker {

	@WorkAutowired
	private ITuserService tuserService;
	@WorkAutowired
	private IDataOracleService dataOracleService;

	@Override
	public String versionName() {
		return String.valueOf("ORACLE实现版本");
	}
	
	@Override
	public Object readData(Object woker, Object params) {
		Object result = new ArrayList<Object>();
		if (woker != null && woker instanceof SybWorkEvents) {
			SybWorkEvents events = (SybWorkEvents) woker;
			switch (events) {
			case SYBSTAFF:
				result = this.readStaffHandler(params);
				break;
			case SYBPATIENT:
				result = this.readPatientHandler(params);
				break;
			case SYBPOTHER:
				result = this.readPotherHandler(params);
				break;
			case SYBDEPARTMENT:
				result = this.readDepartmentHandler(params);
				break;
			case SYBWARDAREA:
				result = this.readWardareaHandler(params);
				break;
			default:
				break;
			}
		}
		return result;
	}

	private Object readWardareaHandler(Object params) {
		return this.dataOracleService.getWardareaList(params);
	}

	private Object readDepartmentHandler(Object params) {
		return this.dataOracleService.getDepartmentList(params);
	}

	private Object readPotherHandler(Object params) {
		return this.dataOracleService.getPotherList(params);
	}

	private Object readPatientHandler(Object params) {
		return this.dataOracleService.getPatientList(params);
	}

	private Object readStaffHandler(Object params) {
	
		return this.dataOracleService.getStaffList(params);
	}

	@Override
	public boolean recvData(Object args) {
       
		return this.dataOracleService.saveBloodGlucose(args);
	}
}
