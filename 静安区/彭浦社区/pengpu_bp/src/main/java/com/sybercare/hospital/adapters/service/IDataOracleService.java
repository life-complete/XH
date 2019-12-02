package com.sybercare.hospital.adapters.service;

/**
 * 功能：oracle数据库实现
 *
 * @author 任梁荣
 * @version 创建时间：Sep 25, 2017 2:37:22 PM
 * */
public interface IDataOracleService {

	Object getWardareaList(Object params);

	Object getDepartmentList(Object params);

	Object getPotherList(Object params);

	Object getStaffList(Object params);

	Object getPatientList(Object params);

	boolean saveBloodGlucose(Object args);

}
