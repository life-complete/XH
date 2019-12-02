package com.sybercare.hospital.adapters.worker.data;

import java.sql.Connection;
import java.util.ArrayList;

import com.sybercare.hospital.adapters.service.IDataCacheDBService;
import com.sybercare.hospital.common.utils.IDataOnWorker;
import com.sybercare.hospital.common.utils.WorkAutowired;
import com.sybercare.hospital.health.worker.SybWorkEvents;

public class HisDataCacheDBOnWorker implements IDataOnWorker {

	@WorkAutowired
	private IDataCacheDBService dataCacheDBService;
	
	private Connection getConnection(){
		Connection dbconn = null;
		try {
			Class.forName("com.intersys.jdbc.CacheDriver").newInstance();
			//CacheDataSource ds = new CacheDataSource();
			//ds.setURL("jdbc:Cache://10.0.0.137:1972/HSD");
//			dbconn = ds.getConnection("xtuser", "xtuser");
			//dbconn = ds.getConnection("_SYSTEM", "SYS");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dbconn;
	} 

	@Override
	public String versionName() {
		return String.valueOf("CacheDB数据实现");
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
		return null;
	}

	private Object readDepartmentHandler(Object params) {
		return null;
	}

	private Object readPotherHandler(Object params) {
		return this.dataCacheDBService.readPother(this.getConnection(),params);
	}

	private Object readPatientHandler(Object params) {
		return this.dataCacheDBService.readPatient(this.getConnection(),params);
	}

	private Object readStaffHandler(Object params) {
		return this.dataCacheDBService.readStaff(this.getConnection(),params);
	}

	@Override
	public boolean recvData(Object args) {
		return false;
	}

}
