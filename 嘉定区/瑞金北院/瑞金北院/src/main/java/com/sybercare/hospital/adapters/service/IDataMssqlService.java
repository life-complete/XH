package com.sybercare.hospital.adapters.service;

/** 
 * 功能：微软sqlserver数据库实现
 *
 * @author 任梁荣 
 * @version 创建时间：Sep 25, 2017 2:36:03 PM  
 * */
public interface IDataMssqlService {
	
	Object getWardareaList(Object params);

	Object getDepartmentList(Object params);

	Object getPotherList(Object params);

	Object getStaffList(Object params);

	Object getPatientList(Object params);

	boolean saveBloodGlucose(Object args);

}
