package com.sybercare.hospital.health.service;

import java.util.List;

import com.sybercare.hospital.adapters.entity.HisStaff;

public interface IStaffService {

	List<?> readTuserByMaxIds();

	/** 处理医院人员信息 */
	boolean doStaff(HisStaff tuser);

}
