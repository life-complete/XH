package com.sybercare.hospital.health.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.adapters.entity.HisStaff;
import com.sybercare.hospital.common.utils.ResultMsg;
import com.sybercare.hospital.health.service.IStaffService;

@RestController
public class StaffController {

	protected static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);

	@Autowired
	private IStaffService staffService;

	@RequestMapping(value = "/staff/save", method = RequestMethod.POST)
	public ResultMsg heartrate(@RequestBody String jsonBody) {
		HisStaff hisStaff = JSONObject.parseObject(jsonBody).toJavaObject(HisStaff.class);
		ResultMsg msg = new ResultMsg();
		msg.setSyb_info("error");
		msg.setSyb_status("100");
		if (hisStaff != null) {
			LOGGER.debug("hisStaff: " + JSONObject.toJSONString(hisStaff));
			if (staffService.doStaff(hisStaff)) {
				msg.setSyb_info("success");
				msg.setSyb_status("200");
			}
		}
		return msg;
	}
}
