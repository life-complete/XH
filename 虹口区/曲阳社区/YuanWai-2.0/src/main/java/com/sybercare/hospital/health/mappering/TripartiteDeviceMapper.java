package com.sybercare.hospital.health.mappering;


import com.sybercare.hospital.health.entity.SysPatient;
import com.sybercare.hospital.health.entity.SysPatientBmi;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TripartiteDeviceMapper {

	SysPatient selectPatientByPhoneAndIdCard(@Param("phone") String phone, @Param("idCard") String idCard);

	void insertPatient(SysPatient patient);

	void insertPatientBmi(SysPatientBmi patientBmi);

	void updatePatient(SysPatient patient);
    List<Map> sela();
}
