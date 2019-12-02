package com.hesicare.hospital.health.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hesicare.hospital.common.utils.IHibernateBaseDao;
import com.hesicare.hospital.health.entity.BloodGlucose;

@Repository
@Transactional
public class BloodGlucoseDAO {

	protected static final Logger LOGGER = LoggerFactory.getLogger(BloodGlucoseDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private IHibernateBaseDao<BloodGlucose> hibernateBloodGlucoseDao;

	public List<BloodGlucose> getBloodGlucoseByOperateState(String operateState) {
		List<BloodGlucose> bloodGlucoses = null;
		try {
			bloodGlucoses = hibernateBloodGlucoseDao.getList(BloodGlucose.class, "data_status", operateState);
		} catch (Exception e) {
			LOGGER.debug("getBloodGlucoseByOperateState: " + e);
		}
		return bloodGlucoses;
	}
	
	public void updateBloodGlucoseOperateState(Long id, short operateState) {
		this.jdbcTemplate.update("update patient_blood_glucose_view set data_status = ? where id = ?", operateState, id);
	}

}
