package com.sybercare.hospital.health.service.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.adapters.entity.HisWardarea;
import com.sybercare.hospital.health.dao.WardareaDAO;
import com.sybercare.hospital.health.entity.PrpScompany;
import com.sybercare.hospital.health.service.IWardareaService;

/**
 * 功能：病区信息
 *
 * @author 任梁荣
 * @version 创建时间：Sep 22, 2017 12:01:30 PM
 * */
@Service
public class WardareaServiceImpl implements IWardareaService {

	@Autowired
	private WardareaDAO wardareaDAO;
	@Value("${custom.hospital.default.comcode}")
	private String comcode;

	@Override
	public boolean doWardarea(HisWardarea wardarea) {
		try {
			PrpScompany company = this.wardareaDAO.readPrpScompanyByHisCode(wardarea.getWardareaCode());
			if (company != null) {
				boolean ftn = false;
				if (!company.getComCName().equals(wardarea.getWardareaName())) {
					company.setComCName(wardarea.getWardareaName());
					ftn = true;
				}
				if (ftn) {
					this.wardareaDAO.updateWardarea(company);
				}
			} else {
				String comcode = this.valiComcode(this.buildComcode(wardarea), wardarea);
				if (StringUtils.isNotBlank(comcode)) {
					company = new PrpScompany();
					company.setComCode(comcode);
					company.setHisCode(wardarea.getWardareaCode());
					company.setComCName(wardarea.getWardareaName());
					company.setValidStatus(wardarea.getValidFlag().toString());
					company.setUpperComcode(this.comcode);
					company.setComLevel(String.valueOf(comcode.length() / 4));
					company.setCreateDate(new Date());
					this.wardareaDAO.saveWardarea(company);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 功能：验证可以使用的comcode
	 * */
	private String valiComcode(String comcode, HisWardarea wardarea) {
		PrpScompany company = this.wardareaDAO.readPrpScompanyByComcode(comcode);
		boolean ftn = false;
		if (company != null) {
			comcode = this.makeComcomde(comcode, wardarea);
		} else {
			ftn = true;
		}
		if (ftn)
			return comcode;
		return this.valiComcode(comcode, wardarea);
	}

	/**
	 * 功能：当comcode被使用自动重新生成
	 * */
	private String makeComcomde(String comcode, HisWardarea wardarea) {
		wardarea.setId(wardarea.getId() + 1);
		return this.buildComcode(wardarea);
	}

	/**
	 * 功能：生成comcode
	 * */
	private String buildComcode(HisWardarea wardarea) {
		StringBuffer buildCode = new StringBuffer(wardarea.getId().toString());
		Integer length = buildCode.length();
		for (int i = 0; i < (4 - length); i++) {
			buildCode = buildCode.insert(0, String.valueOf(0));
		}
		return String.format("%s%s", this.comcode, buildCode.toString());
	}
}
