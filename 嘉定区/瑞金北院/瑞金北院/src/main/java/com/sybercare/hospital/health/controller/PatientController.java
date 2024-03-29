package com.sybercare.hospital.health.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.adapters.entity.HisPatient;
import com.sybercare.hospital.common.utils.ResultMsg;
import com.sybercare.hospital.health.service.IPatientService;

@Controller
public class PatientController {

	protected static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private IPatientService patientService;

	@RequestMapping(value = "/patient/save", method = RequestMethod.POST)
	public ResultMsg heartrate(@RequestBody String jsonBody) {
		HisPatient hisPatient = JSONObject.parseObject(jsonBody).toJavaObject(HisPatient.class);
		ResultMsg msg = new ResultMsg();
		msg.setSyb_info("error");
		msg.setSyb_status("100");
		if (hisPatient != null) {
			LOGGER.debug("hisPatient: " + JSONObject.toJSONString(hisPatient));
			if (patientService.doPatient(hisPatient)) {
				msg.setSyb_info("success");
				msg.setSyb_status("200");
			}
		}
		return msg;
	}

	@RequestMapping(value = "/hospital/index")
	public String index() {
		return "index";
	}

}
