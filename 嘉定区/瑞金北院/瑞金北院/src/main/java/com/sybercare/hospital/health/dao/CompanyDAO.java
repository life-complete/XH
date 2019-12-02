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

@Repository
@Transactional
public class CompanyDAO {
	
	@Autowired
	private IHibernateBaseDao<PrpScompany> hibernatePrpScompanyDao;
	
	
	public PrpScompany readPrpScompanyByHiscode(String hiscode) {
		PrpScompany prpScompany = null;
		try {
			if (StringUtils.isNotBlank(hiscode)) {
				prpScompany = this.hibernatePrpScompanyDao.get(PrpScompany.class, "hisCode", hiscode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prpScompany;
	}
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
				List<PrpScompany> prpScompanys = (List<PrpScompany>) this.hibernatePrpScompanyDao.findAllByCriteria(detachedCriteria);
				return prpScompanys;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
