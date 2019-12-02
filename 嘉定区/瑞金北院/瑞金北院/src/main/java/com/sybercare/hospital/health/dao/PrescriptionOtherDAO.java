package com.sybercare.hospital.health.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.health.entity.MonitorModel;
import com.sybercare.hospital.health.entity.MonitorScheme;
import com.sybercare.hospital.health.entity.MonitorTemplate;
import com.sybercare.hospital.health.entity.PrescriptionOther;

/**
 * 功能：监测医嘱数据处理
 *
 * @author 任梁荣
 * @version 创建时间：Sep 22, 2017 6:25:06 PM
 */
@Repository
@Transactional
public class PrescriptionOtherDAO {

	protected static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionOtherDAO.class);

	@Autowired
	private IHibernateBaseDao<PrescriptionOther> hibernatePrescriptionOtherDao;

	@Autowired
	private IHibernateBaseDao<MonitorTemplate> hibernateMonitorTemplateDao;

	@Autowired
	private IHibernateBaseDao<MonitorModel> hibernateMonitorModelDao;

	@Autowired
	private IHibernateBaseDao<MonitorScheme> hibernateMonitorSchemeDao;

	public PrescriptionOther readPrescriptionOther(String prescriptionId) {
		PrescriptionOther prescriptionOther = null;
		try {
			if (StringUtils.isNotBlank(prescriptionId)) {
				prescriptionOther = this.hibernatePrescriptionOtherDao.get(PrescriptionOther.class, "prescriptionId",
						prescriptionId);
			}
		} catch (Exception e) {
			LOGGER.debug("readPrescriptionOther: " + e);
		}
		return prescriptionOther;
	}

	public void savePrescriptionOther(PrescriptionOther prescriptionOther) {
		try {
			if (null != prescriptionOther) {
				this.hibernatePrescriptionOtherDao.save(prescriptionOther);
			}
		} catch (Exception e) {
			LOGGER.debug("savePrescriptionOther: " + e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<MonitorTemplate> readMonitorTemplate(String comcode, String monitorSchemeName) {
		List<MonitorTemplate> monitorTemplateList = null;
		try {
			String hql = "from MonitorTemplate where comCode = ? and monitoreTemplateName = ?";
			Query query = this.hibernateMonitorTemplateDao.createQuery(hql, comcode, monitorSchemeName);
			monitorTemplateList = query.list();
		} catch (Exception e) {
			LOGGER.debug("readMonitorTemplate: " + e);
		}
		return monitorTemplateList;
	}

	public void saveNewMonitorModel(MonitorModel monitorModel) {
		try {
			if (null != monitorModel) {
				this.hibernateMonitorModelDao.save(monitorModel);
			}
		} catch (Exception e) {
			LOGGER.debug("saveNewMonitorModel: " + e);
		}
	}

	public void saveNewMonitorScheme(MonitorScheme monitorScheme) {
		try {
			if (null != monitorScheme) {
				this.hibernateMonitorSchemeDao.save(monitorScheme);
			}
		} catch (Exception e) {
			LOGGER.debug("saveNewMonitorScheme: " + e);
		}
	}

	public void updatePrescriptionOther(PrescriptionOther prescriptionOther) {
		try {
			if (null != prescriptionOther) {
				this.hibernatePrescriptionOtherDao.update(prescriptionOther);
			}
		} catch (Exception e) {
			LOGGER.debug("updatePrescriptionOther: " + e);
		}
	}
}
