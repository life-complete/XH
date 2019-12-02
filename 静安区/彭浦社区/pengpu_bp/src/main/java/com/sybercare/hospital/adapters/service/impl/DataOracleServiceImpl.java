package com.sybercare.hospital.adapters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.adapters.dao.OracleDAO;
import com.sybercare.hospital.adapters.service.IDataOracleService;

/**
 * 功能：oracle数据库业务逻辑实现
 *
 * @author 任梁荣
 * @version 创建时间：Sep 25, 2017 2:38:00 PM
 * */
@Service
public class DataOracleServiceImpl implements IDataOracleService {
	

	@Autowired
	private OracleDAO oracleDAO ;

	@Override
	public Object getWardareaList(Object params) {
		return this.oracleDAO.readWardareaList();
	}

	@Override
	public Object getDepartmentList(Object params) {
		return this.oracleDAO.readDepartmentList();
	}

	@Override
	public Object getPotherList(Object params) {
		return this.oracleDAO.readPotherList();
	}

	@Override
	public Object getStaffList(Object params) {
		return this.oracleDAO.readStaffList();
	}

	@Override
	public Object getPatientList(Object params) {
		return this.oracleDAO.readPatientList();
	}

	@Override
	public boolean saveBloodGlucose(Object args) {
		return this.oracleDAO.saveBloodGlucoseList();
	}


}
