package com.sybercare.hospital.health.service;

import java.util.List;

import com.sybercare.hospital.adapters.entity.HisPatient;
import com.sybercare.hospital.health.entity.UserPatient;

/**
 * 功能：患者信息
 *
 * @author 任梁荣
 * @version 创建时间：Sep 22, 2017 6:09:46 PM
 * */
public interface IPatientService {

	boolean doPatient(HisPatient patient);
	
	List<UserPatient> getUserPatientByInHospitalState(String state);
}
