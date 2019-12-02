package com.sybercare.hospital.health.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.health.entity.BloodPressure;

@Repository
@Transactional
public class BloodPressureDAO {

	protected static final Logger LOGGER = LoggerFactory.getLogger(BloodPressureDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private IHibernateBaseDao<BloodPressure> hibernateBloodPressureDao;

	public List<BloodPressure> getBloodPressureByOperateState() {
		List<BloodPressure> bloodGlucoses = null;
		try {
			bloodGlucoses = hibernateBloodPressureDao.getListIsNotNull(BloodPressure.class,"idCard");
		} catch (Exception e) {
			LOGGER.debug("getBloodGlucoseByOperateState: " + e);
		}
		return bloodGlucoses;
	}
	
	public void updateBloodGlucoseOperateState(Long id, short operateState) {
		this.jdbcTemplate.update("update data_blood_pressure set data_status = ? where id = ?", operateState, id);
	}

}
