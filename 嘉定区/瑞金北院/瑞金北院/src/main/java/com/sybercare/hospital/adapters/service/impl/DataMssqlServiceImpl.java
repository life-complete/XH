package com.sybercare.hospital.adapters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.adapters.dao.MssqlDAO;
import com.sybercare.hospital.adapters.service.IDataMssqlService;

/**
 * 功能：
 *
 * @author 任梁荣
 * @version 创建时间：Sep 25, 2017 2:37:01 PM
 */
@Service
public class DataMssqlServiceImpl implements IDataMssqlService {
	
	@Autowired
	private MssqlDAO mssqlDAO;

	@Override
	public Object getWardareaList(Object params) {
		return this.mssqlDAO.readWardareaList();
	}

	@Override
	public Object getDepartmentList(Object params) {
		return this.mssqlDAO.readDepartmentList();
	}

	@Override
	public Object getPotherList(Object params) {
		return this.mssqlDAO.readPotherList();
	}

	@Override
	public Object getStaffList(Object params) {
		return this.mssqlDAO.readStaffList();
	}

	@Override
	public Object getPatientList(Object params) {
		return this.mssqlDAO.readPatientList();
	}

	@Override
	public boolean saveBloodGlucose(Object args) {
		return this.mssqlDAO.saveBloodGlucoseList(args);
	}
}
