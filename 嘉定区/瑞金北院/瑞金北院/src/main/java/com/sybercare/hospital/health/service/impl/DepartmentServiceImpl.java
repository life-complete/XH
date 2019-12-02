package com.sybercare.hospital.health.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.adapters.entity.HisDepartment;
import com.sybercare.hospital.health.dao.DepartmentDAO;
import com.sybercare.hospital.health.entity.PrpScompany;
import com.sybercare.hospital.health.service.IDepartmentService;

/**
 * 功能：处理科室信息数据
 *
 * @author 任梁荣
 * @version 创建时间：Sep 22, 2017 1:59:17 PM
 * */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Value("${custom.hospital.default.comcode}")
	private String comcode;
	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	public boolean doDepartment(HisDepartment department) {
		try {
			PrpScompany company = null;
			List<PrpScompany> companys = this.departmentDAO.readPrpScompanyByHisCode(department.getDepartmentCode());
			if (companys != null && companys.size() > 0) {
				company = companys.get(0);
				boolean ftn = false;
				if (!company.getComCName().equals(department.getDepartmentName())) {
					company.setComCName(department.getDepartmentName());
					ftn = true;
				}
				if (ftn) {
					this.departmentDAO.updateDepartment(company);
				}
			} else {
				String comcode = this.valiComcode(this.buildComcode(department), department);
				if (StringUtils.isNotBlank(comcode)) {
					company = new PrpScompany();
					company.setComCode(comcode);
					company.setHisCode(department.getDepartmentCode());
					company.setComCName(department.getDepartmentName());
					company.setValidStatus(department.getValidFlag().toString());
					company.setUpperComcode(this.comcode);
					company.setComLevel(String.valueOf(comcode.length() / 4));
					company.setCreateDate(new Date());
					this.departmentDAO.saveDepartment(company);
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
	private String valiComcode(String comcode, HisDepartment department) {
		PrpScompany company = this.departmentDAO.readPrpScompanyByComcode(comcode);
		boolean ftn = false;
		if (company != null) {
			comcode = this.makeComcomde(comcode, department);
		} else {
			ftn = true;
		}
		if (ftn)
			return comcode;
		return this.valiComcode(comcode, department);
	}

	/**
	 * 功能：当comcode被使用自动重新生成
	 * */
	private String makeComcomde(String comcode, HisDepartment department) {
		department.setId(department.getId() + 1);
		return this.buildComcode(department);
	}

	/**
	 * 功能：生成comcode
	 * */
	private String buildComcode(HisDepartment department) {
		StringBuffer buildCode = new StringBuffer(department.getId().toString());
		Integer length = buildCode.length();
		for (int i = 0; i < (4 - length); i++) {
			buildCode = buildCode.insert(0, String.valueOf(0));
		}
		return String.format("%s%s", this.comcode, buildCode.toString());
	}

}
