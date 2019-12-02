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
 * 功能：机构与科室数据处理
 *
 * @author 任梁荣
 * @version 创建时间：Sep 22, 2017 11:55:37 AM
 * */
@Repository
@Transactional
public class WardareaDAO {

	@Autowired
	private IHibernateBaseDao<PrpScompany> hibernateBaseDao;

	/**
	 * 功能：根据病区Code获取数据
	 * */
	@SuppressWarnings("unchecked")
	public PrpScompany readPrpScompanyByHisCode(String wardareaCode) {
		try {
			if (StringUtils.isNotBlank(wardareaCode)) {
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PrpScompany.class);
				detachedCriteria.add(Restrictions.eq("hisCode", wardareaCode));
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

	/**
	 * 功能：修改病区信息
	 * */
	public void updateWardarea(PrpScompany company) {
		try {
			if (StringUtils.isNotBlank(company.getComCode())) {
				this.hibernateBaseDao.update(company);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 功能：验证comcode
	 * */
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

	/**
	 * 功能：新增病区
	 * */
	public void saveWardarea(PrpScompany company) {
		try {
			if (company != null) {
				this.hibernateBaseDao.save(company);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
