package com.sybercare.hospital.health.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.health.entity.PrpScompany;

/**
 * 功能：科室信息数据
 *
 * @author 任梁荣
 * @version 创建时间：Sep 22, 2017 2:01:49 PM
 * */
@Repository
@Transactional
public class DepartmentDAO {

	@Autowired
	private IHibernateBaseDao<PrpScompany> hibernateBaseDao;

	/**
	 * 功能：获取科室信息
	 * */
	@SuppressWarnings("unchecked")
	public List<PrpScompany> readPrpScompanyByHisCode(String companyCode) {
		try {
			if (StringUtils.isNotBlank(companyCode)) {
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PrpScompany.class);
				detachedCriteria.add(Restrictions.eq("hisCode", companyCode));
				detachedCriteria.add(Restrictions.eq("validStatus", String.valueOf(1)));
				List<PrpScompany> prpScompanys = (List<PrpScompany>) this.hibernateBaseDao.findAllByCriteria(detachedCriteria);
				return prpScompanys;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateDepartment(PrpScompany company) {
		try {
			if (StringUtils.isNotBlank(company.getComCode())) {
				this.hibernateBaseDao.update(company);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public PrpScompany readPrpScompanyByComcode(String comcode) {
		try {
			if (StringUtils.isNotBlank(comcode)) {
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PrpScompany.class);
				detachedCriteria.add(Restrictions.eq("comCode", comcode));
				detachedCriteria.add(Restrictions.eq("validStatus", String.valueOf(1)));
				List<PrpScompany> wardareaList = (List<PrpScompany>) this.hibernateBaseDao.findAllByCriteria(detachedCriteria);
				if (wardareaList != null && wardareaList.size() > 0) {
					PrpScompany company = wardareaList.get(0);
					return company;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveDepartment(PrpScompany company) {
		try {
			if (company != null) {
				this.hibernateBaseDao.save(company);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
