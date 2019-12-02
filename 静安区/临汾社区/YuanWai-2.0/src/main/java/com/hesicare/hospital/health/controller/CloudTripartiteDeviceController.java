package com.hesicare.hospital.health.controller;
import com.hesicare.hospital.common.utils.IdCardUtils;
import com.hesicare.hospital.common.utils.annotation.DateUtils;
import com.hesicare.hospital.common.utils.annotation.PassToken;
import com.hesicare.hospital.health.entity.DataBeiTai;
import com.hesicare.hospital.health.service.ITripartiteDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class CloudTripartiteDeviceController {
	@Autowired
	private ITripartiteDeviceService deviceService;

	@PassToken
	@PostMapping("/bmi")
	public String saveBmi(@RequestBody DataBeiTai dataBmi) {
		System.out.println(dataBmi.getDid());
		if (dataBmi.getPhone() == null && dataBmi.getIdcard() == null) {
			return "手机号和身份证号都为空";
		}
		if (dataBmi.getIdcard() != null) {
			if (!IdCardUtils.IDCardValidate(dataBmi.getIdcard())) {
				return "身份证号不合法";
			}
			dataBmi.setBirth(IdCardUtils.birthByIdCard(dataBmi.getIdcard()));
			dataBmi.setGender(IdCardUtils.sexByIdCard(dataBmi.getIdcard()));
		}
		return "success";
	}

}
