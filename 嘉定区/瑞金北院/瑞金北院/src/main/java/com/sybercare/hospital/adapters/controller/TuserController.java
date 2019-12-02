package com.sybercare.hospital.adapters.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.adapters.entity.Tuser;
import com.sybercare.hospital.adapters.service.ITuserService;
import com.sybercare.hospital.common.utils.ResultMsg;

@RestController
public class TuserController {

	protected static final Logger LOGGER = LoggerFactory.getLogger(TuserController.class);

	@Autowired
	private ITuserService tuserService;

	@RequestMapping(value = "/tuser/adds", method = RequestMethod.POST)
	public ResultMsg heartrate(@RequestBody Tuser user) {
		ResultMsg msg = new ResultMsg();
		msg.setSyb_info("error");
		msg.setSyb_status("100");
		if (user != null) {
			System.out.println(JSONObject.toJSONString(user));
			if (this.tuserService.addTuser(user)) {
				msg.setSyb_info("success");
				msg.setSyb_status("200");
			}
		}
		return msg;
	}
}
